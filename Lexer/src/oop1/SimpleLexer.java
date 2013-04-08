package oop1;

public class SimpleLexer {

	private String input;
	private TokenReader[] readers;

	public SimpleLexer(String input,TokenReader[] readers) {
		this.input = input;
		this.readers = readers;
	}

	public Token readNextToken() {
		int lengthMax = 0;
		Token maxToken = null;
		for (TokenReader reader : readers){
			Token currentToken = reader.tryReadToken(input);
			if(currentToken != null){
				if(currentToken.getText().length() > lengthMax){
					lengthMax = currentToken.getText().length();
					maxToken = currentToken;
				}
			}
		}
		if (lengthMax != 0) {
			input=input.substring(lengthMax);
			return maxToken;
		}
		return null;
	}

	public boolean hasNextToken() {
		 return (input.length() != 0);
	}
	
}