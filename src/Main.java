import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static SistemaTickets sistema = new SistemaTickets();
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int opcion;

        do {

            System.out.println("--- Sistema de tickets ---");
            System.out.println("1. Menu Usuario");
            System.out.println("2. Menu Administrador");
            System.out.println("0. salir");
            System.out.println("Elija una opción: ");

            opcion = leerEntero();


            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;

                case 2:
                    menuAdministrador();
                    break;

                case 0:
                    System.out.println("Salio del sistema");
                    break;

                default:
                    System.out.println("Opción invalida, intente de nuevo");

            }
        } while (opcion != 0);
    }

    private static void menuUsuario () throws IOException {

        int opcion;

        do {

            System.out.println("--- Menú Usuario ---");
            System.out.println("1. Crear un ticket");
            System.out.println("2. Buscar un ticket resuelto");
            System.out.println("0. Volver");
            System.out.println("Elija una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    crearTicket();
                    break;

                case 2:
                    buscarTicket();
                    break;

                case 0:

                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opción invalida, intente de nuevo");

            }
        } while (opcion != 0);
    }
    private static void menuAdministrador() throws IOException {

        int opcion;

        do {

            System.out.println("--- Menú Administrador ---");
            System.out.println("1. Ver ticket al frente de la cola");
            System.out.println("2. Resolver ticket al frente de la cola");
            System.out.println("0. volver");
            System.out.println("Elija una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:

                    verfrente();
                    break;

                case 2:
                    resolverFrente();
                    break;

                case 0:

                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opción invalida, intente de nuevo");

            }
        } while (opcion != 0);
    }
    private static void crearTicket() throws IOException {

        System.out.println("Nombre completo: ");
        String nombreTicket = in.readLine();
        System.out.println("Descipción del problema: ");
        String descripcionTicket = in.readLine();

        Ticket ticket = sistema.crearTicket(nombreTicket, descripcionTicket);
        System.out.println("Ticket creado con éxito. Su número de ticket es: " + ticket.getId());

    }
    private static void buscarTicket() throws IOException {

        System.out.println("Ingrese el id del ticket que quiere buscar: ");
        int id = leerEntero();
        Ticket ticket = sistema.buscarResuelto(id);
        if (ticket != null) {
            System.out.println("Ticket encontrado");
            System.out.println(ticket);
        } else {
            System.out.println("El ticket esta pendiente de resolución");
        }
    }
    private static void verfrente() {

        Ticket ticket = sistema.verFrentePendientes();
        if (ticket != null) {
            System.out.println("Ticket al frente de la cola");
            System.out.println(ticket);
        } else {
            System.out.println("No hay tickets pendientes");
        }
    }
    private static void resolverFrente() {

        Ticket ticket = sistema.resolverSiguiente();
        if (ticket != null) {
            System.out.println("Ticker resuelto");
            System.out.println(ticket);
        } else {
            System.out.println("No hay tickets pendientes para resolver.");
        }
    }
    private static int leerEntero() throws IOException {
        while (true) {
            String linea = in.readLine();
            try {
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor ingrese un número válido: ");
            }

        }
    }
}