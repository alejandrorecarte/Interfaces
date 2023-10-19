package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Digitos extends GUI {

    private static JFrame f;
    private static JLabel lTitulo;

    /**
     * Metodo que abre una ventana complementaria a la GUI principal y que permite digitar en el TextField parametrizado
     *
     * @author Alejandro Recarte Rebollo
     * @param tf        TextField objetivo de la digitacion
     * @param titulo    Título del TextField
     * @param p         Panel receptor de los KeyListeners
     */

    public static void mostrarDigitos(JTextField tf, String titulo, JPanel p){

        f = new JFrame("Dígitos");
        f.setUndecorated(true);
        JPanel pDigitos = new JPanel(new GridBagLayout());
        pDigitos.setBackground(COLOR_PRINCIPAL);
        JButton[] bDigitos = new JButton[10];

        int num = 0;

        lTitulo = new JLabel(titulo);
        pDigitos.add(lTitulo, new GridBagConstraints(0,0, 3, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,3,3,3), 0, 0));

        bDigitos[num] = new JButton(String.valueOf(num));
        pDigitos.add(bDigitos[num], new GridBagConstraints(2,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,3,3,3), 0, 0));
        bDigitos[num].setBackground(COLOR_SECUNDARIO);
        bDigitos[num].setFocusPainted(false);

        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                num++;
                bDigitos[num] = new JButton(String.valueOf(num));
                pDigitos.add(bDigitos[num], new GridBagConstraints(j,i, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                        new Insets(3,3,3,3), 0, 0));
                bDigitos[num].setBackground(COLOR_SECUNDARIO);
                bDigitos[num].setFocusPainted(false);
            }
        }

        JButton bDelete = new JButton ("<");
        bDelete.setBackground(COLOR_SECUNDARIO);
        bDelete.setFocusPainted(false);
        pDigitos.add(bDelete, new GridBagConstraints(3,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,3,3,3), 0, 0));


        f.add(pDigitos);
        f.setBounds(GUI.getLocation().x + TAMANYO_VENTANA[0], GUI.getLocation().y + TAMANYO_VENTANA[1]/4,200,200);

        for(int i = 0; i < bDigitos.length; i++){
            int finalI = i;
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tf.setText(tf.getText() + String.valueOf(finalI));
                    p.requestFocus();
                }
            };
            bDigitos[i].addActionListener(al);
        }

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] digitos = tf.getText().split("");
                String[] digitosBorrado = new String[digitos.length-1];

                for(int i = 0; i < digitosBorrado.length; i++){
                    digitosBorrado[i] = digitos[i];
                }
                tf.setText(String.join("", digitosBorrado));
                p.requestFocus();
            }
        });

        f.setVisible(true);
    }

    /**
     * Metodo que permite cerrar la ventana complementaria
     *
     * @author Alejandro Recarte Rebollo
     */

    public static void ocultarDigitos(){
        try{
            f.setVisible(false);
        }catch(Exception e){}
        f = null;
    }

    /**
     * Funcion que devuelve si el frame de la venta complementaria es visible o no
     *
     * @author Alejandro Recarte Rebollo
     * @return  La visibilidad del frame
     */

    public static boolean isVisible(){
        boolean visible = false;

        if(f != null){
            visible = f.isVisible();
        }

        return visible;
    }

    /**
     * Devuelve el titulo del TextField receptor
     *
     * @author Alejandro Recarte Rebollo
     * @return  Titulo del TextField receptor
     */

    public static String getTitulo(){
        String titulo = new String("");

        if(f != null){
            titulo = lTitulo.getText();
        }
        return titulo;
    }

    /**
     * Metodo que permite establecer la localización de la ventana complementaria
     *
     * @author Alejandro Recarte Rebollo
     * @param x Coordenada x
     * @param y Coordenada y
     */

    public static void setLocation(int x, int y){
        if(f != null){
            f.setLocation(x, y);
        }
    }
}
