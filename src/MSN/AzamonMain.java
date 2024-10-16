package MSN;

import IA.Azamon.*;

import aima.search.framework.Search;
import aima.search.framework.Problem;
import aima.search.informed.HillClimbingSearch;
import aima

public class AzamonMain {

    public static void main(String[] args) {

        AzamonState state = new AzamonState(10, 1, 0);

        /*for (Paquete paquete : state.) {
            System.out.println(paquete.toString());
        }

        for (Oferta oferta : transportes) {
            System.out.println(oferta.toString());
        }*/


        System.out.println(java.util.Arrays.toString(state.getState()));
    }

    private static void HillClimbingMSN(AzamonState azamon) {
        Problem problem = new Problem(azamon, new AzamonSuccesorFunction(), new AzamonGoalTest(), new AzamonHeuristicFunction());
        Search search = new HillClimbingSearch();

    }
}
