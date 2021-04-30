package org.demo.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HelperUtil {

    public static String generateHash(String memberName, String password) {

        String valueToHash = new StringBuilder("demo")
                .append(memberName)
                .append(password)
                .toString();

        String identifier = Hashing.sha256()
                .hashString(valueToHash, Charsets.UTF_16LE)
                .toString();

        return identifier;
    }
}
