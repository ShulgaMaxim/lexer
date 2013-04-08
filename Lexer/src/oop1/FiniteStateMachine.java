package oop1;

import java.util.HashMap;
import java.util.HashSet;

public abstract class FiniteStateMachine implements TokenReader {
	private HashMap<Character, HashMap<Integer, Integer>> jumpTable = new HashMap<Character, HashMap<Integer, Integer>>();
	private HashSet<Integer> finalStates = new HashSet<Integer>();
	private HashMap<Integer, Integer> defaultJumps = new HashMap<Integer, Integer>();
	private String tokenType = null;

	public Token tryReadToken(String input) {
		int currentState = 0, count = 0, finalLength = 0;
		if (input.length() != 0) {			
			while (count < input.length()) {
				if (jumpTable.containsKey(input.charAt(count))) {
					currentState = jumpTable.get(input.charAt(count)).get(currentState);
					count++;
				} else if (defaultJumps.containsKey(currentState)) {
					currentState = defaultJumps.get(currentState);
					count++;
				} else {
					break;
				}
				if (finalStates.contains(currentState)) {
//					System.out.println("lalala1 "+count);
					finalLength = count;
				}
			}
			if (finalLength > 0) {
//					System.out.print("lalala2");
				return new Token(tokenType, input.substring(0, finalLength));
			}
		}
//		System.out.print(finalLength);
//		System.out.print("lalala1");
		return null;
	}

	protected void addJumpInTable(char jumpChar, int currentState, int nextState) {
		if (jumpTable.containsKey(jumpChar)) {
			jumpTable.get(jumpChar).put(currentState, nextState);
		} else {
			HashMap<Integer, Integer> jump = new HashMap<Integer, Integer>();
			jump.put(currentState, nextState);
			jumpTable.put(jumpChar, jump);
		}
		System.out.println(jumpTable);
	}

	protected void addDefaultTransition(int currentState, int nextState) {
		defaultJumps.put(currentState, nextState);
	}

	protected void addFinalStates(int state) {
		finalStates.add(state);
	}

	protected void setTokenType(String type) {
		tokenType = type;
	}

}