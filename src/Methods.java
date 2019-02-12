public class Methods {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int result = add(a, b);
        System.out.println(result);

    }

    //메소드로 분리
    public static int add(int first, int second) {
        return first + second;
    }

    //call by value
    public static void callByValue(int param) {
        param = param + 5;
    }
}
