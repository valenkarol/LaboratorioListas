package co.edu.uniquindio.poo.Ejercicio1.ldobleEnlazada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListaDobleEnlazada<T extends Comparable<T>> implements Iterable<T>{
    private NodoDoble2<T> primero;   // primer nodo
    private NodoDoble2<T> ultimo;     // último nodo
    private int tamaño;             // cantidad de nodos

    public ListaDobleEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }
    public boolean estaVacia() {
        return primero == null;
    }
    //metodo agregar al final
    public void agregarFinal(T elemento) {
        NodoDoble2<T> nuevo = new NodoDoble2<>(elemento);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tamaño++;
    }
    //metodo agregar al inicio
    public void agregarInicio(T elemento) {
        NodoDoble2<T> nuevo = new NodoDoble2<>(elemento);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setProximo(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tamaño++;
    }
    //agregar en posicion especifica
    public void agregarEnPosicion(int indice, T elemento) {
        if (indice <= 0) {
            agregarInicio(elemento);
            return;
        }
        if (indice >= tamaño) {
            agregarFinal(elemento);
            return;
        }
        NodoDoble2<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getProximo();
        }
        NodoDoble2<T> nuevo = new NodoDoble2<>(elemento);
        NodoDoble2<T> anterior = actual.getAnterior();
        anterior.setProximo(nuevo);
        nuevo.setAnterior(anterior);
        nuevo.setProximo(actual);
        actual.setAnterior(nuevo);
        tamaño++;
    }
    public void agregarOrdenado(T elemento) {
        if (estaVacia() || elemento.compareTo(primero.getElemento()) <= 0) {
            agregarInicio(elemento);
        } else if (elemento.compareTo(ultimo.getElemento()) >= 0) {
            agregarFinal(elemento);
        } else {
            NodoDoble2<T> actual = primero;
            while (elemento.compareTo(actual.getElemento()) > 0) {
                actual = actual.getProximo();
            }
            NodoDoble2<T> nuevo = new NodoDoble2<>(elemento);
            NodoDoble2<T> anterior = actual.getAnterior();
            anterior.setProximo(nuevo);
            nuevo.setAnterior(anterior);
            nuevo.setProximo(actual);
            actual.setAnterior(nuevo);
            tamaño++;
        }
    }

    public void sort() {
        if (estaVacia() || primero.getProximo() == null) return;

        // 1. Pasamos los datos a un ArrayList
        ArrayList<T> listaAux = new ArrayList<>();
        NodoDoble2<T> actual = primero;
        while (actual != null) {
            listaAux.add(actual.getElemento());
            actual = actual.getProximo();
        }

        // 2. Ordenamos el ArrayList
        Collections.sort(listaAux);

        // 3. Reconstruimos la lista con los elementos ordenados
        actual = primero;
        int i = 0;
        while (actual != null) {
            actual.setElemento(listaAux.get(i++));
            actual = actual.getProximo();
        }
    }

    public void mostrar() {
        NodoDoble2<T> actual = primero;
        System.out.print("[");
        while (actual != null) {
            System.out.print(actual.getElemento());
            if (actual.getProximo() != null) System.out.print(", ");
            actual = actual.getProximo();
        }
        System.out.println("]");
    }

    //EJERCCIO 6: IMPRIMIR HACIA ATRAS
    public void imprimirHaciaAtras() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoDoble2<T> actual = ultimo;
        System.out.print("[");

        while (actual != null) {
            System.out.print(actual.getElemento());
            if (actual.getAnterior() != null) System.out.print(", ");
            actual = actual.getAnterior();
        }

        System.out.println("]");
    }

    //EJERCICIO 7: iterator
    @Override
    public Iterator<T> iterator() {
        return new IteradorDoble<>(primero);
    }

    //EJERCICIO 8: METODO QUE DE UNA LISTAS DOBLE CON LAS CEDULAS DE TAMAÑO PAR
    public ListaDobleEnlazada<T> obtenerCedulasCantidadPar() {
        ListaDobleEnlazada<T> listaPar = new ListaDobleEnlazada<>();

        NodoDoble2<T> actual = primero;

        while (actual != null) {
            T elemento = actual.getElemento();

            if (elemento instanceof Persona) {
                Persona p = (Persona) elemento;
                String cedula = p.getCedula();

                if (cedula.length() % 2 == 0) {
                    listaPar.agregarFinal(elemento);
                }
            }

            actual = actual.getProximo();
        }

        return listaPar;
    }
}
