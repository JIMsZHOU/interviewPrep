package exp.oa.tigergraph;

import java.util.List;

/**
 * Created by Jim Z on 11/9/20 14:52
 */
public class Strokes {
    public static int strokesRequired(List<String> picture) {
        // Write your code here
        int cnt = 0;
        // check conner case
        if (picture.size() == 0) return cnt;
        int m = picture.size();
        int n = picture.get(0).length();
        char[][] pic = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pic[i][j] = picture.get(i).charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char stroke = pic[i][j];
                if (stroke != 'X') {
                    cnt++;
                    findConnectStroke(pic, i, j, m, n, stroke);
                }
            }
        }
        return cnt;
    }

    private static void findConnectStroke(char[][] pic, int i, int j, int m, int n, char stroke) {
        if (i < 0 || j < 0 || i >= m || j >= n || pic[i][j] != stroke) {
            return;
        }
        // set the visited stroke to X
        pic[i][j] = 'X';
        findConnectStroke(pic, i + 1, j, m, n, stroke);
        findConnectStroke(pic, i - 1, j, m, n, stroke);
        findConnectStroke(pic, i, j + 1, m, n, stroke);
        findConnectStroke(pic, i, j - 1, m, n, stroke);
    }
}
