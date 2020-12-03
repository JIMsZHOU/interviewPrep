package exp.oa.tiktok;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jim Z on 11/22/20 21:41
 */
public class MinimumCharacterTransformation {

    private class UF {

        private Map<Character, Character> uf = new HashMap<>();

        private void union(char a, char b) {

        }

        private char find(char f) {

        }
    }

    public int minTransform(String source, String target) {
        int ans = 0;
        if (source.equals(target)) return ans;
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (map.getOrDefault(source.charAt(i), target.charAt(i)) != target.charAt(i)) {
                return -1;
            }
            map.put(source.charAt(i), target.charAt(i));

        }

    }
}
