package oop1;

public class IdentifierReader implements TokenReader{
	public Token tryReadToken(String input) {

		int i = 0;
		int len = input.length();
		if (len > 0 && Character.isJavaIdentifierStart(input.charAt(i))) {
			i++;
			while (i < len && Character.isJavaIdentifierPart(input.charAt(i)))
				i++;
			return new Token("if", input.substring(0, i));

		}
		return null;
	}

}