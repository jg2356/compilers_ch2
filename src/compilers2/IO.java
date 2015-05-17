package compilers2;

public class IO {

	public String in() {
		return System.console().readLine();
	}

	public void out(String text) {
		System.console().printf(text);
	}

}
