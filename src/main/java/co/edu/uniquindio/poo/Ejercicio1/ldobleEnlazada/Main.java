package co.edu.uniquindio.poo.Ejercicio1.ldobleEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaDobleEnlazada<Persona> personas = new ListaDobleEnlazada<>();
        personas.agregarFinal(new Persona("1234"));
        personas.agregarFinal(new Persona("56789"));
        personas.agregarFinal(new Persona("112233"));
        personas.agregarFinal(new Persona("9988"));

        System.out.println("Lista original:");
        personas.mostrar();

        ListaDobleEnlazada<Persona> parCedulas = personas.obtenerCedulasCantidadPar();

        System.out.println("Personas con cédula de longitud par:");
        parCedulas.mostrar();
    }

        //for (Integer n : lista) {
        //    System.out.println(n);
        //}

        //lista.imprimirHaciaAtras();  // [3, 2, 1]

}
