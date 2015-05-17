public class Parser241b implements Parser {
	private void s(Integer level, Input input, StringBuilder output) throws Exception {
		if (level < 0) {
			throw new Exception("Syntax error: token ')' not expected.");
		}
		
		if (!input.hasNext()) {
			// epsilon
			if (level == 0) {
				return;
			}
			else {
				throw new Exception("Syntax error: token ')' expected.");
			}
		}
		
		Character token = input.next();
		
		// ( S ) S
		if (token == '(') {
			output.append(token);
			s(level + 1, input, output);
		}
		else if (token == ')') {
			output.append(token);
			s(level - 1, input, output);
		}
		else {
			throw new Exception("Syntax error: invalid token '" + token + "' found.");
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
		return "S -> S '(' S ')' S | epsilon";
	}

	public static void main(String[] args) {
		IO io = new IO();
		Parser parser = new Parser241b();
		Runner.run(io, parser);
	}
}
