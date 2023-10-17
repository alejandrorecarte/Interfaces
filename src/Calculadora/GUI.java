package Calculadora;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;

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
    private static JButton bPotenciaCalc;
    private static JButton bRaizCalc;


    public static void principal() {
        operacion = 0;

        f = new JFrame("Calculadora");
        f.setUndecorated(true);
        f.setBackground(COLOR_PRINCIPAL);

        //AJUSTES DEL JFRAME

        JPanel pBotones = new JPanel(new GridBagLayout());
        pBotones.setBackground(COLOR_SECUNDARIO);

        //Label Título
        JLabel lTitulo = new JLabel("Calculadora");
        lTitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        pBotones.add(lTitulo, new GridBagConstraints(0,0, 1, 1, 15.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0,10,0,0), 0, 0));

        //Button Minimizar
        JButton bMinimizar = new JButton("_");
        bMinimizar.setBackground(COLOR_PRINCIPAL);
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
        bCerrar.setBackground(COLOR_PRINCIPAL);
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
        pSeleccion.setBorder(new LineBorder(COLOR_SECUNDARIO, 2));
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
        pCalculadora.setBorder(new LineBorder(COLOR_SECUNDARIO,2));
        pCalculadora.setFocusable(true);
        pCalculadora.setBackground(COLOR_PRINCIPAL);

        //Label Operando1
        JLabel lOperando1Calc = new JLabel("Primer operando");
        pCalculadora.add(lOperando1Calc, new GridBagConstraints(0,0, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));

        //TextField Operando1
        JTextField tfOperando1Calc = new JTextField(16);
        tfOperando1Calc.setBorder(new LineBorder(COLOR_SECUNDARIO));
        tfOperando1Calc.setBackground(COLOR_TEXTFIELD);
        pCalculadora.add(tfOperando1Calc, new GridBagConstraints(0,1, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
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
                new Insets(3,3,3,3), 0, 0));

        bPotenciaCalc = new JButton("^");
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setFocusPainted(false);
        pCalculadora.add(bPotenciaCalc,  new GridBagConstraints(4,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,3), 0, 0));

        bRaizCalc = new JButton ("√");
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setFocusPainted(false);
        pCalculadora.add(bRaizCalc,  new GridBagConstraints(5,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));


        //Label Operando2
        JLabel lOperando2Calc = new JLabel("Segundo operando");
        pCalculadora.add(lOperando2Calc,  new GridBagConstraints(0,3, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));
        pCalculadora.setBackground(COLOR_PRINCIPAL);

        //TextField Operando2
        JTextField tfOperando2Calc = new JTextField(16);
        tfOperando2Calc.setBorder(new LineBorder(COLOR_SECUNDARIO));
        tfOperando2Calc.setBackground(COLOR_TEXTFIELD);
        pCalculadora.add(tfOperando2Calc,  new GridBagConstraints(0,4, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));


        //Button Calcular
        JButton bCalcularCalc =  new JButton("¡CALCULAR!");
        bCalcularCalc.setBackground(COLOR_SECUNDARIO);
        bCalcularCalc.setFocusPainted(false);
        pCalculadora.add(bCalcularCalc,  new GridBagConstraints(0,5, 3, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,3), 0, 0));

        //Button Answer
        JButton bAnsCalc =  new JButton("Ans");
        bAnsCalc.setBackground(COLOR_SECUNDARIO);
        bAnsCalc.setFocusPainted(false);
        pCalculadora.add(bAnsCalc,  new GridBagConstraints(3,5, 3, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));

        //Label Resultado
        JLabel lResultadoCalc = new JLabel("Resultado");
        pCalculadora.add(lResultadoCalc,  new GridBagConstraints(0,6, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,0), 0, 0));

        //TextField Resultado
        JTextField tfResultadoCalc = new JTextField(16);
        tfResultadoCalc.setBackground(COLOR_TEXTFIELD);
        tfResultadoCalc.setEditable(false);
        pCalculadora.add(tfResultadoCalc,  new GridBagConstraints(0,7, 6, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //PANEL FACTORIZACION====================================================================================================================================

        JPanel pFactorizacion = new JPanel(new GridBagLayout());
        pFactorizacion.setBorder(new LineBorder(COLOR_SECUNDARIO,2));
        pFactorizacion.setBackground(COLOR_PRINCIPAL);

        //Label Operando
        JLabel lOperandoFact = new JLabel("Introduce el operando");
        pFactorizacion.add(lOperandoFact,  new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //TextField Operando
        JTextField tfOperandoFact = new JTextField();
        tfOperandoFact.setBackground(COLOR_TEXTFIELD);
        tfOperandoFact.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pFactorizacion.add(tfOperandoFact,  new GridBagConstraints(0,1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Button Calcular
        JButton bCalcularFact = new JButton("Calcular");
        bCalcularFact.setBackground(COLOR_SECUNDARIO);
        bCalcularFact.setFocusPainted(false);
        pFactorizacion.add(bCalcularFact,  new GridBagConstraints(0,2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Label Resultado
        JLabel lResultadoFact = new JLabel("Resultado");
        pFactorizacion.add(lResultadoFact,  new GridBagConstraints(0,3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Text Area Resultado
        JTextArea taResultadoFact = new JTextArea();
        JScrollPane spResultadoFact = new JScrollPane(taResultadoFact);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(COLOR_TEXTFIELD);
        scrollBar.setUI(new CustomScrollBarUI());
        scrollBar.setBorder(new LineBorder(COLOR_PRINCIPAL, 1));
        spResultadoFact.setVerticalScrollBar(scrollBar);
        taResultadoFact.setFont(new Font("Courier New", Font.BOLD, 16));
        taResultadoFact.setBackground(COLOR_TEXTFIELD);
        taResultadoFact.setEditable(false);
        taResultadoFact.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pFactorizacion.add(spResultadoFact,  new GridBagConstraints(0,4, 1, 1, 1.0, 15.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,10,10,10), 0, 0));

        pFactorizacion.setVisible(false);

        //PANEL MCM Y MCD===========================================================================================================================================

        JPanel pMCMMCD = new JPanel(new GridBagLayout());
        pMCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO, 2));
        pMCMMCD.setBackground(COLOR_PRINCIPAL);

        //Label Operando1
        JLabel lOperando1MCMMCD = new JLabel("Primer operando");
        pMCMMCD.add(lOperando1MCMMCD,  new GridBagConstraints(0,0, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
                new Insets(3,10,3,10), 0, 0));

        //TextField Operando1
        JTextField tfOperando1MCMMCD = new JTextField();
        tfOperando1MCMMCD.setBackground(COLOR_TEXTFIELD);
        tfOperando1MCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pMCMMCD.add(tfOperando1MCMMCD,  new GridBagConstraints(0,1, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Label Operando2
        JLabel lOperando2MCMMCD = new JLabel("Segundo operando");
        pMCMMCD.add(lOperando2MCMMCD,  new GridBagConstraints(0,2, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //TextField Operando2
        JTextField tfOperando2MCMMCD = new JTextField();
        tfOperando2MCMMCD.setBackground(COLOR_TEXTFIELD);
        tfOperando2MCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        pMCMMCD.add(tfOperando2MCMMCD,  new GridBagConstraints(0,3, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //Button MCM
        JButton bMCM = new JButton("MCM");
        bMCM.setBackground(COLOR_SECUNDARIO);
        bMCM.setFocusPainted(false);
        pMCMMCD.add(bMCM,  new GridBagConstraints(0,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,3), 0, 0));

        //Button MCD
        JButton bMCD = new JButton("MCD");
        bMCD.setBackground(COLOR_SECUNDARIO);
        bMCD.setFocusPainted(false);
        pMCMMCD.add(bMCD,  new GridBagConstraints(1,4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,3,3,10), 0, 0));

        //Label Resultado
        JLabel lResultadoMCMMCD = new JLabel("Resultado");
        pMCMMCD.add(lResultadoMCMMCD,  new GridBagConstraints(0,5, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(3,10,3,10), 0, 0));

        //TextField Resultado
        JTextField tfResultadoMCMMCD = new JTextField();
        tfResultadoMCMMCD.setBackground(COLOR_TEXTFIELD);
        tfResultadoMCMMCD.setBorder(new LineBorder(COLOR_SECUNDARIO));
        tfResultadoMCMMCD.setEditable(false);
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

        //FUNCIONALIDADES===========================================================================================================================================

        //Botones de selección

        //Botón Calculadora
        bCalculadoraSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pFactorizacion.setVisible(false);
                pMCMMCD.setVisible(false);
                pCalculadora.setVisible(true);
                pCalculadora.requestFocus();
            }
        });

        //Botón Factorización
        bFactorizacionSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCalculadora.setVisible(false);
                pFactorizacion.setVisible(true);
                pMCMMCD.setVisible(false);
                pFactorizacion.requestFocus();
            }
        });

        //Botón MCMMCD
        bMCMMCDSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCalculadora.setVisible(false);
                pFactorizacion.setVisible(false);
                pMCMMCD.setVisible(true);
                pMCMMCD.requestFocus();
            }
        });
        
        //Calculadora

        //ActionListeners
        //Botón Suma
        bSumaCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumar();
            }
        });

        //Botón Resta
        bRestaCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restar();
            }
        });

        //Botón Multiplicación
        bMultiCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplicar();
            }
        });

        //Botón División
        bDividCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dividir();
            }
        });

        //Botón Potencia
        bPotenciaCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                potencia();
            }
        });

        //Botón Raíz
        bRaizCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raiz();
            }
        });

        //Botón Calcular
        bCalcularCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                }            }
        });

        //Botón Ans
        bAnsCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOperando1Calc.setText(tfResultadoCalc.getText());
            }
        });

        //KeyListeners

        //KeyAdapter Común
        KeyAdapter keyAdapterCalc = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == '+'){
                    sumar();
                }

                if(e.getKeyChar() == '-'){
                    restar();
                }

                if(e.getKeyChar() == '*'){
                    multiplicar();
                }

                if(e.getKeyChar() == '/'){
                    dividir();
                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        tfResultadoCalc.setText(String.valueOf(Calc.calcular(operacion, Double.parseDouble(tfOperando1Calc.getText()), Double.parseDouble(tfOperando1Calc.getText()))));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(f, ex.getMessage(), "Error al hacer el cálculo", JOptionPane.ERROR_MESSAGE);
                    }                }
            }
        };

        //Panel
        pCalculadora.addKeyListener(keyAdapterCalc);

        //Botónes
        bSumaCalc.addKeyListener(keyAdapterCalc);
        bRestaCalc.addKeyListener(keyAdapterCalc);
        bMultiCalc.addKeyListener(keyAdapterCalc);
        bDividCalc.addKeyListener(keyAdapterCalc);

        //Factorización

        //ActionListener
        //Calcular
        bCalcularFact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taResultadoFact.setText(Calc.factorizar(Integer.parseInt(tfOperandoFact.getText())));
            }
        });

        //KeyListener

        //KeyAdapter Común
        KeyAdapter keyAdapterFact = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    taResultadoFact.setText(Calc.factorizar(Integer.parseInt(tfOperandoFact.getText())));
                }
            }
        };

        //Panel
        pFactorizacion.addKeyListener(keyAdapterFact);

        //TextField Operando
        tfOperandoFact.addKeyListener(keyAdapterFact);

        //MCM y MCD

        //ActionListener
        //MCM
        bMCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bMCM.setBackground(COLOR_SELECCION);
                bMCD.setBackground(COLOR_SECUNDARIO);
                try {
                    tfResultadoMCMMCD.setText(String.valueOf(Calc.mcm(Integer.parseInt(tfOperando1MCMMCD.getText()), Integer.parseInt(tfOperando2MCMMCD.getText()))));
                }catch (Exception ex){}
            }
        });

        //MCD
        bMCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bMCM.setBackground(COLOR_SECUNDARIO);
                bMCD.setBackground(COLOR_SELECCION);
                try {
                    tfResultadoMCMMCD.setText(String.valueOf(Calc.mcd(Integer.parseInt(tfOperando1MCMMCD.getText()), Integer.parseInt(tfOperando2MCMMCD.getText()))));
                }catch (Exception ex){}
            }
        });

        //KeyListener

        //KeyAdapter Común
        KeyAdapter keyAdapterMCMMCD = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    bMCM.setBackground(COLOR_SELECCION);
                    bMCD.setBackground(COLOR_SECUNDARIO);
                    try {
                        tfResultadoMCMMCD.setText(String.valueOf(Calc.mcm(Integer.parseInt(tfOperando1MCMMCD.getText()), Integer.parseInt(tfOperando2MCMMCD.getText()))));
                    } catch (Exception ex){
                    }
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    bMCM.setBackground(COLOR_SECUNDARIO);
                    bMCD.setBackground(COLOR_SELECCION);
                    try{
                    tfResultadoMCMMCD.setText(String.valueOf(Calc.mcd(Integer.parseInt(tfOperando1MCMMCD.getText()), Integer.parseInt(tfOperando2MCMMCD.getText()))));
                    } catch (Exception ex){
                    }
                }
            }
        };

        //Panel
        pMCMMCD.addKeyListener(keyAdapterMCMMCD);

        //Boton MCM
        bMCM.addKeyListener(keyAdapterMCMMCD);

        //Boton MCD
        bMCD.addKeyListener(keyAdapterMCMMCD);

        //Solicitamos focus para cuando inicie el programa sobre el panel Calculadora
        pCalculadora.requestFocus();
    }

    //METODOS AUXILIARES==========================================================================================================================================

    //Sumar
    public static void sumar() {
        bSumaCalc.setBackground(COLOR_SELECCION);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 1;
    }

    //Restar
    public static void restar() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SELECCION);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 2;
    }

    //Multiplicar
    private static void multiplicar() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SELECCION);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 3;
    }

    //Dividir
    private static void dividir() {
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SELECCION);
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 4;
    }

    private static void potencia(){
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setBackground(COLOR_SELECCION);
        bRaizCalc.setBackground(COLOR_SECUNDARIO);
        operacion = 5;
    }

    private static void raiz(){
        bSumaCalc.setBackground(COLOR_SECUNDARIO);
        bRestaCalc.setBackground(COLOR_SECUNDARIO);
        bMultiCalc.setBackground(COLOR_SECUNDARIO);
        bDividCalc.setBackground(COLOR_SECUNDARIO);
        bPotenciaCalc.setBackground(COLOR_SECUNDARIO);
        bRaizCalc.setBackground(COLOR_SELECCION);
        operacion = 6;
    }

    //Calcular

    private static double calcular(double op1, double op2){
        return Calc.calcular(operacion, op1, op2);
    }

    //CLASES AUXILIARES===========================================================================================================================================

    //Custom ScrollBar
    static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = COLOR_SECUNDARIO; // Cambia el color del thumb del scrollbar aquí
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            Dimension zeroDim = new Dimension(0, 0);
            button.setPreferredSize(zeroDim);
            button.setMinimumSize(zeroDim);
            button.setMaximumSize(zeroDim);
            return button;
        }
    }

}
