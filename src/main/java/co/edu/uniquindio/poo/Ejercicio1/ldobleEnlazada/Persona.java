package co.edu.uniquindio.poo.Ejercicio1.ldobleEnlazada;

public class Persona implements Comparable<Persona>{
    private  String cedula;

    public Persona(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public int compareTo(Persona o){
        return this.cedula.compareTo(o.getCedula());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cedula='" + cedula + '\'' +
                '}';
    }
}
