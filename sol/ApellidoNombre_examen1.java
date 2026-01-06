import java.util.Scanner;

public class ApellidoNombre_examen1 {
    // Función que calcula el IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos datos
        System.out.print("Introduce tu peso (kg): ");
        double peso = sc.nextDouble();

        System.out.print("Introduce tu altura (m): ");
        double altura = sc.nextDouble();

        // Calculamos IMC usando la función
        double imc = calcularIMC(peso, altura);

        // Clasificamos con condicionales
        String clasificacion;
        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25) { // 18.5–24.9
            clasificacion = "Normal";
        } else if (imc < 30) { // 25.0–29.9
            clasificacion = "Sobrepeso";
        } else { // >= 30
            clasificacion = "Obesidad";
        }

        // Mostramos resultados
        System.out.println("Tu IMC es " + imc);
        System.out.println("Clasificación: " + clasificacion);

        sc.close();
    }
}
