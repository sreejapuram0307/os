//Sequential File Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of disk blocks: ");
        int n = sc.nextInt();

        int[] disk = new int[n];

        System.out.print("Enter number of files: ");
        int f = sc.nextInt();

        for (int i = 0; i < f; i++) {
            System.out.print("Enter starting block of file " + (i + 1) + ": ");
            int start = sc.nextInt();

            System.out.print("Enter number of blocks required: ");
            int len = sc.nextInt();

            boolean available = true;

            if (start < 0 || len <= 0 || start + len > n) {
                available = false;
            } else {
                for (int j = start; j < start + len; j++) {
                    if (disk[j] != 0) {
                        available = false;
                        break;
                    }
                }
            }

            if (available) {
                for (int j = start; j < start + len; j++) {
                    disk[j] = i + 1;
                }

                System.out.println("File " + (i + 1) +
                        " allocated successfully.");

                System.out.print("Allocated blocks: ");

                for (int j = start; j < start + len; j++) {
                    System.out.print(j + " ");
                }

                System.out.println();
            } else {
                System.out.println("File " + (i + 1) +
                        " cannot be allocated.");
            }
        }

        System.out.println("\nDisk Block Status:");
        System.out.println("Block\tFile");

        for (int i = 0; i < n; i++) {
            if (disk[i] == 0) {
                System.out.println(i + "\tFree");
            } else {
                System.out.println(i + "\tFile " + disk[i]);
            }
        }

        sc.close();
    }
}
//Indexed File Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of disk blocks: ");
        int n = sc.nextInt();

        int[] disk = new int[n];

        System.out.print("Enter number of files: ");
        int f = sc.nextInt();

        for (int i = 1; i <= f; i++) {
            System.out.print("Enter index block of file " + i + ": ");
            int index = sc.nextInt();

            System.out.print("Enter number of data blocks: ");
            int count = sc.nextInt();

            int[] blocks = new int[count];

            boolean valid = index >= 0 && index < n
                    && count > 0 && disk[index] == 0;

            for (int j = 0; j < count; j++) {
                System.out.print("Enter data block " + (j + 1) + ": ");
                blocks[j] = sc.nextInt();

                if (blocks[j] < 0 || blocks[j] >= n) {
                    valid = false;
                } else if (disk[blocks[j]] != 0 || blocks[j] == index) {
                    valid = false;
                }
            }

            if (valid) {
                disk[index] = i;

                for (int j = 0; j < count; j++) {
                    disk[blocks[j]] = i;
                }

                System.out.println("File " + i +
                        " allocated successfully.");

                System.out.println("Index Block: " + index);
                System.out.print("Data Blocks: ");

                for (int j = 0; j < count; j++) {
                    System.out.print(blocks[j] + " ");
                }

                System.out.println();
            } else {
                System.out.println("File " + i + " allocation failed.");
            }
        }

        System.out.println("\nDisk Block Status:");
        System.out.println("Block\tStatus");

        for (int i = 0; i < n; i++) {
            if (disk[i] == 0) {
                System.out.println(i + "\tFree");
            } else {
                System.out.println(i + "\tFile " + disk[i]);
            }
        }

        sc.close();
    }
}
//Linked File Allocation

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of disk blocks: ");
        int n = sc.nextInt();

        int[] disk = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = -1;
        }

        System.out.print("Enter number of files: ");
        int f = sc.nextInt();

        for (int i = 1; i <= f; i++) {
            System.out.print("Enter number of blocks for file " + i + ": ");
            int count = sc.nextInt();

            if (count <= 0 || count > n) {
                System.out.println("Invalid number of blocks.");
                continue;
            }

            int[] blocks = new int[count];
            boolean valid = true;

            for (int j = 0; j < count; j++) {
                System.out.print("Enter block " + (j + 1) + ": ");
                blocks[j] = sc.nextInt();

                if (blocks[j] < 0 || blocks[j] >= n) {
                    valid = false;
                } else if (disk[blocks[j]] != 0) {
                    valid = false;
                }

                for (int k = 0; k < j; k++) {
                    if (blocks[k] == blocks[j]) {
                        valid = false;
                    }
                }
            }

            if (valid) {
                for (int j = 0; j < count; j++) {
                    disk[blocks[j]] = i;

                    if (j < count - 1) {
                        next[blocks[j]] = blocks[j + 1];
                    }
                }

                System.out.println("File " + i +
                        " allocated successfully.");

                System.out.print("Linked blocks: ");

                for (int j = 0; j < count; j++) {
                    System.out.print(blocks[j]);

                    if (j < count - 1) {
                        System.out.print(" -> ");
                    }
                }

                System.out.println(" -> NULL");
            } else {
                System.out.println("File " + i + " allocation failed.");
            }
        }

        System.out.println("\nDisk Block Status:");
        System.out.println("Block\tFile\tNext");

        for (int i = 0; i < n; i++) {
            if (disk[i] == 0) {
                System.out.println(i + "\tFree\t-");
            } else {
                String link = next[i] == -1
                        ? "NULL" : String.valueOf(next[i]);

                System.out.println(i + "\tFile " + disk[i] +
                        "\t" + link);
            }
        }

        sc.close();
    }
}
