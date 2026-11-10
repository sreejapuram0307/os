//SCAN Disk Scheduling

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.print("Enter disk requests: ");

        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter maximum cylinder number: ");
        int max = sc.nextInt();

        System.out.print("Enter direction (left/right): ");
        String direction = sc.next().toLowerCase();

        Arrays.sort(requests);

        int seek = 0;
        int current = head;

        System.out.print("\nSeek Sequence: " + head);

        if (direction.equals("right")) {
            for (int i = 0; i < n; i++) {
                if (requests[i] >= head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }

            seek += Math.abs(current - max);
            current = max;
            System.out.print(" -> " + current);

            for (int i = n - 1; i >= 0; i--) {
                if (requests[i] < head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (requests[i] <= head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }

            seek += current;
            current = 0;
            System.out.print(" -> " + current);

            for (int i = 0; i < n; i++) {
                if (requests[i] > head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }
        }

        System.out.println("\nTotal Head Movement = " + seek);

        sc.close();
    }
}
//C-SCAN Disk Scheduling

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.print("Enter disk requests: ");

        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter maximum cylinder number: ");
        int max = sc.nextInt();

        Arrays.sort(requests);

        int current = head;
        int seek = 0;

        System.out.print("\nSeek Sequence: " + head);

        // Move right and service requests
        for (int i = 0; i < n; i++) {
            if (requests[i] >= head) {
                seek += Math.abs(current - requests[i]);
                current = requests[i];
                System.out.print(" -> " + current);
            }
        }

        // Move to the last cylinder
        if (current != max) {
            seek += Math.abs(current - max);
            current = max;
            System.out.print(" -> " + current);
        }

        // Jump from last cylinder to cylinder 0
        seek += max;
        current = 0;
        System.out.print(" -> " + current);

        // Continue servicing requests from beginning
        for (int i = 0; i < n; i++) {
            if (requests[i] < head) {
                seek += Math.abs(current - requests[i]);
                current = requests[i];
                System.out.print(" -> " + current);
            }
        }

        System.out.println("\nTotal Head Movement = " + seek);

        sc.close();
    }
}
//LOOK Disk Scheduling

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.print("Enter disk requests: ");

        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter direction (left/right): ");
        String direction = sc.next().toLowerCase();

        Arrays.sort(requests);

        int current = head;
        int seek = 0;

        System.out.print("\nSeek Sequence: " + head);

        if (direction.equals("right")) {

            // Service requests to the right
            for (int i = 0; i < n; i++) {
                if (requests[i] >= head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }

            // Reverse and service requests to the left
            for (int i = n - 1; i >= 0; i--) {
                if (requests[i] < head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }

        } else {

            // Service requests to the left
            for (int i = n - 1; i >= 0; i--) {
                if (requests[i] <= head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }

            // Reverse and service requests to the right
            for (int i = 0; i < n; i++) {
                if (requests[i] > head) {
                    seek += Math.abs(current - requests[i]);
                    current = requests[i];
                    System.out.print(" -> " + current);
                }
            }
        }

        System.out.println("\nTotal Head Movement = " + seek);

        sc.close();
    }
}

