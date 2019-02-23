public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        
        int len = s.length();
        int start = 0;
        int end = 0;
        
        boolean[][] arr = new boolean[len][len];
        
        //all single letters are palindromes, diagonal through array
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = true;
            start = i;
            end = i + 1;
        }
        
        //all matching pairs are palindromes
        for (int i = 0; i < arr.length - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                arr[i][i+1] = true;
                start = i;
                end = i + 1 + 1;                
            }
        }
        
        //iterate through rest of top right of array
        for (int l = 3; l <= len; l++) {
            //realized needed +1 in loop boolean when failing to find full length palindrome
            for (int i = 0; i < len - l + 1; i++) {
                int j = i+l-1;
                if(arr[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = true;
                    start = i;
                    end = j + 1;
                }
            }
        }
        
        return s.substring(start, end);
        
    }

    public String longestPalindromeNspace(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
}