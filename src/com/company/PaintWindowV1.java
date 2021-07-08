package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

class PaintWindowV1 extends JFrame {
    private final JPanel panel;
    private final JPanel panelSouth;
    private final JPanel panelEast;
    private final JPanel panelWest;
    private PadDrawV1 drawPad = new PadDrawV1();

    public PaintWindowV1() {
        setTitle("Grafkom");
        setSize(1000, 600);
        panel = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();

        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());

        panelEast.setLayout(new GridLayout(5, 1, 5, 5));
        panelEast.setBorder(new EmptyBorder(10, 10, 10, 10));

        panelWest.setLayout(new GridLayout(3, 1, 5, 5));
        panelWest.setBorder(new EmptyBorder(10, 10, 10, 10));

        content.add(panelEast, BorderLayout.EAST);
        content.add(drawPad, BorderLayout.CENTER);
        content.add(panel, BorderLayout.NORTH);
        content.add(panelSouth, BorderLayout.SOUTH);
        content.add(panelWest, BorderLayout.WEST);

        TugasRta tugasRta = new TugasRta(panelEast, drawPad);
        drawPad.tugasRta = tugasRta;
        tugasRta.makeLayoutRta();

        // line layout
        Line line = new Line(panelWest, drawPad);
        line.makeLayout();

        // object layout
        Object object = new Object(panelSouth, drawPad);
        object.makeLayout();

        // color layout
        makeColorButton(Color.BLUE);
        makeColorButton(Color.MAGENTA);
        makeColorButton(Color.RED);
        makeColorButton(Color.white);
        makeColorButton(Color.GREEN);
        makeColorButton(Color.BLACK);


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


}