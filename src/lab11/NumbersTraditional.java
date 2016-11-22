package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersTraditional {

    public static List<Integer> isOdd(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();
        for (int n : numbers) {
            if (n % 2 != 0) results.add(n);
        }
        return results;
    }

    public static List<Integer> isPrime(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();
        // TODO
        // Find out all the prime numbers
        for (int num : numbers) {
            if (num <= 3)
                results.add(num);
            else
                for (int i = 3; i < num; i += 2) {
                    if (num % i == 0)
                        break;
                    if (i + 2 >= num)
                        results.add(num);
                }
        }
        return results;
    }

    public static List<Integer> isPalindrome(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();
        // TODO
        // Find out all the palindrome numbers, such as 484 and 121.
        for (int num : numbers) {
            if (num < 10)
                results.add(num);
            else {
                String s = Integer.toString(num);
                int i = 0;
                int j = s.length() - 1;
                while (j > i) {
                    if (s.charAt(i) != s.charAt(j))
                        break;
                    i++;
                    j--;
                    if (i >= j)
                        results.add(num);
                }
            }
        }
        return results;
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(480, 514, 484, 389, 709, 935, 328, 169, 649, 300, 685, 429, 243, 532, 308, 87, 25, 282, 91, 415);

        System.out.println("The odd numbers are : " + isOdd(numbers));
        System.out.println("The prime numbers are : " + isPrime(numbers));
        System.out.println("The palindrome numbers are : " + isPalindrome(numbers));

    }
}
