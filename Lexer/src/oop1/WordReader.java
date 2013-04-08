package oop1;


public class WordReader implements TokenReader{
	
	private final String word;
	private final boolean ignoreCase;

	public WordReader(String word, boolean ignoreCase) {
		super();
		this.ignoreCase = ignoreCase;
		if (ignoreCase) {
			word = word.toLowerCase();
		}
		this.word = word;
	}
	
	public WordReader(String word) {
		this(word, false);
	}
	
	public Token tryReadToken(String input) {

		if (ignoreCase) {
			if (input.length() > word.length()) {
				input = input.substring(0, word.length());
			}
			input = input.toLowerCase();
		}
		if (input.startsWith(word)) {
			return new Token("kw", word);
		}
		return null;
	}

}
