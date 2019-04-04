package at.htl;

import java.util.Random;
import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int sum = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        int amount = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        int arraySize = scanner.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.println("Laufzeit zur Sortierung des " + i + ". Arrays: " + sortRandomArray(arraySize) + " ms");
            sum += sortRandomArray(arraySize);
        }

        int sol = sum / amount;
        System.out.println("Durchschschnittliche Laufzeit: " + sol + " ms");

    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        long timeBefore = System.currentTimeMillis();
        sort(generateRandomArray(length));
        long timeAfter = System.currentTimeMillis();

        return timeAfter - timeBefore;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();

        int[] randomNumbers = new int[length];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(90) + 10;
        }

        return randomNumbers;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        int k;

        for (int i = 0; i < array.length; i++) {
            int j = i;
            k = array[i];

            while(j > 0 && array[j - 1] > k) {
                swap(array, j, j--);
                j--;
            }
        }
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        array[i] = array[j];
    }
}
