package oop1;

import junit.framework.TestCase;

public class CharReaderTest extends TestCase{
	
	private TokenReader reader = new CharReader();

	public void testNull() {

		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("abcdef"));
		assertNull(reader.tryReadToken("\'"));
		assertNull(reader.tryReadToken("\'adsadasd"));
		assertNull(reader.tryReadToken("\'adsadasd\'"));
		assertNull(reader.tryReadToken("\'\\a\'"));

	}
	
	
	public void testGeneral(){
		
		testChar("\'\'", "\'\'");
		testChar("\'l\'", "\'l\'");
		testChar("\'\\n\'","\'\\n\'");
		testChar("\'\\f\'","\'\\f\'");
		testChar("\'\\r\'","\'\\r\'");
		testChar("\'\\b\'","\'\\b\'");
		testChar("\'\\t\'","\'\\t\'");
		testChar("\'\\\'\'","\'\\\'\'");
		testChar("\'\\\\\'","\'\\\\\'");
		testChar("\'l\'d\'", "\'l\'");
		
//		testChar("\'\\\\\'b\'","\'\\\\\'");
	}
	
	public void testChar(String input, String expectedToken) {
		Token token = reader.tryReadToken(input);
		assertEquals("ch", token.getType());
		assertEquals(expectedToken, token.getText());
	}

}
