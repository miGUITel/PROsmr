public class S02_Conversiones {
    public static void main(String[] args) {
        int gigabytesEnteros = 16;
        double gigabytesDecimales = gigabytesEnteros;

        double medidaReal = 7.9;
        int medidaRecortada = (int) medidaReal;

        String textoRam = "32";
        int ramNumerica = Integer.parseInt(textoRam);
        String ramDeNuevoComoTexto = String.valueOf(ramNumerica);

        System.out.println("int a double: " + gigabytesDecimales);
        System.out.println("double a int: " + medidaRecortada);
        System.out.println("String a int: " + ramNumerica);
        System.out.println("int a String: " + ramDeNuevoComoTexto + " GB");

        int divisionEntera = 5 / 2;
        double divisionDecimal = 5.0 / 2;
        System.out.println("5 / 2 = " + divisionEntera);
        System.out.println("5.0 / 2 = " + divisionDecimal);
    }
}

