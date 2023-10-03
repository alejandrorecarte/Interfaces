package GirdBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botonsitos {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(10,10,300,300);
        JPanel p=new JPanel();

        p.setLayout(new GridBagLayout());
        JButton buttton1 = new JButton("Button 1");
        p.add(buttton1,
                new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0, 0));

        p.add(new JButton("Button 2"),
                new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0, 0));

        p.add(new JButton("Button 3"), new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0, 0));

        JTextArea ta = new JTextArea();
        p.add(ta, new GridBagConstraints(0,1, 3, 1, 1.0, 4.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0, 0));

        p.add(new JButton("Button 5"), new GridBagConstraints(1, 2, 2, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0, 0));

        f.add(p);
        f.setVisible(true);
        buttton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("Holiwi UwU");
            }
        });
    }
}
