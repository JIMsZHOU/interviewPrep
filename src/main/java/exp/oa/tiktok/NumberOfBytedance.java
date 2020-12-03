package exp.oa.tiktok;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jim Z on 11/22/20 17:09
 */
public class NumberOfBytedance {
    private final String dic = "bytedance";
    public int countNumOfBytedance(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : dic.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            ans = Math.min(ans, map.get(c));
        }
        return ans;
    }
}
