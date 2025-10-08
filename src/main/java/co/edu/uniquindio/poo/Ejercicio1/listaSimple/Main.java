package co.edu.uniquindio.poo.Ejercicio1.listaSimple;

public class Main {
    public static void main(String[] args) {
        // Creamos una lista simple enlazada de enteros
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();

        // Agregamos nodos en desorden
        lista.agregarUltimo(new Nodo<>(7));
        lista.agregarUltimo(new Nodo<>(3));
        lista.agregarUltimo(new Nodo<>(4));
        lista.agregarUltimo(new Nodo<>(1));
        lista.agregarUltimo(new Nodo<>(2));

        ListaSimpleEnlazada<Integer> impares = lista.obtenerImpares();
        impares.mostrar();

        //System.out.println("Antes de ordenar:");
        //lista.mostrar();

        // Aplicamos el sort
        //lista.sort();

        //System.out.println("Después de ordenar:");
        //lista.mostrar();

        // 🔹 Ejemplo extra: recorrer con el Iterator
        //System.out.println("Recorriendo con Iterator:");
        //for (Integer num : lista) {
        //    System.out.print(num + " ");
        //}
        //System.out.println();
    }
}
