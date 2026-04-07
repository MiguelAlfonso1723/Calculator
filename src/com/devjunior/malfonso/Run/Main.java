package com.devjunior.malfonso.Run;

import com.devjunior.malfonso.UI.CalculatorGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            CalculatorGUI gui = new CalculatorGUI();
            gui.setVisible(true);

        });

    }
}