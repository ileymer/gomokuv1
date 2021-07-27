package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class AlgorithmHelper {
    public static void Rectangle(Integer []m, Integer [][]v)
    {
        m[0] = 0;
        m[1] = 0;
        m[2] = 0;
        m[3] = 0;
        int i, j, mj, mi;

        i = 19;
        j = 19;
        mi = -1;
        mj = -1;



        while (m[2] < 19)
        {
            m[3] = 0;
            while (m[3] < 19)
            {
                if (v[m[2]][m[3]] != 0)
                {
                    if (m[2] < i)
                        i = m[2];
                    if (m[3] < j)
                        j = m[3];
                    if (m[2] > mi)
                        mi = m[2];
                    if (m[3] > mj)
                        mj = m[3];
                }
                m[3]++;
            }
            m[2]++;
        }
        m[0] = i;
        m[1] = j;
        m[2] = mi;
        m[3] = mj;
        m[0]-=2;
        m[1]-=2;
        m[2]+=2;
        m[3]+=2;
        if (m[0] < 0)
            m[0] = 0;
        if (m[1] < 0)
            m[1] = 0;
        if (m[2] > 18)
            m[2] = 18;
        if (m[3] > 18)
            m[3] = 18;

    }

    public static int PromisingPlace(Integer [][]m, int i, int j)
    {
        int ii;
        int jj;
        int in;
        int jn;
        int n = 0;

        ii = Limit(i - 2);
        jj = Limit(j - 2);
        in = Limit(i + 2);
        jn = Limit(j + 2);
        while (ii <= in && jj <= jn)
        {
            if (m[ii][jj] != 0)
                n++;
            ii++;
            jj++;
        }
        jj = j;
        ii = Limit(i - 2);
        in = Limit(i + 2);
        while (ii <= in)
        {
            if (m[ii][jj] != 0)
                n++;
            ii++;
        }
        ii = i;
        jj = Limit(j - 2);
        jn = Limit(j + 2);
        while (jj <= jn)
        {
            if (m[ii][jj] != 0)
                n++;
            jj++;
        }


        ii = Limit(i - 2);
        jj = Limit(j + 2);
        in = Limit(i + 2);
        jn = Limit(j - 2);
        while (ii <= in && jj >= jn)
        {
            if (m[ii][jj] != 0)
                n++;
            ii++;
            jj--;
        }

        if (n > 0)
            return (1);
        return (0);
    }


    public static int Limit(int i)
    {
        if (i < 0)
            return (0);
        if (i > 18)
            return 18;
        return (i);
    }

    public static ArrayList<Integer>[]GetDirections(Integer [][]m, int x, int y) {
        ArrayList<Integer> []Dir = new ArrayList[4];
        Dir[0] = new ArrayList();
        Dir[1] = new ArrayList();
        Dir[2] = new ArrayList();
        Dir[3] = new ArrayList();
        for (int  i = -4; i < 5; i++) {
            if (x + i >= 0 && x + i <= 19 - 1) {
                Dir[0].add(m[x + i][y]);
                if (y + i >= 0 && y + i <= 19 - 1) {
                    Dir[2].add(m[x + i][y + i]);
                }
            }
            if (y + i >= 0 && y + i <= 19 - 1) {
                Dir[1].add(m[x][y + i]);
                if (x - i >= 0 && x - i <= 19 - 1) {
                    Dir[3].add(m[x - i][y + i]);
                }
            }
        }
        return Dir;
    }

    public static int evaluate_move(Integer [][]m, int x, int y, int player) {
        int  score = 0;
        ArrayList<Integer> []Dir = GetDirections(m, x, y);
        int temp_score;
        for (int i = 0; i < 4; i++) {
            temp_score = evaluate_direction(Dir[i], player);
            if (temp_score == 777777777) { //если данный ход выигрывает игру, сразу же возвращаем его
                return 777777777;
            } else {
                score += temp_score;
            }
        }
        return score;
    }

    public static int P(int i)
    {
        if (i == 1)
            return (2);
        return (1);
    }



    public static int evaluate_direction(ArrayList<Integer> direction_arr, int player) {
        int score = 0;
        for (int i = 0; (i + 4) < direction_arr.size(); i++) {
            int you = 0;
            int enemy = 0;
            for (int j = 0; j <= 4; j++) {
                if (direction_arr.get(i+j) == player) {
                    you++;
                } else if (direction_arr.get(i+j) == P(player)) {
                    enemy++;
                }
            }
            score += evalff(get_seq(you, enemy));
            if ((score >= 800000)) {
                return 777777777;
            }
        }
        return score;
    }


    static int evalff(int seq) {
        switch (seq) {
            case 0:
                return 7;
            case 1:
                return 35;
            case 2:
                return 800;
            case 3:
                return 15000;
            case 4:
                return 800000;
            case -1:
                return 15;
            case -2:
                return 400;
            case -3:
                return 1800;
            case -4:
                return 100000;
            case 17:
                return 0;
        }
        return (0);
    }

    static int get_seq(int y, int e) {
        if (y + e == 0) {
            return 0;
        }
        if (y != 0 && e == 0) {
            return y;
        }
        if (y == 0 && e != 0) {
            return -e;
        }
        if (y != 0 && e != 0) {
            return 17;
        }
        return (0);
    }



}
