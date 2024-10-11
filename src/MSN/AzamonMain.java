package MSN;

import IA.Azamon.*;
import aima.*;

public class AzamonMain {

    public static void main(String[] args) {
        IA.Azamon.Paquetes paquetes = new IA.Azamon.Paquetes(10, 234423432);
        for (Paquete paquete : paquetes) {
            System.out.println(paquete.toString());
        }

        IA.Azamon.Transporte transportes = new IA.Azamon.Transporte(paquetes, 1, 2342342);
        for (Oferta oferta : transportes) {
            System.out.println(oferta.toString());
        }

        AzamonState state = new AzamonState(paquetes, transportes);

        System.out.println(java.util.Arrays.toString(state.getState()));
    }
}
