package co.edu.uniquindio.poo.Ejercicio1.listaCircular;



import java.util.ArrayList;
import java.util.Collections;

public class ListaCircular<T extends Comparable<T>> {
    private Nodo<T> primero;
    private int tamaño;

    public ListaCircular() {
        primero=null;
        tamaño=0;
    }

    public void agregarPrimero(Nodo<T> newNodo){
        if (primero == null) {
            primero = newNodo;
            newNodo.setProximo(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);    // último apunta al nuevo
            newNodo.setProximo(primero);   // nuevo apunta al viejo primero
            primero = newNodo;             // actualizamos primero
        }
        tamaño++;
    }

    public void agregarUltimo(Nodo<T> newNodo){
        if (primero == null) {
            primero = newNodo;
            newNodo.setProximo(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setProximo(primero);
        }
        tamaño++;
    }
    // nsertar ordenado
    public void agregarOrdenado(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null || dato.compareTo(primero.getDato()) <= 0) {
            agregarPrimero(nuevo);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero &&
                    dato.compareTo(actual.getProximo().getDato()) > 0) {
                actual = actual.getProximo();
            }
            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
            tamaño++;
        }
    }

    public void sort() {
        if (primero == null || primero.getProximo() == primero) return;

        // 1. Pasar los elementos a un ArrayList
        ArrayList<T> listaAux = new ArrayList<>();
        Nodo<T> actual = primero;
        do {
            listaAux.add(actual.getDato());
            actual = actual.getProximo();
        } while (actual != primero);

        // 2. Ordenar con Collections.sort
        Collections.sort(listaAux);

        // 3. Reconstruir la lista
        actual = primero;
        int i = 0;
        do {
            actual.setDato(listaAux.get(i++));
            actual = actual.getProximo();
        } while (actual != primero);
    }

    // Mostrar la lista circular
    public void mostrar() {
        if (primero == null) {
            System.out.println("[]");
            return;
        }
        Nodo<T> actual = primero;
        System.out.print("[");
        do {
            System.out.print(actual.getDato());
            actual = actual.getProximo();
            if (actual != primero) System.out.print(" -> ");
        } while (actual != primero);
        System.out.println("] (circular)");
    }
}
