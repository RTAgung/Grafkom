package com.company;

import javax.swing.*;
import java.awt.geom.AffineTransform;

public class ActionRta {
    private PadDrawV1 drawPad;

    public ActionRta(PadDrawV1 drawPad) {
        this.drawPad = drawPad;
    }

    public void showActionRefleksi() {
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

    public void showActionRotate() {
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

    public void showActionTranslasi() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Translasi");
        JLabel lX = new JLabel("X = ");
        JLabel lY = new JLabel("Y = ");
        JTextField tfX = new JTextField("0");
        JTextField tfY = new JTextField("0");
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
            try {
                double x = Double.parseDouble(tfX.getText());
                double y = Double.parseDouble(tfY.getText());

                drawPad.clear();
                AffineTransform af = new AffineTransform();
                af.translate(x, -y);
                drawPad.graphics2D.transform(af);
                drawPad.switchCreateShape();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            frame.dispose();
        });
    }

    public void showActionScaling() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Scaling");
        JLabel lX = new JLabel("X (%) = ");
        JLabel lY = new JLabel("Y (%) = ");
        JTextField tfX = new JTextField("0");
        JTextField tfY = new JTextField("0");
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

    public void showActionSkew() {
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
}