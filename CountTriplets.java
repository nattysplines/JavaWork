import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CountTriplets {

  private static Scanner scanner = new Scanner(System.in);

  static long countTriplets(List<Long> arr, long r) {
    long count = 0;

    HashMap<Long, Long> singleMap = new HashMap<Long, Long>();
    HashMap<Long, Long> doubleMap = new HashMap<Long, Long>();
    for( Long item : arr ) {
      
      if ( item % r == 0 ) {
        long preItem = item / r;
        Long countTriplet = doubleMap.get(preItem);
        if ( countTriplet != null ) {
          count += countTriplet;
        }
        Long countPair = singleMap.get(preItem);
        if (countPair != null) {
          doubleMap.put(item, doubleMap.getOrDefault(item, 0L) + countPair);
        }
        
      }
      singleMap.put(item, singleMap.getOrDefault(item, 0L) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int items = scanner.nextInt();
    long ratio = scanner.nextLong();
    ArrayList<Long> arr = new ArrayList<Long>(items);

    for (int i = 0; i < items; i++) {
      arr.add(scanner.nextLong());
    }

    System.out.println(countTriplets(arr, ratio));

  }

}