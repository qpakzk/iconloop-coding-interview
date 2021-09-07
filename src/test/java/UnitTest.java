import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void testIntToHex() {
        IntToHexadecimalConverter converter = new IntToHexadecimalConverter();

        assertEquals("0x0", converter.intToHex(0));
        assertEquals("0x1", converter.intToHex(1));
        assertEquals("-0x1", converter.intToHex(-1));
        assertEquals("0x64", converter.intToHex(100));
        assertEquals("-0x64", converter.intToHex(-100));
        assertEquals("0x3e8", converter.intToHex(1000));
        assertEquals("-0x3e8", converter.intToHex(-1000));
    }

    @Test
    void testTickets() {
        Tickets tickets = new Tickets();

        assertTrue(tickets.tickets(Arrays.asList(25, 25, 50)));
        assertFalse(tickets.tickets(Arrays.asList(25, 100)));
        assertFalse(tickets.tickets(Arrays.asList(25, 25, 50, 50, 100)));
    }

    @Test
    void testPeaks() {
        Peaks peaks = new Peaks();

        Map<String, List<Integer>> expectedResult = new HashMap<>();
        expectedResult.put("pos", new ArrayList<>());
        expectedResult.put("peaks", new ArrayList<>());

        assertEquals(expectedResult, peaks.pickPeaks(new ArrayList<>()));
        assertEquals(expectedResult, peaks.pickPeaks(Arrays.asList(1)));
        assertEquals(expectedResult, peaks.pickPeaks(Arrays.asList(1, 2)));

        Map<String, List<Integer>> expectedResult2 = new HashMap<>();
        List<Integer> pos2 = Collections.singletonList(1);
        List<Integer> peaks2 = Collections.singletonList(2);
        expectedResult2.put("pos", pos2);
        expectedResult2.put("peaks", peaks2);

        assertEquals(expectedResult2, peaks.pickPeaks(Arrays.asList(1, 2, 2, 1)));

        Map<String, List<Integer>> expectedResult3 = new HashMap<>();
        List<Integer> pos3 = Collections.singletonList(1);
        List<Integer> peaks3 = Collections.singletonList(4);
        expectedResult3.put("pos", pos3);
        expectedResult3.put("peaks", peaks3);

        assertEquals(expectedResult3, peaks.pickPeaks(Arrays.asList(1, 4, 2)));

        Map<String, List<Integer>> expectedResult4 = new HashMap<>();
        List<Integer> pos4 = Arrays.asList(1, 3);
        List<Integer> peaks4 = Arrays.asList(5, 4);
        expectedResult4.put("pos", pos4);
        expectedResult4.put("peaks", peaks4);

        assertEquals(expectedResult4, peaks.pickPeaks(Arrays.asList(0, 5, 3, 4, 2)));

        assertEquals(expectedResult, peaks.pickPeaks(Arrays.asList(0, 1, 2, 3, 4, 4)));

        Map<String, List<Integer>> expectedResult5 = new HashMap<>();
        List<Integer> pos5 = Arrays.asList(3, 7);
        List<Integer> peaks5 = Arrays.asList(6, 3);
        expectedResult5.put("pos", pos5);
        expectedResult5.put("peaks", peaks5);

        assertEquals(expectedResult5, peaks.pickPeaks(Arrays.asList(3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3)));
    }
}