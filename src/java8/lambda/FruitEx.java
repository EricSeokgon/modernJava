package java8.lambda;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FruitEx {
    List<Fruit> extractApple(List<Fruit> fruits) {
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if ("apple".equals(fruit.getName())) {
                resultList.add(fruit);
            }
        }
        return resultList;
    }

    List<Fruit> extractRed(List<Fruit> fruits) {
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if ("red".equals(fruit.getName())) {
                resultList.add(fruit);
            }
        }
        return resultList;
    }

    static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate) {
        List<Fruit> resultList = new ArrayList <>();
        for (Fruit fruit : fruits) {
            if (predicate.test(fruit)) {
                resultList.add(fruit);
            }
        }
        return resultList;
    }

}



