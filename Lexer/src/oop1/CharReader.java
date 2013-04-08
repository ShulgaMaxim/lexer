package oop1;

public class CharReader extends FiniteStateMachine{
	
	// States=================
	private static int start = 0, firstQuote = 1,endOfChar = 3,backSlash = 2,finishQuote = 4; ;
	// =======================
	private final static String type = "ch";

	public CharReader() {
		setTokenType(type);
		addFinalStates(finishQuote);
		addDefaultTransition(firstQuote,endOfChar);
		addJumpInTable('\'', start, firstQuote);
		addJumpInTable('\\', firstQuote, backSlash);
		addJumpInTable('b', backSlash, endOfChar);
		addJumpInTable('t', backSlash, endOfChar);
		addJumpInTable('n', backSlash, endOfChar);
		addJumpInTable('r', backSlash, endOfChar);
		addJumpInTable('f', backSlash, endOfChar);
		addJumpInTable('\\', backSlash, endOfChar);
		addJumpInTable('\'', backSlash, endOfChar);
		addJumpInTable('\"', backSlash, endOfChar);
		addJumpInTable('\'', endOfChar, finishQuote);
		addJumpInTable('\'', firstQuote, finishQuote);
	}

}
