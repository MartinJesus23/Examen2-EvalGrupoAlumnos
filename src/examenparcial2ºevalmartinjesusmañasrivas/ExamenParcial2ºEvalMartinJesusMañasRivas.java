//Martín Jesús Mañas Rivas - 1ºGS - Examen parcial 2º evalución
package examenparcial2ºevalmartinjesusmañasrivas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Programa que gestiona alumnos. Permite añadir, borrar por id, mostrar alumno
 * por id, mostrar todos los alumnos aprobados, mostrar todos los alumnos
 * suspensos.
 *
 * @author Martín Jesús Mañas Rivas
 * @version 1.0
 */
public class ExamenParcial2ºEvalMartinJesusMañasRivas {

  private static final Scanner teclado = new Scanner(System.in);
  private static GrupoAlumnos grupoAlumnos = cargarProductosDesdeArchivo();

  public static void main(String[] args) {
    int opcion = -1;
    Integer id;

    do {
      mostrarMenu();
      try {
        opcion = teclado.nextInt();
        teclado.nextLine(); //Vaciamos buffer del teclado
        switch (opcion) {
          case 0:
            if (!confirmar("¿Seguro que desea salir(s/n)?:")) { //Si no acepta, no saldra
              opcion = -1;
            }
            break;
          case 1:
            agregarAlumno();
            break;
          case 2:
            System.out.print("Introduzca el id de alumno:");
            id = teclado.nextInt();
            teclado.nextLine(); //Vaciamos buffer del teclado
            agregarMateriasAlAlumno(id);
            break;
          case 3:
            eliminarAlumno();
            break;
          case 4:
            System.out.print("Introduzca el id de alumno:");
            id = teclado.nextInt();
            teclado.nextLine(); //Vaciamos buffer del teclado
            if (!grupoAlumnos.mostrarAlumnoPorId(id)) {
              System.out.println("No existe el alumno.");
            }
            break;
          case 5:
            grupoAlumnos.mostrarAlumnos();
            break;
          case 6:
            grupoAlumnos.mostrarAlumnosAprobados();
            break;
          case 7:
            grupoAlumnos.mostrarAlumnosSuspensos();
            break;
        }
      } catch (Exception e) {
        System.out.println("Error al introducir un dato.");
      }

    } while (opcion != 0);
    guardarProductosAFichero();
  }

  /**
   * Metodo que muestra el menu de la app.
   */
  public static void mostrarMenu() {
    System.out.println("------ Menu de alumnos ------");
    System.out.println("0.Salir de la app\t 1.Añadir alumno\t 2.Añadir materias al alumno\t 3.Borrar alumno por id");
    System.out.println("4.Mostrar un alumno\t 5.Mostrar todos los alumnos.\t 6.Mostrar alumnos aprobados \t 7.Mostrar alumnos suspensos");
    System.out.print("Introduce una opción (0-7)");
  }

  /**
   * Metodo que permite hacer una confirmación de manera estandar. Recibe un
   * texto como pregunta.
   *
   * @param s String texto que mostrara al usuario
   * @return true o false segun haya pulsado 's'i o 'n'o
   */
  public static boolean confirmar(String s) {
    System.out.print(s);
    return (teclado.nextLine().toLowerCase().charAt(0) == 's');
  }

  /**
   * Metodo para agregar alumnos al grupo de alumnos. Permite crear un alumno y
   * añadirle un numero de materias.
   */
  public static void agregarAlumno() {
    boolean salir = false;

    do {
      try {
        System.out.print("Introduzca id numerico del alumno:");
        Integer id = teclado.nextInt();
        teclado.nextLine(); //Limpiar buffer del teclado.

        System.out.print("Introduzca el DNI:");
        String dni = teclado.next();
        teclado.nextLine(); //Limpiar buffer del teclado.
        if (dni.length() < 9) { //Si el dni es menor a 9 lanza un error
          System.out.println("El dni debe tener una longitud de 9.");
          throw new Exception("Longitud de DNI no valida");
        }

        System.out.print("Introduzca el nombre:");
        String nombre = teclado.nextLine();

        System.out.print("Introduzca los apellidos:");
        String apellidos = teclado.nextLine();

        System.out.print("Introduzca la dirección:");
        String direccion = teclado.nextLine();

        Alumno a = new Alumno(id, dni, nombre, apellidos, direccion);
        a.mostrarAlumno();

        if (confirmar("\n¿Son correctos los datos(s/n)?:")) { //Si no son correctos empezara de nuevo
          if (confirmar("¿Desea añadir materias(s/n)?:")) { // Si no quiere, finaliza y añade el alumno si no existe.
            if (grupoAlumnos.agregarAlumno(a)) { //Añade el alumno y comprueba que no exista
              System.out.println("Alumno añadido correctamente.");
            } else {
              System.out.println("Error: ya existe un alumno con ese codigo.");
              grupoAlumnos.mostrarAlumnoPorId(id);
              throw new Exception("Error: ya existe el alumno.");
            }
            agregarMateriasAlAlumno(id);
            System.out.println("Alumno y materias creadas correctamente.");
          } else {
            if (grupoAlumnos.agregarAlumno(a)) { //Añade el alumno y comprueba que no exista
              System.out.println("Alumno añadido correctamente.");
            } else {
              System.out.println("Error: ya existe un alumno con ese codigo.");
              grupoAlumnos.mostrarAlumnoPorId(id);
            }
          }
          salir = true;
        }
      } catch (Exception e) {
        System.out.println("Error al introducir los datos.");
      }
    } while (!salir);
  }

  /**
   * Metodo para crear una materia.
   *
   * @return devuelve la materia creada
   */
  public static Materia crearMateria() {
    boolean creada = false;
    Materia m = null;
    do {
      try {
        System.out.print("Introduzca el nombre de la materia:");
        String nombre = teclado.nextLine();

        System.out.print("Introduzca nota de la 1º evaluación:");
        double eval1 = teclado.nextDouble();
        teclado.nextLine(); //vaciar buffer del teclado

        System.out.print("Introduzca nota de la 2º evaluación:");
        double eval2 = teclado.nextDouble();
        teclado.nextLine(); //vaciar buffer del teclado

        System.out.print("Introduzca nota de la 3º evaluación:");
        double eval3 = teclado.nextDouble();
        teclado.nextLine(); //vaciar buffer del teclado

        m = new Materia(nombre, eval1, eval2, eval3);
        System.out.println(m);

        if (confirmar("¿Es correcta la materia (s/n)?:")) {
          System.out.println("Materia creada correctamente");
          creada = true;
        }
      } catch (Exception e) {
        System.out.println("Error al introducir datos.");
      }
    } while (!creada);

    return m;
  }

  public static void agregarMateriasAlAlumno(Integer id) {
    if (grupoAlumnos.getAlumnos().containsKey(id)) {
      System.out.print("¿Cuantas materias desea añadir?:");
      int numMaterias = teclado.nextInt();
      teclado.nextLine(); //Limpiar buffer del teclado.

      Alumno a = grupoAlumnos.getAlumnos().get(id); //Accedemos al puntero del alumno

      for (int i = 1; i <= numMaterias; i++) {
        System.out.println("Materia nº" + i);
        a.agregarMateria(crearMateria());
      }

    } else {
      System.out.println("No existe el alumno con ese id.");
    }
  }

  public static void eliminarAlumno() {
    System.out.print("Introduzca el id numerico del alumno:");
    Integer id = teclado.nextInt();
    teclado.nextLine(); //Limpiar buffer

    if (grupoAlumnos.eliminarAlumno(id)) { //Si devuelve true se habra eliminado
      System.out.println("Eliminado correctamente");
    } else { //No se habra eliminado
      System.out.println("Error: El alumno no existe");
    }

  }

  public static GrupoAlumnos cargarProductosDesdeArchivo() {
    GrupoAlumnos gA = null;
    ObjectInputStream entrada;
    File ruta = new File("C:\\GrupoAlumnos");
    File archivo = new File(ruta + "\\alumnos.dat");
    try {
      if (!archivo.exists()) { //si no existe creamos la ruta y el archivo
        ruta.mkdirs(); //Crea la carpeta
        archivo.createNewFile(); //Crea el archivo vacio
        System.out.println("Creando archivos necesarios.");
      } else {
        entrada = new ObjectInputStream(new FileInputStream(archivo));
        gA = (GrupoAlumnos) entrada.readObject();
        entrada.close();
        System.out.println("Datos cargados correctamente.");
      }
    } catch (IOException | ClassNotFoundException e) {
      gA = new GrupoAlumnos();
    }
    return gA;
  }

  public static void guardarProductosAFichero() {
    ObjectOutputStream salida;
    File ruta = new File("C:\\GrupoAlumnos");
    File archivo = new File(ruta + "\\alumnos.dat");
    try {
      if (!archivo.exists()) { //si no existe creamos la ruta y el archivo
        ruta.mkdirs(); //Crea la carpeta
        archivo.createNewFile(); //Crea el archivo vacio
      } else {
        salida = new ObjectOutputStream(new FileOutputStream(archivo));
        salida.writeObject(grupoAlumnos);
        salida.close();
        System.out.println("Guardado correctamente.");
      }
    } catch (IOException e) {
    }
  }

}
