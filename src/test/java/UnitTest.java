import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}