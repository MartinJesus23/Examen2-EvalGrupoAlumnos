//Martín Jesús Mañas Rivas - 1ºGS - Examen parcial 2º evalución
package examenparcial2ºevalmartinjesusmañasrivas;

import java.io.Serializable;

/**
 * Clase materia.
 *
 * @author Martín Jesús Mañas Rivas
 * @version 1.0
 */
public class Materia implements Serializable {

  private String nombre;
  private double eval1, eval2, eval3;

  /**
   * Constructor de clase materia.
   *
   * @param nombre
   * @param eval1
   * @param eval2
   * @param eval3
   */
  public Materia(String nombre, double eval1, double eval2, double eval3) {
    this.nombre = nombre;
    this.eval1 = eval1;
    this.eval2 = eval2;
    this.eval3 = eval3;
  }

  /**
   * Constructor de clase materia dado un objeto materia.
   *
   * @param m
   */
  public Materia(Materia m) {
    this.nombre = m.nombre;
    this.eval1 = m.eval1;
    this.eval2 = m.eval2;
    this.eval3 = m.eval3;
  }

  /**
   * Getter de nombre.
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
   * Getter de eval1
   *
   * @return eval1
   */
  public double getEval1() {
    return eval1;
  }

  /**
   * Setter de eval1
   *
   * @param eval1
   */
  public void setEval1(double eval1) {
    this.eval1 = eval1;
  }

  /**
   * Getter de eval2
   *
   * @return eval2
   */
  public double getEval2() {
    return eval2;
  }

  /**
   * Setter de eval2
   *
   * @param eval2
   */
  public void setEval2(double eval2) {
    this.eval2 = eval2;
  }

  /**
   * Getter de eval3
   *
   * @return eval3
   */
  public double getEval3() {
    return eval3;
  }

  /**
   * Setter de eval3
   *
   * @param eval3
   */
  public void setEval3(double eval3) {
    this.eval3 = eval3;
  }

  /**
   * Metodo toString() de materia.
   *
   * @return
   */
  @Override
  public String toString() {
    return "Materia{" + "nombre=" + nombre + ", eval1=" + eval1 + ", eval2=" + eval2 + ", eval3=" + eval3 + '}';
  }

}
