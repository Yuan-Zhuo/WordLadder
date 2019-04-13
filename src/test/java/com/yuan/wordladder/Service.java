package com.yuan.wordladder;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.yuan.wordladder.func.WordLadder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service {

    @Before
    public void init() {
        System.out.println("测试Service层");
    }

    @Test
    public void exceptionTesting() {
        assertEquals("#word1 error",
                WordLadder.get_path("abcd", "life"));
        assertEquals("#word2 error",
                WordLadder.get_path("movie", "zzzzz"));
        assertEquals("#length error",
                WordLadder.get_path("movie", "cat"));
        assertEquals("#no path",
                WordLadder.get_path("spherules", "aasvogels"));
    }

    @Test
    public void stringTesting() {

        assertEquals("dog\tdot\tcot\tcat",
                WordLadder.get_path("cat", "dog"));

        assertEquals("divide\tdivine\tdiving\tdoving\tcoving\tcovins\tconins\tconias\tcongas\tpongas\tpangas\tpandas\tpandar",
                WordLadder.get_path("pandar", "divide"));

        assertEquals("idyls\todyls\todals\tovals\tovels\tovers\toyers\tdyers\tdoers\tdoors\tdools\tdoole\tdowle\tdowie\tdovie\tmovie",
                WordLadder.get_path("movie", "idyls"));

    }


    @After
    public void after() {
        System.out.println("测试结束");
    }


}
