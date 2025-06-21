/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

//import java.io.OutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StdOutStdErrTee extends OutputStream {

    private Config config;




    private String stdOutFilePath = getStdOutFilePath();
    private String stdErrFilePath = getStdErrFilePath();
    private String receiptFilePath = "src/assignment02PartB/log/Receipt-*-*.log"    ;


    public String getStdOutFilePath() {
        return "alien".equals(Language.getLocale()) ? Language.getAlienSound() : Config.getDefaultStdOutFilePath();

    }
    public String getStdErrFilePath() {
        return "alien".equals(Language.getLocale()) ? Language.getAlienSound() : Config.getDefaultStdErrFilePath();
    }


    //    private OutputStream[] streamsToConsoleToFile; // is array of Output streams will represent the container for the error log file and the output log file
    private List<OutputStream> streamsListToConsoleToFile;

    // default constructor
    public StdOutStdErrTee() {

    }


//    /**
//     *
//     * @param printStream - add functionality to our file output stream like auto close and writing support
//     * @param fileOutputStream - output stream to write to the files
//     * - the constructor take in the print stream and the underlying file output stream
//     * - it is to be constructed on initialization of the Tee
//     */
//    public StdOutStdErrTee(PrintStream printStream, FileOutputStream fileOutputStream) {
//        this.streamsToConsoleToFile = new OutputStream[2];
//        streamsToConsoleToFile[0] = printStream;
//        streamsToConsoleToFile[1] = fileOutputStream;
//    }

    /**
     *
     * @param outs - defined output streams
     */
    public StdOutStdErrTee(OutputStream... outs) {
        // is array of Output streams will represent the container for the error log file and the output log file
        this.streamsListToConsoleToFile = new ArrayList<>(Arrays.asList(outs));

    }

    /**
     *
     * @param stdOutFilePath - represents the file path for our output
     * @param stdErrFilePath - represents the filepath for our errors
     * - this instance is constructed with our output and error file paths
     */
    public StdOutStdErrTee(String stdOutFilePath, String stdErrFilePath) {
        this.stdOutFilePath = stdOutFilePath;
        this.stdErrFilePath = stdErrFilePath;
    }
//    public StdOutStdErrTee(File stdOutFilePath, File stdErrFilePath) {
//        this.stdOutFilePath = stdOutFilePath;
//        this.stdErrFilePath = stdErrFilePath;
//    }


    /**
     * This method starts the log process
     * 1. create our file output streams and provide them with new files. The files will be passed in the constructor on initialization
     * 2. reference and instantiate out Tee. Since it extends OutputStream, it becomes the wrapper for our file outputs streams by calling our second constructor
     * 3. now we reference and instantiate a print stream to assist out file output streams
     *
     */
    public void startLog() {
        try{
//            File outFile = new File(this.stdOutFilePath);
//            outFile.getParentFile().mkdirs();


            /**
             * underlying output streams for out programs output and errors
             * they accept File objects we give the output streams accept the file paths in out system
             */
            FileOutputStream stdOutFile = new FileOutputStream((this.stdOutFilePath));
            FileOutputStream stdErrFile = new FileOutputStream((this.stdErrFilePath));
//            FileOutputStream stdOutFile = new FileOutputStream((new File(stdOutFilePath.toURI())));
//            FileOutputStream stdErrFile = new FileOutputStream((new File(stdErrFilePath.toURI())));

            /**
             * we instantiate our tee and call the first constructor
             * for the output, the tee reads our system out and writes to the file
             * for errors, the tee reads the errors and writes them to the file
             */
            StdOutStdErrTee allStdOut = new StdOutStdErrTee(System.out, stdOutFile);
            StdOutStdErrTee allStdErr = new StdOutStdErrTee(System.err, stdErrFile);

            /**
             * Now we create print streams to assist out file output streams
             * Our tee of streams
             */
            PrintStream stdOut = new PrintStream(allStdOut);
            PrintStream stdErr = new PrintStream(allStdErr);

            System.setOut(stdOut); // sets the new standard output stream to the stream we created
            System.setErr(stdErr); // sets the new standard error stream to the stream we created

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stopLog() {
        // future implementation

//        System.setOut();
    }
    /**
     * OutputStream requires a write method by default to write at least one character to the file
     * @param b   the {@code byte}.
     * @throws IOException  - catches any input output exceptions
     */
    @Override
    public void write(int b) throws IOException {
        for (OutputStream out  : this.streamsListToConsoleToFile) {
            if (streamsListToConsoleToFile == null)
                throw new IllegalStateException("No output streams configured");
            out.write(b);
            out.flush(); // forces any remaining char bytes to be written to the file
        }


    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (OutputStream out : streamsListToConsoleToFile) {
            if (streamsListToConsoleToFile == null)
                throw new IllegalStateException("No output streams configured");

            out.write(b, off, len);
        }
    }

    public String getReceiptFilePath() {
        return receiptFilePath;
    }

    public StdOutStdErrTee setReceiptFilePath(String receiptFilePath) {
        this.receiptFilePath = receiptFilePath;
        return this;
    }
}

    //
    // Static Data Fields
    //


    //
    // Instance Data Fields
    //

    //
    // Constructors
    //

    //
    // Instance Methods
    //

    //
    // Additional Methods
    //

    //
    // Language
    //

    //
    // Override
//    @Override
//        public void write(byte[] b, int off, int len) throws IOException {
//            for (OutputStream out : streamsListToConsoleToFile) {
//                if (streamsListToConsoleToFile == null)
//                    throw new IllegalStateException("No output streams configured");
//
//                out.write(b, off, len);
//            }
//        }
//}