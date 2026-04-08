package com.devjunior.malfonso.Control;

import javax.swing.*;

public class CalculatorLogic {

    private double num1, num2, result;

    private char operator;

    public void processCommand(String command, JTextField display){
        if(Character.isDigit(command.charAt(0))|| command.equals(".")){
            display.setText(display.getText()+command);

        }else if(Character.getType(command.charAt(0))== Character.MATH_SYMBOL && !command.equals("=")){
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            System.out.println(num1 + " " + operator);
            display.setText("");
        }else if(command.equals("=")){
            num2 = Double.parseDouble(display.getText());
            switch (operator){

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

            }
            display.setText(String.valueOf(result));
        }
    }
}
