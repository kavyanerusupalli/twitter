package com.twitter.interview.tweetviewpath.util;

import java.io.InputStream;

/**
 * Helper class for loading resources from java
 */
public class ResourceLoader {

    public static InputStream getResourceAsStream(String resourceName) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
    }
}