/**
 * @author Hanz
 * @date 2020/5/15
 */
public class LongestPalindromicSubstring {


    public static String longestPalindromicSubstring(String s) {
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            findLongest(str, i, range);
        }
        return s.substring(range[0],range[1]);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
