package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListenerSetting implements ActionListener {
    Integer []m;

    public ListenerSetting(Integer []main)
    {
        m = main;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (((JRadioButton)e.getSource()).getName() == "PVE")
            m[0] = 1;  //igra II

        if (((JRadioButton)e.getSource()).getName() == "ONE")
        m[1] = 2; // kem igraet II
        if (((JRadioButton)e.getSource()).getName() == "TWO")
        m[1] = 1;


        m[2] = 1;  //slojnost
        m[2] = 2;





    }

}
