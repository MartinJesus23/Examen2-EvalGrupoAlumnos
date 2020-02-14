//Martín Jesús Mañas Rivas - 1ºGS - Examen parcial 2º evalución
package examenparcial2ºevalmartinjesusmañasrivas;

import java.io.Serializable;

/**
 * Clase persona.
 *
 * @author Martín Jesús Mañas Rivas
 * @version 1.0
 */
public class Persona implements Serializable {

  private Integer id;
  private String dni, nombre, apellidos, direccion;

  /**
   * Constructor de persona.
   *
   * @param id
   * @param dni
   * @param nombre
   * @param apellidos
   * @param direccion
   */
  public Persona(Integer id, String dni, String nombre, String apellidos, String direccion) {
    this.id = id;
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.direccion = direccion;
  }

  /**
   * Constructor de persona con otro objeto persona.
   *
   * @param p
   */
  public Persona(Persona p) {
    this.id = p.id;
    this.dni = p.dni;
    this.nombre = p.nombre;
    this.apellidos = p.apellidos;
    this.direccion = p.direccion;
  }

  /**
   * Getter de id
   *
   * @return id de la persona
   */
  public Integer getId() {
    return id;
  }

  /**
   * Setter de id
   *
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Getter de dni
   *
   * @return dni de la persona
   */
  public String getDni() {
    return dni;
  }

  /**
   * Setter de dni
   *
   * @param dni
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * Getter de nombre
   *
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Setter de nombre
   *
   * @param nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Getter de apellidos
   *
   * @return apellidos
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Setter de apellidos
   *
   * @param apellidos
   */
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  /**
   * Getter de direccion
   *
   * @return direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Setter de direccion
   *
   * @param direccion
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Metodo toString() de persona
   *
   * @return toString() de la persona
   */
  @Override
  public String toString() {
    return "Persona{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + '}';
  }

}
