package co.edu.uniquindio.poo.Ejercicio1.ldobleEnlazada;

import java.util.Iterator;

public class IteradorDoble<T> implements Iterator<T> {
    private NodoDoble2<T> actual;

    public IteradorDoble(NodoDoble2<T> primero) {
        this.actual = primero;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T dato = actual.getElemento();
        actual = actual.getProximo(); // avanzar al siguiente
        return dato;
    }
}
