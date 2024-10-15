package MSN;

import IA.Azamon.*;
import aima.*;

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
}
