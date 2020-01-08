import java.util.ArrayList;
import java.util.List;

public class Methods extends Person {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int result = add(a, b);
        System.out.println(result);

        int byValue = 5;
        callByValue(byValue);
        System.out.println(byValue);

        List<String> byRef = new ArrayList<>();
        byRef.add("red");
        byRef.add("blue");
        System.out.println(byRef);
        callByReference(byRef);
        System.out.println(byRef);
    }

    //메소드로 분리
    public static int add(int first, int second) {
        return first + second;
    }

    //call by value
    public static void callByValue(int param) {
        param = param + 5;
    }

    //call by reference
    public static void callByReference(List param) {
        param.add("white");
    }
}
