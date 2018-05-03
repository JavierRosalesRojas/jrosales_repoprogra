import java.util.Scanner;
public class Pista {
   private int largo_pista;
    Scanner entradaScanner = new Scanner(System.in);

    public Pista() {
        this.largo_pista = largo_pista;
    }

    public int getLargo_pista() {
        return largo_pista;
    }

    public void setLargo_pista(int largo_pista) {
        this.largo_pista = largo_pista;
    }

    int metros_pista = 0 ;
    void Fight()
    {
        System.out.println("Ingrese metros de la pista : " );
        metros_pista = entradaScanner.nextInt();
        System.out.println("los metros de la pista son " + metros_pista);

    }

}
