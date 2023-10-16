package Calculadora;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    private static JFrame f;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int[] TAMANYO_VENTANA = {400, 400};
    private static int operacion;
    private final static int[] COD_PRINCIPAL = {188,152,243};
    private final static int[] COD_SECUNDARIO = {211,188,246};
    private final static int[] COD_SELECCION = {244,126,142};
    private final static int[] COD_TEXTFIELD = {244,208,213};

    private final static Color COLOR_PRINCIPAL = new Color(COD_PRINCIPAL[0], COD_PRINCIPAL[1], COD_PRINCIPAL[2]);
    private final static Color COLOR_SECUNDARIO = new Color(COD_SECUNDARIO[0], COD_SECUNDARIO[1], COD_SECUNDARIO[2]);
    private final static Color COLOR_SELECCION = new Color(COD_SELECCION[0], COD_SELECCION[1], COD_SELECCION[2]);
    private final static Color COLOR_TEXTFIELD = new Color(COD_TEXTFIELD[0], COD_TEXTFIELD[1], COD_TEXTFIELD[2]);
    private static JButton bSumaCalc;
    private static JButton bRestaCalc;
    private static JButton bMultiCalc;
    private static JButton bDividCalc;


    public static void principal() {
        operacion = 0;

        f = new JFrame("Calculadora");
        f.setUndecorated(true);
        f.setBackground(COLOR_PRINCIPAL);

        //AJUSTES DEL JFRAME

        JPanel pBotones = new JPanel(new GridBagLayout());
        pBotones.setBackground(COLOR_PRINCIPAL);

        //Label Título
        JLabel lTitulo = new JLabel("Calculadora");
        pBotones.add(lTitulo, new GridBagConstraints(0,0, 1, 1, 15.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0,10,0,0), 0, 0));

        //Button Minimizar
        JButton bMinimizar = new JButton("_");
        bMinimizar.setBackground(COLOR_SECUNDARIO);
        bMinimizar.setFocusPainted(false);
        bMinimizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setState(Frame.ICONIFIED);
            }
        });
        pBotones.add(bMinimizar, new GridBagConstraints(1,0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0), 0, 0));

        //Button Cerrar
        JButton bCerrar = new JButton("X");
        bCerrar.setBackground(COLOR_SECUNDARIO);
        bCerrar.setFocusPainted(false);
        bCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pBotones.add(bCerrar, new GridBagConstraints(2,0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0), 0, 0));

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

        //PANEL SELECCION========================================================================================================================================

        JPanel pSeleccion = new JPanel(new FlowLayout());
        pSeleccion.setBackground(COLOR_PRINCIPAL);

        //Botones Selección
        JButton bCalculadoraSel = new JButton("Calculadora");
        bCalculadoraSel.setBackground(COLOR_SECUNDARIO);
        bCalculadoraSel.setFocusPainted(false);
        pSeleccion.add(bCalculadoraSel);

        JButton bFactorizacionSel = new JButton("Factorización");
        bFactorizacionSel.setBackground(COLOR_SECUNDARIO);
        bFactorizacionSel.setFocusPainted(false);
        pSeleccion.add(bFactorizacionSel);

        JButton bMCMMCDSel = new JButton("MCM y MCD");
        bMCMMCDSel.setBackground(COLOR_SECUNDARIO);
        bMCMMCDSel.setFocusPainted(false);
        pSeleccion.add(bMCMMCDSel);


        //PANEL CALCULADORA======================================================================================================================================

        JPanel pCalculadora = new JPanel(new GridBagLayout());
        pCalculadora.setBackground(COLOR_PRINCIPAL);

        //Label Operando1
        JLabel lOperando1 = new JLabel("Primer operando");
        pCalculadora.add(lOperando1, new GridBagConstraints(0,0, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));

        //TextField Operando1
        JTextField tfOperando1Calc = new JTextField(16);
        tfOperando1Calc.setBorder(new LineBorder(COLOR_SECUNDARIO));
        tfOperando1Calc.setBackground(COLOR_TEXTFIELD);
        pCalculadora.add(tfOperando1Calc, new GridBagConstraints(0,1, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Button Suma
        bSumaCalc = new JButton("+");
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bSumaCalc.setFocusPainted(false);
        pCalculadora.add(bSumaCalc,  new GridBagConstraints(0,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,3), 0, 0));

        //Button Resta
        bRestaCalc = new JButton("-");
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setFocusPainted(false);
        pCalculadora.add(bRestaCalc,  new GridBagConstraints(1,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,3), 0, 0));

        //Button Multiplica
        bMultiCalc = new JButton("x");
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setFocusPainted(false);
        pCalculadora.add(bMultiCalc,  new GridBagConstraints(2,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,3), 0, 0));

        //Button Divide
        bDividCalc = new JButton("/");
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setFocusPainted(false);
        pCalculadora.add(bDividCalc,  new GridBagConstraints(3,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));

        //Label Operando2
        JLabel lOperando2 = new JLabel("Segundo operando");
        pCalculadora.add(lOperando2,  new GridBagConstraints(0,3, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));
        pCalculadora.setBackground(COLOR_PRINCIPAL);

        //TextField Operando2
        JTextField tfOperando2Calc = new JTextField(16);
        tfOperando2Calc.setBorder(new LineBorder(COLOR_SECUNDARIO));
        tfOperando2Calc.setBackground(COLOR_TEXTFIELD);
        pCalculadora.add(tfOperando2Calc,  new GridBagConstraints(0,4, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));


        //Button Calcular
        JButton bCalcularCalc =  new JButton("¡CALCULAR!");
        bCalcularCalc.setBackground(COLOR_SECUNDARIO);
        bCalcularCalc.setFocusPainted(false);
        pCalculadora.add(bCalcularCalc,  new GridBagConstraints(0,5, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,3), 0, 0));

        //Button Answer
        JButton bAns =  new JButton("Ans");
        bAns.setBackground(COLOR_SECUNDARIO);
        bAns.setFocusPainted(false);
        pCalculadora.add(bAns,  new GridBagConstraints(2,5, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));

        //Label Resultado
        JLabel jResultado = new JLabel("Resultado");
        pCalculadora.add(jResultado,  new GridBagConstraints(0,6, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));

        //TextField Resultado
        JTextField tfResultadoCalc = new JTextField(16);
        tfResultadoCalc.setBackground(COLOR_TEXTFIELD);
        tfResultadoCalc.setEditable(false);
        pCalculadora.add(tfResultadoCalc,  new GridBagConstraints(0,7, 4, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //PANEL FACTORIZACION====================================================================================================================================

        JPanel pFactorizacion = new JPanel(new GridBagLayout());
        pFactorizacion.setBackground(COLOR_PRINCIPAL);

        JLabel lOperandoFact = new JLabel("Introduce el operando");
        pFactorizacion.add(lOperandoFact,  new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JTextField tfOperandoFact = new JTextField();
        tfOperandoFact.setBackground(COLOR_TEXTFIELD);
        tfOperandoFact.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pFactorizacion.add(tfOperandoFact,  new GridBagConstraints(0,1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JButton bCalcularFact = new JButton("Calcular");
        bCalcularFact.setBackground(COLOR_SECUNDARIO);
        bCalcularFact.setFocusPainted(false);
        pFactorizacion.add(bCalcularFact,  new GridBagConstraints(0,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JLabel lResultadoFact = new JLabel("Resultado");
        pFactorizacion.add(lResultadoFact,  new GridBagConstraints(0,3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JTextArea taResultadoFact = new JTextArea();
        JScrollPane spResultadoFact = new JScrollPane(taResultadoFact);
        taResultadoFact.setFont(new Font("Courier New", Font.BOLD, 16));
        taResultadoFact.setBackground(COLOR_TEXTFIELD);
        taResultadoFact.setEditable(false);
        taResultadoFact.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pFactorizacion.add(spResultadoFact,  new GridBagConstraints(0,4, 1, 1, 1.0, 15.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,10,10,10), 0, 0));

        pFactorizacion.setVisible(false);

        //PANEL MCM Y MCD

        JPanel pMCMMCD = new JPanel(new GridBagLayout());
        pMCMMCD.setBackground(COLOR_PRINCIPAL);

        JLabel lOperando1MCMMCD = new JLabel("Primer operando");
        pMCMMCD.add(lOperando1MCMMCD,  new GridBagConstraints(0,0, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,10,3,10), 0, 0));

        JTextField tfOperando1MCMMCD = new JTextField();
        tfOperando1MCMMCD.setBackground(COLOR_TEXTFIELD);
        tfOperando1MCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pMCMMCD.add(tfOperando1MCMMCD,  new GridBagConstraints(0,1, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JLabel lOperando2MCMMCD = new JLabel("Segundo operando");
        pMCMMCD.add(lOperando2MCMMCD,  new GridBagConstraints(0,2, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JTextField tfOperando2MCMMCD = new JTextField();
        tfOperando2MCMMCD.setBackground(COLOR_TEXTFIELD);
        tfOperando2MCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pMCMMCD.add(tfOperando2MCMMCD,  new GridBagConstraints(0,3, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JButton bMCM = new JButton("MCM");
        bMCM.setBackground(COLOR_SECUNDARIO);
        bMCM.setFocusPainted(false);
        pMCMMCD.add(bMCM,  new GridBagConstraints(0,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,3), 0, 0));

        JButton bMCD = new JButton("MCD");
        bMCD.setBackground(COLOR_SECUNDARIO);
        bMCD.setFocusPainted(false);
        pMCMMCD.add(bMCD,  new GridBagConstraints(1,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));

        JLabel lResultadoMCMMCD = new JLabel("Resultado");
        pMCMMCD.add(lResultadoMCMMCD,  new GridBagConstraints(0,5, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        JTextField tfResultadoMCMMCD = new JTextField();
        tfResultadoMCMMCD.setBackground(COLOR_TEXTFIELD);
        tfResultadoMCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pMCMMCD.add(tfResultadoMCMMCD,  new GridBagConstraints(0,6, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,10,10), 0, 0));

        pMCMMCD.setVisible(false);

        //AÑADIR PANELES=========================================================================================================================================

        f.setLayout(new GridBagLayout());

        f.add(pBotones,  new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(0,0,0,0), 0, 0));
        f.add(pSeleccion,  new GridBagConstraints(0,1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(0,0,0,0), 0, 0));
        f.add(pCalculadora,  new GridBagConstraints(0,2, 1, 1, 1.0, 20.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(0,0,0,0), 0, 0));
        f.add(pFactorizacion,  new GridBagConstraints(0,2, 1, 1, 1.0, 20.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(0,0,0,0), 0, 0));
        f.add(pMCMMCD,  new GridBagConstraints(0,2, 1, 1, 1.0, 20.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(0,0,0,0), 0, 0));

        f.setVisible(true);
        f.setFocusable(true);
        f.setBounds((screenSize.width/2-TAMANYO_VENTANA[0]/2),(screenSize.height/2-TAMANYO_VENTANA[1]/2),TAMANYO_VENTANA[0],TAMANYO_VENTANA[1]);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        //FUNCIONALIDAD BOTONES

        bCalculadoraSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCalculadora.setVisible(true);
                pFactorizacion.setVisible(false);
                pMCMMCD.setVisible(false);
            }
        });
        bFactorizacionSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCalculadora.setVisible(false);
                pFactorizacion.setVisible(true);
                pMCMMCD.setVisible(false);
            }
        });

        bMCMMCDSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCalculadora.setVisible(false);
                pFactorizacion.setVisible(false);
                pMCMMCD.setVisible(true);
            }
        });
        
        bSumaCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumar();
            }
        });

        bRestaCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restar();
            }
        });

        bMultiCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplicar();
            }
        });

        bDividCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dividir();
            }
        });

        bCalcularCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                }            }
        });

        bAns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOperando1Calc.setText(tfResultadoCalc.getText());
            }
        });

        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_PLUS){
                    sumar();
                }

                if(e.getKeyCode() == KeyEvent.VK_SUBTRACT){
                    restar();
                }

                if(e.getKeyCode() == KeyEvent.VK_MULTIPLY){
                    multiplicar();
                }

                if(e.getKeyCode() == KeyEvent.VK_DIVIDE){
                    dividir();
                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tfOperando1Calc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sumar();
                }

                if(e.getKeyCode() == KeyEvent.VK_SUBTRACT){
                    restar();
                }

                if(e.getKeyCode() == KeyEvent.VK_MULTIPLY){
                    multiplicar();
                }

                if(e.getKeyCode() == KeyEvent.VK_DIVIDE){
                    dividir();
                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                    }                }
            }
        });

        tfOperando2Calc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 107){
                    System.out.println("HOLI");
                    sumar();
                }

                if(e.getKeyCode() == KeyEvent.VK_SUBTRACT){
                    restar();
                }

                if(e.getKeyCode() == KeyEvent.VK_MULTIPLY){
                    multiplicar();
                }

                if(e.getKeyCode() == KeyEvent.VK_DIVIDE){
                    dividir();
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                    }                }
            }
        });

        bCalcularFact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taResultadoFact.setText(Calc.factorizar(Integer.parseInt(tfOperandoFact.getText())));
            }
        });

        bMCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bMCM.setBackground(COLOR_SELECCION);
                bMCD.setBackground(COLOR_SECUNDARIO);
            }
        });

        bMCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bMCM.setBackground(COLOR_SECUNDARIO);
                bMCD.setBackground(COLOR_SELECCION);
            }
        });

    }
    public static void sumar() {
        bSumaCalc.setBackground(COLOR_SELECCION);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 1;
    }

    public static void restar() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SELECCION);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 2;
    }

    private static void multiplicar() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SELECCION);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 3;
    }

    private static void dividir() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SELECCION);
        operacion = 4;
    }

    private static double calcular(double op1, double op2){
        return Calc.calcular(operacion, op1, op2);
    }



}
