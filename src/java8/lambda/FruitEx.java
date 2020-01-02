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
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (predicate.test(fruit)) {
                resultList.add(fruit);
            }
        }
        return resultList;
    }

    List<Fruit> fruits = Arrays.asList(new Fruit("apple", "red"), new Fruit("melon", "green"), new Fruit("banana", "yellow"));
    List<Fruit> appleList = extractFruitList(fruits, new Predicate<Fruit>() {
        @Override
        public boolean test(Fruit fruit) {
            return "apple".equals(fruit.getName());
        }
    });

    List<Fruit> reList = extractFruitList(fruits, new Predicate<Fruit>() {
        @Override
        public boolean test(Fruit fruit) {
            return "red".equals(fruit.getColor());
        }
    });

    List<Fruit> appleList1 = extractFruitList(fruits, fruit -> "apple".equals(fruit.getName()));
    List<Fruit> redList1 = extractFruitList(fruits, fruit -> "red".equals(fruit.getColor()));


}



