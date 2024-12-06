package assignmnet;


/*
 * @author : rabin
 */

import java.util.Scanner;

public class Find_N_Numbers {
    // Recursive function to find all n-digit numbers with a given sum
    static void findNdigitNums(String res, int n, int sum) {
        // Base case: if we have n digits
        if (res.length() == n) {
            if (sum == 0) {
                System.out.print(res + " ");
            }
            return;
        }

        // Start digit for the first position should be from 1 to 9, others can be from 0 to 9
        int startDigit = (res.length() == 0) ? 1 : 0;

        // Iterate through possible digits
        for (int digit = startDigit; digit <= 9; digit++) {
            // Only proceed if adding this digit doesn't exceed the target sum
            if (sum - digit >= 0) {
                findNdigitNums(res + digit, n, sum - digit);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for number of digits and the desired sum
        System.out.print("Enter number of digits (n): ");
        int n = sc.nextInt();
        System.out.print("Enter desired sum: ");
        int sum = sc.nextInt();

        System.out.println("Finding " + n + "-digit numbers with sum " + sum + ":");
        findNdigitNums("", n, sum);

        sc.close();
    }
}
