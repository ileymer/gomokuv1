


public class Algorithm {
   static int k = 4;
    static int yp = 0;
    static int ep = 0;
    static final int r = 19;

    public static void alg(Integer [][]m, int d1, int d2, Integer []main)
    {
        System.out.println("*_**____");
        Integer [][]mc = new Integer[r][r];
        Integer []il = new Integer[2];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < r; j++)
                mc[i][j] = m[i][j];
            yp = main[1];
            ep = AlgorithmHelper.P(main[1]);
        minimax(main[10], -1000000000,1000000000, main[1], 0, 0, mc, il, d1, d2);
        m[il[0]][il[1]] = main[1];
        main[6] = il[0];
        main[7] = il[1];

    }

    public static int Couple(int i, int j, int y, int e, Integer [][]m, Integer []del)
    {
        if (i > 2 && j > 2)
        {
            if (m[i - 1][j - 1] == e && m[i - 2][j - 2] == e && m[i - 3][j - 3] == y)
            {
                del[0] = i - 2;
                del[1] = j - 2;
                del[2] = i - 1;
                del[3] = j - 1;
                return (1);
            }
        }
        if (i > 2) {
            if (m[i - 1][j] == e && m[i - 2][j] == e && m[i - 3][j] == y) {

                del[0] =i - 2;
                del[1] =j;
                del[2] =i - 1;
                del[3] =j;
                return (1);
            }
        }
        if (j > 2)
        {
            if (m[i][j - 1] == e && m[i][j - 2] == e && m[i][j - 3] == y)
            {

                del[0] =i;
                del[1] =j - 2;
                del[2] =i;
                del[3] =j - 1;
                return (1);
            }
        }
        if (i > 2 && j < 16)
        {
            if (m[i - 1][j + 1] == e && m[i - 2][j + 2] == e && m[i - 3][j + 3] == y)
            {
                del[0] =i - 2;
                del[1] =j + 2;
                del[2] =i - 1;
                del[3] =j + 1;
                return (1);
            }
        }
        if (j < 16)
        {
            if (m[i][j + 1] == e && m[i][j + 2] == e && m[i][j + 3] == y)
            {
                del[0] =i;
                del[1] =j + 2;
                del[2] =i;
                del[3] =j + 1;
                return (1);
            }
        }
        if (i < 16 && j < 16)
        {
            if (m[i + 1][j + 1] == e && m[i + 2][j + 2] == e && m[i + 3][j + 3] == y)
            {
                del[0] =i + 2;
                del[1] =j + 2;
                del[2] =i + 1;
                del[3] =j + 1;
                return (1);
            }
        }
        if (i < 16) {
            if (m[i + 1][j] == e && m[i + 2][j] == e && m[i + 3][j] == y) {
                del[0] =i + 2;
                del[1] =j;
                del[2] =i + 1;
                del[3] =j;
                return (1);
            }
        }
        if (i < 16 && j > 2)
        {
            if (m[i + 1][j - 1] == e && m[i + 2][j - 2] == e && m[i + 3][j - 3] == y)
            {
                del[0] =i + 2;
                del[1] =j - 2;
                del[2] =i + 1;
                del[3] =j - 1;
                return (1);
            }
        }
        return (0);

    }

    public static int minimax(int depth, int alpha, int beta, int p, int i, int j, Integer[][]m, Integer []il, int d1, int d2)
    {
        Integer []del = new Integer[4];
        int f = Algorithm.Couple(i, j, AlgorithmHelper.P(p), p, m, del);
        if (f == 1)
        {
            m[del[0]][del[1]] = 0;
            m[del[2]][del[3]] = 0;
            if (p == ep)
            d1++;
            else
                d2++;
        }
        if (depth == 0)
        {
            if(p == yp && f == 1)
            {
                {
                    m[del[0]][del[1]] = yp;
                    m[del[2]][del[3]] = yp;
                }
            }
            if(p == ep && f == 1)
            {
                {
                    m[del[0]][del[1]] = ep;
                    m[del[2]][del[3]] = ep;
                }
            }
            return (EvaluateState(m,  yp, d1, d2));
        }
        if (Eval.CheckWin(m, i,j))
        {
            if(p == yp && f == 1)
            {
                {
                    m[del[0]][del[1]] = ep;
                    m[del[2]][del[3]] = ep;
                }
            }
            if(p == ep && f == 1)
            {
                {
                    m[del[0]][del[1]] = yp;
                    m[del[2]][del[3]] = yp;
                }
            }
            if (p == ep)
                return (100000);
            else
                return (-100000);
        }

        if (d2 == 5) {
            if(p == yp && f == 1)
            {
                {
                    m[del[0]][del[1]] = ep;
                    m[del[2]][del[3]] = ep;
                }
            }
            if(p == ep && f == 1)
            {
                {
                    m[del[0]][del[1]] = yp;
                    m[del[2]][del[3]] = yp;
                }
            }
            return (100000);
        }
        else if (d1 == 5) {

            if (p == yp && f == 1) {
                {
                    m[del[0]][del[1]] = ep;
                    m[del[2]][del[3]] = ep;
                }
            }
            if (p == ep && f == 1) {
                {
                    m[del[0]][del[1]] = yp;
                    m[del[2]][del[3]] = yp;
                }
            }
            return (-100000);
        }

        Integer []ij = new Integer[4];
        Integer []cl = new Integer[2];
        Integer []l = new Integer[2];
        Integer [][]mc = new Integer[r][r];
        Integer []ilc = new Integer[2];
        for (int s = 0; s < r; s++)
            for (int ss = 0; ss < r; ss++)
                mc[s][ss] = 0;
        int kk = 0;
        int eval;

        AlgorithmHelper.Rectangle(ij, m);

        if (p == yp)
        {
            int maxEval = -1000000000;
            while (kk++ < k && SelectMove(m, mc, l, p, ij[0], ij[1], ij[2], ij[3], d1) == 1)
            {
                mc[l[0]][l[1]] = 1;
                m[l[0]][l[1]] = p;

                eval = minimax(depth - 1, alpha, beta, AlgorithmHelper.P(p), l[0], l[1], m, ilc, d1, d2);

                if (eval > maxEval)
                {
                    maxEval = eval;
                    il[0] = l[0];
                    il[1] = l[1];
                }
                alpha = max(alpha, eval);
                m[l[0]][l[1]] = 0;
                if (beta <= alpha)
                    break;
            }

            if (f == 1)
            {
                m[del[0]][del[1]] = yp;
                m[del[2]][del[3]] = yp;
            }
            return (maxEval);
        }
        else if (p == ep)
        {
            int minEval = 1000000000;
            while (kk++ < k && SelectMove(m, mc, l, p, ij[0], ij[1], ij[2], ij[3], d2) == 1)
            {
                mc[l[0]][l[1]] = 1;
                m[l[0]][l[1]] = p;

                eval = minimax(depth - 1, alpha, beta, AlgorithmHelper.P(p), l[0], l[1], m, ilc, d1, d2);
                minEval = min(minEval, eval);
                beta = min(beta, eval);
                m[l[0]][l[1]] = 0;
                if (beta <= alpha)
                    break;
            }
            if (f == 1)
            {
                m[del[0]][del[1]] = ep;
                m[del[2]][del[3]] = ep;
            }
            return (minEval);
        }
        return (0);

    }

    public static int max(int a, int b)
    {
        if (a > b)
            return (a);
        return (b);
    }

    public static int min(int a, int b)
    {
        if (a < b)
            return (a);
        return (b);
    }






    private static int SelectMove(Integer [][]m, Integer [][]mc, Integer []l, int p, int i, int j, int in, int jn, int d)
    {
        int jc = j;
        int f = 0;
        int ff = 1;
        int max =  -1000;
        Integer []del = new Integer[4];


        while (i <= in)
        {
            j = jc;
            while (j <= jn)
            {
                if (m[i][j] == 0 && AlgorithmHelper.PromisingPlace(m, i, j) == 1 && mc[i][j] == 0 && AlgorithmHelper.DoubleThree(i, j, p, m) == 1) {
                    f = AlgorithmHelper.EvaluateMove(m, i, j, p);
                    if (Algorithm.Couple(i, j, p, AlgorithmHelper.P(p), m, del) == 1)
                        f+=evalc(d + 1);
                    if (f > max) {
                        max = f;
                        ff = 0;
                        l[0] = i;
                        l[1] = j;
                    }
                    if (f == 777777777) {
                        max = f;
                        ff = 0;
                        l[0] = i;
                        l[1] = j;
                        break;
                    }
                }
                j++;
            }
            if (f == 777777777)
                break;
            i++;
        }

        if (ff == 1)
            return (0);
        return (1);

    }

    static int evalc(int seq) {
        switch (seq) {
            case 1:
                return 110000;
            case 2:
                return 130000;
            case 3:
                return 150000;
            case 4:
                return 777777777;

        }
        return (0);
    }

        static int EvaluateState(Integer [][]Board, int yp, int d1, int d2) {
        int EnemyScore = Eval.EvalBoard(Board, AlgorithmHelper.P(yp))+ Eval.evalcs(d2);
        int Your_Score = Eval.EvalBoard(Board, yp) + Eval.evalcs(d1);
        int score = 0;

            score = (Your_Score - EnemyScore);


        return score;
    }



}
