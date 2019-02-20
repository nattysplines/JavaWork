    //pale ple 1

    //pale pales -1

    //pale bale 1 -1 <-- anything more than this is bad, above good

    //pale bake 1 1 -1 -1

import java.util.HashMap;
import java.util.Scanner;

public class OneAway {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();
    
    System.out.println(checkOneAway(str1, str2));

  }

  static boolean checkOneAway(String str1, String str2) {

    if (Math.abs(str1.length() - str2.length()) > 1) {
      return false;
    }

    HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();

    for (int i = 0; i < str1.length(); i++) {
      char c = str1.charAt(i);
      charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < str2.length(); i++) {
      char c = str2.charAt(i);
      charCounter.put(c, charCounter.getOrDefault(c, 0) - 1);
    }

    boolean posFound = false;
    boolean negFound = false;

    for (char key : charCounter.keySet()) {
      if(charCounter.get(key) > 0) {
        if (posFound) {
          return false;
        }
        posFound = true;
      }
      if(charCounter.get(key) < 0) {
        if (negFound) {
          return false;
        }
        negFound = true;
      }
    }

    return true;

  }

}