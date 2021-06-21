package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class PadDrawV1 extends JComponent {

    Image image;
    Graphics2D graphics2D;
    int currentX, currentY, oldX, oldY;
    int selected = 0;
    String objectType = "";

    public PadDrawV1() {
        setDoubleBuffered(false);

        // mouse adapter ============================================
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                currentX = e.getX();
                currentY = e.getY();

                int width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
                int height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;
                int startX = currentX - oldX < 0 ? currentX : oldX;
                int startY = currentY - oldY < 0 ? currentY : oldY;
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                        0, new float[]{9}, 0);

                switch (objectType) {
                    case "Rectangle":
                        graphics2D.fillRect(startX, startY, width, height);
                        repaint();
                        break;

                    case "Triangle":
                        int midPointX = (oldX+oldY) / 2;
                        graphics2D.fillPolygon(new int[] {oldX, currentX, midPointX}, new int[] {oldY, currentY, oldY}, 3);
                        repaint();
                        break;

                    case "Circle":
                        graphics2D.fillOval(oldX, oldY, width, height);
                        repaint();
                        break;

                    case "Line":
                        graphics2D.drawLine(oldX, oldY, currentX, currentY);
                        graphics2D.setStroke(dashed);
                        repaint();
                        break;
                }
            }
        });

        // mouse motion listener ====================================
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                System.out.println("old X : " + oldX);
                System.out.println("old Y : " + oldY);
                System.out.println("current X : " + currentX);
                System.out.println("current Y : " + currentY);

                switch (objectType) {
                    case "Drawline":
                        graphics2D.drawLine(oldX, oldY, currentX, currentY);
                        repaint();

                        oldX = currentX;
                        oldY = currentY;
                        break;
                }
            }
        });

    }

    public void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void changeColor(Color theColor) {
        graphics2D.setPaint(theColor);
        repaint();
    }
}