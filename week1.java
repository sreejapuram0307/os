
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time of P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        int totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tBT\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];

            System.out.println("P" + (i + 1) + "\t" +
                    bt[i] + "\t" + wt[i] + "\t" + tat[i]);

            totalWT += wt[i];
            totalTAT += tat[i];
        }

        System.out.println("\nGantt Chart:");
        System.out.print("0");

        for (int i = 0; i < n; i++) {
            System.out.print(" P" + (i + 1) + " " + tat[i]);
        }

        System.out.printf("\n\nAverage Waiting Time = %.2f",
                (double) totalWT / n);

        System.out.printf("\nAverage Turnaround Time = %.2f\n",
                (double) totalTAT / n);

        sc.close();
    }
}



//Shortest Job First (SJF) Scheduling

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time of P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            p[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bt[i] > bt[j]) {
                    int temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }

        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        int totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tBT\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];

            totalWT += wt[i];
            totalTAT += tat[i];

            System.out.println("P" + p[i] + "\t" + bt[i] +
                    "\t" + wt[i] + "\t" + tat[i]);
        }

        System.out.println("\nGantt Chart:");
        System.out.print("0");

        for (int i = 0; i < n; i++) {
            System.out.print(" P" + p[i] + " " + tat[i]);
        }

        System.out.printf("\n\nAverage Waiting Time = %.2f",
                (double) totalWT / n);

        System.out.printf("\nAverage Turnaround Time = %.2f\n",
                (double) totalTAT / n);

        sc.close();
    }
}
//Round Robin (RR) Scheduling'

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] rem = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time of P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            rem[i] = bt[i];
        }

        System.out.print("Enter time quantum: ");
        int tq = sc.nextInt();

        int time = 0;
        int completed = 0;

        System.out.println("\nGantt Chart:");

        while (completed < n) {
            for (int i = 0; i < n; i++) {
                if (rem[i] > 0) {
                    System.out.print("| P" + (i + 1) + " ");

                    if (rem[i] > tq) {
                        time += tq;
                        rem[i] -= tq;
                    } else {
                        time += rem[i];
                        rem[i] = 0;
                        completed++;
                        tat[i] = time;
                        wt[i] = tat[i] - bt[i];
                    }

                    System.out.print("(" + time + ") ");
                }
            }
        }

        System.out.println("|");

        int totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tBT\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            totalWT += wt[i];
            totalTAT += tat[i];

            System.out.println("P" + (i + 1) + "\t" + bt[i]
                    + "\t" + wt[i] + "\t" + tat[i]);
        }

        System.out.printf("\nAverage Waiting Time = %.2f",
                (double) totalWT / n);

        System.out.printf("\nAverage Turnaround Time = %.2f\n",
                (double) totalTAT / n);

        sc.close();
    }
}



//Priority Based Scheduling

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] p = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] pr = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i + 1;

            System.out.print("Enter burst time of P" + p[i] + ": ");
            bt[i] = sc.nextInt();

            System.out.print("Enter priority of P" + p[i] + ": ");
            pr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pr[i] > pr[j]) {
                    int temp = pr[i];
                    pr[i] = pr[j];
                    pr[j] = temp;

                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }

        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        int totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tBT\tPriority\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];

            totalWT += wt[i];
            totalTAT += tat[i];

            System.out.println("P" + p[i] + "\t" + bt[i] +
                    "\t" + pr[i] + "\t\t" + wt[i] + "\t" + tat[i]);
        }

        System.out.println("\nGantt Chart:");
        System.out.print("0");

        for (int i = 0; i < n; i++) {
            System.out.print(" P" + p[i] + " " + tat[i]);
        }

        System.out.printf("\n\nAverage Waiting Time = %.2f",
                (double) totalWT / n);

        System.out.printf("\nAverage Turnaround Time = %.2f\n",
                (double) totalTAT / n);

        sc.close();
    }
}
