package oop1;

public class SeparationReader extends FiniteStateMachine {

	// States=================
	private static int start = 0, endOfSeparation = 1; ;
	// =======================
	private final static String type = "sp";

	public SeparationReader() {
		setTokenType(type);
		addFinalStates(endOfSeparation);
		addJumpInTable('{', start, endOfSeparation);
		addJumpInTable('}', start, endOfSeparation);
		addJumpInTable('(', start, endOfSeparation);
		addJumpInTable(')', start, endOfSeparation);
		addJumpInTable('[', start, endOfSeparation);
		addJumpInTable(']', start, endOfSeparation);
		addJumpInTable('=', start, endOfSeparation);
		addJumpInTable('*', start, endOfSeparation);
		addJumpInTable('/', start, endOfSeparation);
		addJumpInTable('%', start, endOfSeparation);
		addJumpInTable('^', start, endOfSeparation);
		addJumpInTable('~', start, endOfSeparation);
		addJumpInTable('|', start, endOfSeparation);
		addJumpInTable('&', start, endOfSeparation);
		addJumpInTable('>', start, endOfSeparation);
		addJumpInTable('<', start, endOfSeparation);
		addJumpInTable('!', start, endOfSeparation);
		addJumpInTable('&', start, endOfSeparation);
		addJumpInTable('@', start, endOfSeparation);
		addJumpInTable(':', start, endOfSeparation);
		addJumpInTable(';', start, endOfSeparation);
		addJumpInTable(',', start, endOfSeparation);
		addJumpInTable('.', start, endOfSeparation);
		addJumpInTable('$', start, endOfSeparation);
		addJumpInTable('#', start, endOfSeparation);
	}
	
}
