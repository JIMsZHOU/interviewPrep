package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 17:41
 */
class SearchSnippetTest {

    SearchSnippet o = new SearchSnippet();

    @Test
    void test1() {
        String ans = o.finsSnippet("ByteDance is a technology company operating a range of content platforms that inform, educate, entertain ans inspire people across the world", "bytedance", "people");
        System.out.println(ans);
    }

}