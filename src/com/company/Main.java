package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JComponent {

    public static void main(String[] args) {
        PaintWindowV1 frame = new PaintWindowV1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
