package JList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JListBuilder {


    public static void main(String[] args) {
        JFrame f = new JFrame("JList");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(200,200,450,300);
        JPanel p = new JPanel(new GridBagLayout());

        JLabel lDisponibles = new JLabel("Disponibles:");
        p.add(lDisponibles, new GridBagConstraints(0,0, 1, 1, 5.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));

        JLabel lSeleccionados = new JLabel("Seleccionados:");
        p.add(lSeleccionados, new GridBagConstraints(2,0, 1, 1, 5.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,0,3,10), 0, 0));

        ArrayList<String> disponibles = new ArrayList<>();
        disponibles.add("strSubjectName");
        disponibles.add("strStandardName");
        disponibles.add("strReferenceBook");
        JList liDisponibles = new JList(disponibles.toArray());
        JScrollPane spDisponibles = new JScrollPane(liDisponibles);
        p.add(spDisponibles, new GridBagConstraints(0,1, 1, 4, 5.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,3,3,3), 0, 0));

        JButton bDerechaTodo = new JButton(">>");
        p.add(bDerechaTodo, new GridBagConstraints(1,1, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE,
                new Insets(3,3,3,3), 0, 0));

        JButton bDerecha = new JButton(">");
        p.add(bDerecha, new GridBagConstraints(1,2, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(3,3,10,3), 0, 0));

        JButton bIzquierda = new JButton("<");
        p.add(bIzquierda, new GridBagConstraints(1,3, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE,
                new Insets(10,3,3,3), 0, 0));

        JButton bIzquierdaTodo = new JButton("<<");
        p.add(bIzquierdaTodo, new GridBagConstraints(1,4, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(3,3,3,3), 0, 0));

        ArrayList<String> seleccionados = new ArrayList();
        JList liSeleccionados = new JList(seleccionados.toArray());
        JScrollPane spSeleccionados = new JScrollPane(liSeleccionados);
        p.add(spSeleccionados, new GridBagConstraints(2,1, 1, 4, 5.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,0,3,10), 0, 0));

        bDerechaTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionados.addAll(disponibles);
                disponibles.removeAll(disponibles);
                liSeleccionados.setListData(seleccionados.toArray());
                liDisponibles.setListData(disponibles.toArray());
                liSeleccionados.repaint();
                liDisponibles.repaint();
                liSeleccionados.revalidate();
                liDisponibles.revalidate();
            }
        });

        bIzquierdaTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disponibles.addAll(seleccionados);
                seleccionados.removeAll(seleccionados);
                liSeleccionados.setListData(seleccionados.toArray());
                liDisponibles.setListData(disponibles.toArray());
                liSeleccionados.repaint();
                liDisponibles.repaint();
                liSeleccionados.revalidate();
                liDisponibles.revalidate();
            }
        });

        bDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(liDisponibles.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(f, "Debes seleccionar un item", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }else {
                    seleccionados.add(disponibles.get(liDisponibles.getSelectedIndex()));
                    disponibles.remove(liDisponibles.getSelectedIndex());
                    liDisponibles.setListData(disponibles.toArray());
                    liSeleccionados.setListData(seleccionados.toArray());
                    liSeleccionados.repaint();
                    liDisponibles.repaint();
                    liSeleccionados.revalidate();
                    liDisponibles.revalidate();
                }
            }
        });

        bIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(liSeleccionados.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(f, "Debes seleccionar un item", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                }else {
                    disponibles.add(seleccionados.get(liSeleccionados.getSelectedIndex()));
                    seleccionados.remove(liSeleccionados.getSelectedIndex());
                    liSeleccionados.setListData(seleccionados.toArray());
                    liDisponibles.setListData(disponibles.toArray());
                    liSeleccionados.repaint();
                    liDisponibles.repaint();
                    liSeleccionados.revalidate();
                    liDisponibles.revalidate();
                }
            }
        });

        f.add(p);
        f.setVisible(true);
    }
}
