import java.util.Arrays;
import java.util.Scanner;

public class DSAProblemsSolver {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("       DSA PROBLEMS SOLVER");
            System.out.println("==============================");

            System.out.println("1. Find Largest Element");
            System.out.println("2. Find Smallest Element");
            System.out.println("3. Reverse an Array");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Bubble Sort");
            System.out.println("7. Check Palindrome String");
            System.out.println("8. Reverse a String");
            System.out.println("9. Find Sum of Array");
            System.out.println("10. Find Second Largest");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    largest();
                    break;

                case 2:
                    smallest();
                    break;

                case 3:
                    reverseArray();
                    break;

                case 4:
                    linearSearch();
                    break;

                case 5:
                    binarySearch();
                    break;

                case 6:
                    bubbleSort();
                    break;

                case 7:
                    palindrome();
                    break;

                case 8:
                    reverseString();
                    break;

                case 9:
                    arraySum();
                    break;

                case 10:
                    secondLargest();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    // Read array
    static int[] readArray() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    // Largest element
    static void largest() {

        int[] arr = readArray();

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Largest element = " + max);
    }

    // Smallest element
    static void smallest() {

        int[] arr = readArray();

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Smallest element = " + min);
    }

    // Reverse array
    static void reverseArray() {

        int[] arr = readArray();

        System.out.println("Reversed array:");

        for (int i = arr.length - 1; i >= 0; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Linear search
    static void linearSearch() {

        int[] arr = readArray();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }

        System.out.println("Element not found.");
    }

    // Binary search
    static void binarySearch() {

        int[] arr = readArray();

        // Sort before binary search
        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Element not found.");
    }

    // Bubble sort
    static void bubbleSort() {

        int[] arr = readArray();

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }

    // Palindrome
    static void palindrome() {

        sc.nextLine();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        if (str.equalsIgnoreCase(reverse)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }

    // Reverse string
    static void reverseString() {

        sc.nextLine();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Reversed string: ");

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println();
    }

    // Sum of array
    static void arraySum() {

        int[] arr = readArray();

        int sum = 0;

        for (int value : arr) {
            sum += value;
        }

        System.out.println("Sum = " + sum);
    }

    // Second largest
    static void secondLargest() {

        int[] arr = readArray();

        if (arr.length < 2) {
            System.out.println("At least two elements are required.");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int value : arr) {

            if (value > largest) {
                second = largest;
                largest = value;
            } else if (value > second && value != largest) {
                second = value;
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("No distinct second largest element.");
        } else {
            System.out.println("Second largest = " + second);
        }
    }
}