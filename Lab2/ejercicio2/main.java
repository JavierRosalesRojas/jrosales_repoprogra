import java.util.Scanner;
public class main {

    public static void main (String arg[]){

        String color, dueño;
        Scanner entradaEscaner = new Scanner(System.in);

        System.out.println("Ingrese el color de la rana 1: ");
        color = entradaEscaner.nextLine();

        System.out.println("Ingrese el dueño de la rana 1: ");
        dueño = entradaEscaner.nextLine();

        Rana r1 = new Rana(color,dueño);

        System.out.println("Ingrese el color de la rana 2: ");
        color = entradaEscaner.nextLine();

        System.out.println("Ingrese el dueño de la rana 2: ");
        dueño = entradaEscaner.nextLine();

        Rana r2 = new Rana(color,dueño);

        




    }
}
