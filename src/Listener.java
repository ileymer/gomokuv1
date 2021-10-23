

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Listener implements ActionListener {
    JButton but;
    JButton [][]butM;
    Integer [][]m;
    Integer []main;
    Integer []del = new Integer[4];
    JLabel []results;
    String []Player;
    int x;
    int y;
    static int i = 0;
    public Listener(JButton b, Integer [][]matr, int nx, int ny, JButton [][]butMas, Integer []ma, JLabel []t, String []Player1)
    {
        but = b;
        m = matr;
        x = nx;
        y = ny;
        butM = butMas;
        main  = ma;
        results = t;
        main[2] = 0;
        main[5] = 0;
        Player = Player1;
    }

    public void actionPerformed(ActionEvent e) {
        if (m[x][y] == 0 && main[5] % 2 == 0 && main[12] != 1 && AlgorithmHelper.DoubleThree(x, y, 1, m) == 1)
        {
            setButton(but, false);
            but.setRolloverEnabled(false);
            but.setIcon(new ImageIcon(Player[0]));
            m[x][y] = 1;

            if (Eval.CheckWin(m, x, y)) {
                main[12] = 1;
                results[0].setText("WINNER 1");
                return;
            }
            if (Algorithm.Couple(x, y, 1, 2, m, del) == 1) {
                m[del[0]][del[1]] = 0;
                m[del[2]][del[3]] = 0;
                Visual.DelBut(del[0], del[1]);
                Visual.DelBut(del[2], del[3]);


                main[8]++;
                results[1].setText(main[8].toString());
                if (main[8] > 4)
                {
                    main[12] = 1;
                    results[0].setText("WINNER 1");
                    return;
                }
            }
            main[5]++;
            if (main[0] == 1) {
                long start = System.currentTimeMillis();
                Algorithm.alg(m, main[8], main[9], main);
                long finish = System.currentTimeMillis();
                long elapsed = finish - start;
                results[3].setText(Long.toString(elapsed));
                butM[main[7]][main[6]].setBorderPainted(false);
                butM[main[7]][main[6]].setFocusPainted(false);
                butM[main[7]][main[6]].setContentAreaFilled(false);
                butM[main[7]][main[6]].setRolloverEnabled(false);
                butM[main[7]][main[6]].setIcon(new ImageIcon(Player[1]));
                if (Eval.CheckWin(m, main[6], main[7])) {
                    main[12] = 1;
                    results[0].setText("WINNER 2");
                    return;
                }

                if (Algorithm.Couple(main[6], main[7], 2, 1, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    Visual.DelBut(del[0], del[1]);
                    Visual.DelBut(del[2], del[3]);
                    main[9]++;
                    results[2].setText(main[9].toString());
                    if (main[9] > 4)
                    {
                        main[12] = 1;
                        results[0].setText("WINNER 2");
                        return;
                    }

                }
                System.out.println(main[1]);
                System.out.println(m[main[6]][main[7]]);
                main[5]++;
            }


        }
        if (m[x][y] == 0 && main[5] % 2 == 1 && main[12] != 1 && AlgorithmHelper.DoubleThree(x, y, 2, m) == 1)
        {
            but.setBorderPainted(false);
            but.setFocusPainted(false);
            but.setContentAreaFilled(false);
            but.setRolloverEnabled(false);
            but.setIcon(new ImageIcon(Player[1]));
            m[x][y] = 2;
            if (Eval.CheckWin(m, x, y)) {
                main[12] = 1;
                results[0].setText("WINNER 2");
                return;
            }
            if (Algorithm.Couple(x, y, 2, 1, m, del) == 1) {
                m[del[0]][del[1]] = 0;
                m[del[2]][del[3]] = 0;
                Visual.DelBut(del[0], del[1]);
                Visual.DelBut(del[2], del[3]);
                main[9]++;
                results[2].setText(main[9].toString());
                if (main[9] > 4)
                {
                    main[12] = 1;
                    results[0].setText("WINNER 2");
                    return;
                }
            }
            main[5]++;

            if (main[0] == 1) {
                long start = System.currentTimeMillis();
                Algorithm.alg(m, main[9], main[8], main);
                long finish = System.currentTimeMillis();
                long elapsed = finish - start;
                results[3].setText(Long.toString(elapsed));
                butM[main[7]][main[6]].setBorderPainted(false);
                butM[main[7]][main[6]].setFocusPainted(false);
                butM[main[7]][main[6]].setContentAreaFilled(false);
                butM[main[7]][main[6]].setRolloverEnabled(false);
                butM[main[7]][main[6]].setIcon(new ImageIcon(Player[0]));
                if (Eval.CheckWin(m, main[6], main[7])) {
                    main[12] = 1;
                    results[0].setText("WINNER 1");
                    return;
                }
                if (Algorithm.Couple(main[6], main[7], 1, 2, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    Visual.DelBut(del[0], del[1]);
                    Visual.DelBut(del[2], del[3]);
                    main[8]++;
                    results[1].setText(main[8].toString());
                    if (main[8] > 4)
                    {
                        main[12] = 1;
                        results[0].setText("WINNER 1");
                        return;
                    }

                }



                System.out.println(main[1]);
                System.out.println(m[main[6]][main[7]]);
                main[5]++;


            }

        }




    }

    public static void setButton(JButton but, boolean tf)
    {
        but.setBorderPainted(tf);
        but.setFocusPainted(tf);
        but.setContentAreaFilled(tf);



    }

}
