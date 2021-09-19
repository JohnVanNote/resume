package com.jvn.test.util;

import org.testng.Assert;

public class ToStringUtil {

    public static void assertToStringContains(String actualToString, String... strings) {
        for (String string : strings) {
            Assert.assertTrue(actualToString.contains(string), String.format("ToString %s does not contain %s.", actualToString, string));
        }
    }

}
