package JScrollPane;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneBuilder {

    public static void main(String[] args) {
        JFrame f = new JFrame("JScrollPane");
        JPanel p = new JPanel(new GridBagLayout());

        JLabel lUser = new JLabel("Usuario");
        p.add(lUser, new GridBagConstraints(0,0, 1, 1, 0.25, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10,10,3,0), 0, 0));
        JTextField tfUser = new JTextField(50);
        p.add(tfUser, new GridBagConstraints(1,0, 1, 1, 1.0, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10,0,3,10), 0, 0));

        JLabel lPass = new JLabel("Contraseña");
        p.add(lPass, new GridBagConstraints(0,1, 1, 1, 0.25, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,3,0), 0, 0));
        JPasswordField pfPass = new JPasswordField(50);
        p.add(pfPass, new GridBagConstraints(1,1, 1, 1, 1.0, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,0,3,10), 0, 0));

        JLabel lDesc = new JLabel("Descripción");
        p.add(lDesc,  new GridBagConstraints(0,2, 1, 1, 0.25, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,3,10), 0, 0));
        JTextArea taDesc = new JTextArea(20,20);
        JScrollPane spDesc = new JScrollPane(taDesc);
        spDesc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spDesc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        p.add(spDesc, new GridBagConstraints(0,3, 2, 2, 1.0, 3.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,3,10), 0, 0));

        JLabel laItems = new JLabel("Función");
        p.add(laItems,  new GridBagConstraints(0,5, 1, 1, 0.25, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,3,10), 0, 0));
        JList lItems = new JList();
        JScrollPane spItems = new JScrollPane(lItems);
        String[] items = {"CEO", "CFO", "IT", "Departamento legal", "Logística", "Marketing", "Calidad","Supervisor", "Empleado", "Becario", "Prácticas"};
        lItems.setListData(items);
        p.add(spItems, new GridBagConstraints(0,6, 2, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,10,10), 0, 0));

        JScrollPane sp = new JScrollPane(p);
        f.add(sp);
        f.setBounds(200,200,600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
