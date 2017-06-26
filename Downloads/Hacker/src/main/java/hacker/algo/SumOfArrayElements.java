package hacker.algo;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class SumOfArrayElements {

    static int simpleArraySum(int n, int[] ar) {
        return stream(ar).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
    }
}