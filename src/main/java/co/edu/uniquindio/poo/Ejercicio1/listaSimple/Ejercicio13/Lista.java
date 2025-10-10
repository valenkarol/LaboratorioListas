package co.edu.uniquindio.poo.Ejercicio1.listaSimple.Ejercicio13;

public class Lista {
    NodoLista inicio;

    public Lista() {
        inicio = null;
    }

    public void agregar(int dato) {
        if (inicio == null) {
            inicio = new NodoLista(dato, null);
        } else {
            NodoLista actual = inicio;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = new NodoLista(dato, null);
        }
    }

    // Método público
    public int maxDistancia(int clave) {
        return maxDistanciaRec(inicio, clave, 0, -1, 0);
    }

    /**
     * @param nodo nodo actual
     * @param clave valor que buscamos
     * @param distancia distancia actual desde la última aparición de la clave
     * @param ultimaPos distancia desde la última clave encontrada (-1 si no se ha encontrado aún)
     * @param maxDist máxima distancia encontrada hasta ahora
     * @return máxima distancia entre dos nodos con valor clave
     */
    private int maxDistanciaRec(NodoLista nodo, int clave, int distancia, int ultimaPos, int maxDist) {
        // Caso base: fin de la lista
        if (nodo == null) {
            return maxDist;
        }

        if (nodo.dato == clave) {
            // Si ya había una clave anterior
            if (ultimaPos != -1) {
                if (distancia > maxDist) maxDist = distancia;
            }
            // Reiniciamos la distancia
            distancia = 0;
            ultimaPos = 0;
        } else if (ultimaPos != -1) {
            // Incrementamos distancia solo si ya habíamos encontrado una clave antes
            distancia++;
        }

        // Llamada recursiva
        return maxDistanciaRec(nodo.sig, clave, distancia, ultimaPos, maxDist);
    }

    // Mostrar lista
    public void mostrar() {
        NodoLista actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.sig;
        }
        System.out.println("null");
    }
}
