package com.learning.twentythree.dsalgo.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @Test
    void longestPalindrome() {
        String actualResult = longestPalindromicSubstring.longestPalindrome("babad");
        System.out.println("Actual Result: " + actualResult);
        assertEquals("bab", actualResult);
    }

    @Test
    void longestPalindrome_1() {
        String actualResult = longestPalindromicSubstring.longestPalindrome("cbbd");
        System.out.println("Actual Result: " + actualResult);
        assertEquals("bb", actualResult);
    }
}