import JavaTypestate.AST.TypestateChecker;
import Java14Frontend.JavaChecker;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileNotFoundException;

class TypestateMain {
	JavaChecker jc;
	TypestateChecker tc;

	private String[] files;

	private boolean printErrors = true;
	private boolean semantic = false;
	private boolean verbose = false;
	private boolean printInference = false;

	private final int DEFAULT = 0x111;
	private final int TYPESTATE = 0x01;
	private final int JAVA14 = 0x10;

	private int mode = DEFAULT;

	TypestateMain() {
		jc = new JavaChecker();
		tc = new TypestateChecker();
	}

	private boolean compile() {
		boolean j = true, t = true;
		if((mode & JAVA14) != 0) {
			if(verbose == true)
				System.out.println("Checking java 1.4.");
			j = jc.compile(files);
		}

		if (j == false)
			return false;

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

	private void createJavaFiles() {
		tc.createJavaFiles();
		;//TODO compile with javac ?? 
	}

	private void setMode(int m) {
		if(mode == DEFAULT)
			mode = m;
		else
			mode |= m;
	}

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
			else if(args[i].equals("-printInference") || args[i].equals("-pi")) {
				printInference = true;
				tc.setPrintInference();
			}
			else
				files.add(args[i]);
		}

		this.files = new String[files.size()];
		for(int i = 0; i < files.size(); i++)
			this.files[i] = files.get(i);
	}

	public static void main(String [] args) {
		if(args.length == 0) {
			usage();
			return;
		}
		TypestateMain m = new TypestateMain();
		m.processArgs(args);
		if(m.compile() && !m.semantic)
			m.createJavaFiles();
	}


	private static void usage() {
		System.out.println();
		System.out.println("\tusage: java TypestateMain [flags] files");
		System.out.println();
		System.out.println("flags:");
		System.out.println();
		System.out.print("-Typestate -typestate -t:");
		System.out.println("\tPerform only typechecking.");
		System.out.print("-Java14 -java14 -j:");
		System.out.println("\t\tPerform only java1.4 checking.");
		System.out.println("Note if you put both of the above flags you get both Typestate and Java checks.");
		System.out.println();
		System.out.print("-Semantic -semantic -s:");
		System.out.println("\t\tPerform only typecheck. No java files are created.");
		System.out.print("-Verbose -verbose -v:");
		System.out.println("\t\tPrint the steps the typestate typechecker does.");
		System.out.print("-printInference -pi:");
		System.out.println("\t\tPrints all the infered types.");
	}
}
