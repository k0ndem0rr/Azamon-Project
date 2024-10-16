package MSN;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class AzamonSuccesorFunction implements SuccessorFunction {
    public List<Successor> getSuccessors(Object state) {
        ArrayList<Successor> succesors = new ArrayList<>();
        AzamonState azamonState = (AzamonState) state;
        int[] currentAsignaciones = azamonState.getAsignaciones();
        double[] currentPesosLibres = azamonState.getPesosLibres();
        int nPaquetes = azamonState.getNumPaquetes();
        
        // Codigo para generar sucesores
        // Posibles movimientos:
        // 1. Cambiar un paquete de una oferta a otra
        // 2. Intercambiar dos paquetes de ofertas distintas

        for (int i = 0; i < nPaquetes; i++) {
            for (int j = 0; j < azamonState.getNumOfertas(); j++) {
                if (currentAsignaciones[i] != j) {
                    int[] newAsignaciones = currentAsignaciones.clone();
                    newAsignaciones[i] = j;

                    double[] newPesosLibres = currentPesosLibres.clone();
                    newPesosLibres[j] -= azamonState.getPaquete(i).getPeso();
                    newPesosLibres[currentAsignaciones[i]] += azamonState.getPaquete(i).getPeso();

                    AzamonState newState = azamonState.newAsignaciones(newAsignaciones, newPesosLibres);
                    if(isSolutionState(newState)) succesors.add(new Successor("Cambiar paquete " + i + " a oferta " + j, newState));
                }
            }
        }
        for (int i = 0; i < nPaquetes; i++) {
            for (int j = i+1; j < nPaquetes; j++) {
                if (currentAsignaciones[i] != currentAsignaciones[j]) {
                    int[] newAsignaciones = currentAsignaciones.clone();
                    newAsignaciones[i] = currentAsignaciones[j];
                    newAsignaciones[j] = currentAsignaciones[i];

                    double[] newPesosLibres = currentPesosLibres.clone();
                    newPesosLibres[currentAsignaciones[i]] += azamonState.getPaquete(i).getPeso() - azamonState.getPaquete(j).getPeso();
                    newPesosLibres[currentAsignaciones[j]] += azamonState.getPaquete(j).getPeso() - azamonState.getPaquete(i).getPeso();

                    AzamonState newState = azamonState.newAsignaciones(newAsignaciones, newPesosLibres); 
                    if(isSolutionState(newState)) succesors.add(new Successor("Intercambiar paquete " + i + " con paquete " + j, newState));
                }
            }
        }

        return succesors;
    }

    private boolean isSolutionState(AzamonState azamonState) {
        AzamonState state = (AzamonState) azamonState;

        for (double pesoLibre: state.getPesosLibres()) {
            if (pesoLibre < 0) return false;
        }

        int[] asignaciones = state.getAsignaciones();
        int nPaquetes = state.getNumPaquetes();

        for (int i = 0; i < nPaquetes; i++) {
            if (AzamonState.llegaEnFecha(state.getPaquete(i), state.getOferta(asignaciones[i])) == false) return false;
        }

        return true;
    }
}
