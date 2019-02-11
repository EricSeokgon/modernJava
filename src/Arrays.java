public class Arrays {
    public static void main(String[] args) {
        int[] intArr = new int[5];

        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;
        intArr[3] = 4;
        intArr[4] = 5;

        System.out.println(intArr[3]);

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        for (int item : intArr) {
            System.out.println(item);
        }
        int[] intArr2 = {1, 2, 3, 4, 5, 6};
        for (int item : intArr2) {
            System.out.println(item);
        }

        // 2차원 배열
        int[][] twoDimArr = {
                {101, 102, 103, 104},
                {201, 202, 203, 204},
                {301, 302, 303, 304},
                {401, 402, 403, 404}
        };

        for (int[] floor : twoDimArr) {
            for(int home : floor){
                if (home == 202 || home == 403) {
                    continue;
                }
                System.out.println(home);
            }
        }

    }
}
