import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}