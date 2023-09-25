package Clase1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiPrimerFormulario {

    public static void main(String[] args) {

        JFrame f = new JFrame("Información DNI");
        JPanel p = new JPanel(new FlowLayout());

        JLabel lDNI = new JLabel("DNI:");
        p.add(lDNI, BorderLayout.CENTER);
        JTextField tfDNI = new JTextField(50);
        p.add(tfDNI);

        JLabel lNombre = new JLabel("Nombre y apellidos:");
        p.add(lNombre, BorderLayout.CENTER);
        JTextField tfNombre = new JTextField(50);
        p.add(tfNombre, BorderLayout.CENTER);

        JLabel lFecha = new JLabel("Fecha de nacimiento:");
        p.add(lFecha);
        JTextField tfFecha = new JTextField(50);
        p.add(tfFecha);

        JLabel lSexo = new JLabel("Sexo:");
        p.add(lSexo);
        JComboBox cbSexo = new JComboBox();
        cbSexo.addItem(new String ("Masculino"));
        cbSexo.addItem(new String ("Femenino"));
        p.add(cbSexo);

        JLabel lNacionalidad = new JLabel ("Nacionalidad:");
        p.add(lNacionalidad);
        JTextField tfNacionalidad = new JTextField(50);
        p.add(tfNacionalidad);

        JLabel lDomicilio = new JLabel ("Domicilio:");
        p.add(lDomicilio);
        JTextField tfDomicilio = new JTextField(50);
        p.add(tfDomicilio);

        JButton bEnviar = new JButton ("Enviar");
        bEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(f, "Enviado correctamente", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
            }
        });
        p.add(bEnviar);

        f.add(p);
        f.setResizable(false);
        f.setBounds(0,0, 200, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
