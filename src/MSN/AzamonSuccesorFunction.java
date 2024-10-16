package MSN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class AzamonSuccesorFunction implements SuccessorFunction {
    public List<Successor> getSuccessors(Object state) {
        ArrayList<Successor> succesors = new ArrayList<>();
        AzamonState azamonState = (AzamonState) state;
        AzamonHeuristicFunction heuristicFunction = new AzamonHeuristicFunction();
        int[] currentState = azamonState.getState();
        int nPaquetes = azamonState.getNumPaquetes();
        
        // Codigo para generar sucesores
        // Posibles movimientos:
        // 1. Cambiar un paquete de una oferta a otra
        // 2. Intercambiar dos paquetes de ofertas distintas

        for (int i = 0; i < nPaquetes; i++) {
            for (int j = 0; j < azamonState.getNumOfertas(); j++) {
                if (currentState[i] != j) {
                    int[] newState = currentState.clone();
                    newState[i] = j;
                    succesors.add(new Successor("Cambiar paquete " + i + " a oferta " + j, azamonState.newState(newState)));
                }
            }
        }
        for (int i = 0; i < nPaquetes; i++) {
            for (int j = i+1; j < nPaquetes; j++) {
                if (currentState[i] != currentState[j]) {
                    int[] newState = currentState.clone();
                    newState[i] = currentState[j];
                    newState[j] = currentState[i];
                    succesors.add(new Successor("Intercambiar paquete " + i + " con paquete " + j, azamonState.newState(newState)));
                }
            }
        }

        return succesors;
    }
}
