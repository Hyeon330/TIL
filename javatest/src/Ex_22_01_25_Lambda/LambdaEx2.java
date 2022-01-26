package Ex_22_01_25_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface MyFunction {
    void myMethod(); // public abstract void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction f = () -> {
        }; // MyFunction f = (MyFunction)( () -> {});
        Object obj = (MyFunction) (() -> {
        }); // Object타입으로 형변환이 생략됨
        String str = ((Object) (MyFunction) (() -> {
        })).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        System.out.println((MyFunction) (() -> {
        }));
        System.out.println(((Object) (MyFunction) (() -> {
        })).toString());
    }
}

class Outer {
    int val = 10; // Outer.this.val

    class Inner {
        int val = 20; // this.val

        void method(int i) { // void method(final int i){
            int val = 30; // final int val = 30;
            // i = 10; // 에러. 상수의 값을 변경할 수 없음

            MyFunction f = () -> {
                System.out.println("             i :" + i);
                System.out.println("           val :" + val);
                System.out.println("      this.val :" + ++this.val);
                System.out.println("Outer.this.val :" + ++Outer.this.val);
            };
            f.myMethod();
        }
    }
}

class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}

class LambdaEx4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list의 모든 요소를 출력
        list.forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // list에서 2 또는 3의 배수를 제거한다.
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        list.replaceAll(i -> i * 10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");

        // map의 모든 요소를 {k, v}의 형식으로 출력
        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "},"));
        System.out.println();
    }
}

class LambdaEx5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.println(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10; // i의 1의자리를 없앤다.
        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomthing(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomthing(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}

class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;
        IntConsumer c = i -> System.out.print(i + ", ");
        IntPredicate p = i -> i % 2 == 0;
        IntUnaryOperator op = i -> i / 10 * 10; // i의 일자리를 없앤다.

        int[] arr = new int[10];

        makeRandomList(s, arr);
        System.out.println(Arrays.toString(arr));
        printEvenNum(p, c, arr);
        int[] newArr = doSomthing(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static void makeRandomList(IntSupplier s, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.getAsInt(); // get() 이 아니라 getAsInt()임에 주의
        }
    }

    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if (p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }

    static int[] doSomthing(IntUnaryOperator op, int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]); // apply가 아님에 주의
        }
        return newArr;
    }
}

class LambdaEx7 {
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2)); // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)
        System.out.println(f2.apply("AAA")); // AAA가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        // 100 <= i && (i < 200 || i%2 ==0)
        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println(result);
    }
}