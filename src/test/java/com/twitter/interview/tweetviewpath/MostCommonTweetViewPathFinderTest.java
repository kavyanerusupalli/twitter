package com.twitter.interview.tweetviewpath;

import java.io.InputStream;

import org.junit.Test;

import com.twitter.interview.tweetviewpath.util.ResourceLoader;

public class MostCommonTweetViewPathFinderTest {

    @Test
    public void testBasic() {
        // parse the basic file and ensure you get the correct result
        MostCommonTweetViewPathFinder tweetViewPathFinder = new MostCommonTweetViewPathFinder();
        InputStream basicInputStream = ResourceLoader.getResourceAsStream("samples/basic/input");
        Path path = tweetViewPathFinder.getMostTweetViewPath(basicInputStream);
        System.out.println(path.getOccurance());
    }

    @Test
    public void testMultiUser() {
        // parse the multi-user file and ensure you get the correct result
        MostCommonTweetViewPathFinder tweetViewPathFinder = new MostCommonTweetViewPathFinder();
        InputStream multiUserInputStream = ResourceLoader.getResourceAsStream("samples/multi-user/input");
        Path path = tweetViewPathFinder.getMostTweetViewPath(multiUserInputStream);
        System.out.println(path.getOccurance());
    }
}
