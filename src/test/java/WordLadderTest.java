import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    //EXCEPTION
    @Test
    @DisplayName("Exception throw works well.")
    void exceptionTesting() {

        assertThrows(com.word.WordLadderExpcetion.class,
                ()->com.word.WordLadder.get_path("abcd","life"),
                "word1 error");

        assertThrows(com.word.WordLadderExpcetion.class,
                ()->com.word.WordLadder.get_path("movie","zzzzz"),
                "word2 error");

        assertThrows(com.word.WordLadderExpcetion.class,
                ()->com.word.WordLadder.get_path("movie","cat"),
                "length error");

        assertThrows(com.word.WordLadderExpcetion.class,
                ()->com.word.WordLadder.get_path("spherules","aasvogels"),
                "no path");

    }

    //RESULT
    @Test
    @DisplayName("String path return works well.")
    void stringTesting() {

        assertEquals("dog dot cot cat",
                com.word.WordLadder.get_path("cat", "dog"));

        assertEquals("divide divine diving doving coving covins conins conias congas pongas pangas pandas pandar",
                com.word.WordLadder.get_path("pandar", "divide"));

        assertEquals("idyls odyls odals ovals ovels overs oyers dyers doers doors dools doole dowle dowie dovie movie",
                com.word.WordLadder.get_path("movie", "idyls"));

    }
}
