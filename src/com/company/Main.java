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

    static class PaintWindowV1 extends JFrame
    {
        public PaintWindowV1()
        {
            setTitle("Grafkom");
            setSize(1000, 600);
            panel = new JPanel();
            Container content = this.getContentPanel();
            content.setLayout(new BorderLayout());


            content.add(drawPad, BorderLayout.CENTER);
            content.add(panel, BorderLayout.EAST);

            makeColorButton(Color.BLUE);
            makeColorButton(Color.MAGENTA);
            makeColorButton(Color.RED);
            makeColorButton(Color.white);
            makeColorButton(Color.GREEN);
            makeColorButton(Color.BLACK);

            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    drawPad.clear();
                }
            });
            panel.add(clearButton);
        }
        public void makeColorButton(final Color color)
        {
            JButton tempButton = new JButton();
            tempButton.setBackground(color);
            tempButton.setPreferredSize(new Dimension(16, 16));
            panel.add(tempButton);
            tempButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    drawPad.changeColor(color);
                }
            });
        }
        private final JPanel panel;
        private PadDrawV1 drawPad = new PadDrawV1();
    }

    static class PadDrawV1 extends JComponent
    {

        Image image;
        Graphics2D graphics2D;
        int currentX, currentY, oldX, oldY;
        public PadDrawV1()
        {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    oldX = e.getX();
                    oldY = e.getY();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    currentX = e.getX();
                    currentY = e.getY();

                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                    repaint();

                    oldX = currentX;
                    oldY = currentY;
                }
            });
        }
        public void paintComponent(Graphics g)
        {
            if(image == null)
            {
                image = createImage(getSize().width, getSize().height);
                graphics2D = (Graphics2D)image.getGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                clear();
            }

            g.drawImage(image, 0, 0, null);
        }

        public void clear()
        {
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }

        public void changeColor(Color theColor)
        {
            graphics2D.setPaint(theColor);
            repaint();
        }
    }
}
