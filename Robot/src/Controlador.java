import java.util.Scanner;

public class Controlador {

    private int modo = 1;

    private boolean cambiar_modo;

    Scanner entradaScanner = new Scanner(System.in);

    //Robot valkyria = new Robot(1, true, true, true, true,true,true);

    Robot valkyria;

    Pista pista;
 // El constructor Controlador indica que cuando se inicia el programa se crean los objetos valkyria y pista
    Controlador(){

        valkyria = new Robot();
        pista  =   new Pista(101);

    }
    // Se crean los getters an setters de modo, atributo que nos permitira realizar los cambios de estado en el robot
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {

        this.modo = modo;
    }

    // El metodo launcher, sera donde se realize, el andamiaje de nuestroproyecto, este se compone de otros metodos que permitiran realizar las acciones del robot
    public void launcher (){
        int  altura_figther = 0;
        String existe_pista;
        System.out.println(" ***********************************");
        System.out.println(" *            SIMULACION           * ");
        System.out.println(" *                DE               * ");
        System.out.println(" *             OPERACION           * ");
        System.out.println(" *     ROBOT ::: VALKIRIA X1       * ");
        System.out.println(" ***********************************");
        System.out.println("");
        System.out.println("ANTES DE OPERAR EL ROBOT DEBE ESCOGER QUE ARMA(S)");
        valkyria.escogearma();
         System.out.println("#########  SE ESTAN INICIANDO LOS SISTEMAS  ###########");
         System.out.println("  #########        HANGAR LISTO        ###########");
         System.out.println("     #########   AVION PREPARADO   ###########");




        // el siguiente ciclo permite la constante realizacion  de los metodos ubicados dentro de nuestro menu launcher
        while (true) {
            // este ciclo permite que se realizen constantemente  los metodos pertenecientes al estado figther
            while (getModo() == 1)
            {
                System.out.println("### SE ENCUENTRA EN EL MODO FIGHTER ###");
                    // la siguiente condicion permite establecer el metodo a ejecutar si el robot en estado figther, se encuentra ya volando
                    if (valkyria.getAltura()!= 0)
                    {
                      valkyria.menu_figther();
                    }
                    //
                    if(valkyria.getAltura()== 0)
                    {
                    valkyria.Despegue();
                    }
                    setModo(valkyria.getCambio());

                break;
            }
            // este ciclo permite que se realizen constantemente  los metodos pertenecientes al estado gerwalk
            while (getModo() == 2) {

                System.out.println("### SE ENCUENTRA EN EL MODO GERWALK ###");



                valkyria.menu_gerwalk(valkyria.getAltura());

                setModo(valkyria.getCambio());

                break;

            }
            // este ciclo permite que se realizen constantemente  los metodos pertenecientes al estado bablloid
            while (getModo() == 3) {

                System.out.println("### SE ENCUENTRA EN EL MODO Battloid ###");

                valkyria.menu_batloid();

                setModo(valkyria.getCambio());

                break;
            }
        }
    }
}

