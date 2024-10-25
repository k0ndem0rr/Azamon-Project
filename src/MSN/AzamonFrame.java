package MSN;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import javax.swing.text.NumberFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class AzamonFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = -8877491224336005353L;
    private int nPaquetes;

    public AzamonFrame() {

        numForm = DecimalFormat.getInstance();
        numForm.setParseIntegerOnly(true);
        numForm.setGroupingUsed(false);
        nfor = new NumberFormatter(numForm);
        nfor.setAllowsInvalid(false);
        formSeed = new DefaultFormatterFactory(nfor, nfor, nfor);

        numForm = DecimalFormat.getNumberInstance();
        numForm.setParseIntegerOnly(false);
        ((DecimalFormat) numForm).applyPattern("#####.#######");
        ((DecimalFormat) numForm).setDecimalSeparatorAlwaysShown(true);
        numForm.setGroupingUsed(false);
        nfor = new NumberFormatter(numForm);
        nfor.setAllowsInvalid(false);
        formLambda = new DefaultFormatterFactory(nfor, nfor, nfor);

        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        HillClimbingL = new javax.swing.JLabel();
        AnnealingL = new javax.swing.JLabel();
        annealingTA = new java.awt.TextArea();
        hillClimbTA = new java.awt.TextArea();
        paquetesL = new java.awt.Label();
        ratioL = new java.awt.Label();
        ejecutarB = new javax.swing.JButton();
        PaquetesS = new javax.swing.JSlider();
        RatioS = new javax.swing.JSlider();
        SemillaL = new javax.swing.JLabel();
        SemillaTF = new javax.swing.JFormattedTextField(Integer.valueOf(100));
        AnnealingPL = new javax.swing.JLabel();
        NiterL = new javax.swing.JLabel();
        NiterS = new javax.swing.JSlider();
        LambdaL = new javax.swing.JLabel();
        ParKS = new javax.swing.JSlider();
        ParKL = new javax.swing.JLabel();
        LambdaFT = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        HeuristicL = new javax.swing.JLabel();
        SolutionL = new javax.swing.JLabel();
        HeuristicPrecioRadio = new javax.swing.JRadioButton();
        HeuristicFelicidadRadio = new javax.swing.JRadioButton();
        SolutionPrecioRadio = new javax.swing.JRadioButton();
        SolutionFelicidadRadio = new javax.swing.JRadioButton();
        HeuristicButtons = new javax.swing.ButtonGroup();
        SolutionButtons = new javax.swing.ButtonGroup();


        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Azamon Project by MSN");

        HillClimbingL.setText("Hill Climbing");

        AnnealingL.setText("Simulated Annealing");

        annealingTA.setColumns(40);
        annealingTA.setEditable(false);
        annealingTA.setRows(30);

        hillClimbTA.setColumns(37);
        hillClimbTA.setEditable(false);
        hillClimbTA.setName("hillClimbingTA");
        hillClimbTA.setRows(30);

        paquetesL.setText("Num paquetes:");

        ratioL.setText("Ratio:");

        ejecutarB.setText("Ejecutar Prob Aleatorio");
        ejecutarB.setActionCommand(" Ejecutar");
        ejecutarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ejecutarBMousePressed(evt);
            }
        });

        PaquetesS.setMajorTickSpacing(5);
        PaquetesS.setMaximum(40);
        PaquetesS.setMinimum(10);
        PaquetesS.setMinorTickSpacing(5);
        PaquetesS.setPaintLabels(true);
        PaquetesS.setPaintTicks(true);
        PaquetesS.setSnapToTicks(true);
        PaquetesS.setToolTipText("Elige el número de paquetes");
        PaquetesS.setValue(20);

        RatioS.setMajorTickSpacing(50);
        RatioS.setMaximum(150);
        RatioS.setMinimum(50);
        RatioS.setMinorTickSpacing(50);
        RatioS.setPaintLabels(true);
        RatioS.setPaintTicks(true);
        RatioS.setSnapToTicks(false);
        RatioS.setToolTipText("Elige el ratio");
        RatioS.setValue(100);

        HeuristicL.setText("Heurístico");
        SolutionL.setText("Solución Inicial");

        HeuristicPrecioRadio.setText("Precio");
        HeuristicPrecioRadio.setSelected(true);
        HeuristicFelicidadRadio.setText("Felicidad");
        SolutionPrecioRadio.setText("Precio");
        SolutionPrecioRadio.setSelected(true);
        SolutionFelicidadRadio.setText("Felicidad");

        HeuristicButtons.add(HeuristicPrecioRadio);
        HeuristicButtons.add(HeuristicFelicidadRadio);
        SolutionButtons.add(SolutionPrecioRadio);
        SolutionButtons.add(SolutionFelicidadRadio);

        SemillaL.setText("Semilla:");

        SemillaTF.setFormatterFactory(formSeed);
        SemillaTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        AnnealingPL.setText("Parametros Annealing");

        NiterL.setText("Num It:");

        NiterS.setMajorTickSpacing(1000);
        NiterS.setMaximum(10000);
        NiterS.setMinimum(0);
        NiterS.setMinorTickSpacing(1000);
        NiterS.setOrientation(javax.swing.JSlider.VERTICAL);
        NiterS.setPaintLabels(true);
        NiterS.setPaintTicks(true);
        NiterS.setSnapToTicks(false);
        NiterS.setToolTipText("Numero de iteraciones total");
        NiterS.setValue(2000);

        LambdaL.setText("Lambda");

        ParKS.setMajorTickSpacing(1);
        ParKS.setMaximum(20);
        ParKS.setMinimum(1);
        ParKS.setMinorTickSpacing(1);
        ParKS.setOrientation(javax.swing.JSlider.VERTICAL);
        ParKS.setPaintLabels(true);
        ParKS.setPaintTicks(true);
        ParKS.setSnapToTicks(true);
        ParKS.setToolTipText("Lambda");
        ParKS.setValue(5);

        ParKL.setText("K");

        LambdaFT.setFormatterFactory(formLambda);
        LambdaFT.setToolTipText("Parametro Lambda");
        LambdaFT.setValue(Double.valueOf(0.01));

        jMenu1.setText("Menu");

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/door_out.png")));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(paquetesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(PaquetesS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(ratioL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(RatioS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(HillClimbingL)
                                        .add(hillClimbTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(AnnealingL)
                                        .add(annealingTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(ParKL)
                                        .add(ParKS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(NiterL)
                                        .add(NiterS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(LambdaL)
                                        .add(LambdaFT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(HeuristicL)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(HeuristicPrecioRadio)
                                .add(HeuristicFelicidadRadio))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(SolutionL)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(SolutionPrecioRadio)
                                .add(SolutionFelicidadRadio))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(SemillaL)
                        .add(SemillaTF)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(ejecutarB)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                .add(PaquetesS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(paquetesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(RatioS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(ratioL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                .add(layout.createSequentialGroup()
                                        .add(HillClimbingL)
                                        .add(hillClimbTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                        .add(AnnealingL)
                                        .add(annealingTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                        .add(ParKL)
                                        .add(ParKS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE * 2,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE))
                                .add(layout.createSequentialGroup()
                                        .add(NiterL)
                                        .add(NiterS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                        .add(LambdaL)
                                        .add(LambdaFT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                .add(HeuristicL)
                                .add(layout.createSequentialGroup()
                                        .add(HeuristicPrecioRadio)
                                .add(HeuristicFelicidadRadio))
                                .add(SolutionL)
                                .add(layout.createSequentialGroup()
                                        .add(SolutionPrecioRadio)
                                        .add(SolutionFelicidadRadio))     
                                .add(SemillaL)
                                .add(SemillaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                .add(ejecutarB))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void ejecutarBMousePressed(java.awt.event.MouseEvent evt) {
        try {

            int sm = numForm.parse(SemillaTF.getText()).intValue();
            int ratio = RatioS.getValue()/100;
            int heuristic = HeuristicFelicidadRadio.isSelected() ? 1 : 0;
            boolean solutionAlt = SolutionFelicidadRadio.isSelected();
            nPaquetes = PaquetesS.getValue();
            hillClimbTA.setText("");
            annealingTA.setText("");
          
            AzamonState state = new AzamonState(nPaquetes, ratio, sm, heuristic, solutionAlt);
            HillClimbingMSN(state, hillClimbTA);
            SimulatedAnnealingMSN(state, annealingTA);
          
        } catch (ParseException e) {
        }
    }

    private void HillClimbingMSN(AzamonState state, java.awt.TextArea a) {
        try {
            Problem problem = new Problem(state, new AzamonSuccesorFunction(), new AzamonGoalTest(),
                    new AzamonHeuristicFunction());
            Search search = new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem, search);

            printActions(agent.getActions(), a);
            printInstrumentation(agent.getInstrumentation(), a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SimulatedAnnealingMSN(AzamonState state, java.awt.TextArea a) {
        try {
            Problem problem = new Problem(state, new AzamonSuccesorFunctionSA(), new AzamonGoalTest(),
                    new AzamonHeuristicFunction());
            Search search = new SimulatedAnnealingSearch(
                    NiterS.getValue(),
                    1000,
                    ParKS.getValue(),
                    numForm.parse(LambdaFT.getText()).doubleValue());
            SearchAgent agent = new SearchAgent(problem, search);

            printActions((List) agent.getActions(), a);
            printInstrumentation(agent.getInstrumentation(), a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printActions(List actions, java.awt.TextArea a) {
        for (int i = 0; i < actions.size(); i++) {
            String actionS = (String) actions.get(i).toString();
            a.append(actionS + "\n");
        }
    }

    private static void printInstrumentation(Properties properties, java.awt.TextArea a) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            a.append(key + " : " + property + "\n");
        }
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AzamonFrame().setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup HeuristicButtons;
    private javax.swing.ButtonGroup SolutionButtons;
    private javax.swing.JRadioButton HeuristicPrecioRadio;
    private javax.swing.JRadioButton HeuristicFelicidadRadio;
    private javax.swing.JRadioButton SolutionPrecioRadio;
    private javax.swing.JRadioButton SolutionFelicidadRadio;
    private javax.swing.JLabel HeuristicL;
    private javax.swing.JLabel SolutionL;
    private javax.swing.JLabel AnnealingL;
    private javax.swing.JLabel AnnealingPL;
    private javax.swing.JSlider PaquetesS;
    private javax.swing.JSlider RatioS;
    private javax.swing.JLabel HillClimbingL;
    private javax.swing.JFormattedTextField LambdaFT;
    private javax.swing.JLabel LambdaL;
    private javax.swing.JLabel NiterL;
    private javax.swing.JSlider NiterS;
    private javax.swing.JLabel ParKL;
    private javax.swing.JSlider ParKS;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JLabel SemillaL;
    private javax.swing.JFormattedTextField SemillaTF;
    private java.awt.TextArea annealingTA;
    private java.awt.Label paquetesL;
    private java.awt.Label ratioL;
    private javax.swing.JButton ejecutarB;
    private java.awt.TextArea hillClimbTA;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private NumberFormat numForm;
    private NumberFormatter nfor;
    private DefaultFormatterFactory formSeed;
    private DefaultFormatterFactory formLambda;

}
