package compilers2;

import java.util.ArrayList;
import java.util.Iterator;

public class Input implements Iterator<Character> {
	private final Iterator<Character> iterator;
	
	public Input(String text) {
		if (text == null)
			throw new IllegalArgumentException("text");
		
		ArrayList<Character> input = new ArrayList<Character>();
		for (Character c : text.toCharArray()) {
			input.add(c);
		}
		
		iterator = input.iterator();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Character next() {
		return iterator.next();
	}

	@Override
	public void remove() {
		iterator.remove();
	}
}
