

import java.util.ArrayList;

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
    static final int r = 19;



    static int EvalBoard(Integer [][]Board, int pieceType) {
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

                    if (column == 0 || Board[row][column - 1] != 0) {
                        block++;
                    }

                    for (column++; column < 19 && Board[row][column] == pieceType; column++) {
                        piece++;
                    }
                    if (column == 19 || Board[row][column] != 0) {
                        block++;
                    }
                    score = score + EvaluateBlock(block, piece);
                }
            }
        }

        for (int column = min_c; column < max_c + 1; column++) {
            for (int row = min_r; row < max_r + 1; row++) {
                if (Board[row][column] == pieceType) {
                    int block = 0;
                    int piece = 1;
                    if (row == 0 || Board[row - 1][column] != 0) {
                        block++;
                    }
                    for (row++; row < 19 && Board[row][column] == pieceType; row++) {
                        piece++;
                    }
                    if (row == 19 || Board[row][column] != 0) {
                        block++;
                    }
                    score += EvaluateBlock(block, piece);
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
                        if (c == 0 || r == 19 - 1 || Board[r + 1][c - 1] != 0) {
                            block++;
                        }
                        r--;
                        c++;
                        for (; r >= 0 && Board[r][c] == pieceType; r--) {
                            piece++;
                            c++;
                        }
                        if (r < 0 || c == 19 || Board[r][c] != 0) {
                            block++;
                        }
                        score += EvaluateBlock(block, piece);
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
                        if (c == 0 || r == 0 || Board[r - 1][c - 1] != 0) {
                            block++;
                        }
                        r++;
                        c++;
                        for (; r < 19 && Board[r][c] == pieceType; r++) {
                            piece++;
                            c++;
                        }
                        if (r == 19 || c == 19 || Board[r][c] != 0) {
                            block++;
                        }
                        score += EvaluateBlock(block, piece);
                    }
                }
                r += 1;
                c += 1;
            }

        }
        return score;
    }

    static int EvaluateBlock(int blocks, int pieces) {
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

public static boolean CheckWin(Integer[][]m, int x, int y) {
        ArrayList<Integer> Dir1 = new ArrayList<Integer>();
        ArrayList<Integer> Dir2 = new ArrayList<Integer>();
        ArrayList<Integer> Dir3 = new ArrayList<Integer>();
        ArrayList<Integer> Dir4 = new ArrayList<Integer>();

                for (int  i = -4; i < 5; i++) {
            if (x + i >= 0 && x + i <= 19 - 1) {
                Dir1.add(m[x + i][y]);
                if (y + i >= 0 && y + i <= 19 - 1) {
                    Dir3.add(m[x + i][y + i]);
                }
            }
            if (y + i >= 0 && y + i <= 19 - 1) {
                Dir2.add(m[x][y + i]);
                if (x - i >= 0 && x - i <= 19 - 1) {
                    Dir4.add(m[x - i][y + i]);
                }
            }
        }
        
            if (CheckDirections(Dir1)) {
                return true;
            }
            if (CheckDirections(Dir2)) {
                return true;
            }
            if (CheckDirections(Dir3)) {
                return true;
            }
            if (CheckDirections(Dir4)) {
                return true;
            }
        
        return false;
    }

     public static boolean CheckDirections(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 4; i++) {
            if (arr.get(i) != 0) {
                if (arr.get(i) == arr.get(i + 1) && arr.get(i) == arr.get(i + 2) && arr.get(i) == arr.get(i + 3) && arr.get(i) == arr.get(i + 4)) {
                    return true;
                }
            }
        }
        return false;
    }





    static int evalcs(int seq) {
        switch (seq) {
            case 1:
                return 1100;
            case 2:
                return 2000;
            case 3:
                return 4000;
            case 4:
                return 10000;
            case 5:
                return 777777777;

        }
        return (0);
    }
}
