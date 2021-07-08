package com.company;

import javax.swing.*;
import java.awt.geom.AffineTransform;

public class ActionRta {
    private final PadDrawV1 drawPad;

    public ActionRta(PadDrawV1 drawPad) {
        this.drawPad = drawPad;
    }

    public void showActionRotate() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel title = new JLabel("Rotate");
        JLabel lDegree = new JLabel("Degree = ");
        JTextField tfDegree = new JTextField("0");
        JButton bCancel = new JButton("close");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lDegree.setBounds(20, 80, 90, 20);
        tfDegree.setBounds(120, 80, 80, 20);
        bSet.setBounds(80, 150, 80, 20);
        bCancel.setBounds(180, 180, 80, 20);

        frame.add(title);
        frame.add(lDegree);
        frame.add(tfDegree);
        frame.add(bCancel);
        frame.add(bSet);

        bCancel.addActionListener(e -> {
            frame.dispose();
        });

        bSet.addActionListener(v -> {
            try {
                double degree = Double.parseDouble(tfDegree.getText());

                drawPad.clear();
                AffineTransform af = new AffineTransform();
                af.rotate(Math.toRadians(degree), drawPad.midpointX, drawPad.midpointY);
                drawPad.graphics2D.transform(af);
                drawPad.switchCreateShape();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
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
        JButton bCancel = new JButton("close");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 50, 20);
        lY.setBounds(20, 120, 50, 20);
        tfX.setBounds(80, 80, 80, 20);
        tfY.setBounds(80, 120, 80, 20);
        bSet.setBounds(80, 150, 80, 20);
        bCancel.setBounds(180, 180, 80, 20);

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
        JTextField tfX = new JTextField("100");
        JTextField tfY = new JTextField("100");
        JButton bCancel = new JButton("close");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 50, 20);
        lY.setBounds(20, 120, 50, 20);
        tfX.setBounds(80, 80, 80, 20);
        tfY.setBounds(80, 120, 80, 20);
        bSet.setBounds(80, 150, 80, 20);
        bCancel.setBounds(180, 180, 80, 20);

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
                double x = Double.parseDouble(tfX.getText()) / 100;
                double y = Double.parseDouble(tfY.getText()) / 100;

                drawPad.clear();
                AffineTransform af = new AffineTransform();
                af.translate(-(drawPad.midpointX * (x - 1)), -(drawPad.midpointY * (y - 1)));
                af.scale(x, y);
                drawPad.graphics2D.transform(af);
                drawPad.switchCreateShape();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
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
        JTextField tfX = new JTextField("0");
        JTextField tfY = new JTextField("0");
        JButton bCancel = new JButton("close");
        JButton bSet = new JButton("set");

        title.setBounds(100, 20, 100, 20);
        lX.setBounds(20, 80, 70, 20);
        lY.setBounds(20, 120, 70, 20);
        tfX.setBounds(100, 80, 80, 20);
        tfY.setBounds(100, 120, 80, 20);
        bSet.setBounds(80, 150, 80, 20);
        bCancel.setBounds(180, 180, 80, 20);

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
                af.shear(x, y);
                drawPad.graphics2D.transform(af);
                drawPad.switchCreateShape();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
