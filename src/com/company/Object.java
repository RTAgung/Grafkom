package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Object {
    private final JPanel panelRoot;
    private final PadDrawV1 padDrawV1;
    private JPanel panelButton;

    public Object(JPanel panelRoot, PadDrawV1 padDrawV1) {
        this.panelRoot = panelRoot;
        this.padDrawV1 = padDrawV1;
    }

    public void makeLayout(){
        panelButton = new JPanel();
        panelRoot.add(panelButton);

        makeObjectButton("Drawline");
        makeObjectButton("Rectangle");
        makeObjectButton("Triangle");
        makeObjectButton("Diamond");
        makeObjectButton("Circle");
        makeObjectButton("Hexagon");
        makeObjectButton("Line");
    }

    public void makeObjectButton(String object) {
        JButton objButton = new JButton(object);
        panelButton.add(objButton);
        objButton.setBounds(100, 390, 50, 1000);
        objButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padDrawV1.selected = 1;
                padDrawV1.objectType = object;
            }
        });
    }
}
