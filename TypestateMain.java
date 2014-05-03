import JavaTypestate.AST.TypestateChecker;
import Java14Frontend.JavaChecker;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileNotFoundException;

class TypestateMain {
	JavaChecker jc;
	TypestateChecker tc;

	private boolean printErrors = true;
	private boolean semantic = false;
	private boolean verbose = false;

	private final int DEFAULT = 0x111;
	private final int TYPESTATE = 0x01;
	private final int JAVA14 = 0x10;

	private int mode = DEFAULT;

	TypestateMain() {
		jc = new JavaChecker();
		tc = new TypestateChecker();
	}

	public boolean compile() {
		boolean j = true, t = true;
		if((mode & JAVA14) != 0) {
			if(verbose == true)
				System.out.println("Checking java 1.4.");
			j = jc.compile(files);
		}
		if((mode & TYPESTATE) != 0) {
			if(verbose == true)
				System.out.println("Typestate check.");
			t = tc.compile(files);
			if((tc.hasErrors() || tc.hasWarnings()) && printErrors) {
				if(verbose == true)
					System.out.println("Print errors and Warnings.");
				tc.printErrors();
			}
		}

		return j & t;
	}

	public void createJavaFiles() {
		tc.createJavaFiles();
		;//TODO compile with javac ?? 
	}

	public static void main(String [] args) {
		TypestateMain m = new TypestateMain();
		m.processArgs(args);
		if(m.compile() && !m.semantic)
			m.createJavaFiles();
	}

	private void setMode(int m) {
		if(mode == DEFAULT)
			mode = m;
		else
			mode |= m;
	}

	private String[] files;
	void processArgs(String[] args) {
		ArrayList<String> files = new ArrayList<String>();

		for(int i = 0; i < args.length; i++) {
			if(args[i].equals("-Verbose") || args[i].equals("-verbose") || args[i].equals("-v")) {
				verbose = true;
				tc.setVerbose();
			}
			else if(args[i].equals("-Semantic") || args[i].equals("-semantic") || args[i].equals("-s"))
				semantic = true;
			else if(args[i].equals("-Output") || args[i].equals("output") || args[i].equals("-o")) {
				if(i + 1 >= args.length)
					; //TODO error
				else {
					try {
						tc.setOutputStream(new PrintStream(args[++i]));
					}
					catch (FileNotFoundException e) {
						;//TODO error
					}
				}
			}
			else if(args[i].equals("-Typestate") || args[i].equals("-typestate") || args[i].equals("-t"))
				setMode(TYPESTATE);
			else if(args[i].equals("-Java14") || args[i].equals("-java14") || args[i].equals("-j"))
				setMode(JAVA14);
			else
				files.add(args[i]);
		}

		this.files = new String[files.size()];
		for(int i = 0; i < files.size(); i++)
			this.files[i] = files.get(i);
	}
}
