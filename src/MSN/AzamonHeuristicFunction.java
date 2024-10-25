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
        Paquetes paquetes = azamonState.getPaquetes();
        int[] assignaciones = azamonState.getAsignaciones();
        Transporte ofertas = azamonState.getOfertas();
        double[] pesosLibres = azamonState.getPesosLibres();

        for (Oferta oferta: ofertas) {
            precioTotal += (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * oferta.getPrecio();
          
            precioTotal += 
            (((oferta.getDias() > 2) ? 1 : 0) + ((oferta.getDias() == 5) ? 1 : 0)) 
            * (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * 0.25;
        }

        if (azamonState.getHeuristic() == 0) {
            return -precioTotal;
        } else {
            double felicidad = 0;
            for (Paquete paquete : paquetes) {
                Oferta oferta = ofertas.get(assignaciones[paquetes.indexOf(paquete)]);
                int prio;
                if (paquete.getPrioridad() == 0) {
                    prio = 1;
                } else if (paquete.getPrioridad() == 1) {
                    prio = 2;
                } else {
                    prio = 4;
                }
                if ((prio - oferta.getDias()) > 0) felicidad += (prio - oferta.getDias());
            }
            double finalHeuristic = precioTotal * 100 - felicidad;
            return -finalHeuristic;
        }
    }
}
