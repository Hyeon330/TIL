import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        HashSet<Integer> set2 = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(3);
        set.add(3);
        set2.add(1);
        set2.add(4);
        set2.add(2);
        set2.add(4);
        set2.add(2);
        set2.add(5);

        System.out.println(set);
        System.out.println(set2);
    }
}