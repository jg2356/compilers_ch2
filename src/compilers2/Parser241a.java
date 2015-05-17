package compilers2;

public class Parser241a implements Parser {
	private void s(Input input, StringBuilder output) {
		if (!input.hasNext())
			return;
		
		Character token = input.next();
		
		if (token == 'a') {
			output.append(token);
		}
		else if (token == '+' || token == '-') {
			output.append(token);
			s(input, output);
			s(input, output);
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
		return "S -> '+' S S | '-' S S | 'a'";
	}

	public static void main(String[] args) {
		IO io = new IO();
		Parser parser = new Parser241a();
		Runner.run(io, parser);
	}
}
