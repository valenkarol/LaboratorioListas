package co.edu.uniquindio.poo.Ejercicio1.listaSimple;

public class Main {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();

        lista.agregarUltimo(new Nodo<>(1));
        lista.agregarUltimo(new Nodo<>(2));
        lista.agregarUltimo(new Nodo<>(3));
        lista.agregarUltimo(new Nodo<>(4));


        lista.mostrar();
    }

        //ListaSimpleEnlazada<Integer> listaImpares = lista.obtenerImpares();
        //System.out.print("Lista de impares: ");
        //listaImpares.mostrar();  // [1, 3, 5]



        //System.out.println("Lista sin pares");
        //lista.eliminarPares();
        //lista.mostrar();
        //lista.obtenerCedulasConCantidadPar();// [10, 5, 8, 3, 11]
        //lista.obtenerImpares();   // Números impares: [5, 3, 11]

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
