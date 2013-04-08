package oop1;

public class SignReader extends FiniteStateMachine{

	// States=================
	private static int start = 0, plusOrMinus = 1; ;
	// =======================
	private final static String type = "sg";

	public SignReader() {
		setTokenType(type);
		addFinalStates(plusOrMinus);
		addJumpInTable('-', start, plusOrMinus);
		addJumpInTable('+', start, plusOrMinus);
	}
	
}
