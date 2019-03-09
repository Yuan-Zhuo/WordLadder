import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void generate_string() {
        assertEquals("data date cate cade code", com.word.WordLadder.get_path("code", "data"));
    }
}
