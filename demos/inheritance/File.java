package demos.inheritance;

import mungo.lib.Typestate;

@Typestate("FileProtocol")
public class File{
    private FileHandle h; // Mungo currently requires 'private' here

    public File () {
        h = new FileHandle();
    }

    // Calls read() internally, which may be overridden.
    public void open () {
        h.acquire();
        byte header = read(); // suppose every file starts with a header byte
    }

    public byte read () {
        return 0;
    }

    public void close () {
        h.release();
    }
}
