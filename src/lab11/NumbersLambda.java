package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumbersLambda {

    // Find numbers with certain properties in a unified form
    // The property is specified in Predicate

    public static List<Integer> findNumbers(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> results = new ArrayList<Integer>();
        for (int n : list) {
            if (predicate.test(n)) results.add(n);
        }
        return results;
    }

    public static List<Integer> calculateScore(List<Integer> list, Function<Integer, Integer> function) {
        // TODO: Task 3
        List<Integer> scores = new ArrayList<>();
        for (int num : list)
            scores.add(function.apply(num));
        return scores;
    }

    public static Function<Integer, Integer> policy() {
        // TODO: Task 3
        return x -> (isOdd().test(x) ? 1 : 0) + (isPrime().test(x) ? 2 : 0) + (isPalindrome().test(x) ? 4 : 0);
    }

    public static Predicate<Integer> isOdd() {
        // TODO: Task 2
        return x -> x % 2 != 0;
    }

    public static Predicate<Integer> isPrime() {
        // TODO: Task 2
        return x -> {
            if (x <= 3)
                return true;
            else
                for (int i = 3; i < x; i += 2) {
                    if (x % i == 0)
                        break;
                    if (i + 2 >= x)
                        return true;
                }
            return false;
        };
    }

    public static Predicate<Integer> isPalindrome() {
        // TODO: Task 2
        return x -> {
            if (x < 10)
                return true;
            else {
                String s = Integer.toString(x);
                int i = 0;
                int j = s.length() - 1;
                while (j > i) {
                    if (s.charAt(i) != s.charAt(j))
                        break;
                    i++;
                    j--;
                    if (i >= j)
                        return true;
                }
                return false;
            }
        };
    }

//    public static Function<Integer, Integer> policy() {
//        // TODO: Task 3
//    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(480, 514, 484, 389, 709, 935, 328, 169, 649, 300, 685, 429, 243, 532, 308, 87, 25, 282, 91, 415);

        System.out.println("The odd numbers are : " + findNumbers(numbers, isOdd()));
        System.out.println("The prime numbers are : " + findNumbers(numbers, isPrime()));
        System.out.println("The palindrome numbers are : " + findNumbers(numbers, isPalindrome()));

        System.out.println("The score of the all numbers are :" + calculateScore(numbers, policy()));
    }
}
