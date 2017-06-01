package demos.inheritance;

import mungo.lib.Typestate;

@Typestate("LoggedFileProtocol")
public class LoggedFile /*extends File*/{
    private LogService logging;

    public LoggedFile () {
        logging = new LogService();
    }

    // It should be an error to call super.open() before logging.start(), because
    // super.open() will call my override of read(), which will write to the log.
    public void open () {
//      super.open();
        logging.start();
        logging.log("Opening file");
    }

    public byte read () {
        byte ch = 0;
//      ch = super.read();
        logging.log("Reading " + ch);
        return ch;
    }

    public void close () {
        logging.log("Closing file");
        logging.stop();
    }

    public void clearLog () {
        logging.clear();
    }
}
