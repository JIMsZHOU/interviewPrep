package exp.oa.tiktok;

/**
 * Created by Jim Z on 11/22/20 17:21
 */
public class SearchSnippet {
    public String finsSnippet(String content, String queryW1, String queryW2) {
        int i1 = -1;
        int i2 = -1;
        String[] sarr = content.split(" ");
        for (int i = 0; i < sarr.length; i++) {
            if (i1 != -1 && i2 != -1) {
                break;
            }
            if (i1 == -1 && sarr[i].equalsIgnoreCase(queryW1)) {
                i1 = i;
            }
            if (i2 == -1 && sarr[i].equalsIgnoreCase(queryW2)) {
                i2 = i;
            }
        }
        if (i1 == -1 || i2 == -1) return "";
        int left = Math.max(i1 - 3, 0);
        int right = Math.min(i2 + 3, sarr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(sarr[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
