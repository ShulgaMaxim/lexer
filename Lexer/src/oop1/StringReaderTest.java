package oop1;

import junit.framework.TestCase;

public class StringReaderTest extends TestCase{
	private TokenReader reader = new StringReader();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("\""));
		assertNull(reader.tryReadToken("\"adsadasd"));
	}
	
	public void testGeneral(){
		testString("\"\"", "\"\"");
		testString("\"lalala\"", "\"lalala\"");
		testString("\"with \\\" backslash\"","\"with \\\" backslash\"");
		testString("\"with \\\\\" backslash\"","\"with \\\\\" backslash\"");
	}
	
	public void testString(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("s", token.getType());
		assertEquals(expectedToken, token.getText());
	}

}
