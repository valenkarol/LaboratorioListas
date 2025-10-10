package co.edu.uniquindio.poo.Ejercicio1.listaSimple;

public class Main {
    public static void main(String[] args) {
        Polinomio p = new Polinomio();

        // Polinomio: 3x^4 - 4x^2 + 11
        p.agregarTermino(3, 4);
        p.agregarTermino(-4, 2);
        p.agregarTermino(11, 0);

        System.out.println("Polinomio:");
        p.mostrar();

        System.out.println("\nTabla de valores:");
        p.tablaValores();


        /**ListaSimpleEnlazada<Integer> lista1 = new ListaSimpleEnlazada<>();
        /lista1.agregarUltimo(new Nodo<>(1));
        lista1.agregarUltimo(new Nodo<>(2));
        lista1.agregarUltimo(new Nodo<>(3));

        ListaSimpleEnlazada<Integer> lista2 = new ListaSimpleEnlazada<>();
        lista2.agregarUltimo(new Nodo<>(4));
        lista2.agregarUltimo(new Nodo<>(5));

        ListaSimpleEnlazada<Integer> unida = ListaSimpleEnlazada.concatenar(lista1, lista2);

        System.out.print("Lista 1: ");
        lista1.mostrar();

        System.out.print("Lista 2: ");
        lista2.mostrar();

        System.out.print("Lista unida: ");
        unida.mostrar();**/
    }
        //int repeticiones=lista.contadorRepetidos("A");
        //System.out.println("El numero de repeticion de dato buscado es de "+repeticiones);


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
