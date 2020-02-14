//Martín Jesús Mañas Rivas - 1ºGS - Examen parcial 2º evalución
package examenparcial2ºevalmartinjesusmañasrivas;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Clase grupoAlumnos. Esta es una colección de Alumnos.
 *
 * @author Martín Jesús Mañas Rivas
 */
public class GrupoAlumnos implements Serializable {

  private TreeMap<Integer, Alumno> alumnos;

  public GrupoAlumnos() {
    alumnos = new TreeMap();
  }

  /**
   *
   * @return
   */
  public TreeMap<Integer, Alumno> getAlumnos() {
    return alumnos;
  }

  /**
   *
   * @param alumnos
   */
  public void setAlumnos(TreeMap<Integer, Alumno> alumnos) {
    this.alumnos = alumnos;
  }

  /**
   * Metodo agregarAlumno. Añade un alumno, si no existe.
   *
   * @param a Alumno que queremos añadir
   * @return true o false si se ha podido añadir o no.
   */
  public boolean agregarAlumno(Alumno a) {
    boolean agregado = false; //Si no se agrega devolvera false.
    if (!alumnos.containsKey(a.getId())) { //Si no existe el alumno
      alumnos.put(a.getId(), a);//Añade el alumno dado por parametro.
      agregado = true; //Devuelve true si se ha creado.
    }
    return agregado;
  }

  /**
   * Metodo que elimina un alumno dado un id.
   *
   * @param id
   * @return true o falso si existe el alumno con ese id existe
   */
  public boolean eliminarAlumno(Integer id) {
    boolean eliminado = false; //Devuelve false si no existe 
    if (alumnos.containsKey(id)) { //Si existe el alumno, lo borra.
      alumnos.remove(id);
      eliminado = true; //Devuleve true si existe
    }
    return eliminado;
  }

  /**
   * Metodo muestra un alumno dado su id.
   *
   * @param id
   * @return true o false si existe el alumno o no.
   */
  public boolean mostrarAlumnoPorId(Integer id) {
    boolean existe = false; // Si no existe devuelve false
    if (alumnos.containsKey(id)) { //Si existe el alumno lo muestra y devuelve true
      alumnos.get(id).mostrarAlumno(); //Muestra el alumno dado el id
    }
    return existe;
  }

  /**
   * Metodo que muestra todos los alumnos en la colección
   *
   * @return true o false si la coleccion contiene alumnos
   */
  public boolean mostrarAlumnos() {
    boolean noEstaVacio = false; //Si no hay alumnos devuelve false
    if (!alumnos.isEmpty()) {
      for (Alumno a : alumnos.values()) { //Recorre la colección
        a.mostrarAlumno();
      }
      noEstaVacio = true;
    }
    return noEstaVacio;
  }

  /**
   * Metodo que muestra los alumnos que tengan todo aprobado.
   *
   * @return true o false si la coleccion contiene alumnos
   */
  public boolean mostrarAlumnosAprobados() {
    boolean noEstaVacio = false; //Si no hay alumnos devuelve false
    if (!alumnos.isEmpty()) {
      for (Alumno a : alumnos.values()) { //Recorre la colección
        if (a.estaAprobado()) { // si esta aprobado lo muestro
          a.mostrarAlumno();
        }
      }
      noEstaVacio = true;
    }
    return noEstaVacio;
  }

  /**
   * Metodo que muestra los alumnos que tengan algun suspenso.
   *
   * @return true o false si la coleccion contiene alumnos
   */
  public boolean mostrarAlumnosSuspensos() {
    boolean noEstaVacio = false; //Si no hay alumnos devuelve false
    if (!alumnos.isEmpty()) {
      for (Alumno a : alumnos.values()) { //Recorre la colección
        if (!a.estaAprobado()) { // si esta suspenso lo muestro
          a.mostrarAlumno();
        }
      }
      noEstaVacio = true;
    }
    return noEstaVacio;
  }

}
