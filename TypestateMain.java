import JavaTypestate.AST.TypestateChecker;
import Java14Frontend.JavaChecker;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileNotFoundException;

class TypestateMain {
	JavaChecker jc;
	TypestateChecker tc;

	TypestateMain() {
		jc = new JavaChecker();
		tc = new TypestateChecker();
	}

	public boolean compile() {
		return jc.compile(files) && tc.compile(files);
	}

	public void createJavaFiles() {
		tc.dumpJavaFiles();
		;//TODO compile with javac ?? 
	}

	public static void main(String [] args) {
		TypestateMain m = new TypestateMain();
		m.processArgs(args);
		if(m.compile() && !semantic)
			m.createJavaFiles();
	//	else
	//		m.tc.printErrors();	//TODO dont like here
	}

	private static boolean semantic = false;
	private static void setSemantic() {
		semantic = true;
	}

	//private static boolean typestate = true;
	//private static void setTypestate() {
	//}

	private String[] files;

	void processArgs(String[] args) {
		ArrayList<String> files = new ArrayList<String>();

		for(int i = 0; i < args.length; i++) {
			if(args[i].equals("-Verbose") || args[i].equals("-verbose") || args[i].equals("-v"))
				tc.setVerbose();
			else if(args[i].equals("-Semantic") || args[i].equals("-semantic") || args[i].equals("-s"))
				setSemantic();
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
	//		else if(args[i].equals("-Typestate") || args[i].equals("-typestate") || args[i].equals("-t"))
	//			setTypestate();
	//		else if(args[i].equals("-Java14") || args[i].equals("-java14") || args[i].equals("-j"))
	//			setJava14();
			else
				files.add(args[i]);
		}
		this.files = new String[files.size()];
		for(int i = 0; i < files.size(); i++)
			this.files[i] = files.get(i);
	}
}
