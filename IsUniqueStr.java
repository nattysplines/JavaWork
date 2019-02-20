import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class IsUniqueStr {

  private static Scanner scanner = new Scanner(System.in);

  static boolean CheckStrWithHashMap(String str) {
    HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
    for (char c : str.toCharArray()) {
      Integer value = charCounter.get(c);
      if ( value != null ) {
        return false;
      } else {
        charCounter.put(c, 1);
      }
    }
    return true;
  }

  static boolean CheckStrWithSort(String str) {
    char[] cArr = str.toCharArray();
    Arrays.sort(cArr);
    for (int i = 0; i < cArr.length - 1; i++) {
      if (cArr[i] == cArr[i+1])
        return false;
    }
    return true;
  }

  static boolean CheckStrWithArr(String str) {
    boolean[] charSet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if(charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    String str = scanner.nextLine();
    System.out.println(CheckStrWithHashMap(str));
    System.out.println(CheckStrWithSort(str));
    System.out.println(CheckStrWithArr(str));
  }

}