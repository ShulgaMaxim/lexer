package oop1;

/**
 * 
 * ������ ������� ������ ����������� ��������� ����� �����.
 * @return ���������� ����������� ������� ������.
 */

public class IntReader implements TokenReader{

/**
 * 
 * @param input - ������.
 * ���������, �������� �� ������� ������ ������.
 * @return �������� ������� tryReadNumber, ��� NaN
 */
	
	public Token tryReadToken(String input) {

		if (input.length() == 0) {
			return null;
		}
		if (input.length() == 2 && isOctalNumeral(input)) {
			return tryReadNumber(input, 8, 1, "0");
		}
		if (input.length() > 2) {
			if (isOctalNumeral(input)) {
				return tryReadNumber(input, 8, 1, "0");
			}
			String tmp = input.substring(0, 2);
			tmp = tmp.toLowerCase();
			if (tmp.equalsIgnoreCase("0b")
					&& (Character.digit(input.charAt(2), 2) != -1)) {
				return tryReadNumber(input, 2, 2, "0b");
			}
			if (tmp.equals("0x")
					&& (Character.digit(input.charAt(2), 16) != -1)) {
				return tryReadNumber(input, 16, 2, "0x");
			}
		}
		if (isDecimalNumeral(input)) {
			return tryReadNumber(input, 10, 0, "");
		}
		return null;
	}

	/**
	 * 
	 * @param input - ������, ������� �������,  �������� ������.
	 * @param notation - ������� ���������, � ������� �������� �����.
	 * @param offset - �������� �����.
	 * @param prefix - �������, ������� ������������� � ������� ���������.
	 * ������� ������������� ��� �������� ������.
	 * @return �����.
	 */
	
	public Token tryReadNumber(String input, int notation, int offset,String prefix) {

		input = input.substring(offset, input.length());
		if (input.startsWith("0") && notation == 10) {
			return new Token("i", "0", 0);
		}
		input = parseNumber(input, notation);
		String stringWithoutUnderscores = input.replaceAll("_", "");
		if (isLongNumeral(input)) {
			stringWithoutUnderscores = stringWithoutUnderscores.substring(0,stringWithoutUnderscores.length()-1);
			long longValue = Long.parseLong(stringWithoutUnderscores, notation);
			input = prefix.concat(input);
			return new Token("i", input, longValue);
		}
		int value = Integer.parseInt(stringWithoutUnderscores, notation);
		input = prefix.concat(input);
		return new Token("i", input, value);

	}

	/**
	 * 
	 * @param input - ������.
	 * @param notation - ������� ���������, � ������� �������� �����.
	 * ������� � ����������, ��������������� ������� ������, ������� �������� ������.
	 * �������. �� ������� �� ��� ���, ���� ������� ������������� ������� ����.
	 * @return �����, ������� ��������� � ������.
	 */
	
	public String parseNumber(String input, int notation) {
		int count = 0;
		int len = input.length();
		if (Character.digit(input.charAt(count), notation) != -1) {
			count++;
			while (count < len && (Character.digit(input.charAt(count), notation) != -1 || (input.charAt(count) == '_'))) {
				if (input.charAt(count) == '_') {
					int countOfUndersc = count;
					while (countOfUndersc < len && input.charAt(countOfUndersc) == '_') {
						countOfUndersc++;
					}
					if (countOfUndersc < len && (Character.digit(input.charAt(countOfUndersc),notation) != -1)) {
						count = countOfUndersc;
					} else {
						break;
					}
				} else {
					count++;
				}
			}
			if ((count+1 <= len) && isLongNumeral(input.substring(0, count+1))) {
				input = input.substring(0, count+1);
			}
			else{
				input = input.substring(0, count);
			}
		}
		return input;
	}

	/**
	 * 
	 * @param input - ������
	 * ���������, �������� �� ����� � �������� ������ ���������� �����.
	 * @return ������� ��� ����.
	 */
	
	public boolean isDecimalNumeral(String input) {
		input = input.toLowerCase();
		if (input.length() == 2) {
			if (input.startsWith("0")
					&& (Character.digit(input.charAt(1), 8) == -1)) {
				return true;
			}
		}
		if (input.length() > 2) {
			if (input.startsWith("0x")
					&& (Character.digit(input.charAt(2), 16) == -1)) {
				return true;
			}
			if (input.startsWith("0b")
					&& (Character.digit(input.charAt(2), 2) == -1)) {
				return true;
			}

			if ((Character.digit(input.charAt(0), 10) != -1)
					&& ((Character.digit(input.charAt(1), 10) != -1) || input.charAt(1) == '_')) {
				return true;
			}
		} else {
			if (Character.digit(input.charAt(0), 10) != -1) {
				return true;
			}

		}
		return false;
	}

	/**
	 * 
	 * @param input - ������
	 * ���������, �������� �� ����� � �������� ������ ������������ �����.
	 * @return ������� ��� ����.
	 */
	
	
	public boolean isOctalNumeral(String input) {
		if (input.charAt(0) == '0'
				&& (Character.digit(input.charAt(1), 8) != -1)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param input - ������
	 * ���������, �������� �� ����� � ������ ���� long.
	 * @return ������� ��� ����.
	 */
	
	public boolean isLongNumeral(String input){
		int len = input.length();
		if (input.charAt(len-1) == 'l' || input.charAt(len-1) == 'L') {
			return true;
		}
		return false;
	}

	
}