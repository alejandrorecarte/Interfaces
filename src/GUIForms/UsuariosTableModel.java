package GUIForms;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsuariosTableModel extends AbstractTableModel {
    private enum UsuariosTableColumns {

        Id("ID"),
        Nombre("Nombre"),
        Apellidos("Apellidos"),
        Dni("DNI"),
        Email("Email"),
        Contrasenya("Contraseña");

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
