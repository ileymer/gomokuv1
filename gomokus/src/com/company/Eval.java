package com.company;

import javax.swing.*;
import java.util.ArrayList;
import static com.company.AlgorithmHelper.*;

public class Eval {

    static int LiveOne = 10;
    static int DeadOne = 1;
    static int LiveTwo = 100;
    static int DeadTwo = 10;
    static int LiveThree = 1000;
    static int DeadThree = 100;
    static int LiveFour = 10000;
    static int DeadFour = 1000;
    static int Five = 100000;

    static int evaluate_state(Integer [][]Board, int yp) {
        int black_score = eval_board(Board, P(yp));
        int white_score = eval_board(Board, yp);
        int score = 0;

            score = (white_score - black_score);


        return score;
    }

    static int eval_board(Integer [][]Board, int pieceType) {
        int score = 0;
        int min_r = 0;
        int min_c = 0;
        int max_r = 18;
        int max_c = 18;
        for (int row = min_r; row < max_r + 1; row++) {
            for (int column = min_c; column < max_c + 1; column++) {
                if (Board[row][column] == pieceType) {
                    int block = 0;
                    int piece = 1;
                    // left
                    if (column == 0 || Board[row][column - 1] != 0) {
                        block++;
                    }
                    // pieceNum
                    for (column++; column < 19 && Board[row][column] == pieceType; column++) {
                        piece++;
                    }
                    // right
                    if (column == 19 || Board[row][column] != 0) {
                        block++;
                    }
                    score = score + evaluateblock(block, piece);
                }
            }
        }

        for (int column = min_c; column < max_c + 1; column++) {
            for (int row = min_r; row < max_r + 1; row++) {
                if (Board[row][column] == pieceType) {
                    int block = 0;
                    int piece = 1;
                    // left
                    if (row == 0 || Board[row - 1][column] != 0) {
                        block++;
                    }
                    // pieceNum
                    for (row++; row < 19 && Board[row][column] == pieceType; row++) {
                        piece++;
                    }
                    // right
                    if (row == 19 || Board[row][column] != 0) {
                        block++;
                    }
                    score += evaluateblock(block, piece);
                }
            }
        }

        for (int n = min_r; n < (max_c - min_c + max_r); n += 1) {
            int r = n;
            int c = min_c;
            while (r >= min_r && c <= max_c) {
                if (r <= max_r) {
                    if (Board[r][c] == pieceType) {
                        int block = 0;
                        int piece = 1;
                        // left
                        if (c == 0 || r == 19 - 1 || Board[r + 1][c - 1] != 0) {
                            block++;
                        }
                        // pieceNum
                        r--;
                        c++;
                        for (; r >= 0 && Board[r][c] == pieceType; r--) {
                            piece++;
                            c++;
                        }
                        // right
                        if (r < 0 || c == 19 || Board[r][c] != 0) {
                            block++;
                        }
                        score += evaluateblock(block, piece);
                    }
                }
                r -= 1;
                c += 1;
            }
        }

        for (int n = min_r - (max_c - min_c); n <= max_r; n++) {
            int r = n;
            int c = min_c;
            while (r <= max_r && c <= max_c) {
                if (r >= min_r && r <= max_r) {
                    if (Board[r][c] == pieceType) {
                        int  block = 0;
                        int piece = 1;
                        // left
                        if (c == 0 || r == 0 || Board[r - 1][c - 1] != 0) {
                            block++;
                        }
                        // pieceNum
                        r++;
                        c++;
                        for (; r < 19 && Board[r][c] == pieceType; r++) {
                            piece++;
                            c++;
                        }
                        // right
                        if (r == 19 || c == 19 || Board[r][c] != 0) {
                            block++;
                        }
                        score += evaluateblock(block, piece);
                    }
                }
                r += 1;
                c += 1;
            }

        }
        return score;
    }

    static int evaluateblock(int blocks, int pieces) {
        if (blocks == 0) {
            switch (pieces) {
                case 1:
                    return LiveOne;
                case 2:
                    return LiveTwo;
                case 3:
                    return LiveThree;
                case 4:
                    return LiveFour;
                default:
                    return Five;
            }
        }
        else if (blocks == 1) {
            switch (pieces) {
                case 1:
                    return DeadOne;
                case 2:
                    return DeadTwo;
                case 3:
                    return DeadThree;
                case 4:
                    return DeadFour;
                default:
                    return Five;
            }
        }
        else {
            if (pieces >= 5) {
                return Five;
            }
            else {
                return 0;
            }
        }
    }

    public static boolean checkwin(Integer[][] Board, int x, int y) {
        ArrayList<Integer>[] Directions = GetDirections(Board, x, y);
        for (int i = 0; i < 4; i++) { //Проверяем все 4 направления
            if (check_directions(Directions[i])) {
                return true;
            }
        }
        return false;
    }

     public static boolean check_directions(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 4; i++) {
            if (arr.get(i) != 0) {
                if (arr.get(i) == arr.get(i + 1) && arr.get(i) == arr.get(i + 2) && arr.get(i) == arr.get(i + 3) && arr.get(i) == arr.get(i + 4)) {
                    return true;
                }
            }
        }
        return false;
    }



    public static int RulesWin(int i, int j, int y, Integer [][]m)
    {
        int n;
        int ii = i;
        int jj = j;

        n = 0;

        while (ii >= 0 && jj >= 0 && m[ii][jj] == y)
        {
            n++;
            ii--;
            jj--;
        }
        ii = i;
        jj = j;
        while (ii <= 18 && jj <= 18 && m[ii][jj] == y)
        {
            n++;
            ii++;
            jj++;
        }
        if (n - 1 > 4)
        {
            return (1);
        }
        n = 0;
        ii = i;
        jj = j;

        while (ii >= 0 && jj <= 18 && m[ii][jj] == y)
        {
            n++;
            ii--;
            jj++;
        }
        ii = i;
        jj = j;
        while (ii <= 18 && jj >= 0 && m[ii][jj] == y)
        {
            n++;
            ii++;
            jj--;
        }

        if (n - 1 > 4)
        {
            return (1);
        }
        n = 0;
        ii = i;
        jj = j;

        while (ii >= 0 && m[ii][jj] == y)
        {
            n++;
            ii--;
        }
        ii = i;
        jj = j;
        while (ii <= 18 && m[ii][jj] == y)
        {
            n++;
            ii++;
        }

        if (n - 1 > 4)
        {
            return (1);
        }
        n = 0;
        ii = i;
        jj = j;
        while (jj >= 0 && m[ii][jj] == y)
        {
            n++;
            jj--;
        }
        ii = i;
        jj = j;
        while (jj <= 18 && m[ii][jj] == y)
        {
            n++;
            jj++;
        }
        if (n - 1 > 4)
        {
            return (1);
        }
        return (0);



    }
}
