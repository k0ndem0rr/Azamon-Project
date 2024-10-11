package MSN;

import IA.Azamon.*;
import aima.*;

public class AzamonMain {

    public static void main(String[] args) {
        IA.Azamon.Paquetes paquetes = new IA.Azamon.Paquetes(5, 0);
        for (Paquete paquete : paquetes) {
            System.out.println(paquete.toString());
        }

        IA.Azamon.Transporte transportes = new IA.Azamon.Transporte(paquetes, 0.1, 0);
        for (Oferta oferta : transportes) {
            System.out.println(oferta.toString());
        }

        System.out.println(paquetes.get(0).toString());
    }
}
