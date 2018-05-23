
import java.util.Scanner;
import static java.lang.Math.random;

public class Robot {
    int velocidad;
    int altura;
    int cambio;

    Pista pista;
    Pierna pierna_izq,pierna_der;
    Ala ala_izq,ala_der;
    Brazo brazo_izq,brazo_der;
    Cabeza cabeza;
    Arma arma_1,arma_2,arma_3,arma_4;
  // se presenta el constructor de la clase robot la cual permitira la composicion de este en sus distintas partes
    private int modo;
    public Robot () {

        if (this.modo==1){
             ala_izq = new Ala();
             ala_der = new Ala();
             arma_1= new Arma();
             arma_2=new Arma();
             arma_3=new Arma();
             arma_4=new Arma();
        }
        else if (this.modo == 2){
            // Alas
             ala_izq = new Ala();
             ala_der = new Ala();
            // Brazos
             brazo_der = new Brazo(true);
             brazo_izq = new Brazo(false);
            //Piernas
             pierna_izq = new Pierna();
             pierna_der = new Pierna();

            arma_1= new Arma();
            arma_2=new Arma();
            arma_3=new Arma();
            arma_4=new Arma();
        }else{
            //Cabeza
             cabeza = new Cabeza();
            //Brazos
             brazo_der = new Brazo(true);
             brazo_izq = new Brazo(true);
            //Piernas
             pierna_izq = new Pierna();
             pierna_der = new Pierna();
             arma_1= new Arma();
             arma_2=new Arma();
             arma_3=new Arma();
             arma_4=new Arma();
        }
    }
   // El siguiente metodo permite, a traves de una funcion random, realizar variaciones de la velocidad, para los estados figther y gerwalk de acuerdo se pida
    int aumentar_vel_vuelo()
    {
        int  aumento_de_vel = (int) (Math.random() * 150) + 1;
       return  aumento_de_vel;
    }
    // El siguiente metodo permite, a traves de una funcion random, realizar variaciones de la altura , para los estados figther y gerwalk de acuerdo se pida

    int cambio_altura()
    {
         int cambio_alt = (int) (Math.random() * 200) + 1;
        return  cambio_alt;
    }
    // el metodo disparar permite, simular los disparos del robot a traves de condiciones, que piden ṕarametros especificos (en este caso ingresar la letra f)
    void disparar()
    {
        Scanner dispara = new Scanner(System.in);
        String disparo;
        System.out.println(" ¿desea disparar? ingrese(si/no)");
        // disparo es una variable tipo string que recibira un valor ingresado por consola,  para permitir generar el disparo
        disparo = dispara.nextLine();
        // la siguiente condicion establece que, si el parametro ingresado corresponde si, se realize la accion de, "poner el dedo en el gatillo", para posteriormente disparar
        if(disparo.equals("si"))
        {
            // el siguiente ciclo establece la accion que se encuentra en el interior,  se realizara siempre, hasta que se tope con un break
            while(true)
            {
                System.out.println(" * * * PARA  DISPARAR  PRESIONE f * * * ");
                // disparo es una variable tipo string que recibira un valor ingresado por consola, en esta caso la letra f ya sea en su formato mayuscula y minuscula
                disparo = dispara.nextLine();
                if (disparo.equals("f")|| disparo.equals("F"))
                {
                    System.out.println("¡¡¡ BOOOM!!!  HA DISPARADO ");
                    System.out.println(" PARA DEJAR DE DISPARAR PRESCIONE CUALQUIER OTRA LETRA ");
                    System.out.println("  ");

                }
                // Esta condicion establece que si  el parametro ingresado es distinto de f o F, el sistema arroje un mensaje diciendo que ha dejado de disparar
                if (!disparo.equals("f") || disparo.equals("F"))
                {
                    System.out.println("ha dejado de disparar");
                    break;
                }
            }
        }
    //  En la siguiente condicion se dicta que si se ingresa un parametro o valor distinto de si, no se concrete la accion de disparar y en cambio se arroje el mensaje, no dispara
        else;   if  (!disparo.equals("si"))
    {
        System.out.println("no disparara");
    }
    }

    // el metodo despegue establece el inicio del vuelo del robot, este encontrandose en modo figther, donde tambien se encuentra un menu de opciones,

    // cabe destacar que este metodo se utiliza cada vez que la altura del robot es 0
    int Despegue ()
    {
        // este conjunto de variables son las que utilizaremos para dar las variaciones correspondientes a altura, velocidad y la opcion de poder escojer la cantidad de opciones existentes en el menu
        String existe_pista, escojer, aumentar_velocidad, aumentar_altura;
        Scanner menu_F = new Scanner(System.in);
        Scanner validar = new Scanner(System.in);

        System.out.println("¿Existe alguna pista para poder despegar? ingrese (si//no) ");

        existe_pista = menu_F.nextLine();
            // la condicion siguiente  establece que si la variable,  existe_pista  recive como parametro un si, se ejecutaran las opciones que estan contenidas dentro
        if(existe_pista.equals("si") )
        {
            System.out.println(" PARA PODER DESPEGAR REQUIERE UNA VELOCIDAD MINIMA DE 350 KM/H");
            System.out.println("PARA AUMENTAR LA VELOCIDAD INGRESE << F >>");
            aumentar_velocidad = validar.nextLine();
            // En la condicion siguiente se establece que la accion de aumentar la velocidad de vuelo se ejutara solo si, la variable aumentar velocidad, recibe como parametro un si
            if (aumentar_velocidad.equals("F")|| aumentar_velocidad.equals("f"))
            {

                velocidad = velocidad + aumentar_vel_vuelo();

                System.out.println(" Su velocidad es  "+ velocidad );
            }

            // dentro de los requisitos del proyecto se incluye que solo se pueda despegar en modo figther si la velocidad es menor a 350 Km/H
            // El siguiente ciclo se ejutara siempre que la velocidad, sea menor a 350, esto nos ayuda a asegurarnos a que solamente, se despegue si cumple con la condicion
            // logrando que el usurario suba la velocidad, a traves de consola hasta que se cumpla el valor
            while(velocidad < 350)
            {
                setAltura(0);
                System.out.println(" ## La velocidad es insuficiente para despegar ##");
                System.out.println("PARA AUMENTAR LA VELOCIDAD INGRESE < < F > >");

                aumentar_velocidad = validar.nextLine();
                // se establece la condicion de que solamente se aumente la velocidad si el parametro ingresado es f en sus formatos mayuscula o minuscula
                if (aumentar_velocidad.equals("F")|| aumentar_velocidad.equals("f"))
                {
                    // se establece la operatoria para el aumento de la velocidad
                    velocidad = velocidad + aumentar_vel_vuelo();

                    System.out.println(" Su velocidad es: "+ velocidad);
                }
                // la siguiente condicion estable que si el usuario ingresa un parametro distinto de los ya establecidos f y F) se imprima un menaje advirtiendo el error de ingreso y que porfavor ingrese un parametro correcto
                if (!aumentar_velocidad.equals("F") && !aumentar_velocidad.equals("f"))
                {
                    System.out.println(" A ingresado caracter no aceptado, no aumenta velocidad");
                }
            }
            // la condicion siguiente establece que solamente se pueda producir un despegue si el avion se encuentra entre los parametros limites de velocidad (350 y 750)
            if (velocidad > 350 && velocidad < 750)
            {
                System.out.println(velocidad + "la velocidad es esta");
                System.out.println("PRESENTA UNA VELOCIDAD OPTIMA PARA EL DESPEGUE");
                System.out.println("PARA DESPEGAR REQUIERE ELEVAR SU ALTURA ");
                System.out.println("INGRESE < < S > > PARA AUMENTAR ALTURA");
                aumentar_altura = validar.nextLine();
                // el ciclo posterior permite realiar un aumento de altura, permitiendo que si el usuario ingresa un valor disinto al requerido, este pueda ingresar nuevamente un dato correcto
                while(true)
                {
                    // la siguiente condicion establece que si se ingresa la letra s como parametro (en sus formatos mayuscula y minuscula), sea posible aumentar la altura
                    if(aumentar_altura.equals("S") || aumentar_altura.equals("s") )
                    {
                        altura = cambio_altura() + altura;
                        System.out.println("SU ALTURA ES "+  altura );
                        setAltura(altura);
                        System.out.println("# # # HA DESPEGADO # # #");
                        break;
                    }
                        System.out.println("¡¡¡¡LETRA NO VALIDA!!!!!, POR FAVOR ");
                        System.out.println("INGRESE < < S > > PARA AUMENTAR ALTURA");
                        aumentar_altura = validar.nextLine();
                }

                while (velocidad > 350 && velocidad < 750 )
                {
                    System.out.println(" ****** > > Puede realizar en este momento las siguientes opciones < < ****** ");
                    System.out.println(" Ingrese < < <  A  > > > para disparar ");
                    System.out.println(" Ingrese < < <  S  > > > para  aumentar la altura ");
                    System.out.println(" Ingrese < < <  D  > > > para  disminuir la altura");
                    System.out.println(" Ingrese < < <  F  > > > para   aumentar la velocidad ");
                    if(velocidad > 350) {
                        System.out.println(" Ingrese < < <  G  > > > para   disminuir la velocidad ");

                    }
                    System.out.println(" Ingrese < < <  Q  > > > para   pasar a modo BATTLOID ");
                    System.out.println(" Ingrese < < <  W  > > > para   pasar a modo GERWALK ");

                    escojer = validar.nextLine();
                        // la siguiente condicion establece que si se ingresa como parametro la letra a en sus formatos mayuscula o minuscula, se ejecutara el metodo disparar
                    if (escojer.equals("A") || escojer.equals("a"))
                    {
                      disparar();
                    }
                    // la siguiente condicion establece que si se ingresa la letra s como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la altura
                    if (escojer.equals("S") || escojer.equals("s"))
                    {
                        altura =  altura +  cambio_altura() ;
                        System.out.println(" esta es su nueva altura "+ altura);
                    }
                    // la siguiente condicion establece que si se ingresa la letra D como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la altura
                    if ( escojer.equals("D") || escojer.equals("d"))
                    {
                        altura =  altura - cambio_altura();
                        // la siguiente condicion establece que si la resta de altura  con el metodo cambio_altura(),  es menor a 0,  se establesca como altura, solo 0, ya que no puede existir una altura negativa para terminos del proyecto
                        if (altura <= 0)
                        {
                            altura = 0;
                        }
                        System.out.println(" esta es su nueva altura "+ altura);
                    }

                    // la siguiente condicion establece que si se ingresa la letra f como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la velocidad

                    if (escojer.equals("F") || escojer.equals("f"))
                    {
                        velocidad =  + velocidad + aumentar_vel_vuelo();
                        // esta condicion establece que si el usuario desea aumentar la velocidad a un valor mas alla de 750, no pueda ya que 750 es el valor max de velocidad
                        if(velocidad >= 750)
                        {
                            velocidad = 750;

                            System.out.println(" esta es su nueva velocidad " + velocidad);

                            System.out.println("Ha alcanzado la velocidad máxima");

                        }
                        else {
                            System.out.println(" esta es su nueva velocidad " + velocidad);
                        }
                    }
                    // la siguiente condicion establece que si se ingresa la letra G como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la velocidad

                    if (escojer.equals("G") || escojer.equals("g"))
                    {

                        velocidad =  velocidad - aumentar_vel_vuelo() ;

                        System.out.println(" esta es su nueva velocidad " + velocidad);
                        // esta condicion establece que si el usuario desea disminuir la velocidad a un valor mas alla de 350, no pueda ya que 350 es el valor max de velocidad
                        if(velocidad <= 350 )
                        {
                            velocidad = 350;
                        }
                    }
                    // Esta condicion indica que si se ingresa como parametro la letra q en formato q y Q el robot pueda pasar al modo batlloid, eso si siempre, tomando en cuenta una altura max de 200 para transformarse
                    if (escojer.equals("Q") || escojer.equals("q"))
                    {
                        if(altura > 200)
                        {
                            System.out.println(" ¡¡¡ LA ALTURA ES MUY GRANDE PARA INICIALIZAR EL PASO AL ESTADO BATTLOID");

                        }
                        if(altura <= 200)
                        {

                            setAltura(0);
                            setVelocidad(0);
                            setCambio(3);
                            break;
                        }
                    }
                    // Esta condicion indica que si se ingresa como parametro la letra q en formato W y w el robot pueda pasar al modo gerwalk

                    if (escojer.equals("W") || escojer.equals("w"))
                    {
                        setCambio(2);
                        break;
                    }


                }


            }

        }
         if (existe_pista.equals("no"))
        {



        }
            return getCambio();
    }

    void menu_figther()
    {
        String choise_figther;
        Scanner menu_figther = new Scanner(System.in);
        while (true)
        {
            System.out.println(" ****** > > Puede realizar en este momento las siguientes opciones < < ****** ");

            System.out.println(" Ingrese < < <  A  > > > para disparar ");

            System.out.println(" Ingrese < < <  S  > > > para  aumentar la altura ");

            System.out.println(" Ingrese < < <  D  > > > para  disminuir la altura");

            if(velocidad<750) {
                System.out.println(" Ingrese < < <  F  > > > para   aumentar la velocidad ");
            }
            if(velocidad>350) {
                System.out.println(" Ingrese < < <  G  > > > para   disminuir la velocidad ");

            }
            System.out.println(" prescione < < <  Q  > > > para   pasar a modo BATTLOID ");

            System.out.println(" prescione < < <  W  > > > para   pasar a modo GERWALK ");


            choise_figther  = menu_figther.nextLine();
            // la siguiente condicion establece que si se ingresa como parametro la letra a en sus formatos mayuscula o minuscula, se ejecutara el metodo disparar
            if (choise_figther.equals("A") || choise_figther.equals("a"))
            {
                disparar();
            }
            // la siguiente condicion establece que si se ingresa la letra s como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la altura
            if (choise_figther.equals("S") || choise_figther.equals("s"))
            {
                altura = cambio_altura() + altura;
                System.out.println(" esta es su nueva altura "+ altura);
            }
            // la siguiente condicion establece que si se ingresa la letra D como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la altura
            if (choise_figther.equals("D") || choise_figther.equals("d"))
            {
                altura =  altura - cambio_altura();
                System.out.println(" esta es su nueva altura "+ altura);
                // la siguiente condicion establece que si la resta de altura  con el metodo cambio_altura(),  es menor a 0,  se establesca como altura, solo 0, ya que no puede existir una altura negativa para terminos del proyecto
                if(altura < 0)
                {
                    altura = 0;
                }
                System.out.println(" esta es su nueva altura "+ altura);
            }
            // la siguiente condicion establece que si se ingresa la letra f como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la velocidad

            if (choise_figther.equals("F") || choise_figther.equals("f"))
            {
                velocidad = aumentar_vel_vuelo() + velocidad;
                // esta condicion establece que si el usuario desea aumentar la velocidad a un valor mas alla de 750, no pueda ya que 750 es el valor max de velocidad
                if(aumentar_vel_vuelo()+velocidad>750){
                    velocidad=750;

                    System.out.println(" esta es su nueva velocidad " + velocidad);
                    System.out.println("Ha alcanzado la velocidad máxima");

                }
                else {
                    System.out.println(" esta es su nueva velocidad " + velocidad);
                }
            }
            // la siguiente condicion establece que si se ingresa la letra G como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la velocidad

            if (choise_figther.equals("G") || choise_figther.equals("g"))
            {
                velocidad =  velocidad - aumentar_vel_vuelo() ;
                // esta condicion establece que si el usuario desea disminuir la velocidad a un valor mas alla de 350, no pueda ya que 350 es el valor min de velocidad
                if(velocidad <= 350 )
                {
                    velocidad =  350;

                }
                System.out.println(" esta es su nueva velocidad " + velocidad);
            }
            // Esta condicion indica que si se ingresa como parametro la letra q en formato q y Q el robot pueda pasar al modo batlloid, eso si siempre, tomando en cuenta una altura max de 200 para transformarse
            if (choise_figther.equals("Q") || choise_figther.equals("q"))
            {
                if(altura > 200)
                {
                    System.out.println(" ¡¡¡ LA ALTURA ES MUY GRANDE PARA INICIALIZAR EL PASO AL ESTADO BATTLOID");

                }
                if(altura <= 200)
                {

                    setAltura(0);
                    setVelocidad(0);
                    setCambio(3);
                    break;

                }
            }
            // Esta condicion indica que si se ingresa como parametro la letra q en formato W y w el robot pueda pasar al modo gerwalk
            if (choise_figther.equals("W") || choise_figther.equals("w"))
            {
                setCambio(2);
                break;
            }


        }
    }
    void caminar()
    {

//la siguiente variable (escogerpierna) es utilizada para escoger izquierda (1) o derecha(2) y para establecer hasta que momento se estara caminando.
        int escogerpierna=0;
        int contadorpasos=0;
        System.out.println("=====>  Para poder caminar ingrese un 1 <====== ");
        Scanner piernaScanner = new Scanner(System.in);
        escogerpierna = piernaScanner.nextInt();
        System.out.println("Para dar pasos con la pierna izquierda pulse 1 y para la derecha pulse 2, para dejar de caminar pulse 0 ");
        // este while nos permite entrar en un ciclo para poder caminar
        while(escogerpierna!=0) {
            escogerpierna = piernaScanner.nextInt();
        //en estos if se ve que pierna se escoge, y el estado actual de esa pierna, de ser 1(adelante) cambiara a 0 (normal) y viceversa;

            if (pierna_izq.getPierna() == 0 && escogerpierna == 1) {
                System.out.println("Ha avanzado un paso la pierna izquierda");
                pierna_izq.setPierna(1);
                contadorpasos= contadorpasos+1;
                if(pierna_der.getPierna()==1){
                    pierna_der.setPierna(0);
                }
                escogerpierna = 3;
            }
            if (pierna_der.getPierna() == 0 && escogerpierna == 2) {
                System.out.println("Ha avanzado un paso la pierna derecha");
                pierna_der.setPierna(1);
                contadorpasos=contadorpasos+1;
                if(pierna_izq.getPierna()==1){
                    pierna_izq.setPierna(0);
                }
                escogerpierna = 3;
            }
            if (pierna_izq.getPierna() == 1 && escogerpierna == 1) {
                System.out.println("Ha retrocedido un paso la pierna izquierda");
                pierna_izq.setPierna(0);
                contadorpasos=contadorpasos-1;
                escogerpierna = 3;
            }
            if (pierna_der.getPierna() == 1 && escogerpierna == 2) {
                System.out.println("Ha retrocedido un paso la pierna derecha");
                pierna_der.setPierna(0);
                contadorpasos=contadorpasos-1;
                escogerpierna = 3;
            }
        }
        System.out.println("Has dado "+contadorpasos+" pasos.");
    }
    int menu_batloid()
    {
        String choise;
        Scanner menu_b = new Scanner(System.in);
        while(true) {
            System.out.println(" ********************************* ");
            System.out.println(" PRESIONE < < < C > > > SI DESEA CAMINAR  ");
            System.out.println(" PRESIONE < < < A > > > SI DESEA DISPARAR ");
            System.out.println(" PRESIONE < < < W > > > SI DESEA CAMBIAR DE ESTADO A GERWALK ");
            System.out.println(" ********************************* ");
            choise = menu_b.nextLine();
            // La siguiente condicion  establece que si se ingresan los parametros s o S se pueda poder ocupar el metodo caminar
            if(choise.equals("C") || choise.equals("c"))
            {
                caminar();
            }
            // la siguiente condicion establece que si se ingresa como parametro la letra a en sus formatos mayuscula o minuscula, se ejecutara el metodo disparar
            if(choise.equals("A") || choise.equals("a"))
            {
                disparar();
            }
            // Esta condicion indica que si se ingresa como parametro la letra q en formato W y w el robot pueda pasar al modo gerwalk
            if(choise.equals("W") || choise.equals("w"))
            {
                setCambio(2);
                break;
            }
        }
        return getCambio();
    }
    int menu_gerwalk(int altura_gerwalk)
    {
        String choise_gerwalk;
        Scanner menu_b = new Scanner(System.in);

        while (true) {
            System.out.println(" ********************************* ");
            if (altura_gerwalk == 0) {
                System.out.println(" PRESIONE < < <  C  > > > SI DESEA CAMINAR  ");
            }
            System.out.println(" PRESIONE < < <  A  > > > SI DESEA DISPARAR ");
            System.out.println(" PRESIONE < < <  S  > > > SI DESEA  AUMENTAR LA ALTURA ");
            if (altura >= 0)
            {
                System.out.println(" PRESIONE < < <  D  > > > SI DESEA  DISMINUIR LA ALTURA");
            }
            if (velocidad <= 750)
            {
                System.out.println(" PRESIONE < < <  F  > > > SI DESEA  AUMENTAR LA VELOCIDAD ");
            }
            if (velocidad >= 0)
            {
                System.out.println(" PRESIONE < < <  G  > > > SI DESEA  DISMINUIR LA VELOCIDAD ");
            }
         System.out.println(" PRESIONE < < <  Q  > > > SI DESEA  PASAR A MODO BATTLOID ");
         System.out.println(" PRESIONE < < <  E  > > > SI DESEA CAMBIAR DE ESTADO A FIGTHER");
         System.out.println(" ********************************* ");
         choise_gerwalk = menu_b.nextLine();
         // La siguiente condicion  establece que si se ingresan los parametros s o S se pueda poder ocupar el metodo caminar
         if(choise_gerwalk.equals("C") || choise_gerwalk.equals("c"))
         {
             caminar();
         }
         // la siguiente condicion establece que si se ingresa como parametro la letra a en sus formatos mayuscula o minuscula, se ejecutara el metodo disparar
         if(choise_gerwalk.equals("A") || choise_gerwalk.equals("a"))
         {
             disparar();
         }
        // la siguiente condicion establece que si se ingresa la letra s como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la altura
         if (choise_gerwalk.equals("S") || choise_gerwalk.equals("s"))
         {
             altura = cambio_altura() + altura;
             System.out.println(" esta es su nueva altura "+ altura);
         }
         // la siguiente condicion establece que si se ingresa la letra D como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la altura
         if (choise_gerwalk.equals("D") || choise_gerwalk.equals("d"))
         {
             altura =  altura - cambio_altura();
             // la siguiente condicion establece que si la resta de altura  con el metodo cambio_altura(),  es menor a 0,  se establesca como altura, solo 0, ya que no puede existir una altura negativa para terminos del proyecto
             if(altura < 0 )
             {
                 altura = 0;
             }
             System.out.println(" esta es su nueva altura " + altura);
         }
            // la siguiente condicion establece que si se ingresa la letra f como parametro (en sus formatos mayuscula o minuscula), sea posible aumentar la velocidad

            if (choise_gerwalk.equals("F") || choise_gerwalk.equals("f"))
         {
             velocidad = aumentar_vel_vuelo() +velocidad;
             // esta condicion establece que si el usuario desea aumentar la velocidad a un valor mas alla de 750, no pueda ya que 750 es el valor max de velocidad
             if(velocidad >= 750)
             {
                 velocidad = 750;
                 System.out.println("HA ALCANZADO SU VELOCIDAD MAXIMA");
             }
             System.out.println(" esta es su nueva velocidad " + velocidad);

         }
            // la siguiente condicion establece que si se ingresa la letra G como parametro (en sus formatos mayuscula o minuscula), sea posible disminuir la velocidad

            if (choise_gerwalk.equals("G") || choise_gerwalk.equals("g"))
         {
             velocidad =  velocidad - aumentar_vel_vuelo() ;
             // esta condicion establece que si el usuario desea disminuir la velocidad a un valor mas alla de 0, no pueda ya que 0 es el valor min de velocidad en gerwalk
             if(velocidad <= 0)
             {
                 velocidad = 0;
                 System.out.println(" A ALCANZADO VELOCIDAD MINIMA  " );

             }

             System.out.println(" esta es su nueva velocidad " + velocidad);


         }

            // Esta condicion indica que si se ingresa como parametro la letra q en formato q y Q el robot pueda pasar al modo batlloid, eso si siempre, tomando en cuenta una altura max de 200 para transformarse
            if (choise_gerwalk.equals("Q")|| choise_gerwalk.equals("q"))
         {
             if(altura > 200)
             {
                 System.out.println(" ¡¡¡ LA ALTURA ES MUY GRANDE PARA INICIALIZAR EL PASO AL ESTADO BATTLOID");

             }

             if(altura <= 200)
             {

                 setVelocidad(0);
                 setAltura(0);
                 setCambio(3);
                 break;

             }
         }
         // la siguiente condicion establece el cambio de estado a figther si es que se ingresa la letra e o E
         if (choise_gerwalk.equals("E") || choise_gerwalk.equals("e"))
         {
             setCambio(1);
             break;



         }


     }
        return getCambio();
    }

    void escogearma(){

        System.out.println("¿Cuantas pistolas laser deseas tener? (El cañon ya viene incluido) (min. 0, max. 3)");
        //con la variable cant guardamos la cantidad de armas a usar
        Scanner cant = new Scanner(System.in);
        //con la variable which se ve que arma escogio.
        Scanner which = new Scanner(System.in);
        int valor;
        int eleccion;
        valor = cant.nextInt();
// aquí se hacen las acciones a realizar dependiendo de la cantidad de armas escogida, para 0 armas case 0, para 1 arma case 1 y así sucesivamente
        switch (valor) {
            case 0:
                System.out.println("No has escogido ninguna arma.");
                break;
            //se va a realizar la pregunta de qué arma quiere la cantidad de veces que sea necesario para escoger la cantidad de armas dicha.
            case 1:
                System.out.println(" Has escogido 1 arma.");
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_1.setNombre("rojo");
                        System.out.println(" Has escogido la de color " + arma_1.getNombre());
                        break;
                    case 2:
                        arma_1.setNombre("verde");
                        System.out.println(" Has escogido la de color " + arma_1.getNombre());
                        break;
                    case 3:
                        arma_1.setNombre("azul");
                        System.out.println(" Has escogido la de color " + arma_1.getNombre());
                        break;
                }
                //System.out.println(" Has escogido la de color "+ arma_1.getNombre());
                //break;
            case 2:
                System.out.println("Has escogido 2 armas.");
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_1.setNombre("rojo");
                        break;
                    case 2:
                        arma_1.setNombre("verde");
                        break;
                    case 3:
                        arma_1.setNombre("azul");
                        break;
                }
                System.out.println("Has escogido la de color " + arma_1.getNombre());
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_2.setNombre("rojo");
                        break;
                    case 2:
                        arma_2.setNombre("verde");
                        break;
                    case 3:
                        arma_2.setNombre("azul");
                        break;
                }
                System.out.println("Has escogido la de color " + arma_2.getNombre());
                break;
            case 3:
                System.out.println("Has escogido 3 armas.");
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_1.setNombre("rojo");
                        break;
                    case 2:
                        arma_1.setNombre("verde");
                        break;
                    case 3:
                        arma_1.setNombre("azul");
                        break;
                }
                System.out.println("Has escogido la de color " + arma_1.getNombre());
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_2.setNombre("rojo");
                        break;
                    case 2:
                        arma_2.setNombre("verde");
                        break;
                    case 3:
                        arma_2.setNombre("azul");
                        break;
                }
                System.out.println("Has escogido la de color " + arma_2.getNombre());
                System.out.println("¿Que pistola laser quieres?");
                System.out.println("INGRESE < < 1 > > si desea laser rojo");
                System.out.println("INGRESE < < 2 > > si desea laser verde");
                System.out.println("INGRESE < < 3 > > si desea laser azul");
                eleccion = which.nextInt();
                switch (eleccion) {
                    case 1:
                        arma_3.setNombre("rojo");
                        break;
                    case 2:
                        arma_3.setNombre("verde");
                        break;
                    case 3:
                        arma_3.setNombre("azul");
                        break;
                }
                System.out.println("Has escogido la de color " + arma_3.getNombre());
                break;
        }

    }
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}



