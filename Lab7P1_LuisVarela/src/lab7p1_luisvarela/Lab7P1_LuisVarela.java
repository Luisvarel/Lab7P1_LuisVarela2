/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_luisvarela;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Luis Andres Varela
 */
public class Lab7P1_LuisVarela {

    static Scanner lea = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = true;
        while (salir) {
            int opcion = menu();
            switch (opcion) {
                case 1: {
                    int heroe = 0;
                    String confirmacion = "s";
                    boolean salir1 = true;
                    while (salir1) {
                        System.out.println("Seleccione un tipo de heroe");
                        System.out.println("1.Caballero:");
                        System.out.println("2.Mago:");
                        heroe = lea.nextInt();
                        switch (heroe) {
                            case 1: {
                                System.out.println("Informacion:");
                                System.out.println("-----Caballero-----");
                                System.out.println("Caracter:'C'");
                                System.out.println("Puntos de Vida:250");
                                System.out.println("Energía:50");
                                System.out.println("Ingrese s para confirmar el heroe:");
                                confirmacion = lea.next();
                                if (confirmacion.equalsIgnoreCase("s")) {
                                    salir1 = false;
                                }
                            }
                            break;
                            case 2: {
                                System.out.println("Informacion:");
                                System.out.println("-----Mago-----");
                                System.out.println("Caracter:'M'");
                                System.out.println("Puntos de Vida:150");
                                System.out.println("Energía:230");
                                System.out.println("Ingrese s para confirmar el heroe:");
                                confirmacion = lea.next();
                                if (confirmacion.equalsIgnoreCase("s")) {
                                    salir1 = false;
                                }
                            }
                            break;
                            case 3: {
                                System.out.println("Informacion:");
                                System.out.println("-----Bruiser-----");
                                System.out.println("Caracter:'B'");
                                System.out.println("Puntos de Vida:150");
                                System.out.println("Energía:70");
                                System.out.println("Ingrese s para confirmar el heroe:");
                                confirmacion = lea.next();
                                if (confirmacion.equalsIgnoreCase("s")) {
                                    salir1 = false;
                                }
                            }
                            break;
                            case 4: {
                                System.out.println("Informacion:");
                                System.out.println("-----Asesino-----");
                                System.out.println("Caracter:'A'");
                                System.out.println("Puntos de Vida:115");
                                System.out.println("Energía:150");
                                System.out.println("Ingrese s para confirmar el heroe:");
                                confirmacion = lea.next();
                                if (confirmacion.equalsIgnoreCase("s")) {
                                    salir1 = false;
                                }
                            }
                            break;
                            default:
                                System.out.println("Error");
                        }
                    }
                    Dungeons_and_Dragons(heroe);

                }
                break;
                case 2: {
                    laberinto();
                }
                break;
                case 3: {
                    salir = false;
                }
                break;
                default:
                    System.out.println("Error");

            }
        }
        // TODO code application logic here
    }

    public static int menu() {
        System.out.println("1.Dungeons and Dragons");
        System.out.println("2.Laberinto");
        System.out.println("3.Salir");
        int opcion = lea.nextInt();
        return opcion;
    }

    public static void Dungeons_and_Dragons(int heroe) {
        String Caracter = "", espacio_anterior = "";
        int vida = 0, energia = 0, bono_vida = 25, bono_energia = 5, dado = 0, f = 0, c = 0, pelea, energia2 = 0;
        switch (heroe) {
            case 1: {
                Caracter = "C";
                vida = 250;
                energia = 50;
            }
            break;
            case 2: {
                Caracter = "M";
                vida = 150;
                energia = 230;
            }
            break;
            case 3: {
                Caracter = "B";
                vida = 150;
                energia = 70;
            }
            break;
            case 4: {
                Caracter = "A";
                vida = 115;
                energia = 150;
            }
            break;
        }
        String[][] mapa1 = {
            {".", "♡", "-", "♡", "-", "-", "♡", "-", "-", "♡"},
            {"-", "▲", "-", "-", "-", "-", "-", "-", "▲", "-"},
            {"-", "♡", "▲", "♡", "-", "-", "♡", "▲", "-", "♡"},
            {"-", "-", "-", "▲", "-", "-", "▲", "-", "-", "-"},
            {"-", "♡", "-", "♡", "▲", "▲", "♡", "-", "-", "♡"},
            {"-", "-", "-", "-", "▲", "▲", "-", "-", "-", "-"},
            {"-", "♡", "-", "♡", "-", "-", "♡", "-", "-", "♡"},
            {"-", "-", "▲", "-", "-", "-", "-", "▲", "-", "-"},
            {"-", "♡", "-", "♡", "-", "-", "♡", "-", "▲", "♡"},
            {"▲", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };
        String[][] mapa = {
            {".", "♡", "-", "♡", "-", "-", "♡", "-", "-", "♡"},
            {"-", "▲", "-", "-", "-", "-", "-", "-", "▲", "-"},
            {"-", "♡", "▲", "♡", "-", "-", "♡", "▲", "-", "♡"},
            {"-", "-", "-", "▲", "-", "-", "▲", "-", "-", "-"},
            {"-", "♡", "-", "♡", "▲", "▲", "♡", "-", "-", "♡"},
            {"-", "-", "-", "-", "▲", "▲", "-", "-", "-", "-"},
            {"-", "♡", "-", "♡", "-", "-", "♡", "-", "-", "♡"},
            {"-", "-", "▲", "-", "-", "-", "-", "▲", "-", "-"},
            {"-", "♡", "-", "♡", "-", "-", "♡", "-", "▲", "♡"},
            {"▲", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };
        espacio_anterior = mapa[f][c];
        boolean impar = false;
        boolean fin = true;
        energia2 = energia;
        while (fin) {
            mapa[f][c] = Caracter;
            imprimir_DD(mapa);
            System.out.println("Presione enter, para seguir adelnate....");
            String nada = lea.next();
            dado = ran.nextInt(16) + 1;
            pelea = ran.nextInt(100) + 1;
            System.out.println("Usted saco:" + dado);
            if (dado % 2 == 0) {
                impar = false;
            } else {
                impar = true;
            }
            mapa[f][c] = espacio_anterior;

            if (dado + c < 10) {
                c += dado;
            } else if (dado + c >= 10) {
                while (dado > 0) {
                    if (f == 9 && c + dado >= 10) {
                        dado = 0;
                        f = 9;
                        c = 9;
                    } else if (c + 1 < 10) {
                        c++;
                        dado--;
                    } else if (c + 1 >= 10) {
                        f++;
                        c = 0;
                        dado--;
                    }
                }
            }
            espacio_anterior = mapa[f][c];
            mapa[f][c] = Caracter;

            if (mapa1[f][c].equalsIgnoreCase("♡")) {
                System.out.println("Encontro un cofre con 25 de vida!");
                System.out.println("No encontro ningun dragon");
                vida += bono_vida;
            } else if (mapa1[f][c].equalsIgnoreCase("▲")) {
                System.out.println("Encontro un cofre con 5 de energia!");
                System.out.println("No encontro ningun dragon");
                energia += bono_energia;
            } else if (impar) {
                System.out.println("-----------SE HA ENCONTRADO CON DRAGONES!-----------");
                if (f >= 0 && f <= 2) {
                    System.out.print("Se encontro a 2 dragones ");
                    if (pelea <= 50) {
                        System.out.print("y no logro ganar, pierde " + bono_vida * 2 + " de vida");
                        vida -= bono_vida * 2;
                    } else {
                        System.out.print("y logro ganar, pierde " + bono_energia * 2 + " de energia");
                        energia -= bono_energia * 2;
                    }
                } else if (f >= 3 && f <= 5) {
                    System.out.print("Se encontro a 3 dragones ");
                    if (pelea <= 50) {
                        System.out.print("y no logro ganar, pierde " + bono_vida * 3 + " de vida");
                        vida -= bono_vida * 3;
                    } else {
                        System.out.print("y logro ganar, pierde " + bono_energia * 3 + " de energia");
                        energia -= bono_energia * 3;
                    }
                } else if (f >= 6 && f <= 8) {
                    System.out.print("Se encontro a 4 dragones ");
                    if (pelea <= 50) {
                        System.out.print("y no logro ganar, pierde " + bono_vida * 4 + " de vida");
                        vida -= bono_vida * 4;
                    } else {
                        System.out.print("y logro ganar, pierde " + bono_energia * 4 + " de energia");
                        energia -= bono_energia * 4;
                    }
                } else {
                    System.out.print("Se encontro a 5 dragones ");
                    if (pelea <= 50) {
                        System.out.print("y no logro ganar, pierde " + bono_vida * 5 + " de vida");
                        vida -= bono_vida * 5;
                    } else {
                        System.out.print("y logro ganar, pierde " + bono_energia * 2 + " de energia");
                        energia -= bono_energia * 5;
                    }
                }
            } else {
                System.out.println("No encontro ningun dragon");
            }
            if (f == 9 && c == 9) {
                System.out.println("");
                System.out.println("-----------VICTORIA!-----------");
                System.out.println("Tu heroe has logrado completar la mazmorra");
                fin = false;
                imprimir_DD(mapa);
            } else if (vida <= 0) {
                System.out.println("");
                System.out.println("-----------HAS MUERTO!-----------");
                System.out.println("                                     _ _ _      \n"
                        + "                              __,---'     `--.__\n"
                        + "                           ,-'                ; `.\n"
                        + "                          ,'                  `--.`--.\n"
                        + "                         ,'                       `._ `-.\n"
                        + "                         ;                     ;     `-- ;\n"
                        + "                       ,-'-_       _,-~~-.      ,--      `.\n"
                        + "                       ;;   `-,;    ,'~`.__    ,;;;    ;  ;\n"
                        + "                       ;;    ;,'  ,;;      `,  ;;;     `. ;\n"
                        + "                       `:   ,'    `:;     __/  `.;      ; ;\n"
                        + "                        ;~~^.   `.   `---'~~    ;;      ; ;\n"
                        + "                        `,' `.   `.            .;;;     ;'\n"
                        + "                        ,',^. `.  `._    __    `:;     ,'\n"
                        + "                        `-' `--'    ~`--'~~`--.  ~    ,'\n"
                        + "                       /;`-;_ ; ;. /. /   ; ~~`-.     ;\n"
                        + "-._                   ; ;  ; `,;`-;__;---;      `----'\n"
                        + "   `--.__             ``-`-;__;:  ;  ;__;\n"
                        + " ...     `--.__                `-- `-'\n"
                        + "`--.:::...     `--.__                ____\n"
                        + "    `--:::::--.      `--.__    __,--'    `.\n"
                        + "        `--:::`;....       `--'       ___  `.\n"
                        + "            `--`-:::...     __           )  ;\n"
                        + "                  ~`-:::...   `---.      ( ,'\n"
                        + "                      ~`-:::::::::`--.   `-.\n"
                        + "                          ~`-::::::::`.    ;\n"
                        + "                              ~`--:::,'   ,'\n"
                        + "                                   ~~`--'~");
                fin = false;
            }
            System.out.println("\n-----------ESTADO-----------");
            if (vida <= 0) {
                System.out.println("Vida: 0");
            } else {
                System.out.println("Vida: " + vida);
            }
            if (energia <= 0) {
                System.out.println("Después de una noche de descanso has recuperado tu energia");
                energia += energia2;
            }
            System.out.println("Energia: " + energia);
        }
    }

    public static void imprimir_DD(String[][] mapa) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(mapa[i][j] + "   ");
            }
            System.out.println("");
        }
    }

    public static void imprimir(String[][] laberinto) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(laberinto[i][j]);
            }
            System.out.println("");
        }
    }

    public static void laberinto() {
        String[][] laberinto = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "C", "#", " ", " ", " ", "#", "#", " ", "#"},
            {"#", " ", "#", " ", "#", "#", "#", " ", " ", " "},
            {"#", " ", "#", " ", " ", " ", "#", " ", "#", "#"},
            {"#", " ", " ", " ", "#", " ", "#", " ", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", "#", " ", "#"},
            {"#", " ", "#", " ", "#", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
        };
        int f = 1;
        int c = 1;
        boolean fin = true;
        boolean Validar_movi = true;

        while (fin) {
            do {
                Validar_movi = true;
                imprimir(laberinto);
                System.out.println("Ingrese un movimiento (w/a/s/d)");
                String mov = lea.next();
                if (mov.equalsIgnoreCase("w")) {
                    if (laberinto[f - 1][c].equals(" ")) {
                        laberinto[f][c] = " ";
                        f--;
                        Validar_movi = false;
                    }
                } else if (mov.equalsIgnoreCase("s")) {
                    if (laberinto[f + 1][c].equals(" ")) {
                        laberinto[f][c] = " ";
                        f++;
                        Validar_movi = false;

                    }
                } else if (mov.equalsIgnoreCase("a")) {
                    if (laberinto[f][c - 1].equals(" ")) {
                        laberinto[f][c] = " ";
                        c--;
                        Validar_movi = false;
                    }
                } else if (mov.equalsIgnoreCase("d")) {
                    if (laberinto[f][c + 1].equals(" ")) {
                        laberinto[f][c] = " ";
                        c++;
                        Validar_movi = false;
                    }
                }else{
                    System.out.println("Error no se puede mover con esta tecla");
                }
            } while (Validar_movi);
            laberinto[f][c] = "C";
            if (f == 2 && c == 9) {
                imprimir(laberinto);
                fin = false;
                System.out.println("Enhorabuena has conseguido completar el laberinto");
            }
        }
    }
}
