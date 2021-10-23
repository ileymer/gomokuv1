

import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





public class Visual {

    static JFrame frame = new JFrame("Gomoku");
    static Integer []main = new Integer[13];
    static String []Background = new String[5];
    static JLabel []results = new JLabel[4];
    static Integer bi = 0;
    static Integer [][]m = new Integer[19][19];
    static String []Player = new String[2];
    static JButton [][]but = new JButton[19][19];


    public static JLabel AddLabel(String text, int x, int y, Color c)
    {

        JLabel winner;
        winner = new JLabel(text);
        winner.setForeground(c);
        winner.setFont(new Font("Verdana", Font.PLAIN, 29));
        winner.setBounds(x,y,1000,100);
        frame.add(winner);
        return winner;
    }


    public static void Buttons(JButton but)
    {
        JButton []b = new JButton[10];
        Color act = new Color(10, 224, 200, 124);
        Color deact = new Color(245, 156, 237, 124);

        b[2] = AddBut("1", 30, 340,90, 40, act, "ONE", 1);
        b[3] = AddBut("2", 140, 340,90, 40, deact, "TWO", 1);
        b[2].addActionListener(e -> {
            newgame();
            b[2].setBackground(act);
            b[3].setBackground(deact);
            main[1] = 2;});
        b[3].addActionListener(e -> {
            newgame();
            b[3].setBackground(act);
            b[2].setBackground(deact);
            main[1] = 1;
            if (main[0] == 1 && main[1] == 1 && main[5] == 0)
            {
                m[8][8] = 1;
                but.setIcon(new ImageIcon(Player[0]));
                main[5]++;
            }});

        b[4] = AddBut("3", 30, 460,90, 40, act, "EASY", 1);
        b[5] = AddBut("5", 140, 460,90, 40, deact, "HARD", 1);
        b[6] = AddBut("11", 250, 460,90, 40, deact, "HARD2", 1);

        b[4].addActionListener(e -> {
        main[10] = 3;
            b[4].setBackground(act);
            b[5].setBackground(deact);
            b[6].setBackground(deact);
        });
        b[5].addActionListener(e -> {
            main[10] = 5;
            b[5].setBackground(act);
            b[4].setBackground(deact);
            b[6].setBackground(deact);
        });
        b[6].addActionListener(e -> {
            main[10] = 11;
            b[6].setBackground(act);
            b[4].setBackground(deact);
            b[5].setBackground(deact);
        });



        b[0] = AddBut("PVP", 30, 220,90, 40, act, "PVP", 0);
        b[0].addActionListener(e -> {
            newgame();
            b[2].setVisible(false);
            b[3].setVisible(false);
            b[4].setVisible(false);
            b[5].setVisible(false);
            b[6].setVisible(false);
            b[0].setBackground(act);
            b[1].setBackground(deact);
        main[0] = 0;
        });

        b[1] = AddBut("PVE", 140, 220,90, 40, new Color(245, 156, 237, 124),"PVE", 0);
        b[1].addActionListener(e -> {
            newgame();
            b[2].setVisible(true);
            b[3].setVisible(true);
            b[4].setVisible(true);
            b[5].setVisible(true);
            b[6].setVisible(true);
            b[1].setBackground(act);
            b[0].setBackground(deact);
            b[2].setBackground(act);
            b[3].setBackground(deact);

            main[10] = 3;
            main[0] = 1;
            main[1] = 2;});



    }

    public static JButton AddBut(String text, int x, int y, int w, int h, Color c, String name, int f)
    {
        JButton but = new JButton(text);
        Font font = new Font("Serif", Font.BOLD, 18);
        but.setBounds(x, y, w, h);
        but.setName(name);
        but.setContentAreaFilled(false);
        but.setOpaque(true);
        but.setBorderPainted(false);
        but.setFocusPainted(false);
        but.setBackground(c);
        but.setFont(font);

        if (f == 1)
            but.setVisible(false);

        but.setForeground(Color.white);
        but.setText(text);
        frame.add(but);
        return (but);
    }

    public static void DelBut(int i, int j)
    {
        but[j][i].setIcon(new ImageIcon("res/ff.png"));
        but[j][i].setRolloverEnabled(true);
    }


    public static void newgame()
    {

        int nx = 0;
        int ny = 0;
        main[5] = 0;
        main[12] = 0;
        main[8] = 0;
        main[9] = 0;
        results[0].setText("");
        results[1].setText(main[8].toString());
        results[2].setText(main[9].toString());
        for (int x = 0; x <= 18; x++) {
            ny = 0;
            for (int y = 0; y <= 18; y++) {
                if (m[x][y] != 0)
                {
                    m[x][y] = 0;
                    but[y][x].setIcon(new ImageIcon("res/ff.png"));
                    but[y][x].setRolloverEnabled(true);
                }

                ny++;
            }
            nx++;
        }
        return;
    }





    public Visual() {
        Background[0] = "res/fon3.jpg";
        Background[1] = "res/fon3.jpg";
        Player[0] = "res/skin6.jpg";
        Player[1] = "res/one2.png";
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }


                results[0] = AddLabel(" ", 1320, 140, new Color(233, 6, 25, 145)); 
                results[0].setFont(new Font("Verdana", Font.PLAIN, 350));
                results[0].setBounds(350,300,3000,600);

                results[1] = AddLabel("0", 2175, 140, new Color(243, 0, 219, 255));
                results[2] = AddLabel("0", 2175, 240, new Color(0, 50, 246, 255));
                results[3] = AddLabel("0", 30, 1390, new Color(255, 255, 255, 213));

                for (int fff = 0; fff < 13; fff++)
                    main[fff] = 0;
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                AddLabel("Game Type Selection", 30, 140, Color.white);
                AddLabel("Player 1:", 2030, 140, Color.white);
                AddLabel("Player 2:", 2030, 240, Color.white);

                AddLabel("Player Choice", 30, 260, Color.white);
                AddLabel("Depth", 30, 380, Color.white);

                AddLabel("GOMOKU", 1228, 7, new Color(255, 255, 255, 255));
                JLabel create =  AddLabel("clala X dgeonosi", 1245, 0, new Color(152, 217, 206, 136));
                create.setBounds(1215,1448,1000,50);
                create.setFont(new Font("Verdana", Font.PLAIN, 20));

                Integer []mm = new Integer[10];
                mm[0] = 0;
                mm[1] = 0;
                Color red = Color.green;

                ActionListener[][]actionListener = new Listener[19][19];


                for (int i = 0; i < 19; i++)
                    for (int j = 0; j < 19; j++)
                        m[i][j] = 0;

                for (int i = 0; i < 19; i++)
                    for (int j = 0; j < 19; j++)
                        but[i][j] = new JButton("");


                int nx = 0;
                int ny = 0;
                for (int x = 750; x <= 1830; x += 60) {
                    ny = 0;
                    for (int y = 80; y <= 1160; y += 60) {
                        but[nx][ny].setBounds(x, y, 40, 40);


                        but[nx][ny].setIcon(new ImageIcon("res/ff.png"));
                        but[nx][ny].setRolloverIcon(new ImageIcon("res/cur.jpg"));
                        but[nx][ny].setBorderPainted(false);
                        but[nx][ny].setFocusPainted(false);
                        but[nx][ny].setContentAreaFilled(false);
                       actionListener[nx][ny] = new Listener(but[nx][ny], m, ny, nx, but, main, results, Player);
                       but[nx][ny].addActionListener(actionListener[nx][ny]);
                        frame.add(but[nx][ny]);

                        ny++;
                    }
                    nx++;
                }
                Buttons(but[8][8]);


                frame.add(new TestPane());
                frame.pack();
                frame.setBackground(Color.BLACK);


                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        });
    }

    public static class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(2560, 1600);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            File file = new File(Background[bi]);
            try {
                BufferedImage image = ImageIO.read(file);
                Graphics2D g2d = (Graphics2D) g.create();

                int size = Math.min(getWidth() - 4, getHeight() - 4) / 10;



                g.setColor(Color.cyan);
                g.drawImage(image, 0, 0,null);
                g.setColor(new Color(255, 255, 255));
                for (int x = 770; x <= 1790; x += 60)
                    for (int y = 100; y <= 1120; y += 60)
                        g.drawRect(x, y, 60, 60);
                g2d.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}


