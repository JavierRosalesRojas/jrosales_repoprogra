public class Contenedor {
    Battloid robot;
    Fight avion;
    Gerwalk hibrido;
    Pista pista;


    public Contenedor() {

    avion = new  Fight();
    hibrido = new Gerwalk();
    robot = new Battloid();


    }
    void Crear_armas(String x , String y  )
    {
        avion.arma1.setTipo_arma(x);
    }


}
