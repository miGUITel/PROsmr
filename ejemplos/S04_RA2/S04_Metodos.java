public class S04_Metodos {
    public static void saludar(String nombre) { //1
        System.out.println("Hola, " + nombre);
    }

    public static int duplicar(int numero) { //2
        return numero * 2;
    }

    public static void main(String[] args) { //3
        saludar("SMR");
        int resultado = duplicar(12);
        System.out.println("El doble de 12 es " + resultado);
    }
}
