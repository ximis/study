package app.Common;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * this class is used to parse the command line args.
 */
public class CLI {
    private final String usageMessage = "LogicMonitor silicon framework\n";
    private final Integer VERSION = 1;

    @Parameter(names = {"-v", "--version"}, description = "show the version", help = true)
    private boolean version;

    @Parameter(names = {"-h", "--help"}, description = "print the help message.", help = true)
    private boolean help;

    @Parameter(names = "-f", description = "the file name", required = true)
    public String filename;

    @Parameter(names = "-p", description = "the path name")
    public String path;


    private CLI() {

    }

    public static CLI getInstance(String[] argv) {
        CLI cli = new CLI();

        JCommander.newBuilder()
                .addObject(cli)
                .build()
                .parse(argv);

        cli.checkHelpInfo();

        return cli;
    }

    private void checkHelpInfo() {
        if (version) {
            System.out.println("print the version:" + VERSION);
            System.exit(0);
        }
        if (help) {
            System.out.println(usageMessage);
            System.exit(0);
        }
    }


    // this code is used to test.
    public static void main(String[] args) {
        String[] arg = {"--version"};
        CLI cli = CLI.getInstance(arg);

        System.out.println(cli.version);
        System.out.println(cli.help);
        System.out.println(cli.filename);
    }


}
