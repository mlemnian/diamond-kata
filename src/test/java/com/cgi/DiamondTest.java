package com.cgi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondTest {
    @Test
    public void testParsePositiveUppercase() {
        for (char c = 'A'; c <= 'Z'; c++) {
            String msg = "letter '" + c + "' is parsed wrongly";
            assertEquals(msg, c, Diamond.parseSingleCharacter(""+c));
        }
    }

    @Test
    public void testParsePositiveLowercase() {
        for (char c = 'a'; c <= 'z'; c++) {
            String msg = "letter '" + c + "' is parsed wrongly";
            assertEquals(msg, Character.toUpperCase(c), Diamond.parseSingleCharacter(""+c));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputNull() {
        Diamond.parseSingleCharacter(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputWrongLength() {
        Diamond.parseSingleCharacter("wrong length");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputEmpty() {
        Diamond.parseSingleCharacter("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputWrongCharacter1() {
        // one before "A" in ASCII
        Diamond.parseSingleCharacter("@");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputWrongCharacter2() {
        // one after "Z" in ASCII
        Diamond.parseSingleCharacter("[");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputWrongCharacter3() {
        // one before "a" in ASCII
        Diamond.parseSingleCharacter("`");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputWrongCharacter4() {
        // one after "z" in ASCII
        Diamond.parseSingleCharacter("{");
    }

    @Test
    public void testA() {
        String createDiamondString = Diamond.createDiamondString('A');
        assertEquals("diamond for 'A' is incorrect", "A", createDiamondString);
    }

    @Test
    public void testB() {
        String createDiamondString = Diamond.createDiamondString('B');
        String expected = " A\nB B\n A";
        assertEquals("diamond for 'B' is incorrect", expected, createDiamondString);
    }

    @Test
    public void testC() {
        String createDiamondString = Diamond.createDiamondString('C');
        String expected = "  A\n B B\nC   C\n B B\n  A";
        assertEquals("diamond for 'C' is incorrect", expected, createDiamondString);
    }

    @Test
    public void testD() {
        String createDiamondString = Diamond.createDiamondString('D');
        String expected = "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A";
        assertEquals("diamond for 'C' is incorrect", expected, createDiamondString);
    }
}