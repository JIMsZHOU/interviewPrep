package exp.oa.tiktok;

import java.util.*;

/**
 * Created by Jim Z on 11/22/20 21:13
 */
public class CommonElementsInArrays {
    public int[] findCommonElems(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if (arr1.length > arr2.length) {
            int[] temp = null;
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : arr2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                ans.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
