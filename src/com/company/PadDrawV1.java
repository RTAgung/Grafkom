package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

class PadDrawV1 extends JComponent {

    Image image;
    Graphics2D graphics2D;
    AffineTransform old;
    int currentX, currentY, oldX, oldY, width, height, startX, startY;
    int midpointX, midpointY;
    int selected = 0;
    int strokeWidth = 1;
    String objectType = "";
    private Diamond diamond;
    private Triangle triangle;
    private Hexagonal hexagonal;

    TugasRta tugasRta;

    public PadDrawV1() {
        setDoubleBuffered(false);

        // mouse adapter ============================================
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();

                graphics2D.setTransform(new AffineTransform());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                currentX = e.getX();
                currentY = e.getY();

                startX = currentX - oldX < 0 ? currentX : oldX;
                startY = currentY - oldY < 0 ? currentY : oldY;

                switchCreateShape();
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
                        drawFreeLine();
                        break;
                }
            }
        });

    }

    public void switchCreateShape() {
        switch (objectType) {
            case "Rectangle":
                drawRectangle();
                break;

            case "Triangle":
                drawTriangle();
                break;

            case "Circle":
                drawCircle();
                break;

            case "Line":
                drawLine();
                break;

            case "Diamond":
                drawDiamond();
                break;

            case "Hexagon":
                drawHexagon();
                break;
        }
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

    private void drawRectangle() {
        width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
        height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;

        midpointX = startX + width / 2;
        midpointY = startY + height / 2;

        graphics2D.fillRect(startX, startY, width, height);
        repaint();
    }

    private void drawTriangle() {
        width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
        height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;

        triangle = new Triangle(width, height);

        int xTriangle = oldX < currentX ? oldX : currentX;
        int yTriangle = oldY < currentY ? oldY : currentY;

        midpointX = (oldX + currentX + ((oldX + currentX) / 2)) / 3;
        midpointY = (yTriangle + (yTriangle + height) + (yTriangle + height)) / 3;

        AffineTransform at = AffineTransform.getTranslateInstance(xTriangle, yTriangle);
        Shape shape = at.createTransformedShape(triangle);

        graphics2D.fill(shape);
        graphics2D.draw(shape);
        repaint();
    }

    private void drawDiamond() {
        width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
        height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;

        midpointX = startX + width / 2;
        midpointY = startY + height / 2;

        diamond = new Diamond(width, height);

        int xDiamond = oldX < currentX ? oldX : currentX;
        int yDiamond = oldY < currentY ? oldY : currentY;

        AffineTransform at = AffineTransform.getTranslateInstance(xDiamond, yDiamond);
        Shape shape = at.createTransformedShape(diamond);

        graphics2D.fill(shape);
        graphics2D.draw(shape);
        repaint();
    }

    private void drawCircle() {
        int xCircle = oldX < currentX ? oldX : currentX;
        int yCircle = oldY < currentY ? oldY : currentY;

        width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
        height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;

        midpointX = startX + width / 2;
        midpointY = startY + height / 2;

        graphics2D.fillOval(xCircle, yCircle, width, height);
        repaint();
    }

    private void drawHexagon() {
        width = currentX - oldX < 0 ? oldX - currentX : currentX - oldX;
        height = currentY - oldY < 0 ? oldY - currentY : currentY - oldY;

        midpointX = startX + width / 2;
        midpointY = startY + height / 2;

        hexagonal = new Hexagonal(width, height);

        int xHexagonal = oldX < currentX ? oldX : currentX;
        int yHexagonal = oldY < currentY ? oldY : currentY;

        AffineTransform at = AffineTransform.getTranslateInstance(xHexagonal, yHexagonal);
        Shape shape = at.createTransformedShape(hexagonal);

        graphics2D.fill(shape);
        graphics2D.draw(shape);
        repaint();
    }

    private void drawLine() {
        midpointX = (currentX + oldX) / 2;
        midpointY = (currentY + oldY) / 2;

        graphics2D.drawLine(oldX, oldY, currentX, currentY);
        repaint();
    }

    private void drawFreeLine() {
        graphics2D.drawLine(oldX, oldY, currentX, currentY);
        repaint();

        oldX = currentX;
        oldY = currentY;
    }

    public void setStroke(String strokeType) {
        switch (strokeType) {
            case "dashed":
                Stroke dashed = new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                        0, new float[]{9}, 0);
                graphics2D.setStroke(dashed);
                break;

            case "normal":
                Stroke normal = new BasicStroke(strokeWidth);
                graphics2D.setStroke(normal);
                break;

            case "dotted":
                float jarak = (strokeWidth < 10) ? 2 : (strokeWidth < 50) ? strokeWidth / 2 : strokeWidth / 4;
                Stroke dotted = new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                        0, new float[]{strokeWidth, jarak}, 0);
                graphics2D.setStroke(dotted);
                break;
        }
    }

    static class Diamond extends Path2D.Double {

        public Diamond(double width, double height) {
            moveTo(0, height / 2);
            lineTo(width / 2, 0);
            lineTo(width, height / 2);
            lineTo(width / 2, height);
            closePath();
        }
    }

    static class Triangle extends Path2D.Double {

        public Triangle(double width, double height) {
            moveTo(0, height);
            lineTo(width / 2, 0);
            lineTo(width, height);
            closePath();
        }
    }

    static class Hexagonal extends Path2D.Double {

        public Hexagonal(double width, double height) {
            double x_div = width / 4;
            double y_div = height / 4;

            moveTo(width / 2, 0);
            lineTo(width, y_div);
            lineTo(width, y_div + y_div + y_div);
            lineTo(width / 2, height);
            lineTo(0, y_div + y_div + y_div);
            lineTo(0, y_div);
            closePath();
        }
    }
}