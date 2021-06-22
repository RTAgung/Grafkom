package com.company;

import javax.swing.*;
import java.awt.*;

public class TugasRta {
    private Container content;
    private JPanel panelRoot;
    private JPanel panelButton;


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

    private void makeRtaButton(String text) {
        JButton rtaButton = new JButton(text);
        panelButton.add(rtaButton);
        rtaButton.setSize(20, 20);
    }
}
