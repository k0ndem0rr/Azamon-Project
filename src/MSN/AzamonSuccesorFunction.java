package MSN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class AzamonSuccesorFunction implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList succesors = new ArrayList();
        AzamonState azamonState = (AzamonState) state;
        AzamonHeuristicFunction heuristicFunction = new AzamonHeuristicFunction();
        
        // Codigo para generar sucesores
        // Posibles movimientos:
        // 1. Cambiar un paquete de una oferta a otra
        // 2. Intercambiar dos paquetes de ofertas distintas

        for
        


        return succesors;
    }
}
