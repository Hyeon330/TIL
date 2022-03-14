package Ex_22_01_29_Stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class StreamEx6 {
    public static void main(String[] args) {
        Student_[] stuArr = {
                new Student_("이자바", 3, 300),
                new Student_("김자바", 1, 200),
                new Student_("안자바", 2, 100),
                new Student_("박자바", 2, 150),
                new Student_("소자바", 1, 200),
                new Student_("나자바", 3, 290),
                new Student_("김자바", 3, 180)
        };

        // 학생 이름만 뽑아서 List에 저장
        List<String> names = Stream.of(stuArr).map(Student_::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // 스트림을 배열로 변환
        Student_[] stuArr2 = Stream.of(stuArr).toArray(Student_[]::new);

        for (Student_ s : stuArr2)
            System.out.println(s);

        // // 스트림을 Map<String, Student_>로 변환. 학생 이름이 Key
        // Map<String, Student_> stuMap = Stream.of(stuArr)
        // .collect(Collectors.toMap(s -> s.getName(), p -> p));

        // for (String name : stuMap.keySet())
        // System.out.println(name + "-" + stuMap.get(name));

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                .collect(summingInt(Student_::getTotalScore));
        System.out.println("count=" + count);
        System.out.println("totalScore=" + totalScore);

        totalScore = Stream.of(stuArr)
                .collect(reducing(0, Student_::getTotalScore, Integer::sum));
        System.out.println("totalScore=" + totalScore);

        Optional<Student_> topStudent_ = Stream.of(stuArr)
                .collect(maxBy(Comparator.comparingInt(Student_::getTotalScore)));
        System.out.println("topStudent_=" + topStudent_.get());

        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(summarizingInt(Student_::getTotalScore));

        System.out.println(stat);

        String stuNames = Stream.of(stuArr).map(Student_::getName)
                .collect(joining(",", "{", "}"));

        System.out.println(stuNames);
    }
}

class Student_ implements Comparable<Student_> {
    String name;
    int ban;
    int totalScore;

    Student_(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName() {
        return name;
    }

    int getBan() {
        return ban;
    }

    int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student_ s) {
        return s.totalScore - this.totalScore;
    }
}

class StremaEx5 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println("noEmptyStr=" + noEmptyStr);
        System.out.println("sWord=" + sWord.get());

        // Stream<String[]>을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        System.out.println("max=" + max.getAsInt());
        System.out.println("min=" + min.getAsInt());
    }
}

public class StremaEx {

}