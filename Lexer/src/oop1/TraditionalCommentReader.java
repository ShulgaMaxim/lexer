package oop1;

public class TraditionalCommentReader extends FiniteStateMachine {

	// States=================
	private static int start = 0, slash = 1, commentTail = 2,
			commentTailStar = 3, finalSlash = 4;
	// =======================
	private final static String type = "tc";

	public TraditionalCommentReader() {
		setTokenType(type);
		addFinalStates(finalSlash);
		addDefaultTransition(commentTail, commentTail);
		addDefaultTransition(commentTailStar, commentTail);
		addJumpInTable('/', start, slash);
		addJumpInTable('*', slash, commentTail);
		addJumpInTable('*', commentTail, commentTailStar);
		addJumpInTable('*', commentTailStar, commentTailStar);
		addJumpInTable('/', commentTailStar, finalSlash);
	}
}
