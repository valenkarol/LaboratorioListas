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
    public void mostrar(){
        Nodo<T> actual=primero;
        String mensaje="[";
        do {
            mensaje+=actual.getDato();
            actual=actual.getProximo();
        }while (actual != null);
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
    @Override
    public Iterator<T> iterator() {
        return new ListaIterator<>(primero);
    }
}
