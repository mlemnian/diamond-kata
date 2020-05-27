package com.cgi;

import java.util.Collections;

public class Diamond {
    
    public static void printDiamond(String input) {
        char character = parseSingleCharacter(input);
        System.out.println(createDiamondString(character));
    }

    static char parseSingleCharacter(String input)
    {
        if (null == input) {
            throw new IllegalArgumentException("input is null");
        }
        if (input.length() != 1) {
            throw new IllegalArgumentException("input has wrong length");
        }

        final char character = input.toUpperCase().charAt(0);

        if (character < 'A' || character > 'Z') {
            throw new IllegalArgumentException("input is out of range A...Z");
        }
        return character;
    }

    static String createDiamondString(char character) {
        if (character == 'A') {
            return "A";
        }

        String res = "";
        int initDistance = character - 'A';
        int currentDistance = initDistance;

        // first line
        res += String.join("", Collections.nCopies(initDistance, " "));
        res += "A\n";
        currentDistance--;

        // first half
        for(char i='B'; i<character; i++, currentDistance--) {
            res += String.join("", Collections.nCopies(currentDistance, " "));
            res += i;
            res += String.join("", Collections.nCopies(2*(i-'A')-1, " "));
            res += i;
            res += '\n';
        }

        // middle
        res += character;
        res += String.join("", Collections.nCopies(2*initDistance-1, " "));
        res += character;
        res += '\n';

        // second half
        currentDistance = 1;
        for(char i=(char)((int)character-1); i>'A'; i--, currentDistance++) {
            res += String.join("", Collections.nCopies(currentDistance, " "));
            res += i;
            res += String.join("", Collections.nCopies(2*(i-'A')-1, " "));
            res += i;
            res += '\n';
        }

        // last line
        res += String.join("", Collections.nCopies(initDistance, " "));
        res += "A";

        return res;
    }
}
