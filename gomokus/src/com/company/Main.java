package com.company;

import java.io.IOException;
import java.util.Scanner;

import static com.company.Algorithm.Couple;
import static com.company.Algorithm.alg;
import static com.company.Visual.*;



public class Main {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    static final int r = 19;

    public static void main(String[] args){
        if (args.length == 1)
        {
            if (args[0].equals("c"))
                Console();
            if (args[0].equals("v"))
                new Visual();
        }


    }



    public static void Console() {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int k;
        Integer[][] m = new Integer[r][r];
        Integer[] del = new Integer[4];
        Integer[] main = new Integer[8];
        int d1 = 0;
        int d2 = 0;

        k = 0;
        for (int ii = 0; ii < r; ii++) {
            for (int jj = 0; jj < r; jj++)
                m[ii][jj] = 0;
        }

        while (true) {
            if (k % 2 != 1) {
                try {
                    i = in.nextInt();
                    j = in.nextInt();
                } catch (Throwable t) {
                    System.out.println("error");
                    System.exit(0);
                }
                if (i < 0 || j < 0 || i > 18 || j > 18) {
                    System.out.println("error");
                    System.exit(0);
                }

                if (Couple(i, j, 1, 2, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    d1++;
                }
                m[i][j] = 1;
            } else {
                long start = System.currentTimeMillis();
                alg(m, d1, d2,main);
                if (Couple(main[6], main[7], 1, 2, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    d2++;
                }
                System.out.println("work");
                long finish = System.currentTimeMillis();
                long elapsed = finish - start;
                System.out.println("Прошло времени, мс: " + elapsed);
            }
            System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18");
            for (int ii = 0; ii < r; ii++) {
                System.out.print(ii + "\t");
                for (int jj = 0; jj < r; jj++) {
                    if (m[ii][jj] == 1)
                        System.out.print(ANSI_YELLOW + "X" + ANSI_RESET);
                    else if (m[ii][jj] == 2)
                        System.out.print(ANSI_RED + "O" + ANSI_RESET);
                    else if (m[ii][jj] == 0)
                        System.out.print(ANSI_BLUE + "." + ANSI_RESET);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println("Player 1 = " + d1 + "\t" + "Player 2 = " + d2);
            System.out.println();

            k++;
        }
    }
}
