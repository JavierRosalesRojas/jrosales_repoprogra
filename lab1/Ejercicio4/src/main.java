import java.util.Scanner;

public class main {
    public static void main (String[]args){
        Recorrido r;
        int tarifa;

        r = new Recorrido();

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el valor minimo del Taxi :");
        int numero = sc.nextInt();

        System.out.println("Ingrese los kilometros recorridos arriba del taxi:");
        int numero1 = sc.nextInt();

        System.out.println("Ingrese el tiempo que anduvo arriba del taxi :");
        int numero2 = sc.nextInt();

        tarifa = numero + (numero1 * 150) + (numero2 * 60);

        System.out.println("Toral a Pagar: " + tarifa);

    }
}
