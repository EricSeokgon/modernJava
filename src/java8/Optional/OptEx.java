package java8.Optional;

import java.util.Optional;


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
            //return "";
        }
        //로직
        return "";
    }

    class Optonal<T> {
        private T t;
    }

    public static void main(String[] args) {
        String str = "hello";
        Optional<String> str1 = Optional.of(str); // str이 null이면 NPE발생
        Optional<String> str2 = Optional.ofNullable(str); //str이 null 이면 빈 Optinal 객체 반환
        Optional<Object> empty = Optional.empty(); // 빈 Optional 객체 반환

        Optional<Object> empty1 = Optional.empty();
        Object o = empty1.orElse(new Object());
        Object o1 = empty1.orElseGet(() -> new Object());
        Object o2 = empty1.orElseGet(Object::new);

        Object object2 = empty1.orElseGet(() -> {
            Object obj = new Object();
            //obj.setitem();
            //obj.setName();
        });

        Optional<Integer> integerOptional = Optional.empty();
        Integer integer = integerOptional.orElse(5);
        Integer integer1 = integerOptional.orElseGet(() -> 5);

        Optional<Object> empty2 = Optional.empty();
        Object obj = empty2.map(Object::getClass)
                .orElse(null);

    }

}
