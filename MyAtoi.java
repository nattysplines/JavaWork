public class MyAtoi {
    static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        int i = 0;
        boolean isNeg = false;
        while (i < chars.length && chars[i] == ' '){
            i++;
        }
        if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
            if (chars[i] == '-') {
                isNeg = true;
            } else {
                isNeg = false;
            }
            i++;
        }
        if (i < chars.length && (chars[i] < 48 || chars[i] > 57)) {
            return result;
        }
        while ( i < chars.length && chars[i] >= 48 && chars[i] <= 57) {
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && chars[i] - 48 > 7))
                return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && chars[i] - 48 > 8))
                return Integer.MIN_VALUE;
            if (isNeg) {
                result = result * 10 - (chars[i] - 48);
            } else {
                result = result * 10 + (chars[i] - 48);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("123 String is int: " + myAtoi("123"));
        System.out.println("42 String is int: " + myAtoi("42"));
    }
    
}
