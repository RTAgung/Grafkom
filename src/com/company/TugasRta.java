package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasRta {
    private Container content;
    private JPanel panelRoot;
    private PadDrawV1 drawPad;

    private JPanel panelButton;

//    private int startX = 0;
//    private int startY = 0;
//    private int endX = 0;
//    private int endY = 0;
//    boolean haveSelect = false;

    public TugasRta(Container content, JPanel panelRoot, PadDrawV1 drawPad) {
        this.panelRoot = panelRoot;
        this.content = content;
        this.drawPad = drawPad;
    }

    public void makeLayoutRta() {
        panelButton = new JPanel();
        panelButton.setSize(150, 150);
        panelButton.setLayout(new GridLayout(2, 3, 5, 5));

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
                showActionTranslasi();
                break;
            case "Scaling":
                showActionScaling();
                break;
            case "Skew":
                showActionSkew();
                break;
            case "Rotate":
                showActionRotate();
                break;
            case "Refleksi":
                showActionRefleksi();
                break;
        }
    }

    private void showActionRefleksi() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Refleksi");
        JLabel lX = new JLabel("Horizontal");
        JLabel lY = new JLabel("Vertical");
        JCheckBox cX = new JCheckBox();
        JCheckBox cY = new JCheckBox();
        JButton bCancel = new JButton("cancel");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 70, 20);
        lY.setBounds(20, 120, 70, 20);
        cX.setBounds(90, 80, 80, 20);
        cY.setBounds(90, 120, 80, 20);
        bCancel.setBounds(80, 180, 80, 20);
        bSet.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lX);
        frame.add(lY);
        frame.add(cX);
        frame.add(cY);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            //asd
        });
    }

    private void showActionRotate() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Rotate");
        JLabel lX = new JLabel("X (degree) = ");
        JLabel lY = new JLabel("Y (degree) = ");
        JTextField tfX = new JTextField();
        JTextField tfY = new JTextField();
        JButton bCancel = new JButton("cancel");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 90, 20);
        lY.setBounds(20, 120, 90, 20);
        tfX.setBounds(120, 80, 80, 20);
        tfY.setBounds(120, 120, 80, 20);
        bCancel.setBounds(80, 180, 80, 20);
        bSet.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lX);
        frame.add(lY);
        frame.add(tfX);
        frame.add(tfY);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            //asd
        });
    }

    private void showActionTranslasi() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Translasi");
        JLabel lX = new JLabel("X = ");
        JLabel lY = new JLabel("Y = ");
        JTextField tfX = new JTextField();
        JTextField tfY = new JTextField();
        JButton bCancel = new JButton("cancel");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 50, 20);
        lY.setBounds(20, 120, 50, 20);
        tfX.setBounds(80, 80, 80, 20);
        tfY.setBounds(80, 120, 80, 20);
        bCancel.setBounds(80, 180, 80, 20);
        bSet.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lX);
        frame.add(lY);
        frame.add(tfX);
        frame.add(tfY);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            //asd
        });
    }

    private void showActionScaling() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Scaling");
        JLabel lX = new JLabel("X (%) = ");
        JLabel lY = new JLabel("Y (%) = ");
        JTextField tfX = new JTextField();
        JTextField tfY = new JTextField();
        JButton bCancel = new JButton("cancel");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 50, 20);
        lY.setBounds(20, 120, 50, 20);
        tfX.setBounds(80, 80, 80, 20);
        tfY.setBounds(80, 120, 80, 20);
        bCancel.setBounds(80, 180, 80, 20);
        bSet.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lX);
        frame.add(lY);
        frame.add(tfX);
        frame.add(tfY);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            //asd
        });
    }

    private void showActionSkew() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Skew");
        JLabel lX = new JLabel("X (*axis) = ");
        JLabel lY = new JLabel("Y (*axis) = ");
        JTextField tfX = new JTextField();
        JTextField tfY = new JTextField();
        JButton bCancel = new JButton("cancel");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 70, 20);
        lY.setBounds(20, 120, 70, 20);
        tfX.setBounds(100, 80, 80, 20);
        tfY.setBounds(100, 120, 80, 20);
        bCancel.setBounds(80, 180, 80, 20);
        bSet.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lX);
        frame.add(lY);
        frame.add(tfX);
        frame.add(tfY);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            //asd
        });
    }

//    public void setCoordinate(int startX, int startY, int endX, int endY) {
//        this.startX = startX;
//        this.startY = startY;
//        this.endX = endX;
//        this.endY = endY;
//    }
}
