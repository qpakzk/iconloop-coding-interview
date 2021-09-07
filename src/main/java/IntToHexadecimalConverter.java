public class IntToHexadecimalConverter {

    private static final char[] hexNums = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String intToHex(int value) {
        String head = "0x";
        if (value < 0) {
            head = "-".concat(head);
        }

        StringBuilder hex;
        if (value == 0) {
            hex = new StringBuilder("0");
        } else {
            hex = new StringBuilder();
            int quotient = value < 0 ? -value : value;
            while (quotient > 0) {
                int remainder = quotient % 16;
                hex.insert(0, hexNums[remainder]);
                quotient /= 16;
            }
        }

        hex.insert(0, head);
        return hex.toString();
    }
}
