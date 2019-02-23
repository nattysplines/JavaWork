import java.util.ArrayList;

public class ZigZagString {

    public static void main(String[] args) {
        System.out.println("methodical in zig zag 3: ");
        System.out.println(convert("methodical", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
        
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int currentRow = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow >= numRows - 1) {
                down = false;
            } else if (currentRow <= 0) {
                down = true;
            }
            currentRow += (down) ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb.toString());
        }
        
        return result.toString();
    }
}