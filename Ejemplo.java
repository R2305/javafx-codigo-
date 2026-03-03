public class Ejemplo {
    
    /**
     * Método que suma dos números
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public static int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Método que multiplica dos números
     * @param a primer número
     * @param b segundo número
     * @return el producto de a y b
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    
    /**
     * Método que imprime un mensaje de saludo
     * @param nombre el nombre de la persona
     */
    public static void saludar(String nombre) {
        System.out.println("¡Hola, " + nombre + "!");
    }
    
    /**
     * Método principal para ejecutar el programa
     */
    public static void main(String[] args) {
        System.out.println("=== Programa de Ejemplo ===");
        
        int resultado1 = sumar(5, 3);
        System.out.println("Suma de 5 + 3 = " + resultado1);
        
        int resultado2 = multiplicar(4, 7);
        System.out.println("Multiplicación de 4 × 7 = " + resultado2);
        
        saludar("Usuario");
    }
}
