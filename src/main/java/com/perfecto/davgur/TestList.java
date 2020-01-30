package com.perfecto.davgur;

import java.util.HashMap;

public class TestList {
    private static HashMap<Long, TestItem> tests;
    private static Long counter = 0L;

    private TestList() {
    }

    private static HashMap<Long, TestItem> build() {
        if (tests == null) {
            tests = new HashMap<Long, TestItem>() {
            };
        }
        return tests;
    }

    public static TestItem add(TestItem test) {
        counter++;
        test.setId(counter);
        build().put(counter, test);
        return build().get(counter);
    }

    public static HashMap<Long, TestItem> all() {
        return build();
    }

    public static TestItem getTest(Long id) {
        return build().get(id);
    }

    public static TestItem start(Long id) {
        TestItem test = getTest(id);
        test.start();
        return test;
    }
}
