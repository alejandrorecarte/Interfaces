package GirdBagLayout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutBuilder {
    public static void main(String[] args) {
        JFrame f = new JFrame("GridBagLayout Builder");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(200,200, 400,350);
        JPanel p = new JPanel(new GridBagLayout());
        f.setResizable(false);

        JLabel lName = new JLabel("Full Name");
        p.add(lName, new GridBagConstraints(0,0,1,1,1.0,0.10,GridBagConstraints.EAST, GridBagConstraints.EAST, new Insets(3,3,3,3),0,0));

        JTextField tfName = new JTextField();
        p.add(tfName, new GridBagConstraints(1,0,3,1,1.0,0.10,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,30),0,0));

        JLabel lStreet = new JLabel("Street");
        p.add(lStreet, new GridBagConstraints(1,1,1,1,2.0,0.025,GridBagConstraints.SOUTH, GridBagConstraints.SOUTH, new Insets(3,3,3,10),0,0));

        JLabel lCity = new JLabel("City");
        p.add(lCity, new GridBagConstraints(2,1,1,1,1.0,0.025,GridBagConstraints.SOUTH, GridBagConstraints.SOUTH, new Insets(3,3,3,3),0,0));

        JLabel lZip = new JLabel("Zip Code");
        p.add(lZip, new GridBagConstraints(3,1,1,1,1.0,0.025,GridBagConstraints.SOUTH, GridBagConstraints.SOUTH, new Insets(3,3,3,30),0,0));

        JLabel lAdress = new JLabel("Adress");
        p.add(lAdress, new GridBagConstraints(0,2,1,1,1.0,0.1,GridBagConstraints.EAST, GridBagConstraints.EAST, new Insets(3,3,3,3),0,0));

        JTextField tfStreet = new JTextField();
        p.add(tfStreet, new GridBagConstraints(1,2,1,1,2.0,0.1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,5,5,3),0,0));

        JTextField tfCity = new JTextField();
        p.add(tfCity, new GridBagConstraints(2,2,1,1,1.0,0.1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,3),0,0));

        JTextField tfZip = new JTextField();
        p.add(tfZip, new GridBagConstraints(3,2,1,1,1.0,0.1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,30),0,0));

        JLabel lPhone = new JLabel("Phone");
        p.add(lPhone, new GridBagConstraints(0,3,1,1,1.0,0.1,GridBagConstraints.EAST, GridBagConstraints.EAST, new Insets(3,3,3,3),0,0));

        JTextField tfPhone = new JTextField();
        p.add(tfPhone, new GridBagConstraints(1,3,1,1,2.0,0.1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5,3,3,3),0,0));

        JLabel lAge = new JLabel("Age");
        p.add(lAge, new GridBagConstraints(2,3,1,1,1.0,0.1,GridBagConstraints.EAST, GridBagConstraints.EAST, new Insets(3,3,3,3),0,0));

        JTextField tfAge = new JTextField();
        p.add(tfAge, new GridBagConstraints(3,3,1,1,1.0,0.1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,30),0,0));

        JLabel lDesc = new JLabel("Description");
        p.add(lDesc, new GridBagConstraints(0,4,1,1,1.0,0.75,GridBagConstraints.NORTHEAST, GridBagConstraints.NORTHEAST, new Insets(3,3,3,3),0,0));

        JTextField tfDesc = new JTextField();
        p.add(tfDesc, new GridBagConstraints(1,4,3,1,1.0,0.75,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,30),0,0));

        JButton bSubmit = new JButton("Submit");
        p.add(bSubmit, new GridBagConstraints(2,5,2,1,1.0,0.025,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3,3,3,30),0,0));


        f.add(p);
        f.setResizable(false);
        f.setVisible(true);
    }
}
