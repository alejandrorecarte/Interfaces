package JButtonImagen;

import javax.swing.*;

public class GUI {
    private JButtonImagen boton1;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(0,0,100,100);
    }

    public void createUIComponents(){
        boton1 = new JButtonImagen();
    }
}
