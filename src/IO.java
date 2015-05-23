import java.io.PrintStream;
import java.util.Scanner;

public class IO {
	private final Scanner in;
	private final PrintStream out;
	
	public IO() {
		in  = new Scanner(System.in);
		out = System.out;
	}
	
	public String in() {
		return in.nextLine();
	}

	public void out(String text) {
		out.print(text);
	}

}
