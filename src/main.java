import IA.Azamon.*;

public class main {

    public static void main(String[] args) {
        IA.Azamon.Paquetes paquetes = new IA.Azamon.Paquetes(5, 0);
        for (Paquete paquete : paquetes) {
            System.out.println(paquete.toString());
            
        }

        IA.Azamon.Transporte transportes = new IA.Azamon.Transporte(paquetes, 0.2, 0);
        for (Oferta oferta : transportes) {
            System.out.println(oferta.toString());
        }
    }
}
