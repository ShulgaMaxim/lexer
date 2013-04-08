package oop1;

import junit.framework.TestCase;

public class IntReaderTest extends TestCase {
	
	private IntReader reader = new IntReader();

	public void testNotANumbers() {
		assertNull(reader.tryReadToken(""));
		assertNull(reader.tryReadToken("qwerty"));
		assertNull(reader.tryReadToken("a"));
		assertNull(reader.tryReadToken("_"));
		assertNull(reader.tryReadToken("_12345"));
		assertNull(reader.tryReadToken(" 1234"));
	}

	public void testDecimal() {
		checkInt("0", "0", 0);
		checkInt("1", "1", 1);
		checkInt("0bksvgsbk", "0", 0);
		checkInt("0b","0",0);
		checkInt("0x","0",0);
		checkInt("08","0",0);
		checkInt("0b2","0",0);
		checkInt("0xG","0",0);
		checkInt("1__", "1", 1);
		checkInt("1_1", "1_1", 11);
		checkInt("48__84_7","48__84_7",48847);
		checkInt("2147483647","2147483647",2147483647);
		checkLong("9223372036854775807L", "9223372036854775807L", 9223372036854775807l);
	}

	public void testHex() {
		checkInt("0x1","0x1",1);
		checkInt("0XA","0xA",10);
		checkInt("0xabcdef1__","0xabcdef1",180150001);
		checkInt("0xabcdefg","0xabcdef",11259375);
		checkInt("0x0", "0x0", 0);
		checkInt("0x1ACF", "0x1ACF", 6863);
		checkInt("0x00FF00FF", "0x00FF00FF", 16711935);
		checkInt("0x1", "0x1", 1);
		checkInt("0x00_FF__00_FF", "0x00_FF__00_FF", 16711935);
		checkLong("0x7fff_ffff_ffff_ffffL", "0x7fff_ffff_ffff_ffffL", 9223372036854775807l);
	}

	public void testBinary() {
		checkInt("0B1","0b1",1);
		checkInt("0b0101","0b0101",5);
		checkInt("0b1__","0b1",1);
		checkInt("0b11qweqwrqwr","0b11",3);
		checkInt("0b0_1_0__1","0b0_1_0__1",5);
		checkInt("0b0_1_0__1_","0b0_1_0__1",5);
		checkInt("0b0_1_0__1_","0b0_1_0__1",5);
		checkInt("0b0111_1111_1111_1111_1111_1111_1111_1111","0b0111_1111_1111_1111_1111_1111_1111_1111",2147483647);
		checkLong("0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L", 
				"0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L", 
				9223372036854775807l);
	}

	public void testOct() {
		checkInt("017777777777", "017777777777", 2147483647);
		checkInt("017", "017", 15);
		checkInt("01", "01", 1);
		checkInt("01dcfv", "01", 1);
		checkInt("01___", "01", 1);
		checkInt("0177_7777", "0177_7777", 524287);
		checkLong("07_7777_7777_7777_7777_7777L", "07_7777_7777_7777_7777_7777L", 9223372036854775807l);
	}

	private void checkInt(String input, String expectedToken, int expectedValue) {
		Token token = reader.tryReadToken(input);
		assertEquals("i", token.getType());
		assertEquals(expectedToken, token.getText());
		assertEquals(expectedValue, token.getValue());

	}
	
	private void checkLong(String input, String expectedToken, long expectedValue) {
		Token token = reader.tryReadToken(input);
		assertEquals("i", token.getType());
		assertEquals(expectedToken, token.getText());
		assertEquals(expectedValue, token.getValue());
		}
}