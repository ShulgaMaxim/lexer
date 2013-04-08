package oop1;

public class EndOfLineComment extends FiniteStateMachine {
	// States=================
	private static int start = 0, slash = 1, commentLine = 2, lineEnd = 3;
	// =======================
	private final static String type = "ec";

	public EndOfLineComment() {
		setTokenType(type);
		addFinalStates(lineEnd);
		addFinalStates(commentLine);
		addDefaultTransition(commentLine, commentLine);
		addJumpInTable('/', start, slash);
		addJumpInTable('/', slash, commentLine);
		addJumpInTable('\n', commentLine, lineEnd);
	}

}
