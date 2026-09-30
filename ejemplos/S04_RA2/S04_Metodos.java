public class S04_Metodos {
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }

    public static int duplicar(int numero) {
        return numero * 2;
    }

    public static void main(String[] args) {
        saludar("SMR");
        int resultado = duplicar(6);
        System.out.println("El doble de 6 es " + resultado);
    }
}
