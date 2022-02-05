/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cs2263_hw01;

import org.apache.commons.cli.*;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {
        // Create a set of Apache Commons Options
        Options options = new Options();
        options.addOption("h", false, "Get help for usage");
        options.addOption(Option.builder()
                .longOpt("help")
                .desc("Get help for usage")
                .build());
        options.addOption("o", true, "Write the output to the specified file");
        options.addOption(Option.builder()
                .longOpt("output")
                .hasArg()
                .argName("file")
                .desc("Write the output to the specified file")
                .build());
        options.addOption("b", true, "Calculate the expression stored in the file");
        options.addOption(Option.builder()
                .longOpt("batch")
                .hasArg()
                .argName("file")
                .desc("Calculate the expression stored in the file")
                .build());

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h") || cmd.hasOption("help")){
                System.out.println("Usage eval [OPTIONS]\nEvaluation of simple mathematical expressions\n\n" +
                        "-b,--batch <file>\tbatch file containing expressions to evaluate\n" +
                        "-h,--help\t\tprint usage message\n" +
                        "-o,--output <file>\toutput file\n\n" +
                        "Copyright (C) 2022 Autumn M Clark");
                exit(0);
            }
            if(cmd.hasOption("o")) {
                System.out.println("Output value: " + cmd.getOptionValue("o"));
            }
            if(cmd.hasOption("output")){
                System.out.println("Output value: " + cmd.getOptionValue("output"));
            }
            if(cmd.hasOption("b")){
                System.out.println("Batch value: " + cmd.getOptionValue("b"));
            }
            if(cmd.hasOption("batch")){
                System.out.println("Batch value: " + cmd.getOptionValue("batch"));
            }
        } catch (ParseException exp) {
            System.out.println("Unexpected exception: " + exp.getMessage());
        }
    }
}