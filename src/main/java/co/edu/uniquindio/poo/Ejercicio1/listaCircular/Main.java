package co.edu.uniquindio.poo.Ejercicio1.listaCircular;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.mostrar();

        System.out.println("¿Contiene 20?: " + lista.buscar(20)); // true
        System.out.println("¿Contiene 40?: " + lista.buscar(40)); // false
    }
}
