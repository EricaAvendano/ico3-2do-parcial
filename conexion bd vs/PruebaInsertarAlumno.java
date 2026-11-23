import java.util.Scanner;

public class PruebaInsertarAlumno {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        ProcesosBD procesoInsertar = new ProcesosBD();
        Scanner entrada = new Scanner(System.in);

        System.out.println("REGISTRO DE ALUMNOS");
        System.out.println("Ingrese los datos del alumno a registrar en la base de datos:");

        System.out.print("Número de cuenta: ");
        alumno.setCuenta(entrada.nextInt());
        entrada.nextLine();

        System.out.print("Apellido paterno: ");
        alumno.setPaterno(entrada.nextLine());

        System.out.print("Apellido materno: ");
        alumno.setMaterno(entrada.nextLine());

        System.out.print("Nombre: ");
        alumno.setNombre(entrada.nextLine());

        System.out.print("Direccion: ");
        alumno.setDireccion(entrada.nextLine());

        System.out.print("Numero telefonico: ");
        alumno.setTelefono(entrada.nextLine());

        System.out.print("Licenciatura: ");
        alumno.setLicenciatura(entrada.nextLine());

        System.out.print("Semestre: ");
        alumno.setSemestre(entrada.nextInt());
        entrada.nextLine();

        if (procesoInsertar.insertarRegistro(alumno)) {
            System.out.println("\n¡Datos guardados con éxito en la base de datos!");
        } else {
            System.out.println("\nNo se pudieron guardar los datos.");
        }

        entrada.close();
    }
}