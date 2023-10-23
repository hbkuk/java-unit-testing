package structure.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static structure.stack.CheckBrace.checkBrace;
import static structure.stack.CheckBrace.checkBraceWithStack;

public class CheckBraceTest {

    @Test
    @DisplayName("괄호의 유효성을 체크한다.")
    public void checkBraceTest() throws Exception {
        assertTrue(checkBrace("(())"));
        assertTrue(checkBrace("()()"));

        assertFalse(checkBrace(")(())("));
        assertFalse(checkBrace("(())("));
        assertFalse(checkBrace(")(())"));
        assertFalse(checkBrace("(()"));
        assertFalse(checkBrace("())"));

        assertTrue(checkBrace("(asdc;aga;ac;dsc;)"));
        assertTrue(checkBrace("(aaa(bbb)ccc)"));
    }

    @Test
    @DisplayName("Stack을 활용해서 괄호의 유효성을 체크한다.")
    public void checkBraceWithStackTest() throws Exception {
        assertTrue(checkBraceWithStack("(())"));
        assertTrue(checkBraceWithStack("()()"));

        assertFalse(checkBraceWithStack(")()("));

        assertFalse(checkBraceWithStack(")(())("));
        assertFalse(checkBraceWithStack("(())("));
        assertFalse(checkBraceWithStack(")(())"));
        assertFalse(checkBraceWithStack("(()"));
        assertFalse(checkBraceWithStack("())"));

        assertTrue(checkBraceWithStack("(asdc;aga;ac;dsc;)"));
        assertTrue(checkBraceWithStack("(aaa(bbb)ccc)"));
    }
}
