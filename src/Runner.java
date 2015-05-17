public class Runner {
	public static void run(IO io, Parser parser) {
		io.out("Press Ctrl+C or enter a blank line to exit.\r\n\r\nEnter an expression to parse according to the grammar:\r\n" + parser.grammar() + "\r\n");
		
		while (true) {
			io.out("> ");
			String expression = io.in();
			
			if (expression == null || expression.length() == 0)
				break;
			
			Input input = new Input(expression);
			
			String result = parser.parse(input);
			io.out(result + "\r\n");
		}
	}
}
