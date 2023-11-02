package JTable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private enum UsuarioTableColumns {

        Nif("NIF"),
        Name("Nombre"),
        Surname("Apellidos"),
        Age("Edad");

        final String header;

        UsuarioTableColumns(String header){this.header = header;}

    }

    private List<Student> students;

    public StudentTableModel(List<Student> students){
        super();
        this.students = students;
    }


    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return UsuarioTableColumns.values().length;
    }

    @Override
    public String getColumnName (int column){
        return UsuarioTableColumns.values()[column].header;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (UsuarioTableColumns.values()[columnIndex]){
            case Name:
                return student.getName();
            case Surname:
                return student.getSurname();
            case Nif:
                return student.getNif();
            case Age:
                return student.getAge();
            default:
                throw new RuntimeException("No existe la columna " + columnIndex);
        }
    }

}
