package com.acompany.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>(
                Arrays.asList("cat", "hippo", "giraffe", "elephant", "monkey", "")
        );
        animals.removeIf(s -> s.length() < 2);

        System.out.println(animals);
    }
}
