package com.devjunior.malfonso.Control;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorLogic {

    private BigDecimal num1, num2;
    private boolean nresult;
    private char operator;

    public CalculatorLogic(){
        num1 = BigDecimal.ZERO;
        num2 = BigDecimal.ZERO;
        nresult = true;
    }

    public void processCommand(String command, JTextField display, JTextField opercount){
        if((Character.isDigit(command.charAt(0))|| command.equals(".")) && display.getText().length() <=30){
            display.setText(Character.isDigit(command.charAt(0)) || !display.getText().contains(".")?display.getText()+command:display.getText());
            if(display.getText().charAt(0)=='0' && Character.isDigit(command.charAt(0)) && !display.getText().contains("."))display.setText(command);
            if(!nresult){
                display.setText(command);
                nresult = true;
            }
            if(display.getText().charAt(0)=='.')display.setText("0" + display.getText());
        }else if("+-*/".contains(command)){
            if(!display.getText().isEmpty() && !display.getText().equals("-")){
                num1 = operator == '\u0000'?new BigDecimal(display.getText()):operation(num1, new BigDecimal(display.getText()), operator);
                operator = command.charAt(0);
                opercount.setText(opercount.getText() + display.getText() + command);
                display.setText("");
            }else if(display.getText().isEmpty() && operator != '\u0000'){
                operator = command.charAt(0);
                opercount.setText(opercount.getText().substring(0,opercount.getText().length()-1)+operator);
            } else if (display.getText().isEmpty() && operator == '\u0000' && command.equals("-")) {
                display.setText(command);
            }


        }else if(command.equals("=") && !display.getText().equals("-")){
            if(!display.getText().isEmpty()){
                num2 = new BigDecimal(display.getText());
                operator = operator == '\u0000'? '+':operator;
                display.setText(String.valueOf(operation(num1, num2, operator)));
                num1 = BigDecimal.ZERO;
            }
            else{
                display.setText(String.valueOf(num1));
            }

            opercount.setText("");
            operator = '\u0000';
            nresult = false;
        }
    }

    private BigDecimal operation(BigDecimal n1, BigDecimal n2, char oper){
        BigDecimal result = null;

        switch (oper){
            case '+':
                result = n1.add(n2);
                break;
            case '-':
                result = n1.subtract(n2);
                break;
            case '*':
                result = n1.multiply(n2);
                break;
            case '/':
                if(n2.compareTo(BigDecimal.ZERO) == 0){
                    JOptionPane.showMessageDialog(null,"No se puede dividir por cero", "Error División por 0", JOptionPane.ERROR_MESSAGE);
                    return BigDecimal.ZERO;
                }
                try{
                    result = n1.divide(n2);
                }catch (ArithmeticException e){
                    result = n1.divide(n2, 4, RoundingMode.HALF_UP);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + oper);
        }

        return result;
    }
}
