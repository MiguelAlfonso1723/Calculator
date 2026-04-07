package com.devjunior.malfonso.UI;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel panel;

    public CalculatorGUI(){

        setTitle("Calculadora");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Roboto", Font.PLAIN, 50));
        add(display, BorderLayout.NORTH);

    }


}
