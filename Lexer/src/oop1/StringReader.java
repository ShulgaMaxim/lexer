package oop1;

public class StringReader extends FiniteStateMachine{

	// States=================
	private static int start = 0, string = 1,backSlash = 2,finishQuote = 3; ;
	// =======================
	private final static String type = "s";

	public StringReader() {
		setTokenType(type);
		addFinalStates(finishQuote);
		addDefaultTransition(string, string);
		addDefaultTransition(backSlash, string);
		addJumpInTable('"', start, string);
		addJumpInTable('\\', string, backSlash);
		addJumpInTable('\\', backSlash, backSlash);
		addJumpInTable('"', backSlash, string);
		addJumpInTable('"', string, finishQuote);
	}

}
