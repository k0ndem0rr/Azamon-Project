package MSN;

import IA.Azamon.Oferta;
import IA.Azamon.Transporte;
import aima.search.framework.HeuristicFunction;

public class AzamonHeuristicFunction implements HeuristicFunction {

    public double getHeuristicValue(Object state) {
        AzamonState azamonState = (AzamonState) state;
        double precioTotal = 0;
        Transporte ofertas = azamonState.getOfertas();
        double[] pesosLibres = azamonState.getPesosLibres();

        for (Oferta oferta: ofertas) {
            precioTotal += (oferta.getPesomax() - pesosLibres[ofertas.indexOf(oferta)]) * oferta.getPrecio();
            System.out.println("Precio total: " + precioTotal);
        }

        return -precioTotal;



    }
}
