package MSN;

import IA.Azamon.Oferta;
import IA.Azamon.Paquete;
import IA.Azamon.Paquetes;
import IA.Azamon.Transporte;
import aima.search.framework.HeuristicFunction;

public class AzamonHeuristicFunction implements HeuristicFunction {

    public double getHeuristicValue(Object state) {
        AzamonState azamonState = (AzamonState) state;
        double precioTotal = 0;
        double felicidad = 0;
        int numPaquetes = azamonState.getNumPaquetes();
        Paquetes paquetes = azamonState.getPaquetes();
        int[] assignaciones = azamonState.getAsignaciones();
        Transporte ofertas = azamonState.getOfertas();
        double[] pesosLibres = azamonState.getPesosLibres();

        for (Oferta oferta: ofertas) {
            precioTotal += (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * oferta.getPrecio();
            if (oferta.getDias() == 3 || oferta.getDias() == 4) {
                precioTotal += (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * 0.25;
            } else if (oferta.getDias() == 5) {
                precioTotal += (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * 0.5;
            }
        }
        if (azamonState.getHeuristic() == 1) {
            return -precioTotal;
        } else {
            int i = 0;
            for (Paquete paquete : paquetes) {
                Oferta oferta = ofertas.get(assignaciones[i]);
                int prio = 0;
                if (paquete.getPrioridad() == 0) {
                    prio = 1;
                } else if (paquete.getPrioridad() == 1) {
                    prio = 2;
                } else {
                    prio = 4;
                }
                if ((prio - oferta.getDias()) > 0) felicidad += (prio - oferta.getDias());
            }
            double finalHeuristic = precioTotal * 1000 - felicidad;
            return -finalHeuristic;
        }
    }
}
