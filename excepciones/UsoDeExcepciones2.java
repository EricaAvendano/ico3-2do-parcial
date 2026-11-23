public class UsoDeExcepciones2 {
    public static void main(String args[]) {
        try { // llama a lanzaExcepcion para demostrar la limpieza de la pila
            lanzaExcepcion();
        } 
        catch (Exception excepcion) { // excepción lanzada en lanzaExcepcion
            System.err.println("La excepción se manejó en main");
        } 
    } 

    // lanzaExcepcion lanza la excepción que no se atrapa en este método
    public static void lanzaExcepcion() throws Exception {
        try { 
            System.out.println("Método lanzaExcepcion");
            throw new Exception(); // genera la excepción
        } 
        catch (RuntimeException runtimeException) { // atrapa el tipo incorrecto
            System.err.println("La excepción se manejó en el método lanzarExcepcion");
        }
        finally { // el bloque finally siempre se ejecuta
            System.err.println("Finally siempre se ejecuta");
        } 
    } 
} 