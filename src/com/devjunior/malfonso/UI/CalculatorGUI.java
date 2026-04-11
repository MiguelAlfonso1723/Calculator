package com.devjunior.malfonso.UI;

import com.devjunior.malfonso.Control.CalculatorLogic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel panel;
    private CalculatorLogic calculatorLogic;
    private JTextField opercount;
    private JTextArea textArea;

    public CalculatorGUI(){
        JPanel panelSpace = new JPanel(new GridLayout(3,1));
        calculatorLogic = new CalculatorLogic();
        setTitle("Calculadora");
        setMinimumSize(new Dimension(400, 500));
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Roboto", Font.PLAIN, 50));
        display.setForeground(Color.white);
        display.setBackground(new Color(28, 29, 30));
        display.setBorder(BorderFactory.createLineBorder(new Color(28, 29, 30),2));
        KeyEvent();

        opercount = new JTextField();
        opercount.setEditable(false);
        opercount.setFont(new Font("Roboto", Font.BOLD, 19));
        opercount.setForeground(Color.lightGray);
        opercount.setBackground(new Color(28, 29, 30));
        opercount.setBorder(BorderFactory.createLineBorder(new Color(28, 29, 30),2));
        opercount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                display.requestFocusInWindow();
            }
        });
        add(panelSpace, BorderLayout.NORTH);

        JPanel subpanel = new JPanel(new GridBagLayout());
        subpanel.setBackground(new Color(28, 29, 30));
        subpanel.setPreferredSize(new Dimension(200, 40));
        subpanel.setMinimumSize(new Dimension(200, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;

        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea.setFont(new Font("Roboto", Font.PLAIN, 16));
        textArea.setForeground(Color.white);
        textArea.setBackground(new Color(28, 30, 31));
        textArea.setBorder(BorderFactory.createLineBorder(new Color(28, 29, 30),2));
        textArea.setEditable(false);
        textArea.setVisible(false);
        scroll.setVisible(false);
        textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                display.requestFocusInWindow();
            }
        });

        gbc.gridx = 0;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        subpanel.add(scroll, gbc);

        JButton btn = new JButton("🕐");
        btn.setFont(new Font("Arial Unicode MS", Font.BOLD, 29));
        btn.setForeground(new Color(255, 140, 0));
        btn.setPreferredSize(new Dimension(29, 0));
        btn.setMinimumSize(new Dimension(29, 0));
        btn.setBackground(Color.DARK_GRAY);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!textArea.isVisible()){
                    textArea.setVisible(true);
                    scroll.setVisible(true);

                    revalidate();
                }else{
                    textArea.setVisible(false);
                    scroll.setVisible(false);
                    revalidate();
                }
            }
        });
        btn.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                display.requestFocusInWindow();
            }
        });


        gbc.gridx = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        subpanel.add(btn, gbc);


        panelSpace.add(subpanel);
        panelSpace.add(opercount);
        panelSpace.add(display);


        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(new Color(28, 29, 30));
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
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

    }

    private void KeyEvent() {

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if("+-/*%.=".contains(String.valueOf(c)) || Character.isDigit(c)){
                    calculatorLogic.processCommand(String.valueOf(c), display, opercount, textArea);
                } else if (c == KeyEvent.VK_BACK_SPACE) {
                    calculatorLogic.processCommand("⌫", display, opercount, textArea);
                } else if (c == KeyEvent.VK_ESCAPE) {
                    calculatorLogic.processCommand("AC", display, opercount, textArea);
                } else if (c == KeyEvent.VK_ENTER) {
                    calculatorLogic.processCommand("=", display, opercount, textArea);
                }
                if(display.getText().length() > 14) display.setFont(new Font("Roboto", Font.PLAIN, 23));
                if(display.getText().length() <= 14) display.setFont(new Font("Roboto", Font.PLAIN, 50));
            }
            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        display.addKeyListener(keyListener);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            calculatorLogic.processCommand(command, display, opercount, textArea);
            if(display.getText().length() > 14) display.setFont(new Font("Roboto", Font.PLAIN, 23));
            if(display.getText().length() <= 14) display.setFont(new Font("Roboto", Font.PLAIN, 50));
            display.requestFocusInWindow();
        }

    }
}
