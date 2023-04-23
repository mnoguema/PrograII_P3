/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class MercatUB {

    private Adaptador adaptador = new Adaptador();

    public void gestioMercatUB() {
        Scanner sc = new Scanner(System.in);
        gestioMenu(sc);
    }

    private static enum OpcionsMenu {
        M_Opcio_1_GestioArticles,
        M_Opcio_2_GestioClients,
        M_Opcio_3_GestioComandes,
        M_Opcio_4_GuardarDades,
        M_Opcio_5_CarregaDades,
        M_Opcio_6_Sortir
    };
    private static final String[] descMenu = {
        "Dona pas a un submenú que permet gestionar la informació relacionada amb els articles.",
        "Mostra un submenú que permet gestionar els clients.",
        "Visualitza un submenú per gestionar les comandes.",
        "Guarda les dades de l'aplicació.",
        "Carrega les dades de l'aplicació.",
        "Surt de l'aplicació."
    };

    private static enum OpcionsMenuArticles {
        M_OPCIO_1_AfegirArticle,
        M_OPCIO_2_VisualitzarArticles,
        M_OPCIO_3_Sortir
    }

    private static final String[] descMenuArticles = {
        "Afegeix un nou article al sistema.",
        "Mostra tots els articles afegits.",
        "Torna al menú principal."
    };

    private static enum OpcionsMenuClients {
        M_OPCIO_1_AfegirClient,
        M_OPCIO_2_VisualitzarClients,
        M_OPCIO_3_Sortir
    }

    private static final String[] descMenuClients = {
        "Incorpora un nou client a l'aplicació.",
        "Visualitza tots els clients afegits.",
        "Torna al menú principal."
    };

    private static enum OpcionsMenuComandes {
        M_OPCIO_1_AfegirComanda,
        M_OPCIO_2_CancelarComanda,
        M_OPCIO_3_VisualitzarComandes,
        M_OPCIO_4_VisualitzarComandesCancelades,
        M_OPCIO_5_Sortir
    }

    private static final String[] descMenuComandes = {
        "Crea una nova comanda.",
        "Cancel·la una comanda determinada, sempre que no hagi estat enviat encara.",
        "Visualitza totes les comandes realitzades.",
        "Visualitza únicament les comandes cancel·lades.",
        "Torna al menú principal."
    };

    public void gestioMenu(Scanner sc) {
        Menu<OpcionsMenu> menuMercatUB = new Menu<>("Menu Mercat UB ", OpcionsMenu.values());
        menuMercatUB.setDescripcions(descMenu);
        OpcionsMenu opcioMenu;

        do {
            menuMercatUB.mostrarMenu();
            opcioMenu = menuMercatUB.getOpcio(sc);

            switch (opcioMenu) {
                case M_Opcio_1_GestioArticles:
                    gestioArticles(sc);
                    break;
                case M_Opcio_2_GestioClients:
                    gestioClients(sc);
                    break;
                case M_Opcio_3_GestioComandes:
                    gestioComandes(sc);
                    break;
                case M_Opcio_4_GuardarDades:
                    System.out.println("Amb quin nom ho vols guardar?");
                    String nomFitxer = sc.nextLine();
                    try {
                        adaptador.guarda(nomFitxer);
                    } catch (MercatException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case M_Opcio_5_CarregaDades:

                    System.out.println("Nom del arxiu que vols recuperar.");
                    String srcFile = sc.nextLine();

                    try {
                        adaptador.recupera(srcFile);
                    } catch (MercatException ex) {
                        System.out.println(ex.getMessage());

                    }
                    break;
            }
        } while (opcioMenu != OpcionsMenu.M_Opcio_6_Sortir);
    }

    public void gestioArticles(Scanner sc) {
        Menu<OpcionsMenuArticles> menuArticles = new Menu<>("Menu Articles ", OpcionsMenuArticles.values());
        menuArticles.setDescripcions(descMenuArticles);
        OpcionsMenuArticles opcioMenu;

        do {
            menuArticles.mostrarMenu();
            opcioMenu = menuArticles.getOpcio(sc);

            switch (opcioMenu) {
                case M_OPCIO_1_AfegirArticle:
                    System.out.println("ID de l'article: ");
                    String id = sc.nextLine();
                    System.out.println("Nom de l'article: ");
                    String nom = sc.nextLine();
                    System.out.println("Preu de l'article: ");
                    float preu = sc.nextFloat();
                    System.out.println("Temps d'enviament de l'article: ");
                    int temps = sc.nextInt();
                    System.out.println("L'article admet enviament urgent? (true/false): ");
                    boolean admetUrgent = sc.nextBoolean();

                    try {
                        adaptador.afegirArticle(id, nom, preu, temps, admetUrgent);
                    } catch (MercatException mercatException) {
                        System.out.println(mercatException.getMessage());
                    }
                    break;

                case M_OPCIO_2_VisualitzarArticles:
                    System.out.println(adaptador.llistarArticles());
                    break;
            }
        } while (opcioMenu != OpcionsMenuArticles.M_OPCIO_3_Sortir);
    }

    public void gestioClients(Scanner sc) {
        Menu<OpcionsMenuClients> menuClients = new Menu<>("Menu Clients ", OpcionsMenuClients.values());
        menuClients.setDescripcions(descMenuClients);
        OpcionsMenuClients opcioMenu;

        do {
            menuClients.mostrarMenu();
            opcioMenu = menuClients.getOpcio(sc);

            switch (opcioMenu) {
                case M_OPCIO_1_AfegirClient:
                    System.out.println("Email del client: ");
                    String email = sc.nextLine();
                    System.out.println("Nom del client: ");
                    String nom = sc.nextLine();
                    System.out.println("Adreça del client: ");
                    String adreca = sc.nextLine();
                    System.out.println("El client és premium? (true/false): ");
                    boolean esPremium = sc.nextBoolean();
                    try {
                        adaptador.afegirClient(email, nom, adreca, esPremium);
                    } catch (MercatException mercatException) {
                        System.out.println(mercatException.getMessage());
                    }
                    break;

                case M_OPCIO_2_VisualitzarClients:
                    System.out.println(adaptador.llistarClients());
                    break;
            }
        } while (opcioMenu != OpcionsMenuClients.M_OPCIO_3_Sortir);
    }

    public void gestioComandes(Scanner sc) {
        Menu<OpcionsMenuComandes> menuComandes = new Menu<>("Menu Comandes ", OpcionsMenuComandes.values());
        menuComandes.setDescripcions(descMenuComandes);
        OpcionsMenuComandes opcioMenu;

        do {
            menuComandes.mostrarMenu();
            opcioMenu = menuComandes.getOpcio(sc);

            switch (opcioMenu) {
                case M_OPCIO_1_AfegirComanda:
                    System.out.println("Posició de l'article a la llista: ");
                    int articlePos = sc.nextInt();
                    System.out.println("Posició del client a la llista: ");
                    int clientPos = sc.nextInt();
                    System.out.println("Quantitat a comprar: ");
                    int quantitat = sc.nextInt();
                    System.out.println("La comanda és urgent? (true/false): ");
                    boolean esUrgent = sc.nextBoolean();

                    try {
                        adaptador.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
                    } catch (MercatException mercatException) {
                        System.out.println(mercatException.getMessage());
                    }
                    break;

                case M_OPCIO_2_CancelarComanda:
                    System.out.println("Posició de la comanda a la llista: ");
                    int position = sc.nextInt();

                    try {
                        adaptador.cancelarComanda(position);
                    } catch (MercatException mercatException) {
                        System.out.println(mercatException.getMessage());
                    }
                    break;
                case M_OPCIO_3_VisualitzarComandes:
                    System.out.println(adaptador.llistarComandes("totes"));
                    break;
                case M_OPCIO_4_VisualitzarComandesCancelades:
                    System.out.println(adaptador.llistarComandes("cancelades"));
                    break;

            }
        } while (opcioMenu != OpcionsMenuComandes.M_OPCIO_5_Sortir);
    }

}
