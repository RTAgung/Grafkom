package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasRta {
    private final JPanel panelRoot;
    private final ActionRta actionRta;

    private JPanel panelButton;

    public TugasRta(JPanel panelRoot, PadDrawV1 drawPad) {
        this.panelRoot = panelRoot;
        actionRta = new ActionRta(drawPad);
    }

    public void makeLayoutRta() {
        panelButton = new JPanel();
        panelButton.setSize(150, 150);
        panelButton.setLayout(new GridLayout(3, 2, 5, 5));

        panelRoot.add(panelButton);

//        makeRtaButton("Select");
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
            case "Translasi":
                actionRta.showActionTranslasi();
                break;
            case "Scaling":
                actionRta.showActionScaling();
                break;
            case "Skew":
                actionRta.showActionSkew();
                break;
            case "Rotate":
                actionRta.showActionRotate();
                break;
            case "Refleksi":
                actionRta.showActionRefleksi();
                break;
        }
    }
}
