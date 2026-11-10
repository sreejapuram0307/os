//FIFO Page Replacement

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int[] pages = new int[n];

        System.out.print("Enter page reference string: ");

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int f = sc.nextInt();

        int[] frames = new int[f];

        for (int i = 0; i < f; i++) {
            frames[i] = -1;
        }

        int pointer = 0, faults = 0, hits = 0;

        System.out.println("\nPage\tFrames\t\tStatus");

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < f; j++) {
                if (frames[j] == pages[i]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                hits++;
            } else {
                frames[pointer] = pages[i];
                pointer = (pointer + 1) % f;
                faults++;
            }

            System.out.print(pages[i] + "\t");

            for (int j = 0; j < f; j++) {
                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            System.out.println("\t" +
                    (found ? "Hit" : "Page Fault"));
        }

        System.out.println("\nTotal Page Faults = " + faults);
        System.out.println("Total Page Hits = " + hits);

        sc.close();
    }
}
//Optimal Page Replacement

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int[] pages = new int[n];

        System.out.print("Enter page reference string: ");

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int f = sc.nextInt();

        int[] frames = new int[f];

        for (int i = 0; i < f; i++) {
            frames[i] = -1;
        }

        int faults = 0, hits = 0;

        System.out.println("\nPage\tFrames\t\tStatus");

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < f; j++) {
                if (frames[j] == pages[i]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                hits++;
            } else {
                int replace = -1;
                int farthest = -1;

                for (int j = 0; j < f; j++) {
                    if (frames[j] == -1) {
                        replace = j;
                        break;
                    }

                    int k;

                    for (k = i + 1; k < n; k++) {
                        if (pages[k] == frames[j]) {
                            break;
                        }
                    }

                    if (k == n) {
                        replace = j;
                        break;
                    }

                    if (k > farthest) {
                        farthest = k;
                        replace = j;
                    }
                }

                frames[replace] = pages[i];
                faults++;
            }

            System.out.print(pages[i] + "\t");

            for (int j = 0; j < f; j++) {
                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            System.out.println("\t" +
                    (found ? "Hit" : "Page Fault"));
        }

        System.out.println("\nTotal Page Faults = " + faults);
        System.out.println("Total Page Hits = " + hits);

        sc.close();
    }
}
//LRU Page Replacement

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int[] pages = new int[n];

        System.out.print("Enter page reference string: ");

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int f = sc.nextInt();

        int[] frames = new int[f];
        int[] lastUsed = new int[f];

        for (int i = 0; i < f; i++) {
            frames[i] = -1;
            lastUsed[i] = -1;
        }

        int faults = 0, hits = 0;

        System.out.println("\nPage\tFrames\t\tStatus");

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < f; j++) {
                if (frames[j] == pages[i]) {
                    found = true;
                    lastUsed[j] = i;
                    break;
                }
            }

            if (found) {
                hits++;
            } else {
                int replace = -1;
                int leastRecent = Integer.MAX_VALUE;

                for (int j = 0; j < f; j++) {
                    if (frames[j] == -1) {
                        replace = j;
                        break;
                    }

                    if (lastUsed[j] < leastRecent) {
                        leastRecent = lastUsed[j];
                        replace = j;
                    }
                }

                frames[replace] = pages[i];
                lastUsed[replace] = i;
                faults++;
            }

            System.out.print(pages[i] + "\t");

            for (int j = 0; j < f; j++) {
                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            System.out.println("\t" +
                    (found ? "Hit" : "Page Fault"));
        }

        System.out.println("\nTotal Page Faults = " + faults);
        System.out.println("Total Page Hits = " + hits);

        sc.close();
    }
}
