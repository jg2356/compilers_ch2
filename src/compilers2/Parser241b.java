package compilers2;

public class Parser241b implements Parser {
	private void s(Input input, StringBuilder output) {
		if (!input.hasNext())
			return;
		
		Character token = input.next();
		
		if (token == '(') {
			output.append(token);
			s(input, output);
		}
		else if (token == ')') {
			output.append(token);
		}
		else {
			output.append("(Syntax error:" + token + ")");
		}
	}
	
	@Override
	public String parse(Input input) {
		StringBuilder output = new StringBuilder();
		s(input, output);
		return output.toString();
	}
	
	@Override
	public String grammar() {
		return "S -> S ( S ) S | ε";
	}

	public static void main(String[] args) {
		IO io = new IO();
		Parser parser = new Parser241b();
		Runner.run(io, parser);
	}
}
