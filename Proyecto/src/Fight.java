import java.util.Scanner;
public class Fight {

    private int altura;
    private int velocidad_min;
    private int velocidad_max;

    Pista pista;
    Ala a1, a2;
    Arma arma1, arma2, arma3, arma4;

    public Fight() {
        pista = new Pista();
        a1 = new Ala();
        a2 = new Ala();
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getVelocidad_min() {
        return velocidad_min;
    }

    public void setVelocidad_min(int velocidad_min) {
        this.velocidad_min = velocidad_min;
    }

    public int getVelocidad_max() {
        return velocidad_max;
    }

    public void setVelocidad_max(int velocidad_max) {
        this.velocidad_max = velocidad_max;
    }

}
