package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line {
    private final JPanel panelRoot;
    private final PadDrawV1 padDrawV1;
//    private JPanel panelButton;
    private Box boxButton;

    public Line(JPanel panelRoot, PadDrawV1 padDrawV1) {
        this.panelRoot = panelRoot;
        this.padDrawV1 = padDrawV1;
    }

    public void makeLayout() {
//        panelButton = new JPanel();
//        panelButton.setSize(150, 150);
//        panelButton.setLayout(new GridLayout(5, 1, 5, 5));
//
//        panelRoot.add(panelButton);

        boxButton = Box.createVerticalBox();
        panelRoot.add(boxButton);

        makeButton("dashed");
        makeButton("normal");
        makeButton("dotted");
        strokeWidth();

    }

    public void makeButton(String type) {
        JButton btn = new JButton(type);
//        panelButton.add(btn);
        boxButton.add(btn);
        btn.setSize(20, 20);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padDrawV1.setStroke(type);
            }
        });
    }

    private void strokeWidth() {
        JTextField tfStrokewidth = new JTextField();
        JButton btnSet = new JButton("Set");

//        panelButton.add(tfStrokewidth);
        boxButton.add(tfStrokewidth);
        tfStrokewidth.setSize(20, 20);

//        panelButton.add(btnSet);
        boxButton.add(btnSet);
        btnSet.setSize(20, 10);
        btnSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String strokeWidth = tfStrokewidth.getText();

                    if (!strokeWidth.isEmpty()){
                        int width = Integer.parseInt(strokeWidth);

                        if (width < 1){
                            JOptionPane.showMessageDialog(null, "Please input positive value!");
                        } else {
                            padDrawV1.strokeWidth = width;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Empty Text field, please input a value!");
                    }
                } catch (NullPointerException e1) {
                    System.out.println("null input");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please input numeric value!");
                }

            }
        });
    }
}
