import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {

        int i = () -> (int) (Math.random() * 6);

        System.out.println(i);
    }
}