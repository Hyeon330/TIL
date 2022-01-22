package Ex_22_01_21;

import java.util.*;

public class TreeSetEx {
}

class TreeSetEx1 {
    public static void main(String[] args) {
        Set set = new TreeSet<>();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // set.add(new Integer(num));
        }

        System.out.println(set);
    }
}

class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZZ");
        set.add("dzzzz");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);

        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to));
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));
    }
}

class TreeSetEx3 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();
        int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };

        for (int i = 0; i < score.length; i++) {
            set.add(new Integer(score[i]));
        }

        System.out.println("50보다 작은 값 :" + set.headSet(new Integer(50)));
        System.out.println("50보다 큰 값 :" + set.tailSet(new Integer(50)));
    }
}