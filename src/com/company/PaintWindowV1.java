package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PaintWindowV1 extends JFrame {
    private final JPanel panel;
    private final JPanel panel2;
    private PadDrawV1 drawPad = new PadDrawV1();

    public PaintWindowV1() {
        setTitle("Grafkom");
        setSize(1000, 600);
        panel = new JPanel();
        panel2 = new JPanel();
        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());

        content.add(drawPad, BorderLayout.CENTER);
        content.add(panel, BorderLayout.NORTH);
        content.add(panel2, BorderLayout.SOUTH);

        makeColorButton(Color.BLUE);
        makeColorButton(Color.MAGENTA);
        makeColorButton(Color.RED);
        makeColorButton(Color.white);
        makeColorButton(Color.GREEN);
        makeColorButton(Color.BLACK);

        makeObjectButton("Drawline");
        makeObjectButton("Rectangle");
        makeObjectButton("Triangle");
        makeObjectButton("Diamond");
        makeObjectButton("Circle");
        makeObjectButton("Hexagon");
        makeObjectButton("Line");


        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.clear();
            }
        });
        panel.add(clearButton);
    }

    public void makeColorButton(final Color color) {
        JButton tempButton = new JButton();
        tempButton.setBackground(color);
        tempButton.setPreferredSize(new Dimension(16, 16));
        panel.add(tempButton);
        tempButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.changeColor(color);
            }
        });
    }

    public void makeObjectButton(String object){
        JButton objButton = new JButton(object);
        panel2.add(objButton);
        objButton.setBounds(100,390,50,1000);
        objButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.selected = 1;
                drawPad.objectType = object;
            }
        });

    }
}