package demos.inheritance;

class Main {
    public static void main () {
        LoggedFile f = new LoggedFile();
        f.open();
        f.read();
        f.clearLog();
        LoggedFile g = f; // TODO: make this File
        g.close();
    }
}
