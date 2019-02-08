import java.util.Scanner;

public class Branching {
    public static void main(String[] args) {
        Scanner fromUser = new Scanner(System.in);
        System.out.println("나이를 입력하세요");
        String theAge = fromUser.next();

        int age = Integer.parseInt(theAge);

        if (age >= 20 && age < 40) {
            System.out.println("청녕");

        } else if (age >= 40 && age < 60) {
            System.out.println("장년");

        } else {
            System.out.println("기타");
        }

        Scanner in = new Scanner(System.in);
        System.out.println("좋아하는 색깔은?");
        String color = in.next();

        switch (color) {
            case "red":
                System.out.println("열정적이군요");
            case "blue":
                System.out.println("감성적이군요");
            case "green":
            case "yello":
                System.out.println("잘 모르겠어요");
            default:
                System.out.println("알수없어요");
        }

    }
}
