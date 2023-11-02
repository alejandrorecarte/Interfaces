package JTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        JPanel p = new JPanel(new FlowLayout());

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("000000001A", "Alejandro", "Recarte", 22));
        students.add(new Student("000000002B", "Inés", "Trigo", 24));
        students.add(new Student("000000003C", "Sergio", "Cervera", 21));

        JTable t = new JTable(new StudentTableModel(students));
        JScrollPane sp = new JScrollPane(t);

        p.add(sp);
        f.add(p);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setBounds(0,0,500,200);
        f.setVisible(true);
    }
}
