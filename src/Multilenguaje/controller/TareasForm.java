package Multilenguaje.controller;

import Multilenguaje.model.Tarea;
import Multilenguaje.view.TareasTableModel;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class TareasForm {
    ;
    private JLabel lNombre;
    private JLabel lDescripcion;
    private JLabel lFecha;
    private JLabel lHora;
    private JLabel lRealizada;
    private JLabel lPrioridad;
    private JTextField tfNombre;
    private JTextField tfDescripcion;
    private JTextField tfHora;
    private JComboBox cbRealizada;
    private JComboBox cbPrioridad;
    private JPanel p;
    private JButton bAnyadir;
    private JButton bModificar;
    private JButton bEliminar;
    private JScrollPane sp;
    private JTable tList;
    private JPanel panelBotones;
    private JButton bAyuda;
    private JLabel lFiltrar;
    private JComboBox cbFiltrar;
    private JButton bCambiarEstado;
    private JButton bDeseleccionar;
    private JButton bSeleccionarFecha;
    private JLabel lColon;
    private JTextField tfMinuto;
    private JLabel lColon2;
    private JTextField tfSegundo;
    private JLabel lIdioma;
    private JComboBox cbIdioma;
    private JButton bBuscar;
    private static ArrayList<Tarea> tareas;
    private static JFrame frame;
    private Date fecha = new Date();
    public Properties propiedades;

    public TareasForm() {
        detectarIdioma();
        try{
            tareas = Streams.importarTareas("src/Multilenguaje/model/data/ArrayListTarea");
        }catch(Exception e){
            JOptionPane.showConfirmDialog(frame, propiedades.getProperty("errorTextImportar"), propiedades.getProperty("mensajeError"), JOptionPane.WARNING_MESSAGE);
            tareas = new ArrayList<Tarea>();
            e.printStackTrace();
        }

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(frame, propiedades.getProperty("confirmacionTextSalir"), propiedades.getProperty("mensajeConfirmacion"), JOptionPane.INFORMATION_MESSAGE) == 0){
                    try {
                        Streams.exportarTareas(tareas);
                    } catch (IOException ex) {
                        JOptionPane.showConfirmDialog(frame, propiedades.getProperty("errorTextExportar"), propiedades.getProperty("mensajeError"), JOptionPane.WARNING_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        actualizarTabla(tList, tareas);
        bAnyadir.setEnabled(true);
        bModificar.setEnabled(false);
        bEliminar.setEnabled(false);
        bCambiarEstado.setEnabled(false);
        bDeseleccionar.setEnabled(false);
        tfHora.setColumns(2);
        tfMinuto.setColumns(2);
        tfSegundo.setColumns(2);
        TableRowSorter<TareasTableModel> sorter = new TableRowSorter<>(new TareasTableModel(tareas, propiedades));
        ArrayList list = new ArrayList();
        list.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(list);
        sorter.sort();
        tList.setRowSorter(sorter);

        bAnyadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNombre.getText().equals("") || fecha == null || tfHora.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, propiedades.getProperty("errorText"), propiedades.getProperty("mensajeError"), JOptionPane.INFORMATION_MESSAGE);
                } else {
                    fecha.setHours(Integer.parseInt(tfHora.getText()));
                    fecha.setMinutes(Integer.parseInt(tfMinuto.getText()));
                    fecha.setSeconds(Integer.parseInt(tfSegundo.getText()));
                    tareas.add(new Tarea(tfNombre.getText(),
                            fecha,
                            tfDescripcion.getText(),
                            (String) cbRealizada.getSelectedItem(),
                            Integer.parseInt((String) cbPrioridad.getSelectedItem())));
                    actualizarTabla(tList, tareas);
                    tList.repaint();
                    tList.revalidate();
                    tfNombre.setText("");
                    tfDescripcion.setText("");
                    fecha = null;
                    bSeleccionarFecha.setText(propiedades.getProperty("bSeleccionarFecha"));
                    tfHora.setText("");
                    tfMinuto.setText("");
                    tfSegundo.setText("");
                    cbRealizada.setSelectedIndex(0);
                    cbPrioridad.setSelectedIndex(0);
                    bAnyadir.setEnabled(true);
                    bModificar.setEnabled(false);
                    bCambiarEstado.setEnabled(false);
                    JOptionPane.showConfirmDialog(frame, propiedades.getProperty("confirmacionTextUsuarioCreado"), propiedades.getProperty("mensajeConfirmacion"), JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        bSeleccionarFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameFecha = new JFrame(propiedades.getProperty("seleccionarFecha"));
                JPanel pFecha = new JPanel();
                JCalendar calendar = new JCalendar();
                if(fecha != null) {
                    calendar.setDate(fecha);
                }
                JButton bAceptar = new JButton(propiedades.getProperty("aceptar"));

                frameFecha.add(pFecha);
                pFecha.add(calendar);
                pFecha.add(bAceptar);

                frameFecha.setVisible(true);
                frameFecha.setBounds(bSeleccionarFecha.getX() ,bSeleccionarFecha.getY(),250,250);

                bAceptar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fecha = calendar.getDate();
                        frameFecha.dispose();
                        bSeleccionarFecha.setText(fecha.getDate() + " / " + fecha.getMonth() + " / 20" + (fecha.getYear()%100));
                    }
                });
            }
        });
        bDeseleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tList.repaint();
                tList.revalidate();
                tfNombre.setText("");
                tfDescripcion.setText("");
                fecha = null;
                bSeleccionarFecha.setText(propiedades.getProperty("bSeleccionarFecha"));
                tfHora.setText("");
                tfMinuto.setText("");
                tfSegundo.setText("");
                cbRealizada.setSelectedIndex(0);
                cbPrioridad.setSelectedIndex(0);
                bAnyadir.setEnabled(true);
                bModificar.setEnabled(false);
                bCambiarEstado.setEnabled(false);
                bDeseleccionar.setEnabled(false);
                bEliminar.setEnabled(false);
            }
        });
        tList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(tList.getSelectedRow() != -1){
                    Tarea tarea = tareas.get(tList.getSelectedRow());
                    tfNombre.setEditable(true);
                    tfDescripcion.setEditable(true);
                    tfHora.setEditable(true);
                    tfMinuto.setEditable(true);
                    tfSegundo.setEditable(true);
                    cbRealizada.setEnabled(true);
                    cbPrioridad.setEnabled(true);
                    bAnyadir.setEnabled(true);
                    bModificar.setEnabled(false);
                    tfNombre.setText(String.valueOf(tarea.getNombre()));
                    tfDescripcion.setText(tarea.getDescripcion());
                    fecha = tarea.getFecha();
                    bSeleccionarFecha.setText(fecha.getDate() + " / " + fecha.getMonth() + " / 20" + (fecha.getYear()%100));
                    tfHora.setText(String.valueOf(tarea.getFecha().getHours()));
                    tfMinuto.setText(String.valueOf(tarea.getFecha().getMinutes()));
                    tfSegundo.setText(String.valueOf(tarea.getFecha().getSeconds()));
                    cbPrioridad.setSelectedItem(String.valueOf(tarea.getPrioridad()));
                    if(tarea.getRealizada().equals(propiedades.getProperty("completado"))){
                        cbRealizada.setSelectedItem(propiedades.getProperty("completado"));
                    }else{
                        cbRealizada.setSelectedItem(propiedades.getProperty("pendiente"));
                    }
                    bModificar.setEnabled(true);
                    bEliminar.setEnabled(true);
                    bAnyadir.setEnabled(false);
                    bCambiarEstado.setEnabled(true);
                    bDeseleccionar.setEnabled(true);
                    bSeleccionarFecha.setEnabled(true);
                }
            }
        });

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(frame, propiedades.getProperty("confirmacionTextEliminar"), propiedades.getProperty("mensajeConfirmacion"), JOptionPane.INFORMATION_MESSAGE) == 0){
                    tareas.remove(tList.getSelectedRow());
                    actualizarTabla(tList, tareas);
                    tList.revalidate();
                    tList.repaint();
                    tfNombre.setText("");
                    tfDescripcion.setText("");
                    fecha = null;
                    bSeleccionarFecha.setText(propiedades.getProperty("bSeleccionarFecha"));
                    tfHora.setText("");
                    tfMinuto.setText("");
                    tfSegundo.setText("");
                    cbRealizada.setSelectedIndex(0);
                    cbPrioridad.setSelectedIndex(0);
                    tfNombre.setEditable(true);
                    tfDescripcion.setEditable(true);
                    bSeleccionarFecha.setEnabled(true);
                    tfHora.setEditable(true);
                    cbRealizada.setEnabled(true);
                    cbPrioridad.setEnabled(true);
                    bAnyadir.setEnabled(true);
                    bModificar.setEnabled(false);
                    bEliminar.setEnabled(false);
                    bCambiarEstado.setEnabled(false);
                    bDeseleccionar.setEnabled(false);
                }
            }
        });

        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNombre.getText().equals("") || fecha == null || tfHora.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, propiedades.getProperty("errorText"), propiedades.getProperty("mensajeError"), JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(frame, propiedades.getProperty("confirmacionTextModificar"), propiedades.getProperty("mensajeConfirmacion"), JOptionPane.INFORMATION_MESSAGE) == 0) {
                        Tarea tarea = tareas.get(tList.getSelectedRow());
                        tareas.remove(tList.getSelectedRow());
                        tarea.setNombre(tfNombre.getText());
                        tarea.setDescripcion(tfDescripcion.getText());
                        fecha.setHours(Integer.parseInt(tfHora.getText()));
                        fecha.setMinutes(Integer.parseInt(tfMinuto.getText()));
                        fecha.setSeconds(Integer.parseInt(tfSegundo.getText()));
                        tarea.setFecha(fecha);
                        tarea.setPrioridad(Integer.parseInt((String) cbPrioridad.getSelectedItem()));
                        if (cbRealizada.getSelectedItem().equals(propiedades.getProperty("completado"))) {
                            tarea.setRealizada(propiedades.getProperty("completado"));
                        } else {
                            tarea.setRealizada(propiedades.getProperty("pendiente"));
                        }

                        tareas.add(tarea);
                        actualizarTabla(tList, tareas);
                        tList.revalidate();
                        tList.repaint();
                        tfNombre.setText("");
                        tfDescripcion.setText("");
                        fecha = null;
                        bSeleccionarFecha.setText(propiedades.getProperty("bSeleccionarFecha"));
                        tfHora.setText("");
                        tfMinuto.setText("");
                        tfSegundo.setText("");
                        cbRealizada.setSelectedIndex(0);
                        cbPrioridad.setSelectedIndex(0);
                        tfNombre.setEditable(true);
                        tfDescripcion.setEditable(true);
                        bSeleccionarFecha.setEnabled(true);
                        tfHora.setEditable(true);
                        tfMinuto.setEditable(true);
                        tfSegundo.setEditable(true);
                        cbRealizada.setEnabled(true);
                        cbPrioridad.setEnabled(true);
                        bAnyadir.setEnabled(true);
                        bModificar.setEnabled(false);
                        bEliminar.setEnabled(false);
                        bCambiarEstado.setEnabled(false);
                        bDeseleccionar.setEnabled(false);
                    }
                }
            }
        });

        bAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, propiedades.getProperty("ayudaText"), propiedades.getProperty("informacion"), JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cbFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Tarea> tareasFiltradas = new ArrayList<Tarea>();
                        for (int i = 0; i < tareas.size(); i++) {
                            if (cbFiltrar.getSelectedItem().equals(propiedades.getProperty("todas"))) {
                                tareasFiltradas.add(tareas.get(i));
                            }
                            if (cbFiltrar.getSelectedItem().equals(propiedades.getProperty("pendientes")) && tareas.get(i).getRealizada().equals(propiedades.getProperty("pendiente"))) {
                                tareasFiltradas.add(tareas.get(i));
                            }
                            if (cbFiltrar.getSelectedItem().equals(propiedades.getProperty("completadas")) && tareas.get(i).getRealizada().equals(propiedades.getProperty("completado"))) {
                                tareasFiltradas.add(tareas.get(i));
                            }
                        }
                    actualizarTabla(tList, tareasFiltradas);

                }catch (Exception ex){}
                bAnyadir.setEnabled(true);
                bEliminar.setEnabled(false);
                bModificar.setEnabled(false);
                bCambiarEstado.setEnabled(false);
            }
        });

        bCambiarEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(frame, "¿Seguro que desea cambiar el estado de la tarea?", "Confirmación", JOptionPane.INFORMATION_MESSAGE) == 0){
                    if(tareas.get(tList.getSelectedRow()).getRealizada().equals("Pendiente")) {
                        tareas.get(tList.getSelectedRow()).setRealizada("Completado");
                    }else{
                        tareas.get(tList.getSelectedRow()).setRealizada("Pendiente");
                    }

                    actualizarTabla(tList, tareas);
                    tList.revalidate();
                    tList.repaint();
                    tfNombre.setText("");
                    tfDescripcion.setText("");
                    fecha = null;
                    bSeleccionarFecha.setText("Seleccionar");
                    tfHora.setText("");
                    tfMinuto.setText("");
                    tfSegundo.setText("");
                    cbRealizada.setSelectedIndex(0);
                    cbPrioridad.setSelectedIndex(0);
                    bAnyadir.setEnabled(true);
                    bModificar.setEnabled(false);
                    bEliminar.setEnabled(false);
                    bCambiarEstado.setEnabled(false);
                }
            }
        });

        cbIdioma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch((String) cbIdioma.getSelectedItem()){
                    case "Español": cambiarIdioma("languages_es_ES.properties"); break;
                    case "English": cambiarIdioma("languages_en_UK.properties"); break;
                    case "Italiano": cambiarIdioma("languages_it_IT.properties"); break;
                }
            }
        });
    }


    public static void GUI() {
        frame = new JFrame("Tareas");
        frame.setContentPane(new TareasForm().p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(0,0,1000,300);
    }


    private void actualizarTabla(JTable t, ArrayList<Tarea> tareas){
        if(tareas.size() > 0) {
            String[] columnNames = {propiedades.getProperty("tNombre"), propiedades.getProperty("tDescripcion"), propiedades.getProperty("tFecha"), propiedades.getProperty("tCompletado"), propiedades.getProperty("tPrioridad")};
            DefaultTableModel model = new DefaultTableModel(convertListTo2DArray(tareas), columnNames);
            t.setModel(model);
            t.getColumnModel().getColumn(0).setPreferredWidth(0);
        }
    }

    private void cambiarIdioma(String idioma){
        propiedades = Multilenguaje.controller.Propiedades.seleccionarIdioma(idioma);

        frame.setTitle(propiedades.getProperty("titulo"));
        lNombre.setText(propiedades.getProperty("lNombre"));
        lDescripcion.setText(propiedades.getProperty("lDescripcion"));
        lFecha.setText(propiedades.getProperty("lFecha"));
        lHora.setText(propiedades.getProperty("lHora"));
        lRealizada.setText(propiedades.getProperty("lRealizada"));
        lPrioridad.setText(propiedades.getProperty("lPrioridad"));
        bSeleccionarFecha.setText(propiedades.getProperty("bSeleccionarFecha"));
        bAnyadir.setText(propiedades.getProperty("bAnyadir"));
        bEliminar.setText(propiedades.getProperty("bEliminar"));
        bModificar.setText(propiedades.getProperty("bModificar"));
        bCambiarEstado.setText(propiedades.getProperty("bCambiarEstado"));
        bDeseleccionar.setText(propiedades.getProperty("bDeseleccionar"));
        lFiltrar.setText(propiedades.getProperty("lFiltrar"));
        lIdioma.setText(propiedades.getProperty("lIdioma"));
        bAyuda.setText(propiedades.getProperty("bAyuda"));

        cbRealizada.removeAllItems();
        cbRealizada.addItem(propiedades.getProperty("pendiente"));
        cbRealizada.addItem(propiedades.getProperty("completado"));

        cbFiltrar.removeAllItems();
        cbFiltrar.addItem(propiedades.getProperty("todas"));
        cbFiltrar.addItem(propiedades.getProperty("pendientes"));
        cbFiltrar.addItem(propiedades.getProperty("completadas"));

        try {
            actualizarTabla(tList, tareas);
        }catch(Exception e){}
    }

    private static Object[][] convertListTo2DArray(ArrayList<Tarea> list) {
        Object[][] array = new Object[list.size()][5];
        try {
            for (int i = 0; i < list.size(); i++) {
                array[i][0] = list.get(i).getNombre();
                array[i][1] = list.get(i).getDescripcion();
                array[i][2] = list.get(i).getFecha();
                array[i][3] = list.get(i).getRealizada();
                array[i][4] = list.get(i).getPrioridad();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            return array;
    }

    public void detectarIdioma(){
        switch(Locale.getDefault().getDisplayLanguage().toLowerCase()){
            case "español": cambiarIdioma("languages_es_ES.properties"); cbIdioma.setSelectedItem("Español"); break;
            case "english": cambiarIdioma("languages_en_EN.properties"); cbIdioma.setSelectedItem("English"); break;
            case "italiano": cambiarIdioma("languages_it_IT.properties"); cbIdioma.setSelectedItem("Italiano"); break;
        }
    }
}
