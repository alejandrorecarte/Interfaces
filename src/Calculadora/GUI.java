package Calculadora;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    private static JFrame f;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int operacion;
    private final static int[] COLOR_PRINCIPAL = {188,152,243};
    private final static int[] COLOR_SECUNDARIO = {211,188,246};
    private final static int[] COLOR_SELECCION = {244,126,142};
    private final static int[] COLOR_TEXTFIELD = {244,208,213};

    private static Color colorPrincipal = new Color(COLOR_PRINCIPAL[0], COLOR_PRINCIPAL[1], COLOR_PRINCIPAL[2]);
    private static Color colorSecundario = new Color(COLOR_SECUNDARIO[0], COLOR_SECUNDARIO[1], COLOR_SECUNDARIO[2]);
    private static Color colorSeleccion = new Color(COLOR_SELECCION[0], COLOR_SELECCION[1], COLOR_SELECCION[2]);
    private static Color colorTextfield = new Color(COLOR_TEXTFIELD[0], COLOR_TEXTFIELD[1], COLOR_TEXTFIELD[2]);
    private static JButton bSuma;

    public static void principal(){

        JPanel p[] = new JPanel[6];
        operacion = 0;

        f = new JFrame("Calculadora");
        f.setUndecorated(true);

        //AJUSTES DEL JFRAME

        p[0] = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p[0].setBackground(colorPrincipal);

        //Label Título
        JLabel lTitulo = new JLabel("Calculadora    ");
        p[0].add(lTitulo);

        //Button Minimizar
        JButton bMinimizar = new JButton("_");
        bMinimizar.setBackground(colorSecundario);
        bMinimizar.setFocusPainted(false);
        bMinimizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setState(Frame.ICONIFIED);
            }
        });
        p[0].add(bMinimizar);

        //Button Cerrar
        JButton bCerrar = new JButton("X");
        bCerrar.setBackground(colorSecundario);
        bCerrar.setFocusPainted(false);
        bCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        p[0].add(bCerrar);

        //Movilidad Ventana
        final Point[] initialClick = {null};
        f.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick[0] = e.getPoint();
                f.getComponentAt(initialClick[0]);
            }
        });

        f.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int thisX = f.getLocation().x;
                int thisY = f.getLocation().y;

                int xMoved = thisX + e.getX() - initialClick[0].x;
                int yMoved = thisY + e.getY() - initialClick[0].y;

                f.setLocation(xMoved, yMoved);
            }
        });

        //AJUSTES DE LOS JPANELS

        p[1] = new JPanel(new FlowLayout());
        p[1].setBackground(colorPrincipal);

        //Label Operando1
        JLabel lOperando1 = new JLabel("Primer operando");
        p[1].add(lOperando1);

        //TextField Operando1
        JTextField tfOperando1 = new JTextField(16);
        tfOperando1.setBorder(new LineBorder(colorSecundario));
        tfOperando1.setBackground(colorTextfield);
        p[1].add(tfOperando1);

        p[2] = new JPanel(new FlowLayout());
        p[2].setBackground(colorPrincipal);

        //Button Suma
        bSuma = new JButton("+");
        bSuma.setBackground(colorSecundario);
        bSuma.setFocusPainted(false);
        p[2].add(bSuma);

        //Button Resta
        JButton bResta = new JButton("-");
        bResta.setBackground(colorSecundario);
        bResta.setFocusPainted(false);
        p[2].add(bResta);

        //Button Multiplica
        JButton bMulti = new JButton("x");
        bMulti.setBackground(colorSecundario);
        bMulti.setFocusPainted(false);
        p[2].add(bMulti);

        //Button Divide
        JButton bDivid = new JButton("/");
        bDivid.setBackground(colorSecundario);
        bDivid.setFocusPainted(false);
        p[2].add(bDivid);

        p[3] = new JPanel(new FlowLayout());

        //Label Operando2
        JLabel lOperando2 = new JLabel("Segundo operando");
        p[3].add(lOperando2);
        p[3].setBackground(colorPrincipal);

        //TextField Operando2
        JTextField tfOperando2 = new JTextField(16);
        tfOperando2.setBorder(new LineBorder(colorSecundario));
        tfOperando2.setBackground(colorTextfield);
        p[3].add(tfOperando2);

        p[4] = new JPanel(new FlowLayout());
        p[4].setBackground(colorPrincipal);

        //Button Calcular
        JButton bCalcular =  new JButton("¡CALCULAR!");
        bCalcular.setBackground(colorSecundario);
        bCalcular.setFocusPainted(false);
        p[4].add(bCalcular);

        //Button Answer
        JButton bAns =  new JButton("Ans");
        bAns.setBackground(colorSecundario);
        bAns.setFocusPainted(false);
        p[4].add(bAns);

        p[5] = new JPanel(new FlowLayout());
        p[5].setBackground(colorPrincipal);

        //Label Resultado
        JLabel jResultado = new JLabel("Resultado");
        p[5].add(jResultado);

        //TextField Resultado
        JTextField tfResultado = new JTextField(16);
        tfResultado.setBackground(colorTextfield);
        tfResultado.setEditable(false);
        p[5].add(tfResultado);

        f.setLayout(new GridLayout(6,1));

        for(int i = 0; i < p.length; i++){
            f.add(p[i], i);
        }

        f.setVisible(true);
        f.setBounds((screenSize.width/2-100),(screenSize.height/2-125),200,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        //FUNCIONALIDAD BOTONES
        
        bSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sumar();
            }
        });

        bResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //restar();
            }
        });

        bMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //multiplicar();
            }
        });

        bDivid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dividir();
            }
        });

        bCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double op1 = Double.parseDouble(tfOperando1.getText());
                    double op2 = Double.parseDouble(tfOperando2.getText());
                    tfResultado.setText(String.valueOf(Calc.calcular(operacion, op1, op2)));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bAns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOperando1.setText(tfResultado.getText());
            }
        });
    }
    /*public static void sumar() {
        bSuma.setBackground(colorSeleccion);
        bResta.setBackground(colorSecundario);
        bMulti.setBackground(colorSecundario);
        bDivid.setBackground(colorSecundario);
        operacion = 1;
    }

    public static void restar() {
        bSuma.setBackground(colorSecundario);
        bResta.setBackground(colorSeleccion);
        bMulti.setBackground(colorSecundario);
        bDivid.setBackground(colorSecundario);
        operacion = 2;
    }

    private static void multiplicar() {
        bSuma.setBackground(colorSecundario);
        bResta.setBackground(colorSecundario);
        bMulti.setBackground(colorSeleccion);
        bDivid.setBackground(colorSecundario);
        operacion = 3;
    }

    private static void dividir() {
        bSuma.setBackground(colorSecundario);
        bResta.setBackground(colorSecundario);
        bMulti.setBackground(colorSecundario);
        bDivid.setBackground(colorSeleccion);
        operacion = 4;
    }*/
}
