import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> times = new Stack<>();
        Stack<String> strings = new Stack<>();
        StringBuilder result = new StringBuilder();

        int i = 0;
        int open = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int number = ch - '0';
                while (true) {
                    i++;
                    if (i >= s.length() || !Character.isDigit(ch = s.charAt(i))) break;
                    number = number * 10 + (ch - '0');
                }

                times.add(number);
                continue;
            } else if (ch == '[') {
                open++;
                StringBuilder str = new StringBuilder();
                while (true) {
                    i++;
                    if (i >= s.length() || !Character.isLetter(ch = s.charAt(i))) break;
                    str.append(ch);
                }

                strings.add(str.toString());
                continue;
            } else if (ch == ']') {
                open--;
                int number = times.pop();
                String str = strings.pop();
                String encodedStr = "";
                while (number-- > 0) {
                    encodedStr += str;
                }

                if (open == 0) {
                    result.append(encodedStr);
                } else {
                    String prev = strings.pop();
                    prev += encodedStr;
                    strings.push(prev);
                }
            } else {
                if (open == 0) {
                    result.append(ch);
                }
            }
            i++;
        }

        return result.toString();
    }
}
