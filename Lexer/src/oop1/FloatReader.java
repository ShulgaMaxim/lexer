package oop1;

public class FloatReader extends FiniteStateMachine{
	// States=================
	private static int start = 0, digitsBeforePoint = 1, point = 2,
			digitsPrefExp = 3, exponent = 4,signAfterExp = 5,digitsSufExp = 6;
	// =======================
	private final static String type = "fl";

	public FloatReader() {
		setTokenType(type);
		addFinalStates(digitsBeforePoint);
		addFinalStates(digitsPrefExp);
		addFinalStates(digitsSufExp);
		//***********Start************
		addJumpInTable('0', start, digitsBeforePoint);
		addJumpInTable('1', start, digitsBeforePoint);
		addJumpInTable('2', start, digitsBeforePoint);
		addJumpInTable('3', start, digitsBeforePoint);
		addJumpInTable('4', start, digitsBeforePoint);
		addJumpInTable('5', start, digitsBeforePoint);
		addJumpInTable('6', start, digitsBeforePoint);
		addJumpInTable('7', start, digitsBeforePoint);
		addJumpInTable('8', start, digitsBeforePoint);
		addJumpInTable('9', start, digitsBeforePoint);
		
		addJumpInTable('0', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('1', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('2', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('3', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('4', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('5', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('6', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('7', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('8', digitsBeforePoint, digitsBeforePoint);
		addJumpInTable('9', digitsBeforePoint, digitsBeforePoint);
		//*************************************
		//*******Point & digitsPrefExp*********
		addJumpInTable('.', digitsBeforePoint, point);
		addJumpInTable('0', point, digitsPrefExp);
		addJumpInTable('1', point, digitsPrefExp);
		addJumpInTable('2', point, digitsPrefExp);
		addJumpInTable('3', point, digitsPrefExp);
		addJumpInTable('4', point, digitsPrefExp);
		addJumpInTable('5', point, digitsPrefExp);
		addJumpInTable('6', point, digitsPrefExp);
		addJumpInTable('7', point, digitsPrefExp);
		addJumpInTable('8', point, digitsPrefExp);
		addJumpInTable('9', point, digitsPrefExp);
		
		addJumpInTable('0', digitsPrefExp, digitsPrefExp);
		addJumpInTable('1', digitsPrefExp, digitsPrefExp);
		addJumpInTable('2', digitsPrefExp, digitsPrefExp);
		addJumpInTable('3', digitsPrefExp, digitsPrefExp);
		addJumpInTable('4', digitsPrefExp, digitsPrefExp);
		addJumpInTable('5', digitsPrefExp, digitsPrefExp);
		addJumpInTable('6', digitsPrefExp, digitsPrefExp);
		addJumpInTable('7', digitsPrefExp, digitsPrefExp);
		addJumpInTable('8', digitsPrefExp, digitsPrefExp);
		addJumpInTable('9', digitsPrefExp, digitsPrefExp);
		//******************************************
		//************Exponent**********************
		addJumpInTable('e', digitsBeforePoint, exponent);
		addJumpInTable('E', digitsBeforePoint, exponent);
		addJumpInTable('e', digitsPrefExp, exponent);
		addJumpInTable('E', digitsPrefExp, exponent);
		addJumpInTable('+', exponent, signAfterExp);
		addJumpInTable('-', exponent, signAfterExp);
		//******************************************
		//************digitsSufExp******************
		addJumpInTable('0', exponent, digitsSufExp);
		addJumpInTable('1', exponent, digitsSufExp);
		addJumpInTable('2', exponent, digitsSufExp);
		addJumpInTable('3', exponent, digitsSufExp);
		addJumpInTable('4', exponent, digitsSufExp);
		addJumpInTable('5', exponent, digitsSufExp);
		addJumpInTable('6', exponent, digitsSufExp);
		addJumpInTable('7', exponent, digitsSufExp);
		addJumpInTable('8', exponent, digitsSufExp);
		addJumpInTable('9', exponent, digitsSufExp);
		
		addJumpInTable('0', signAfterExp, digitsSufExp);
		addJumpInTable('1', signAfterExp, digitsSufExp);
		addJumpInTable('2', signAfterExp, digitsSufExp);
		addJumpInTable('3', signAfterExp, digitsSufExp);
		addJumpInTable('4', signAfterExp, digitsSufExp);
		addJumpInTable('5', signAfterExp, digitsSufExp);
		addJumpInTable('6', signAfterExp, digitsSufExp);
		addJumpInTable('7', signAfterExp, digitsSufExp);
		addJumpInTable('8', signAfterExp, digitsSufExp);
		addJumpInTable('9', signAfterExp, digitsSufExp);
		
		addJumpInTable('0', digitsSufExp, digitsSufExp);
		addJumpInTable('1', digitsSufExp, digitsSufExp);
		addJumpInTable('2', digitsSufExp, digitsSufExp);
		addJumpInTable('3', digitsSufExp, digitsSufExp);
		addJumpInTable('4', digitsSufExp, digitsSufExp);
		addJumpInTable('5', digitsSufExp, digitsSufExp);
		addJumpInTable('6', digitsSufExp, digitsSufExp);
		addJumpInTable('7', digitsSufExp, digitsSufExp);
		addJumpInTable('8', digitsSufExp, digitsSufExp);
		addJumpInTable('9', digitsSufExp, digitsSufExp);
	}
}