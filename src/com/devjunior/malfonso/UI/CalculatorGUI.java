package com.devjunior.malfonso.UI;

import com.devjunior.malfonso.Control.CalculatorLogic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel panel;
    private CalculatorLogic calculatorLogic;
    private JTextField opercount;

    public CalculatorGUI(){
        JPanel panelSpace = new JPanel(new GridLayout(2,1));
        calculatorLogic = new CalculatorLogic();
        setTitle("Calculadora");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Roboto", Font.PLAIN, 50));
        display.setForeground(Color.white);
        display.setBackground(Color.BLACK);
        display.setBorder(BorderFactory.createLineBorder(Color.black,2));


        opercount = new JTextField();
        opercount.setEditable(false);
        opercount.setFont(new Font("Roboto", Font.BOLD, 19));
        opercount.setForeground(Color.lightGray);
        opercount.setBackground(Color.BLACK);
        opercount.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        panelSpace.add(opercount);
        panelSpace.add(display);

        add(panelSpace, BorderLayout.NORTH);


        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(Color.BLACK);
        add(panel, BorderLayout.CENTER);


        String [] buttons =
                {"AC", "⌫", "%", "/",
                 "7", "8", "9", "*",
                 "4", "5", "6", "-",
                 "1", "2", "3", "+",
                 "+/-", "0", ".", "="
                };
        for(String text : buttons){

            JButton button = new JButton(text);
            button.setFont(new Font("Arial Unicode MS", Font.BOLD, 23));
            button.setBackground(text.equals("=")?new Color(255, 140, 0):Color.DARK_GRAY);
            button.setForeground(Character.isDigit(text.charAt(0)) || text.equals(".") || text.equals("=") || text.equals("+/-")?Color.white:new Color(255, 140, 0));
            button.setBorder(new LineBorder(Color.DARK_GRAY, 0, true));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
    }

    private class ButtonClickListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            calculatorLogic.processCommand(command, display, opercount);
            if(display.getText().length() > 14) display.setFont(new Font("Roboto", Font.PLAIN, 23));
            if(display.getText().length() <= 14) display.setFont(new Font("Roboto", Font.PLAIN, 50));

        }

    }
}
