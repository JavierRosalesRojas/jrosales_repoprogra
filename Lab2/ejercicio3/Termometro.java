public class Termometro {
    private int temperatura;
    private int agitada;

    public Termometro() {
        this.agitada = 0;
    }
    public void agitar(){
        this.agitada +=1;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;

    }

    public int getAgitada() {
        return agitada;
    }

    public void setAgitada(int agitada) {
        this.agitada = agitada;
    }
}


