package oop1;

import junit.framework.TestCase;

public class SeparationReaderTest extends TestCase{
	
	private TokenReader reader = new SeparationReader();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("asd{"));
		assertNull(reader.tryReadToken("123}"));
		assertNull(reader.tryReadToken("1["));
		assertNull(reader.tryReadToken("a]"));
	}

	public void testGeneral(){
		
		testSep("{", "{");
		testSep("{ ", "{");
		testSep("{ 123", "{");
		testSep("{asdas", "{");
	}
	
	public void testSep(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("sp", token.getType());
		assertEquals(expectedToken, token.getText());
	}

}