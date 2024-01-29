package MultilenguajeAltaUsuarios.controllers;

import MultilenguajeAltaUsuarios.models.Usuario;
import MultilenguajeAltaUsuarios.views.UsuariosTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

import static BBDD.Conexion.conectar;

public class AltaUsuario {

    private JTextField tfId;
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JTextField tfDni;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JLabel lId;
    private JLabel lNombre;
    private JLabel lApellidos;
    private JLabel lDni;
    private JLabel lEmail;
    private JLabel lPassword;
    private JPanel p;
    private JButton bNuevo;
    private JButton bAnyadir;
    private JButton bModificar;
    private JButton bEliminar;
    private JScrollPane sp;
    private JTable tList;
    private static Connection conexion;
    private static ArrayList<Usuario> usuarios;

    public AltaUsuario() {
        tfId.setEditable(false);
        conexion = conectar("mydb","root", "admin");
        usuarios = new ArrayList<Usuario>();
        actualizarTabla(tList);
        bAnyadir.setEnabled(false);
        bModificar.setEnabled(false);
        bEliminar.setEnabled(false);
        bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId.setText("AUTO");
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDni.setText("");
                tfEmail.setText("");
                pfPassword.setText("");
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

                    if(!validarDNI(tfDni.getText())){
                        JOptionPane.showMessageDialog(p, "El DNI no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".")){
                        JOptionPane.showMessageDialog(p, "El email no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try{
                        PreparedStatement ps = conexion.prepareStatement("INSERT INTO `mydb`.`users` (`username`, `surname`, `dni`, `email`, `password`) VALUES (?, ?, ?, ?,?);");
                        ps.setString(1, tfNombre.getText());
                        ps.setString(2, tfApellidos.getText());
                        ps.setString(3, tfDni.getText());
                        ps.setString(4, tfEmail.getText());
                        ps.setString(5, pfPassword.getText());
                        ps.executeUpdate();
                        actualizarTabla(tList);
                    }catch(SQLException ex){
                        System.out.println("No se pudo añadir el registro a la BBDD.");
                        ex.printStackTrace();
                    }

                    tList.repaint();
                    tList.revalidate();
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
                    JOptionPane.showConfirmDialog(p, "Se ha introducido al usuario correctamente", "Confirmación", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(p, "No se ha podido añadir el usuario porque no se han cumplimentado todos los campos.", "Error al añadir el usuario", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(p, "¿Seguro que desea eliminar al usuario seleccionado?", "Confirmación", JOptionPane.INFORMATION_MESSAGE) == 0){
                    Usuario usuario = usuarios.get(tList.getSelectedRow());
                    usuarios.remove(tList.getSelectedRow());

                    if(!validarDNI(tfDni.getText())){
                        JOptionPane.showMessageDialog(p, "El DNI no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".")){
                        JOptionPane.showMessageDialog(p, "El email no tiene un formato válido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try{
                        PreparedStatement ps = conexion.prepareStatement("UPDATE users SET username = ?, surname = ?, dni = ?, email = ?, password = ? WHERE id = ?");
                        ps.setString(1, tfNombre.getText());
                        ps.setString(2, tfApellidos.getText());
                        ps.setString(3, tfDni.getText());
                        ps.setString(4, tfEmail.getText());
                        ps.setString(5, pfPassword.getText());
                        ps.setInt(6, Integer.parseInt(tfId.getText()));
                        ps.executeUpdate();
                    }catch(SQLException ex){
                        System.out.println("No se ha podido actualizar el registro.");
                        ex.printStackTrace();
                    }

                    usuarios.add(usuario);
                    actualizarTabla(tList);
                    tList.revalidate();
                    tList.repaint();
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
        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(p, "¿Seguro que desea eliminar al usuario seleccionado?", "Confirmación", JOptionPane.INFORMATION_MESSAGE) == 0){
                    try{
                        PreparedStatement ps = conexion.prepareStatement("DELETE FROM users WHERE id = ?");
                        ps.setInt(1, (Integer) tList.getValueAt(tList.getSelectedRow(),0));
                        ps.execute();
                    }catch (SQLException ex){
                        System.out.println("No se pudo eliminar el registro especificado.");
                        ex.printStackTrace();
                    }
                    actualizarTabla(tList);
                    tList.revalidate();
                    tList.repaint();
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
        tList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(tList.getSelectedRow() != -1){
                    Usuario usuario = usuarios.get(tList.getSelectedRow());
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alta Usuario");
        frame.setContentPane(new AltaUsuario().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(0,0,1000,300);
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

    private static void actualizarTabla(JTable t){
        try {
            usuarios.removeAll(usuarios);
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuarios.add(new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            t.setModel(new UsuariosTableModel(usuarios));
            t.getColumnModel().getColumn(0).setPreferredWidth(0);
        }catch (SQLException e){
            System.out.println("No se ha podido obtener los datos de la BBDD.");
            e.printStackTrace();
        }
    }
}
