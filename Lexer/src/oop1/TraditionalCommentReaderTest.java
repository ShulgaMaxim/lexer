package oop1;

import junit.framework.TestCase;

public class TraditionalCommentReaderTest extends TestCase{
	private TokenReader reader = new TraditionalCommentReader();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("/"));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("a/*bcdef*/"));
		assertNull(reader.tryReadToken("abcdef/*bcdef*/"));
		assertNull(reader.tryReadToken("/*asdf"));
		assertNull(reader.tryReadToken("/*"));
	}
	
	public void testComment(){
		testComment("/**/", "/**/");
		testComment("/*asdf*/", "/*asdf*/");
		testComment("/*asdasd*/asdasdasd", "/*asdasd*/");
		testComment("/******/", "/******/");
	}
	
	public void testComment(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("tc", token.getType());
		assertEquals(expectedToken, token.getText());
	}
}
