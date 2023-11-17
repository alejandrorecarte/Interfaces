package AltaUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AltaUsuario {

    private static ArrayList<Usuario> usuarios;

    public static void altaUsuario (){
        usuarios = new ArrayList<Usuario>();
        JFrame f = new JFrame("Alta Usuarios");
        JPanel p = new JPanel(new GridBagLayout());

        JLabel lId = new JLabel("ID:*");
        p.add(lId, new GridBagConstraints(0,0,1,1,0.25,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,10,3,3),0,0));

        JLabel lNombre = new JLabel("Nombre:*");
        p.add(lNombre, new GridBagConstraints(1,0,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,3,3,3),0,0));

        JLabel lApellidos = new JLabel("Apellidos:*");
        p.add(lApellidos, new GridBagConstraints(2,0,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,3, 3,3),0,0));

        JLabel lDni = new JLabel ("DNI:*");
        p.add(lDni, new GridBagConstraints(3,0,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,3, 3,3),0,0));

        JLabel lEmail = new JLabel("Email:*");
        p.add(lEmail, new GridBagConstraints(4,0,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,3, 3,3),0,0));

        JLabel lPassword = new JLabel ("Contraseña:");
        p.add(lPassword, new GridBagConstraints(5,0,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(10,3, 3,10),0,0));

        //========================================================================

        JTextField tfId = new JTextField();
        tfId.setEditable(false);
        p.add(tfId, new GridBagConstraints(0,1,1,1,0.25,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10, 3,3),0,0));

        JTextField tfNombre = new JTextField();
        tfNombre.setEditable(false);
        p.add(tfNombre, new GridBagConstraints(1,1,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,3),0,0));

        JTextField tfApellidos = new JTextField();
        tfApellidos.setEditable(false);
        p.add(tfApellidos, new GridBagConstraints(2,1,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,3),0,0));

        JTextField tfDni = new JTextField();
        tfDni.setEditable(false);
        p.add(tfDni, new GridBagConstraints(3,1,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,3),0,0));

        JTextField tfEmail = new JTextField();
        tfEmail.setEditable(false);
        p.add(tfEmail, new GridBagConstraints(4,1,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,3),0,0));

        JPasswordField pfPassword = new JPasswordField();
        pfPassword.setEditable(false);
        p.add(pfPassword, new GridBagConstraints(5,1,1,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,10),0,0));

        //================================================================================================

        JPanel pBotones = new JPanel(new GridBagLayout());
        JButton bNuevo = new JButton("Nuevo");
        pBotones.add(bNuevo, new GridBagConstraints(0,0,1,1,1.0,10.0,GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(3,10, 3,3),0,0));

        JButton bAnyadir = new JButton("Añadir");
        bAnyadir.setEnabled(false);
        pBotones.add(bAnyadir, new GridBagConstraints(1,0,1,1,1.0,10.0,GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(3,3, 3,3),0,0));

        JButton bModificar = new JButton("Modificar");
        bModificar.setEnabled(false);
        pBotones.add(bModificar, new GridBagConstraints(2,0,1,1,1.0,10.0,GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(3,3, 3,3),0,0));

        JButton bEliminar = new JButton("Eliminar");
        bEliminar.setEnabled(false);
        pBotones.add(bEliminar, new GridBagConstraints(3,0,1,1,1.0,10.0,GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(3,3, 3,10),0,0));

        p.add(pBotones, new GridBagConstraints(0,2,6,1,1.0,1.0,GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3, 3,3),0,0));

        //================================================================================================

        JTable t = new JTable(new UsuariosTableModel(usuarios));
        actualizarTabla(t, usuarios);
        JScrollPane sp = new JScrollPane(t);
        p.add(sp, new GridBagConstraints(0,3,6,1,1.0,10.0,GridBagConstraints.EAST, GridBagConstraints.BOTH,
                new Insets(3,10, 10,10),0,0));

        //================================================================================================

        f.add(p);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setBounds(0,0,1000,300);
        f.setVisible(true);

        //================================================================================================

        bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId.setText(String.valueOf(getPrimerIdDisponible(usuarios)));
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDni.setText("");
                tfEmail.setText("");
                pfPassword.setText("");
                tfId.setEditable(true);
                tfNombre.setEditable(true);
                tfApellidos.setEditable(true);
                tfDni.setEditable(true);
                tfEmail.setEditable(true);
                pfPassword.setEditable(true);
                bAnyadir.setEnabled(true);
                bModificar.setEnabled(false);
                bEliminar.setEnabled(false);
            }
        });

        bAnyadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfNombre.getText().equals("") && !tfApellidos.getText().equals("") && !tfId.equals("") &&
                        !tfDni.equals("") && !tfEmail.equals("")) {

                    if(isIdUsado(usuarios, Integer.parseInt(tfId.getText())) == true) {
                        JOptionPane.showMessageDialog(f, "El ID ya está registro en la BBDD", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!validarDNI(tfDni.getText())){
                        JOptionPane.showMessageDialog(f, "El DNI no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".")){
                        JOptionPane.showMessageDialog(f, "El email no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    usuarios.add(new Usuario(Integer.parseInt(tfId.getText()),
                            tfNombre.getText(),
                            tfApellidos.getText(),
                            tfDni.getText(),
                            tfEmail.getText(),
                            pfPassword.getText()));
                    actualizarTabla(t, usuarios);
                    t.repaint();
                    t.revalidate();
                    tfId.setText("");
                    tfNombre.setText("");
                    tfApellidos.setText("");
                    tfDni.setText("");
                    tfEmail.setText("");
                    pfPassword.setText("");
                    tfId.setEditable(false);
                    tfNombre.setEditable(false);
                    tfApellidos.setEditable(false);
                    tfDni.setEditable(false);
                    tfEmail.setEditable(false);
                    pfPassword.setEditable(false);
                    bAnyadir.setEnabled(false);
                    bModificar.setEnabled(false);
                    JOptionPane.showConfirmDialog(f, "Se ha introducido al usuario correctamente", "Confirmación", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(f, "No se ha podido añadir el usuario porque no se han cumplimentado todos los campos.", "Error al añadir el usuario", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    t.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(t.getSelectedRow() != -1){
                Usuario usuario = usuarios.get(t.getSelectedRow());
                tfId.setEditable(true);
                tfNombre.setEditable(true);
                tfApellidos.setEditable(true);
                tfDni.setEditable(true);
                tfEmail.setEditable(true);
                pfPassword.setEditable(true);
                bAnyadir.setEnabled(true);
                bModificar.setEnabled(false);
                tfId.setText(String.valueOf(usuario.getId()));
                tfNombre.setText(usuario.getNombre());
                tfApellidos.setText(usuario.getApellidos());
                tfDni.setText(usuario.getDni());
                tfEmail.setText(usuario.getEmail());
                bModificar.setEnabled(true);
                bEliminar.setEnabled(true);
                bAnyadir.setEnabled(false);
            }
        }
    });

    bEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(f, "¿Seguro que desea eliminar al usuario seleccionado?", "Confirmación", JOptionPane.INFORMATION_MESSAGE) == 0){
                usuarios.remove(t.getSelectedRow());
                actualizarTabla(t, usuarios);
                t.revalidate();
                t.repaint();
                tfId.setText("");
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDni.setText("");
                tfEmail.setText("");
                pfPassword.setText("");
                tfId.setEditable(false);
                tfNombre.setEditable(false);
                tfApellidos.setEditable(false);
                tfDni.setEditable(false);
                tfEmail.setEditable(false);
                pfPassword.setEditable(false);
                bAnyadir.setEnabled(false);
                bModificar.setEnabled(false);
                bEliminar.setEnabled(false);
            }
        }
    });

    bModificar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(f, "¿Seguro que desea eliminar al usuario seleccionado?", "Confirmación", JOptionPane.INFORMATION_MESSAGE) == 0){
                Usuario usuario = usuarios.get(t.getSelectedRow());
                usuarios.remove(t.getSelectedRow());
                if(isIdUsado(usuarios, Integer.parseInt(tfId.getText())) == true) {
                    JOptionPane.showMessageDialog(f, "El ID ya está registro en la BBDD", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!validarDNI(tfDni.getText())){
                    JOptionPane.showMessageDialog(f, "El DNI no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".")){
                    JOptionPane.showMessageDialog(f, "El email no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                usuario.setId(Integer.parseInt(tfId.getText()));
                usuario.setNombre(tfNombre.getText());
                usuario.setApellidos(tfApellidos.getText());
                usuario.setDni(tfDni.getText());
                usuario.setEmail(tfEmail.getText());
                usuario.setPassword(pfPassword.getText());

                usuarios.add(usuario);
                actualizarTabla(t, usuarios);
                t.revalidate();
                t.repaint();
                tfId.setText("");
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDni.setText("");
                tfEmail.setText("");
                pfPassword.setText("");
                tfId.setEditable(false);
                tfNombre.setEditable(false);
                tfApellidos.setEditable(false);
                tfDni.setEditable(false);
                tfEmail.setEditable(false);
                pfPassword.setEditable(false);
                bAnyadir.setEnabled(false);
                bModificar.setEnabled(false);
                bEliminar.setEnabled(false);
            }
        }
    });
    }

    private static int getPrimerIdDisponible(ArrayList<Usuario> usuarios){
        int id = 1;
        boolean encontrado = false;

        for(int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() != (i+1) && encontrado == false){
                id = i+1;
                encontrado = true;
            }else if (encontrado == false) {
                id = usuarios.get(i).getId()+1;
            }
        }

        return id;
    }

    private static boolean isIdUsado(ArrayList<Usuario> usuarios, int id) {
        boolean usado = false;

        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == id) {
                usado = true;
            }
        }

        return usado;
    }

    public static boolean validarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        boolean valido = false;

        if (dni.length() == 9) {
            char letraCalculada = letras.charAt(Integer.parseInt(dni.substring(0, 8)) % 23);
            char letraDNI = Character.toUpperCase(dni.charAt(8));

            if (letraCalculada == letraDNI) {
                valido = true;
            }
        }

        return valido;
    }

    private static void actualizarTabla(JTable t, ArrayList<Usuario> usuarios){
        t.setModel(new UsuariosTableModel(usuarios));
        t.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
}
