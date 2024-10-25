package MSN;

import IA.Azamon.*;

public class AzamonState {

    private final Paquetes paquetes;
    private final Transporte ofertas;

    /// Número de paquetes
    private int nPaquetes;

    /// Número de ofertas
    private int nOfertas;

    // Representación de las asignaciones de paquetes a ofertas:
    // - Índice: paquete
    // - Valor: oferta
    private int[] asignaciones;

    // Representación del peso libre en cada oferta
    private double[] pesosLibres;


    // Constructor
    public AzamonState(int nPaquetes, double ratio, int seed) {

        // Inicialización de paquetes y ofertas
        paquetes = new Paquetes(nPaquetes, seed);
        ofertas = new Transporte(paquetes, ratio, seed);
        this.nPaquetes = nPaquetes;
        this.nOfertas = ofertas.size();
        asignaciones = new int[nPaquetes];
        pesosLibres = new double[nOfertas];

        for (int i = 0; i < nOfertas; i++) {
            pesosLibres[i] = ofertas.get(i).getPesomax();
        }

        estadoInicial();
    }

    private AzamonState(Paquetes paquetes, Transporte ofertas, int[] asignaciones, double[] pesosLibres) {
        this.paquetes = paquetes;
        this.ofertas = ofertas;
        this.nPaquetes = paquetes.size();
        this.nOfertas = ofertas.size();
        this.asignaciones = asignaciones;
        this.pesosLibres = pesosLibres;
    }

    private void estadoInicial() {
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
        
        // Asignación de paquetes a ofertas
        // Recorremos las ofertas y asignamos paquetes hasta que no quepan más
        int i = 0; // Índice de paquetes
        for (Oferta oferta : ofertas) {
            boolean nextCabe = true; // Indica si cabe el siguiente paquete
            while (nextCabe && i < nPaquetes) { // Mientras quepa el siguiente paquete y haya paquetes por asignar
                if (sortedPaquetes[i][1] <= pesosLibres[ofertas.indexOf(oferta)]) { // Si cabe el paquete
                    asignaciones[(int) sortedPaquetes[i][2]] = ofertas.indexOf(oferta); // Asignamos el paquete a la oferta
                    pesosLibres[ofertas.indexOf(oferta)] -= sortedPaquetes[i][1]; // Restamos el peso del paquete al peso libre
                    i++;   // Pasamos al siguiente paquete
                }
                else { // Si no cabe el paquete
                    nextCabe = false; // Indicamos que no cabe el siguiente paquete
                }
            }
        }
    }

    public AzamonState newAsignaciones(int[] newAsignaciones, double[] newPesosLibres) {
        AzamonState azamonState = new AzamonState(paquetes, ofertas, newAsignaciones, newPesosLibres);
        return azamonState;
    }

    public Transporte getOfertas() {
        return ofertas;
    }

    public Paquetes getPaquetes() {
        return paquetes;
    }

    public int[] getAsignaciones() {
        return asignaciones;
    }

    public double[] getPesosLibres() {
        return pesosLibres;
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
            str += "Paquete " + i + ": Oferta " + asignaciones[i] + "\n";
        }
        return str;
    }

    public static boolean llegaEnFecha(Paquete paquete, Oferta oferta) {
        int prioridad = paquete.getPrioridad();
        int maxDias = oferta.getDias();

        return ((prioridad == 0 && maxDias <= 1) || (prioridad == 1 && maxDias <= 3) || prioridad == 2);
    }
}
