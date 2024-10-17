package MSN;

import javax.swing.*;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class NewAzamonFrame extends JFrame {
    private JTextField paquetesField;
    private JTextField ratioField;
    private JTextField semillaField;
    private JTextArea resultadoArea;

    public NewAzamonFrame() {
        setTitle("Azamon Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Crear los componentes
        JLabel paquetesLabel = new JLabel("Número de paquetes:");
        paquetesField = new JTextField(10);

        JLabel ratioLabel = new JLabel("Ratio Peso/Peso Máx:");
        ratioField = new JTextField(10);

        JLabel semillaLabel = new JLabel("Semilla:");
        semillaField = new JTextField(10);

        JButton ejecutarButton = new JButton("Ejecutar");
        ejecutarButton.addActionListener(new EjecutarActionListener());

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        resultadoArea.setEditable(false);

        JScrollPane resultadoScroll = new JScrollPane(resultadoArea);

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(paquetesLabel, gbc);

        gbc.gridx = 1;
        add(paquetesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(ratioLabel, gbc);

        gbc.gridx = 1;
        add(ratioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(semillaLabel, gbc);

        gbc.gridx = 1;
        add(semillaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(ejecutarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultadoScroll, gbc);
    }

    private class EjecutarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener valores de los campos de texto
            String str = "25";
try {
    Integer number = Integer.valueOf(str);
    System.out.println(number); // Output: 25
} catch (NumberFormatException ex) {
    ex.printStackTrace();
}

            int paquetes = 0;
            int ratio = 0;
            int semilla = 0;
            try{
                paquetes = Integer.valueOf(paquetesField.getText());
                ratio = Integer.valueOf(ratioField.getText());
                semilla = Integer.valueOf(semillaField.getText());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }


            // Aquí se llamaría a tu programa con los valores obtenidos
            ejecutarPrograma(paquetes, ratio, semilla);

            // Mostrar el resultado en la caja de texto
        }
    }

    // Método que representa el programa que ejecuta el algoritmo
    private void ejecutarPrograma(int paquetes, int ratio, int semilla) {
        AzamonState state = new AzamonState(paquetes, ((double)ratio)/100, semilla);
        resultadoArea.append(String.valueOf(paquetes));
        try {
            Problem problem = new Problem(state, new AzamonSuccesorFunction(), new AzamonGoalTest(),
                    new AzamonHeuristicFunction());
            Search search = new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem, search);

            // System.out.println();
            printActions(agent.getActions(), resultadoArea);
            // printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printActions(java.util.List actions, JTextArea a) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            // System.out.println(action);
            a.append(action + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NewAzamonFrame frame = new NewAzamonFrame();
            frame.setVisible(true);
        });
    }
}
