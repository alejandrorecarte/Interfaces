package MyJListWindow;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyJListWindow {
    public static void main(String[] args) {
        JFrame f = new JFrame("MyJListWindow");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(200,200,300,400);
        JPanel p = new JPanel(new GridBagLayout());

        JLabel lJList = new JLabel("JList");
        lJList.setBorder(new BevelBorder(1));
        lJList.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("Arial", Font.PLAIN, 40);
        lJList.setFont(font);
        p.add(lJList, new GridBagConstraints(0,0, 2, 1, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(25,40,25,40), 0, 0));

        JTextField tfAgregar = new JTextField(50);
        p.add(tfAgregar, new GridBagConstraints(0,1, 1, 1, 25, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5,10,5,3), 0, 0));

        JButton bAgregar = new JButton("Agregar");
        p.add(bAgregar, new GridBagConstraints(1,1, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(5,3,5,10), 0, 0));

        ArrayList items = new ArrayList();
        JList liItems = new JList(items.toArray());
        JScrollPane spLiItems = new JScrollPane(liItems);
        liItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        p.add(spLiItems,  new GridBagConstraints(0,2, 2, 1, 1, 15, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5,10,5,10), 0, 0));

        JButton bEliminar = new JButton("Eliminar");
        p.add(bEliminar, new GridBagConstraints(0,3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5,10,5,5), 0, 0));

        JButton bBorrarList = new JButton("Borrar Lista");
        p.add(bBorrarList, new GridBagConstraints(1,3, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5,5,5,10), 0, 0));

        JLabel lOutput = new JLabel();
        p.add(lOutput, new GridBagConstraints(0,4, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(20,10,20,10), 0, 0));

        lJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lJList.setForeground(Color.RED);
                lJList.repaint();
                lJList.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lJList.setForeground(Color.BLACK);
                lJList.repaint();
                lJList.revalidate();
            }
        });

        liItems.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lOutput.setText("Seleccionado ${"+ liItems.getSelectedValue() +"}");
                lOutput.repaint();
                lOutput.revalidate();
            }
        });

        bAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfAgregar.getText().equals("")){
                    items.add(tfAgregar.getText());
                    liItems.setListData(items.toArray());
                    liItems.repaint();
                    liItems.revalidate();
                    lOutput.setText("Se agregó un nuevo elemento");
                }
            }
        });

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!liItems.isSelectionEmpty()){
                    items.remove(liItems.getSelectedIndex());
                    liItems.setListData(items.toArray());
                    liItems.repaint();
                    liItems.revalidate();
                    lOutput.setText("Se ha eliminado un elemento");
                }
            }
        });

        bBorrarList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                items.removeAll(items);
                liItems.setListData(items.toArray());
                liItems.repaint();
                liItems.revalidate();
                lOutput.setText("Se ha eliminado toda la lista");
            }
        });

        f.add(p);
        f.setVisible(true);
    }
}
