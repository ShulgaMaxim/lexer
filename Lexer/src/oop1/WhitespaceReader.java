package oop1;

public class WhitespaceReader implements TokenReader{
	
	public Token tryReadToken(String input) {
		int i = 0;
		int len = input.length();
		if (len > 0 && Character.isWhitespace(input.charAt(i))) {
			while (i < len && Character.isWhitespace(input.charAt(i)))
				i++;
			return new Token("ws", input.substring(0, i));
		}
		return null;
	}
}