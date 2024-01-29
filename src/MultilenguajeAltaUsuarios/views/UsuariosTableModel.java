package MultilenguajeAltaUsuarios.views;

import MultilenguajeAltaUsuarios.models.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class UsuariosTableModel extends AbstractTableModel {

    private enum UsuariosTableColumns {

        Id(ResourceBundle.getBundle("languages").getString("tId")),
        Nombre(ResourceBundle.getBundle("languages").getString("tNombre")),
        Apellidos(ResourceBundle.getBundle("languages").getString("tApellidos")),
        Dni(ResourceBundle.getBundle("languages").getString("tDNI")),
        Email(ResourceBundle.getBundle("languages").getString("tEmail")),
        Contrasenya(ResourceBundle.getBundle("languages").getString("tContrasenya"));

        final String header;

        UsuariosTableColumns(String header){this.header = header;}

    }

    private List<Usuario> usuarios;

    public UsuariosTableModel(ArrayList<Usuario> usuarios){
        super();
        usuarios.sort(Comparator.comparing(Usuario::getId));
        this.usuarios = usuarios;
    }


    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return UsuariosTableColumns.values().length;
    }

    @Override
    public String getColumnName (int column){
        return UsuariosTableColumns.values()[column].header;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch (UsuariosTableColumns.values()[columnIndex]){
            case Id:
                return usuario.getId();
            case Nombre:
                return usuario.getNombre();
            case Apellidos:
                return usuario.getApellidos();
            case Dni:
                return usuario.getDni();
            case Email:
                return usuario.getEmail();
            case Contrasenya:
                return usuario.getPassword();
            default:
                throw new RuntimeException("No existe la columna " + columnIndex);
        }
    }
}
