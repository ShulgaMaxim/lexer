package oop1;

import junit.framework.TestCase;

public class EndOfLineCommentTest extends TestCase{
	private TokenReader reader = new EndOfLineComment();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("/"));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("a//bcdef"));
		assertNull(reader.tryReadToken("abcdef//bcdef"));
		assertNull(reader.tryReadToken("/asdf"));
	}
	
	public void testComment(){
		testComment("//\n", "//\n");
		testComment("//lalala \n", "//lalala \n");
		testComment("//lalala", "//lalala");
		testComment("//lalala \n helloWorld", "//lalala \n");
	}
	
	public void testComment(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("ec", token.getType());
		assertEquals(expectedToken, token.getText());
	}

}
