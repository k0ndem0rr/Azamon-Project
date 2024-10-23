package MSN;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class AzamonSuccesorFunctionSA implements SuccessorFunction {
    public List<Successor> getSuccessors(Object state) {
        ArrayList<Successor> succesors = new ArrayList<>();
        AzamonState azamonState = (AzamonState) state;
        int[] currentAsignaciones = azamonState.getAsignaciones();
        double[] currentPesosLibres = azamonState.getPesosLibres();
        int nPaquetes = azamonState.getNumPaquetes();
        int nOfertas = azamonState.getNumOfertas();
        Random random = new Random();
        
        // Codigo para generar sucesores
        // Posibles movimientos:
        // 1. Cambiar un paquete de una oferta a otra
        // 2. Intercambiar dos paquetes de ofertas distintas

        while (succesors.isEmpty()) {
            int step = random.nextInt(2);
            int i, j;
            if (step == 1) {
                i = j = random.nextInt(nPaquetes);
                while (currentAsignaciones[i] == j) j = random.nextInt(nOfertas);
                AzamonState newState = movePaquete(azamonState, i, j);
                if(isSolutionState(newState)) succesors.add(new Successor("Cambiar paquete " + i + " a oferta " + j, newState));
            }
            else {
                i = j = random.nextInt(nPaquetes);
                while (i == j) j = random.nextInt(nPaquetes);
                AzamonState newState = swapPaquetes(azamonState, i, j);
                if(isSolutionState(newState)) succesors.add(new Successor("Intercambiar paquete " + i + " con paquete " + j, newState));
            }
        }

        return succesors;
    }

    private AzamonState movePaquete(AzamonState azamonState, int i, int j) {
        int[] newAsignaciones = azamonState.getAsignaciones().clone();
        newAsignaciones[i] = j;

        double[] newPesosLibres = azamonState.getPesosLibres().clone();
        System.out.println(newPesosLibres.toString());
        newPesosLibres[j] -= azamonState.getPaquete(i).getPeso();
        newPesosLibres[azamonState.getAsignaciones()[i]] += azamonState.getPaquete(i).getPeso();

        return azamonState.newAsignaciones(newAsignaciones, newPesosLibres);
    }

    private AzamonState swapPaquetes(AzamonState azamonState, int i, int j) {
        int[] newAsignaciones = azamonState.getAsignaciones().clone();
        newAsignaciones[i] = azamonState.getAsignaciones()[j];
        newAsignaciones[j] = azamonState.getAsignaciones()[i];

        double[] newPesosLibres = azamonState.getPesosLibres().clone();
        newPesosLibres[azamonState.getAsignaciones()[i]] += azamonState.getPaquete(i).getPeso() - azamonState.getPaquete(j).getPeso();
        newPesosLibres[azamonState.getAsignaciones()[j]] += azamonState.getPaquete(j).getPeso() - azamonState.getPaquete(i).getPeso();

        return azamonState.newAsignaciones(newAsignaciones, newPesosLibres);
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
