public class Parser241c implements Parser {
	private void r(Integer level, Input input, StringBuilder output) throws Exception {
		if (level < 0) {
			throw new Exception("Syntax error: token 1 not expected.");
		}
		
		if (!input.hasNext()) {
			if (level == 0) {
				return;
			}
			else {
				throw new Exception("Syntax error: token 1 expected.");	
			}			
		}
		
		Character token = input.next();
		
		if (token == '1') {
			output.append(token);
			r(level - 1, input, output);
		}
		else if (token == '0') {
			throw new Exception("Syntax error: token 0 not expected.");
		}
		else {
			throw new Exception("Syntax error: invalid token " + token + " found.");
		}
	}
	
	private void s(Integer level, Input input, StringBuilder output) throws Exception {
		if (!input.hasNext() && level == 0) {
			throw new Exception("Syntax error: token 0 expected.");
		}
		
		Character token = input.next();
		
		// 0 S 1
		if (token == '0') {
			output.append(token);
			s(level + 1, input, output);
		}
		else if (token == '1') {
			output.append(token);
			r(level - 1, input, output);
		}
		else {
			throw new Exception("Syntax error: invalid token " + token + " found.");
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
		return "S -> '0' S '1' | '0' '1'";
	}

	public static void main(String[] args) {
		IO io = new IO();
		Parser parser = new Parser241c();
		Runner.run(io, parser);
	}
}
