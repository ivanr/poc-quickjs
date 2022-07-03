package com.hippo.quickjs.android;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test() {
        QuickJS qjs = new QuickJS.Builder().build();

        try (JSRuntime runtime = qjs.createJSRuntime()) {
            try (JSContext context = runtime.createJSContext()) {

                String script = "" +
                        "function fibonacci(n) {" +
                        "  if (n == 0 || n == 1) return n;" +
                        "  return fibonacci(n - 1) + fibonacci(n - 2);" +
                        "}" +
                        "fibonacci(10);";

                int result = context.evaluate(script, "fibonacci.js", int.class);
                assertEquals(55, result);
            }
        }
    }
}
