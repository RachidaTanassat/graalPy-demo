package com.example;

import org.graalvm.polyglot.*;

public class App {
    public static void main(String[] args) {
        try (Context context = Context.newBuilder("python").allowAllAccess(true).build()) {

            // Run NumPy code
            Value result = context.eval("python",
                    "import numpy as np\n" +
                            "arr = np.array([1, 2, 3, 4, 5])\n" +
                            "arr.sum()"
            );

            System.out.println("Sum of array: " + result.asInt());
        }
    }
}
