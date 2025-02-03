package com.example.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {

    @Test
    public void testIsPrime() {
        assertTrue(NumberUtils.isPrime(2));
        assertTrue(NumberUtils.isPrime(3));
        assertFalse(NumberUtils.isPrime(4));
        assertTrue(NumberUtils.isPrime(5));
        assertFalse(NumberUtils.isPrime(1));
        assertFalse(NumberUtils.isPrime(0));
        assertFalse(NumberUtils.isPrime(-1));
    }

    @Test
    public void testIsPerfect() {
        assertTrue(NumberUtils.isPerfect(6)); // 6 is a perfect number
        assertTrue(NumberUtils.isPerfect(28)); // 28 is a perfect number
        assertFalse(NumberUtils.isPerfect(5));
        assertFalse(NumberUtils.isPerfect(12));
    }

    @Test
    public void testIsArmstrong() {
        assertTrue(NumberUtils.isArmstrong(153)); // 153 is an Armstrong number
        assertTrue(NumberUtils.isArmstrong(371)); // 371 is an Armstrong number
        assertFalse(NumberUtils.isArmstrong(123));
        assertFalse(NumberUtils.isArmstrong(10));
    }

    @Test
    public void testGetDigitSum() {
        assertEquals(6, NumberUtils.getDigitSum(123)); // 1 + 2 + 3 = 6
        assertEquals(10, NumberUtils.getDigitSum(1234)); // 1 + 2 + 3 + 4 = 10
        assertEquals(1, NumberUtils.getDigitSum(1000)); // 1 + 0 + 0 + 0 = 1
    }

    @Test
    public void testGetProperties() {
        assertArrayEquals(new String[]{"armstrong", "odd"}, NumberUtils.getProperties(153));
        assertArrayEquals(new String[] { "armstrong", "odd" }, NumberUtils.getProperties(371));
        assertArrayEquals(new String[] { "armstrong", "even" }, NumberUtils.getProperties(370));
        assertArrayEquals(new String[]{"armstrong", "even"}, NumberUtils.getProperties(9474));
        assertArrayEquals(new String[] { "odd" }, NumberUtils.getProperties(15));
        assertArrayEquals(new String[]{"odd"}, NumberUtils.getProperties(77));
        assertArrayEquals(new String[]{"even"}, NumberUtils.getProperties(14));
        assertArrayEquals(new String[]{"even"}, NumberUtils.getProperties(10));
    }
}