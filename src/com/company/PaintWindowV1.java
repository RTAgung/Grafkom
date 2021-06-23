package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

class PaintWindowV1 extends JFrame {
    private final JPanel panel;
    private final JPanel panel2;
    private final JPanel panelEast;
    private PadDrawV1 drawPad = new PadDrawV1();

    public PaintWindowV1() {
        setTitle("Grafkom");
        setSize(1000, 600);
        panel = new JPanel();
        panel2 = new JPanel();
        panelEast = new JPanel();

        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());

        panelEast.setLayout(new GridLayout(5, 1, 5, 5));
        panelEast.setBorder(new EmptyBorder(10, 10, 10, 10));

        content.add(panelEast, BorderLayout.EAST);
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

        TugasRta tugasRta = new TugasRta(panelEast, drawPad);
        drawPad.tugasRta = tugasRta;
        tugasRta.makeLayoutRta();

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.graphics2D.setTransform(new AffineTransform());
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

    public void makeObjectButton(String object) {
        JButton objButton = new JButton(object);
        panel2.add(objButton);
        objButton.setBounds(100, 390, 50, 1000);
        objButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPad.selected = 1;
                drawPad.objectType = object;
            }
        });
    }
}