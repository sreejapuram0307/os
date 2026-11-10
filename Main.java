//First Fit Memory Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of memory blocks: ");
        int m = sc.nextInt();

        int[] block = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter size of block " + (i + 1) + ": ");
            block[i] = sc.nextInt();
        }

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        int[] allocation = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter size of process " + (i + 1) + ": ");
            process[i] = sc.nextInt();
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (block[j] >= process[i]) {
                    allocation[i] = j;
                    block[j] -= process[i];
                    break;
                }
            }
        }

        System.out.println("\nProcess\tSize\tBlock");

        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + "\t" +
                    process[i] + "\t");

            if (allocation[i] != -1) {
                System.out.println("B" + (allocation[i] + 1));
            } else {
                System.out.println("Not Allocated");
            }
        }

        sc.close();
    }
}
//Best Fit Memory Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of memory blocks: ");
        int m = sc.nextInt();

        int[] block = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter size of block " + (i + 1) + ": ");
            block[i] = sc.nextInt();
        }

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        int[] allocation = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter size of process " + (i + 1) + ": ");
            process[i] = sc.nextInt();
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int best = -1;

            for (int j = 0; j < m; j++) {
                if (block[j] >= process[i]) {
                    if (best == -1 || block[j] < block[best]) {
                        best = j;
                    }
                }
            }

            if (best != -1) {
                allocation[i] = best;
                block[best] -= process[i];
            }
        }

        System.out.println("\nProcess\tSize\tBlock");

        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + "\t" +
                    process[i] + "\t");

            if (allocation[i] != -1) {
                System.out.println("B" + (allocation[i] + 1));
            } else {
                System.out.println("Not Allocated");
            }
        }

        sc.close();
    }
}
//Worst Fit Memory Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of memory blocks: ");
        int m = sc.nextInt();

        int[] block = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter size of block " + (i + 1) + ": ");
            block[i] = sc.nextInt();
        }

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        int[] allocation = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter size of process " + (i + 1) + ": ");
            process[i] = sc.nextInt();
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int worst = -1;

            for (int j = 0; j < m; j++) {
                if (block[j] >= process[i]) {
                    if (worst == -1 || block[j] > block[worst]) {
                        worst = j;
                    }
                }
            }

            if (worst != -1) {
                allocation[i] = worst;
                block[worst] -= process[i];
            }
        }

        System.out.println("\nProcess\tSize\tBlock");

        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + "\t" +
                    process[i] + "\t");

            if (allocation[i] != -1) {
                System.out.println("B" + (allocation[i] + 1));
            } else {
                System.out.println("Not Allocated");
            }
        }

        sc.close();
    }
}
