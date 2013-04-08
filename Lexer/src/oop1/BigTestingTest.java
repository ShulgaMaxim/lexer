package oop1;

import junit.framework.TestCase;

public class BigTestingTest extends TestCase{
	TokenReader[] readerSet = new TokenReader[]{
		new WhitespaceReader(),
		new IntReader(),
		new FloatReader(),
		new IdentifierReader(),
		new StringReader(),
		new CharReader(),
		new EndOfLineComment(),
		new TraditionalCommentReader(),
		
		new WordReader("{"),
		new WordReader("}"),
		new WordReader("("),
		new WordReader(")"),
		new WordReader("["),
		new WordReader("]"),
		new WordReader("="),
		new WordReader("+"), //SignReader
		new WordReader("-"), //SignReader
		new WordReader("*"),
		new WordReader("/"),
		new WordReader("%"),
		new WordReader("^"),
		new WordReader("~"),
		new WordReader("|"),
		new WordReader("&"),
		new WordReader(">"),
		new WordReader("<"),
		new WordReader("!"),
		new WordReader("?"),
		new WordReader("@"),
		new WordReader(";"),
		new WordReader(":"),
		new WordReader(","),
		new WordReader(".")
	};

}
