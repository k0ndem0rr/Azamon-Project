package MSN;

import aima.search.framework.GoalTest;

public class AzamonGoalTest implements GoalTest {
    
    public boolean isGoalState(Object azamonState) {
        AzamonState state = (AzamonState) azamonState;
        int nOfertas = state.getNumOfertas();

        double[] pesosLibres = new double[state.getNumOfertas()];

        for (int i = 0; i < nOfertas; i++) {
            pesosLibres[i] = state.getOferta(i).getPesomax();
        }

        for (int i: state.getState()) {
            pesosLibres[i] -= state.getPaquete(i).getPeso();
            if (pesosLibres[i] < 0 || AzamonState.llegaEnFecha(state.getPaquete(i), state.getOferta(i)) == false) return false;
        }
        
        return true;
    }
}
