package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private static final int LINE = 10;
    private static final int CHAR_PER_LINE = 25;
    private JTextArea theText;
    private Calculator cal;

    public Interface() {
        cal = new Calculator();

        setSize(WIDTH, HEIGHT);
        setTitle("Calculator");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(4, 5));

        JButton seven = new JButton("7");
        seven.addActionListener(this);
        buttonPane.add(seven);

        JButton eight = new JButton("8");
        eight.addActionListener(this);
        buttonPane.add(eight);

        JButton nine = new JButton("9");
        nine.addActionListener(this);
        buttonPane.add(nine);

        JButton add = new JButton("+");
        add.addActionListener(this);
        buttonPane.add(add);

        JButton clear = new JButton("cle");
        clear.addActionListener(this);
        buttonPane.add(clear);

        JButton four = new JButton("4");
        four.addActionListener(this);
        buttonPane.add(four);

        JButton five = new JButton("5");
        five.addActionListener(this);
        buttonPane.add(five);

        JButton six = new JButton("6");
        six.addActionListener(this);
        buttonPane.add(six);

        JButton minus = new JButton("-");
        minus.addActionListener(this);
        buttonPane.add(minus);

        JButton delete = new JButton("del");
        delete.addActionListener(this);
        buttonPane.add(delete);

        JButton one = new JButton("1");
        one.addActionListener(this);
        buttonPane.add(one);

        JButton two = new JButton("2");
        two.addActionListener(this);
        buttonPane.add(two);

        JButton three = new JButton("3");
        three.addActionListener(this);
        buttonPane.add(three);

        JButton multi = new JButton("*");
        multi.addActionListener(this);
        buttonPane.add(multi);

        JButton exit = new JButton("exit");
        exit.addActionListener(this);
        buttonPane.add(exit);

        JButton dot = new JButton(".");
        dot.addActionListener(this);
        buttonPane.add(dot);

        JButton zero = new JButton("0");
        zero.addActionListener(this);
        buttonPane.add(zero);

        JButton equal = new JButton("=");
        equal.addActionListener(this);
        buttonPane.add(equal);

        JButton divi = new JButton("/");
        divi.addActionListener(this);
        buttonPane.add(divi);

        contentPane.add(buttonPane, BorderLayout.SOUTH);

        JPanel textPane = new JPanel();
        textPane.setBackground(Color.BLUE);
        theText = new JTextArea(LINE, CHAR_PER_LINE);
        theText.setBackground(Color.WHITE);
        textPane.add(theText);
        contentPane.add(textPane, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String text = theText.getText();
        theText.setText(cal.address(action, text));
    }


}

