public class Main {
    public static void main(String[] args) {
        Alumno unAlumno = new Alumno();
        unAlumno.setCuenta(2529278);
        unAlumno.setPaterno("Avendano");
        unAlumno.setMaterno("Monroy");
        unAlumno.setNombre("Erica");
        unAlumno.setLicenciatura("Ingenieria en Computacion");
        unAlumno.setDireccion("Ecatepec");
        unAlumno.setTelefono("5512345678");
        unAlumno.setSemestre(3);

        ProcesosBD procesos = new ProcesosBD();

        if (procesos.insertarRegistro(unAlumno)) {
            System.out.println("Registro de prueba insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el registro de prueba.");
        }
    }
}