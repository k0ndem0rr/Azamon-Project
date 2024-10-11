package MSN;

import IA.Azamon.*;
import aima.*;
import java.util.Random;

public class AzamonState {

    private int nPaquetes;

    private int nOfertas;

    private int[] state;

    public AzamonState(Paquetes paquetes, Transporte transportes) {
        nPaquetes = paquetes.size();
        nOfertas = transportes.size();
        state = new int[nPaquetes];

        // TODO
        // Inicializar el estado asignado a cada paquete la primera oferta que no esté llena y cumpla su tiempo de entrega
    }


}
