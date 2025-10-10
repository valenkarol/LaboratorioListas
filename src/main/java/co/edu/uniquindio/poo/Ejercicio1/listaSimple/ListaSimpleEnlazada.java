package co.edu.uniquindio.poo.Ejercicio1.listaSimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements Iterable<T>{
    private Nodo<T> primero;
    private int tamaño;

    public ListaSimpleEnlazada(){
        primero = null;
        tamaño=0;
    }

    //metodo que permita usar "priemro" en el ejercico 11
    public Nodo<T> getPrimero() {
        return primero;
    }



    // metodo para agregar al inicio
    public void agregarPrimero(Nodo<T> newNodo){
        if (primero==null){
            primero=newNodo;
            tamaño++;
        }else{
            newNodo.setProximo(primero);
            primero=newNodo;
            tamaño++;
        }
    }
    //metodo mostrar una lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[]");
            return;
        }
        Nodo<T> actual = primero;
        String mensaje = "[";

        do {
            mensaje += actual.getDato();
            actual = actual.getProximo();

            if (actual != null) {
                mensaje += ", ";
            }

        } while (actual != null);
        mensaje += "]";
        System.out.println(mensaje);
    }

    //metodo agregar de ultimo
    public void agregarUltimo(Nodo<T> newNodo){
        Nodo<T> nuevo=newNodo;
        if (primero==null){
            primero=nuevo;
            tamaño++;
        }else{
            Nodo<T> actual=primero;
            while(actual.getProximo()!=null){
                actual=actual.getProximo();
            }
            actual.setProximo(newNodo);
            tamaño++;
        }
    }
    // Metodo para agregar en una posicion especifica
    public void agregarEnPosicion(int posicion, Nodo<T> newNodo) {
        if (posicion < 0 || posicion > tamaño) {
            System.out.println("Posición inválida");
            return;
        }
        if (posicion == 0) {
            agregarPrimero(newNodo);
        } else if (posicion == tamaño) {
            agregarUltimo(newNodo);
        } else {
            Nodo<T> actual = primero;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
            tamaño++;
        }
    }
    //metodo para lista vacia
    public void vaciarLista(){
        primero=null;
        tamaño=0;
        System.out.println("Lista vacia");
    }
    //metodo para verificar lista vacia
    public boolean estaVacia(){
        return primero==null;
    }

    //metodo para localizar
    public int localizar(T datoBusqueda){
        Nodo<T> actual=primero;
        int indexBusqueda =0;
        while(actual !=null){
            if(actual.getDato().equals(datoBusqueda)){
                return indexBusqueda;
            }
            indexBusqueda++;
            actual=actual.getProximo();
        }
        return -1;
    }
    // metodo para buscar un dato
    public boolean buscar(T datoBusqueda) {
        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                return true; // dato encontrado
            }
            actual = actual.getProximo(); // avanzar al siguiente nodo
        }

        return false; // no se encontró
    }
    //metodo para eliminar primer elemento
    public boolean eliminar(T datoBusqueda) {
        Nodo<T> actual = primero;
        if(actual.getDato().equals(datoBusqueda)){
            primero=actual.getProximo();
            tamaño--;
            return true;
        }else{
            while(actual.getProximo()!=null){
                if (actual.getProximo().getDato().equals(datoBusqueda)){
                    actual.setProximo(actual.getProximo().getProximo());
                    tamaño--;
                    return true;
                }
                actual=actual.getProximo();
            }
            return false;

        }
    }
    //metodo para agregar de manera natural a un nodo
    public void agregarOrdenado(Nodo <T> newNodo) {

        // Caso 1: lista vacía o el dato es menor que el primero
        if (primero == null || newNodo.getDato().compareTo(primero.getDato()) < 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        } else {
            // Recorremos la lista buscando el lugar correcto
            Nodo<T> actual = primero;
            while (actual.getProximo() != null && newNodo.getDato().compareTo(actual.getProximo().getDato()) > 0) {
                actual = actual.getProximo();
            }
            // Insertamos el nuevo nodo en su posición
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tamaño++;
    }

    public void sort() {
        if (estaVacia() || primero.getProximo() == null) return;

        // 1. Pasar a un ArrayList
        ArrayList<T> listaAux = new ArrayList<>();
        Nodo<T> actual = primero;
        while (actual != null) {
            listaAux.add(actual.getDato());
            actual = actual.getProximo();
        }

        // 2. Ordenar con Collections.sort
        Collections.sort(listaAux);

        // 3. Reconstruir la lista
        actual = primero;
        int i = 0;
        while (actual != null) {
            actual.setDato(listaAux.get(i++));
            actual = actual.getProximo();
        }
    }



    //Metodo EJEJRCICIO 1 Obtener los números de las posiciones impares
    public void PosicionImpar(){
        Nodo<T> actual = primero;
        int indexBusqueda =0;
        System.out.print("Elementos en posiciones impares: ");

        while (actual != null) {
            if (indexBusqueda % 2 != 0) {
                System.out.print(actual.getDato() + " ");
            }
            actual = actual.getProximo();
            indexBusqueda++;
        }
        System.out.println();
    }

    //EJERCICO 2: METODO DE OBTENER SOLO LAS CEDULAS DE TAMAÑO PAR
    public void obtenerCedulasConCantidadPar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<T> actual = primero;
        String mensaje = "[";
        int contador = 0;

        while (actual != null) {
            Persona p = (Persona) actual.getDato(); // ya sabes que es Persona
            int longitud = p.getCedula().length();
            if (longitud % 2 == 0) {
                if (contador > 0) {
                    mensaje += ", ";
                }
                mensaje += " (" + p.getCedula() + ")";
                contador++;
            }
            actual = actual.getProximo();
        }
        mensaje += "]";
        System.out.println("Personas con cédula de longitud par: " + mensaje);
    }

    //EJERCICIO 3: ELIMINAR LOS  NUMEROS PARES DE UNA LISTA
    public void eliminarPares() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;
        while (actual != null) {
            if (actual.getDato() instanceof Integer) {
                int valor = (Integer) actual.getDato();
                // Si es par, eliminar el nodo
                if (valor % 2 == 0) {
                    if (anterior == null) {
                        // El nodo par está al inicio
                        primero = actual.getProximo();
                    } else {
                        // Saltar el nodo actual
                        anterior.setProximo(actual.getProximo());
                    }
                    tamaño--;
                } else {
                    // Solo avanzamos el puntero anterior si no eliminamos
                    anterior = actual;
                }
            }
            actual = actual.getProximo();
        }
        System.out.println("Nodos con números pares eliminados.");
    }

    //EJERCICIO 4:CREAR UNA LISTA ENLAZADA CON SOLO LOS NUMEROS IMPARES
    public ListaSimpleEnlazada obtenerImpares() {
        ListaSimpleEnlazada<T> listaImpares = new ListaSimpleEnlazada<>();

        if (estaVacia()) {
            return listaImpares; // devuelve lista vacía si no hay elementos
        }

        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getDato() instanceof Integer) {
                int valor = (Integer) actual.getDato();
                if (valor % 2 != 0) {
                    listaImpares.agregarUltimo(new Nodo<>(actual.getDato()));
                }
            }
            actual = actual.getProximo();
        }

        return listaImpares;
    }

    //EJERCICIO 5: OBTENER CANTIDAD DE VECES QUE SE REPITE UN VALOR
    public int contadorRepetidos(T datoBusqueda) {
        if (estaVacia()) {
            return 0;
        }
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                contador++;
            }
            actual = actual.getProximo();
        }
        return contador;
    }

    //EJERCICIO 10: UNIR LISTAS
    public static <T extends Comparable<T>> ListaSimpleEnlazada<T> concatenar(
            ListaSimpleEnlazada<T> lista1,
            ListaSimpleEnlazada<T> lista2) {

        ListaSimpleEnlazada<T> resultado = new ListaSimpleEnlazada<>();

        // Copiar los elementos de la primera lista
        Nodo<T> actual = lista1.primero;
        while (actual != null) {
            resultado.agregarUltimo(new Nodo<>(actual.getDato()));
            actual = actual.getProximo();
        }

        // Copiar los elementos de la segunda lista
        actual = lista2.primero;
        while (actual != null) {
            resultado.agregarUltimo(new Nodo<>(actual.getDato()));
            actual = actual.getProximo();
        }

        return resultado;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListaIterator<>(primero);
    }
}
