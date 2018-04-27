import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String arg[]) {

        Termometro a1 = new Termometro();

        System.out.println("Ingrese un 1 para inicializar su termometro ");
        Scanner entradaEscaner = new Scanner(System.in);
        a1.setAgitada(entradaEscaner.nextInt());
        int temp = 0;

        if (a1.getAgitada() == 1){
            //generar numero random 1-10
             temp = 35 + (int)(Math.random() * ((40 - 35)+1));

            //llamar funcion setTemp para asignar
            a1.setTemperatura(temp);
            System.out.println(" Su temperatura es :"+temp);
            a1.setAgitada(2);

        }
        else {
            System.out.println("debe Agitar su termometro nuevamnte");
        }



        if (a1.getAgitada() ==2){
            int randomNum=35 + (int)(Math.random() * ((40 - 35)+1));
            System.out.println(" La temperatura de Juanito es : "+randomNum);

            int promedio;
            promedio = (randomNum + temp)/2;

            System.out.println("La Temperatura Final es de : "+ promedio + " grados");
        }




    }

}
