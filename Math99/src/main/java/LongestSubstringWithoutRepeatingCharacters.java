import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hanz
 * @date 2020/4/26
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int maxLength = longestSubstringWithoutRepeatingCharacters("dvdf");
        System.out.println(maxLength);
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;
    }
}
