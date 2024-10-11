package MSN;

import IA.Azamon.*;
import aima.*;
import java.util.Random;

public class AzamonState {

    private int nPaquetes;

    private int nOfertas;

    private int[] state;

    public AzamonState(Paquetes paquetes, Transporte transportes) {
        nPaquetes = paquetes.size();
        nOfertas = transportes.size();
        state = new int[nPaquetes];

        double[][] sortedPaquetes = new double[nPaquetes][3];
        for (int i = 0; i < nPaquetes; i++) {
            sortedPaquetes[i][0] = paquetes.get(i).getPrioridad();
            sortedPaquetes[i][1] = paquetes.get(i).getPeso();
            sortedPaquetes[i][2] = i;
        }

        java.util.Arrays.sort(sortedPaquetes, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

        System.out.println(java.util.Arrays.deepToString(sortedPaquetes));
        
        int i = 0;
        for (Oferta oferta : transportes) {
            double pesoLibre = oferta.getPesomax();
            boolean nextCabe = true;
            while (nextCabe && i < nPaquetes) {
                System.out.println("Peso libre en oferta " + transportes.indexOf(oferta) + ": " + pesoLibre);
                if (sortedPaquetes[i][1] <= pesoLibre) {
                    state[(int) sortedPaquetes[i][2]] = transportes.indexOf(oferta);
                    pesoLibre -= sortedPaquetes[i][1];
                    i++;
                }
                else {
                    nextCabe = false;
                }
            }
            System.out.println("Paquetes por asignar: " + (nPaquetes - (i+1)));
        }
    }

    public int[] getState() {
        return state;
    }
}
