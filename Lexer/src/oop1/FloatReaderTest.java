package oop1;

import junit.framework.TestCase;

public class FloatReaderTest extends TestCase{
	
	private TokenReader reader = new FloatReader();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("lalala123"));
		assertNull(reader.tryReadToken("_123"));
	}
	
	public void testGeneral(){
		testFloat("0", "0");
		testFloat("0 ", "0");
		testFloat("1", "1");
		testFloat("10 5", "10");
		testFloat("10. 5", "10");
		testFloat("10.5", "10.5");
		testFloat("10.5aaaaa", "10.5");
		testFloat("10.5e", "10.5");
		testFloat("10.5E", "10.5");
		testFloat("10.5e2", "10.5e2");
		testFloat("10.5e+2", "10.5e+2");
		testFloat("10.5e-2", "10.5e-2");
	}

	public void testFloat(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("fl", token.getType());
		assertEquals(expectedToken, token.getText());
	}

}
