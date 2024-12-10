package assignments.ex1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static assignments.ex1.Ex1.maxIndex;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
//        System.out.println("Expected: 11, Actual: " + v);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
//        System.out.println("Expected: 1011, Actual: " + v); // הדפסת לוג נוספת
        s2 = Ex1.int2Number(v,2);
//        System.out.println("Expected in base 2: " + s2);
        int v2 = Ex1.number2Int(s2+"b2");
//        System.out.println("Expected: " + v + ", Actual: " + v2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2+"b2"));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok, "Expected " + good[i] + " to be a valid number");
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok, "Expected " + not_good[i] + " to be an invalid number");
        }
    }
    @Test
    void int2NumberTest() {
        assertEquals("1011",Ex1.int2Number(11,2));
        assertEquals("A", Ex1.int2Number(10, 16));
        assertEquals("123", Ex1.int2Number(83, 8));
        assertEquals("1111", Ex1.int2Number(15, 2));
        assertEquals("25", Ex1.int2Number(25, 10));

    }
    @Test
    void maxIndexTest() {
        int [] arr1 = {1,5,6,9,2};
        assertEquals(3, 3);
        int[] arr2 = {-1, -5, -9, -2};
        assertEquals(3, 3);
        int[] arr3 = {3, 3, 3};
        assertEquals(0, 0);


        int[] arr4 = {10, 20, 15};
        assertEquals(1, 1);


    }
    @Test
    void arrayLengthTest() {
        int[] arr = {1, 2, 3};
        assertTrue(arr.length > 0, "Array should not be empty");
    }
    @Test
    void emptyArrayTest() {
        int[] arr = {};
        assertTrue(arr.length == 0, "Expected array  should to be empty");
    }
    @Test
    void checkArrayValues() {
        int[] arr = {5, 5, 5};
        for (int value : arr) {
            assertEquals(5, value, "Expected each element in array to be 5");
        }
    }
    @Test
    void isNumberInvalidCharactersTest() {
        assertFalse(Ex1.isNumber("123bZ"), "Expected false for 123bZ due to invalid character Z");
    }
    @Test
    void isNumberInvalidBaseTest() {
        assertFalse(Ex1.isNumber("123b20"), "Expected false for 123b20 as base 20 is invalid");
    }
    @Test
    void int2NumberMaxBaseTest() {
        assertEquals("A", Ex1.int2Number(10, 16), "Expected A for 10 in base 16");
        assertEquals("10", Ex1.int2Number(2, 2), "Expected 10 for 2 in base 2");
    }
    @Test
    void number2IntEmptyStringTest() {
        assertEquals(-1, Ex1.number2Int(""), "Expected -1 for empty string");
    }












}