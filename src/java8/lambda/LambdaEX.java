package java8.lambda;

import java.util.Arrays;

public class LambdaEX {
    public static void main(String[] args) {
        //람다식
        int[] arr = new int[5];
        Arrays.setAll(arr, i -> (int) (Math.random() * 5) + 1);

    }

    //일반 메서드
    int method(int i) {
        return (int) (Math.random() * 5) + 1;
    }
}
