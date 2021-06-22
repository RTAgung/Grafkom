package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasRta {
    private Container content;
    private JPanel panelRoot;

    private JPanel panelButton;

    private int startX = 0;
    private int startY = 0;
    private int endX = 0;
    private int endY = 0;

    boolean haveSelect = false;

    public TugasRta(Container content, JPanel panelRoot) {
        this.panelRoot = panelRoot;
        this.content = content;
    }

    public void makeLayoutRta() {
        panelButton = new JPanel();
        panelButton.setBackground(Color.GREEN);
        panelButton.setSize(150, 150);
        panelButton.setLayout(new GridLayout(2, 3, 5, 5));

        panelRoot.add(panelButton);

        makeRtaButton("Select");
        makeRtaButton("Translasi");
        makeRtaButton("Scaling");
        makeRtaButton("Skew");
        makeRtaButton("Rotate");
        makeRtaButton("Refleksi");
    }

    private void makeRtaButton(String type) {
        JButton rtaButton = new JButton(type);
        panelButton.add(rtaButton);
        rtaButton.setSize(20, 20);
        rtaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton(type);
            }
        });
    }

    private void actionButton(String type) {
        switch (type) {
            case "Select":
                break;
        }
    }

    public void setCoordinate(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
