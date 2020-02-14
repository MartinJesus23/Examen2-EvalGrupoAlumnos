//Martín Jesús Mañas Rivas - 1ºGS - Examen parcial 2º evalución
package examenparcial2ºevalmartinjesusmañasrivas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase alumno. Extiende la clase persona, y ademas contiene una colección de
 * Materias.
 *
 * @author Martín Jesús Mañas Rivas
 * @version 1.0
 */
public class Alumno extends Persona implements Serializable, Comparable {

  private List<Materia> materias;

  /**
   * Constructor de alumno.
   *
   * @param id
   * @param dni
   * @param nombre
   * @param apellidos
   * @param direccion
   */
  public Alumno(Integer id, String dni, String nombre, String apellidos, String direccion) {
    super(id, dni, nombre, apellidos, direccion);
    materias = new ArrayList();
  }

  /**
   * Constructor de alumno dado otro objeto alumno
   *
   * @param a Alumno
   */
  public Alumno(Alumno a) {
    super(a.getId(), a.getDni(), a.getNombre(), a.getApellidos(), a.getDireccion());
    materias = new ArrayList(a.materias);
  }

  /**
   * Metodo que añade una materia al alumno
   *
   * @param m
   */
  public void agregarMateria(Materia m) {
    materias.add(m);
  }

  public void mostrarAlumno() {
    System.out.println("Alumno|-> " + "id:" + this.getId() + " DNI:" + this.getDni() + " Nombre:" + this.getNombre() + " Apellidos:" + this.getApellidos() + "Dirección" + this.getDireccion());
    System.out.println("-Materias");
    mostrarMaterias();
  }

  public void mostrarMaterias() {
    if (!materias.isEmpty()) { //Si tiene materias las muestra
      for (Materia m : materias) {
        System.out.println("\t" + "-" + m);
      }
    } else { // si no tiene dice que tiene 0 materias
      System.out.print("Aún no tiene materias.");
    }
  }

  /**
   * Metodo para comprobar si el alumno tiene alguna materia suspensa.
   *
   * @return true o false si se ha encontrado o no alguna materia suspensa.
   */
  public boolean estaAprobado() {
    boolean aprobado = true; // Devuelve true mientras que no encuentre una materia suspensa

    if (!materias.isEmpty()) { //Si no esta vacio..
      for (int i = 0; i < materias.size() && aprobado; i++) { //El bucle recorre todas las materias o hasta que haya algun suspenso.
        Materia m = materias.get(i); //Sacamos una materia hasta llegar al final o que haya una suspensa
        if ((m.getEval1() < 5) && (m.getEval2() < 5) && (m.getEval3() < 5)) { // Si en alguna evaluación alguna materia esta por debajo de 5 estara suspenso.
          aprobado = false;
        }
      }
    } else { // Si esta vacio...
      aprobado = false; // Si no tiene materias devuelve false
    }
    return aprobado;
  }

  @Override
  public int compareTo(Object o) {
    Alumno a = (Alumno) o;
    return this.getId().compareTo(a.getId());
  }

}
