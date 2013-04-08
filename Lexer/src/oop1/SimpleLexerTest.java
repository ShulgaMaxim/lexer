package oop1;


import junit.framework.TestCase;

public class SimpleLexerTest extends TestCase {
	public static TokenReader[] tokens = { 
		new IntReader(),
		new IdentifierReader(), 
		new WhitespaceReader() 
		};

	public static TokenReader[] readers = { 
			new WordReader("number",false),
			new WordReader("numb",false),
			new IdentifierReader(), 
			new IntReader(),
			new WhitespaceReader()
			
	};
	public static TokenReader[] readers2 = {
			new IdentifierReader(), 
			new IntReader(),
			new WhitespaceReader(),
			new WordReader("number",false)
			
	};
	
	public static TokenReader[] emptySet = new TokenReader[0];
	
	public void testCase() {
		SimpleLexer test = new SimpleLexer("41is abc", tokens);
		tokenTest("i", "41", 41, test.readNextToken());
		tokenTest("if", "is", "is", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "abc", "abc", test.readNextToken());
		assertEquals(false, test.hasNextToken());

		test = new SimpleLexer("8736bdf   pop__", tokens);
		tokenTest("i", "8736", 8736, test.readNextToken());
		tokenTest("if", "bdf", "bdf", test.readNextToken());
		tokenTest("ws", "   ", "   ", test.readNextToken());
		assertEquals(true, test.hasNextToken());
		tokenTest("if", "pop__", "pop__", test.readNextToken());
		assertEquals(false, test.hasNextToken());

		test = new SimpleLexer("  aadsd876dsd 123_32", tokens);
		tokenTest("ws", "  ", "  ", test.readNextToken());
		tokenTest("if", "aadsd876dsd", "aadsd876dsd", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("i", "123_32", 12332, test.readNextToken());
		test = new SimpleLexer("12345__dd", tokens);
		tokenTest("i", "12345", 12345, test.readNextToken());
		tokenTest("if", "__dd", "__dd", test.readNextToken());
		assertEquals(false, test.hasNextToken());

	}

	public void testNull() {
		SimpleLexer test = new SimpleLexer(";;;;", tokens);
		assertNull(test.readNextToken());
		assertEquals(true, test.hasNextToken());
		test = new SimpleLexer("", tokens);
		assertNull(test.readNextToken());
		assertFalse(test.hasNextToken());
		test = new SimpleLexer("(((((", tokens);
		assertNull(test.readNextToken());
		assertEquals(true, test.hasNextToken());
		test = new SimpleLexer("--123", tokens);
		assertNull(test.readNextToken());
		assertEquals(true, test.hasNextToken());
		test = new SimpleLexer("#######adasd", tokens);
		assertNull(test.readNextToken());
		assertEquals(true, test.hasNextToken());
	}
	
	public void testEmpty(){
		SimpleLexer test = new SimpleLexer("lalala", emptySet);
		assertNull(test.readNextToken());
		assertEquals(true, test.hasNextToken());
		test = new SimpleLexer("", emptySet);
		assertNull(test.readNextToken());
		assertFalse(test.hasNextToken());
	}

	public void testConflict(){
	
		SimpleLexer test = new SimpleLexer("41is the number ***", readers);
		tokenTest("i", "41", 41, test.readNextToken());
		tokenTest("if", "is", "is", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "the", "the", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("kw", "number", "number", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		assertEquals(true, test.hasNextToken());
		
		test = new SimpleLexer("41is the numb___er *", readers);
		tokenTest("i", "41", 41, test.readNextToken());
		tokenTest("if", "is", "is", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "the", "the", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "numb___er", "numb___er", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		assertEquals(true, test.hasNextToken());
		
		test = new SimpleLexer("41is the number *", readers2);
		tokenTest("i", "41", 41, test.readNextToken());
		tokenTest("if", "is", "is", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "the", "the", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		tokenTest("if", "number", "number", test.readNextToken());
		tokenTest("ws", " ", " ", test.readNextToken());
		assertEquals(true, test.hasNextToken());
	
	}
	public void tokenTest(String exceptedToken, String exceptedText, Object exceptedIntValue, Token token) {
		assertEquals(exceptedText, token.getText());
		assertEquals(exceptedToken, token.getType());
		assertEquals(exceptedIntValue, token.getValue());
	}
}
