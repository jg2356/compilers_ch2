package compilers2;

public class Runner {
	public static void run(IO io, Parser parser) {
		io.out("Enter an expression according to the grammar:\r\n" + parser.grammar() + "\r\n");
		while (true) {
			io.out("> ");
			String expression = io.in();
			
			if (expression.length() == 0)
				break;
			
			Input input = new Input(expression);
			
			String result = parser.parse(input);
			io.out(result + "\r\n");
		}
	}
}
