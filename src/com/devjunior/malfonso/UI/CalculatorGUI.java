package com.devjunior.malfonso.UI;

import com.devjunior.malfonso.Control.CalculatorLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel panel;
    private CalculatorLogic calculatorLogic;

    public CalculatorGUI(){
        calculatorLogic = new CalculatorLogic();
        setTitle("Calculadora");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Roboto", Font.PLAIN, 50));
        add(display, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,10,10));
        add(panel, BorderLayout.CENTER);

        String [] buttons =
                {"7", "8", "9", "/",
                 "4", "5", "6", "*",
                 "3", "2", "1", "-",
                 "0", ".", "=", "+"
                };
        for(String text : buttons){
            JButton button = new JButton(text);
            button.setFont(new Font("Roboto", Font.PLAIN, 20));

            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
    }

    private class ButtonClickListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            calculatorLogic.processCommand(command, display);

        }

    }
}
