package co.edu.uniquindio.poo.Ejercicio1.listaSimple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una lista enlazada para almacenar los números reales
        ListaSimpleEnlazada<Double> lista = new ListaSimpleEnlazada<>();

        try {
            // ✅ Aquí se crea el objeto File
            // Si el archivo está en la raíz del proyecto (fuera de src/), solo se pone el nombre
            File archivo = new File("numeros.txt");

            // Si lo tienes dentro de src/main/java/... entonces usa la ruta completa:
            // File archivo = new File("src/main/java/co/edu/uniquindio/poo/Ejercicio1/listaSimple/numeros.txt");

            Scanner lector = new Scanner(archivo);

            // Leer los números del archivo y agregarlos a la lista
            while (lector.hasNextDouble()) {
                double numero = lector.nextDouble();
                lista.agregarUltimo(new Nodo<>(numero));
            }

            lector.close();

            // Calcular la media
            double suma = 0;
            int n = 0;
            Nodo<Double> actual = lista.getPrimero();

            while (actual != null) {
                suma += actual.getDato();
                n++;
                actual = actual.getProximo();
            }

            double media = suma / n;

            // Calcular la desviación estándar
            double sumaDesviacion = 0;
            actual = lista.getPrimero();
            while (actual != null) {
                sumaDesviacion += Math.pow(actual.getDato() - media, 2);
                actual = actual.getProximo();
            }

            double desviacionEstandar = Math.sqrt(sumaDesviacion / n);

            // Mostrar resultados
            System.out.println("Media: " + media);
            System.out.println("Desviación estándar: " + desviacionEstandar);

        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Error: No se encontró el archivo.");
            e.printStackTrace();
        }



    /**public static void main(String[] args) {
        Polinomio p = new Polinomio();

        // Polinomio: 3x^4 - 4x^2 + 11
        p.agregarTermino(3, 4);
        p.agregarTermino(-4, 2);
        p.agregarTermino(11, 0);

        System.out.println("Polinomio:");
        p.mostrar();

        System.out.println("\nTabla de valores:");
        p.tablaValores();
     **/


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
