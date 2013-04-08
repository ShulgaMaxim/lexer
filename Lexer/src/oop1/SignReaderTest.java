package oop1;

import junit.framework.TestCase;

public class SignReaderTest extends TestCase {
	
	private TokenReader reader = new SignReader();

	public void testNull() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("asd+"));
		assertNull(reader.tryReadToken("123+"));
		assertNull(reader.tryReadToken("1+"));
		assertNull(reader.tryReadToken("a+"));
	}

public void testGeneral(){
		
		testSign("+", "+");
		testSign("-", "-");
		testSign("-123", "-");
		testSign("+1", "+");
		testSign("-asd", "-");
		testSign("+a", "+");
//		testSign("-+", "-");
//		testSign("--", "-");
//		testSign("++", "+");
//		testSign("+-", "+");
	}
	
	public void testSign(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("sg", token.getType());
		assertEquals(expectedToken, token.getText());
	}
	
}
