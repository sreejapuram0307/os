//4(a) Deadlock Avoidance – Banker's Algorithm

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] alloc = new int[n][m];
        int[][] max = new int[n][m];
        int[][] need = new int[n][m];

        int[] avail = new int[m];
        int[] safe = new int[n];
        boolean[] finish = new boolean[n];

        System.out.println("Enter Allocation Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alloc[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Maximum Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = sc.nextInt();
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }

        System.out.println("Enter Available Resources:");

        for (int j = 0; j < m; j++) {
            avail[j] = sc.nextInt();
        }

        int count = 0;

        while (count < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    boolean possible = true;

                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > avail[j]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        for (int j = 0; j < m; j++) {
                            avail[j] += alloc[i][j];
                        }

                        safe[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                break;
            }
        }

        System.out.println("\nNeed Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.println();
        }

        if (count == n) {
            System.out.println("\nSystem is in a SAFE state.");
            System.out.print("Safe Sequence: ");

            for (int i = 0; i < n; i++) {
                System.out.print("P" + safe[i]);

                if (i < n - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        } else {
            System.out.println("\nSystem is in an UNSAFE state.");
            System.out.println("No safe sequence exists.");
        }

        sc.close();
    }
}
//4(b) Deadlock Detection Algorithm

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] alloc = new int[n][m];
        int[][] request = new int[n][m];
        int[] avail = new int[m];
        boolean[] finish = new boolean[n];

        System.out.println("Enter Allocation Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alloc[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Request Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                request[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Available Resources:");

        for (int j = 0; j < m; j++) {
            avail[j] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean hasAllocation = false;

            for (int j = 0; j < m; j++) {
                if (alloc[i][j] > 0) {
                    hasAllocation = true;
                    break;
                }
            }

            finish[i] = !hasAllocation;
        }

        boolean found;

        do {
            found = false;

            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    boolean possible = true;

                    for (int j = 0; j < m; j++) {
                        if (request[i][j] > avail[j]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        for (int j = 0; j < m; j++) {
                            avail[j] += alloc[i][j];
                        }

                        finish[i] = true;
                        found = true;
                    }
                }
            }
        } while (found);

        boolean deadlock = false;

        System.out.println("\nDeadlocked Processes:");

        for (int i = 0; i < n; i++) {
            if (!finish[i]) {
                System.out.println("P" + i);
                deadlock = true;
            }
        }

        if (deadlock) {
            System.out.println("Deadlock detected.");
        } else {
            System.out.println("No deadlock detected.");
        }

        sc.close();
    }
}
