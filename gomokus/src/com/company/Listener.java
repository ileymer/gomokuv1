package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Algorithm.*;

public class Listener implements ActionListener {
    JButton but;
    JButton [][]butM;
    Integer [][]m;
    Integer []main;
    Integer []del = new Integer[4];
    JLabel winner;
    JLabel pl1;
    JLabel pl2;
    String []Player;
    int x;
    int y;
    static int i = 0;
    public Listener(JButton b, Integer [][]matr, int nx, int ny, JButton [][]butMas, Integer []ma, JLabel t, String []Player1)
    {
        but = b;
        m = matr;
        x = nx;
        y = ny;
        butM = butMas;
        main  = ma;
        winner = t;
        main[2] = 0;
        main[5] = 0;
        Player = Player1;
    }

    public void actionPerformed(ActionEvent e) {
        if (m[x][y] == 0 && main[5] % 2 == 0)
        {
            but.setBorderPainted(false);
            but.setFocusPainted(false);
            but.setContentAreaFilled(false);
            but.setRolloverEnabled(false);
            but.setIcon(new ImageIcon(Player[0]));
            m[x][y] = 1;
            if (Couple(x, y, 1, 2, m, del) == 1) {
                m[del[0]][del[1]] = 0;
                m[del[2]][del[3]] = 0;
                butM[del[1]][del[0]].setIcon(new ImageIcon("ff.jpg"));
                butM[del[3]][del[2]].setIcon(new ImageIcon("ff.jpg"));
                main[8]++;
            }
            main[5]++;
            if (main[0] == 1) {
                alg(m, main[8], main[9], main);
                butM[main[7]][main[6]].setBorderPainted(false);
                butM[main[7]][main[6]].setFocusPainted(false);
                butM[main[7]][main[6]].setContentAreaFilled(false);
                butM[main[7]][main[6]].setRolloverEnabled(false);
                butM[main[7]][main[6]].setIcon(new ImageIcon(Player[1]));
                //butM[5][10].setIcon(new ImageIcon("X.jpg"));
               // System.out.println(main[7] + "  " + main[6]);
                if (Couple(main[6], main[7], 2, 1, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    butM[del[1]][del[0]].setIcon(new ImageIcon("ff.jpg"));
                    butM[del[3]][del[2]].setIcon(new ImageIcon("ff.jpg"));
                    main[8]++;
                }
                System.out.println(main[1]);
                System.out.println(m[main[6]][main[7]]);
                main[5]++;
            }


        }
        if (m[x][y] == 0 && main[5] % 2 == 1)
        {
            but.setBorderPainted(false);
            but.setFocusPainted(false);
            but.setContentAreaFilled(false);
            but.setRolloverEnabled(false);
            but.setIcon(new ImageIcon(Player[1]));
            m[x][y] = 2;
            if (Couple(x, y, 2, 1, m, del) == 1) {
                m[del[0]][del[1]] = 0;
                m[del[2]][del[3]] = 0;
                butM[del[1]][del[0]].setIcon(new ImageIcon("ff.jpg"));
                butM[del[3]][del[2]].setIcon(new ImageIcon("ff.jpg"));
                main[9]++;
            }
            main[5]++;

            if (main[0] == 1) {
                alg(m, main[9], main[8], main);
                butM[main[7]][main[6]].setBorderPainted(false);
                butM[main[7]][main[6]].setFocusPainted(false);
                butM[main[7]][main[6]].setContentAreaFilled(false);
                butM[main[7]][main[6]].setRolloverEnabled(false);
                butM[main[7]][main[6]].setIcon(new ImageIcon(Player[0]));
                if (Couple(main[6], main[7], 2, 1, m, del) == 1) {
                    m[del[0]][del[1]] = 0;
                    m[del[2]][del[3]] = 0;
                    butM[del[1]][del[0]].setIcon(new ImageIcon("ff.jpg"));
                    butM[del[3]][del[2]].setIcon(new ImageIcon("ff.jpg"));
                    main[8]++;
                }

                //butM[5][10].setIcon(new ImageIcon("X.jpg"));
                // System.out.println(main[7] + "  " + main[6]);
                System.out.println(main[1]);
                System.out.println(m[main[6]][main[7]]);
                main[5]++;
            }

        }




    }

}
