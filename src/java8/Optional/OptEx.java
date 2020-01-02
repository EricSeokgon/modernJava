package java8.Optional;

public class OptEx {
    public void method01(Object obj) {
        if (obj == null) {
            return;
        }
        //로직
    }

    public String method02(String str) {
        if (str == null) {
            //null을 그대로 리턴하는건 클라이언트에서 다시금 null체크를 해줘야하기 때무넹 기본값을 리턴하는걸 권한다.
            return null;
            return "";
        }
        //로직
        return "";
    }

}
