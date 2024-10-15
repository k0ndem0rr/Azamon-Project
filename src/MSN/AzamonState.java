package MSN;

import IA.Azamon.*;
import aima.*;
import java.util.Random;

public class AzamonState {

    private final Paquetes paquetes;
    private final Transporte ofertas;

    /// Número de paquetes
    private int nPaquetes;

    /// Número de ofertas
    private int nOfertas;

    // Representación del estado:
    // - Índice: paquete
    // - Valor: oferta
    private int[] state;


    // Constructor
    public AzamonState(int nPaquetes, double ratio, int seed) {

        // Inicialización de paquetes y ofertas
        paquetes = new Paquetes(nPaquetes, seed);
        ofertas = new Transporte(paquetes, ratio, seed);
        this.nPaquetes = nPaquetes;
        this.nOfertas = ofertas.size();
        state = new int[nPaquetes];

        // Transformación de paquetes a array de dobles
        double[][] sortedPaquetes = new double[nPaquetes][3];
        for (int i = 0; i < nPaquetes; i++) {
            sortedPaquetes[i][0] = paquetes.get(i).getPrioridad();
            sortedPaquetes[i][1] = paquetes.get(i).getPeso();
            sortedPaquetes[i][2] = i;
        }

        // Ordenación de paquetes por prioridad
        java.util.Arrays.sort(sortedPaquetes, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });


        System.out.println(java.util.Arrays.deepToString(sortedPaquetes));
        
        // Asignación de paquetes a ofertas
        // Recorremos las ofertas y asignamos paquetes hasta que no quepan más
        int i = 0; // Índice de paquetes
        for (Oferta oferta : ofertas) {
            double pesoLibre = oferta.getPesomax(); // Peso libre en la oferta
            boolean nextCabe = true; // Indica si cabe el siguiente paquete
            while (nextCabe && i < nPaquetes) { // Mientras quepa el siguiente paquete y haya paquetes por asignar
                System.out.println("Peso libre en oferta " + ofertas.indexOf(oferta) + ": " + pesoLibre);
                if (sortedPaquetes[i][1] <= pesoLibre) { // Si cabe el paquete
                    state[(int) sortedPaquetes[i][2]] = ofertas.indexOf(oferta); // Asignamos el paquete a la oferta
                    pesoLibre -= sortedPaquetes[i][1]; // Restamos el peso del paquete al peso libre
                    i++;   // Pasamos al siguiente paquete
                }
                else { // Si no cabe el paquete
                    nextCabe = false; // Indicamos que no cabe el siguiente paquete
                }
            }
            System.out.println("Paquetes por asignar: " + (nPaquetes - (i+1)));
        }
    }

    public int[] getState() {
        return state;
    }

    public int getNumPaquetes() {
        return nPaquetes;
    }

    public int getNumOfertas() {
        return nOfertas;
    }

    public Oferta getOferta(int i) {
        return ofertas.get(i);
    }

    public Paquete getPaquete(int i) {
        return paquetes.get(i);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < nPaquetes; i++) {
            str += "Paquete " + i + ": Oferta " + state[i] + "\n";
        }
        return str;
    }

    public static boolean llegaEnFecha(Paquete paquete, Oferta oferta) {
        int prioridad = paquete.getPrioridad();
        int maxDias = oferta.getDias();
        
        return ((prioridad == 0 && maxDias <= 1) || (prioridad == 1 && maxDias <= 3) || prioridad == 2);
    }
}
