package FlowLayout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Botones");
        f.setLayout(new FlowLayout());
        f.setBounds(200,200,1000, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JButton b1 = new JButton("Button 1");
        p1.add(b1);

        JButton b2 = new JButton("Button 2");
        p1.add(b2);

        JButton b3 = new JButton("Button 3");
        p1.add(b3);

        JButton b4 = new JButton ("Long-named Button 4");
        p1.add(b4);

        JButton b5 = new JButton("5");
        p1.add(b5);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton("Left to Right");
        bg.add(rb1);
        p2.add(rb1);
        JRadioButton rb2 = new JRadioButton("Right to Left");
        bg.add(rb2);
        p2.add(rb2);

        JButton b6 = new JButton("Apply orientation");
        p2.add(b6);

        f.add(p1);
        f.add(p2);
        f.setVisible(true);
    }
}
