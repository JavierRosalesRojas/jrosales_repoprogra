public class Gerwalk {

    private int altura;

    Brazo B1;
    Pierna P1,P2;
    Ala a1, a2;

    public Gerwalk() {

        B1 = new Brazo();
        a1 = new Ala();
        a2 = new Ala();
        P1 = new Pierna();
        P2 = new Pierna();

    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
