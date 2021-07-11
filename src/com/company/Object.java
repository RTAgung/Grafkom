package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

        makeObjectButton("Drawline", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\pencil.png");
        makeObjectButton("Rectangle", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\square.png");
        makeObjectButton("Triangle", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\segitiga.png");
        makeObjectButton("Diamond", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\diamond.png");
        makeObjectButton("Circle", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\circle.png");
        makeObjectButton("Hexagon", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\hexagon.png");
        makeObjectButton("Line", "E:\\tugas\\#UPNVY\\#Semester 6\\Grafika Komputer dan Multimedia (C)\\Projek\\icon\\line.png");
    }

    public void makeObjectButton(String object, String path) {
        Image scaled;
        JButton objButton = new JButton();
        panelButton.add(objButton);
        objButton.setPreferredSize(new Dimension(50,30));
        try {
            scaled = ImageIO.read(new File(path)).getScaledInstance(25,25,Image.SCALE_SMOOTH);
            objButton.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            e.printStackTrace();
        }
        objButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padDrawV1.selected = 1;
                padDrawV1.objectType = object;
            }
        });
    }
}
