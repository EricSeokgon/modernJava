package java8.lambda;

import java.util.Arrays;

public class LambdaEX {
    public static void main(String[] args) {

        int[] arr = new int[5];
        Arrays.setAll(arr, i -> (int) (Math.random() * 5) + 1);

    }

    int method(int i) {
        return (int) (Math.random() * 5) + 1;
    }
}
