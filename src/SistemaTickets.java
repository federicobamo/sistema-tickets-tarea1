public class SistemaTickets {

    private ColaPrioridad pendientes;
    private ListaEnlazadaSimple resueltos;

    public SistemaTickets() {
        this.pendientes = new ColaPrioridad();
        this.resueltos = new ListaEnlazadaSimple();
    }

    public Ticket crearTicket(String nombreCompleto, String descripcion) {
        Ticket ticket = new Ticket(nombreCompleto, descripcion);
        pendientes.encolar(ticket);
        return ticket;
    }

    public Ticket buscarResuelto(int id) {
        return resueltos.buscar(id);
    }

    public Ticket verFrentePendientes() {
        return pendientes.verFrente();
    }

    public Ticket resolverSiguiente() {
        Ticket resuelto = pendientes.resolverFrente();
        if (resuelto != null) {
            resueltos.agregar(resuelto);
        }
        return resuelto;
    }

    public boolean hayPendientes() {
        return !pendientes.estaVacia();
    }

    public void mostrarResueltos() {
        resueltos.mostrarTodos();
    }
}