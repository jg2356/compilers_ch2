public class Parser241a implements Parser {
	private void s(Integer level, Input input, StringBuilder output) throws Exception {
		if (!input.hasNext()) {
			throw new Exception("Syntax error: token '+' or 'a' expected.");
		}
		
		Character token = input.next();
		
		// a
		if (token == 'a') {
			output.append(token);
		}
		// + S S | - S S
		else if (token == '+' || token == '-') {
			output.append(token);
			s(level + 1, input, output);
			s(level + 1, input, output);
		}
		else {
			throw new Exception("Syntax error: invalid token '" + token + "' found.");	
		}
		
		if (input.hasNext() && level == 0) {
			throw new Exception("Syntax error: token '" + input.next() + "' not expected.");
		}
	}
	
	@Override
	public String parse(Input input) {
		StringBuilder output = new StringBuilder();
		try {
			s(0, input, output);
			return output.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
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
