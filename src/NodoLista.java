public class NodoLista {

    private Ticket ticket;
    private NodoLista siguienteNodo;

    public NodoLista(Ticket ticket) {
        this.siguienteNodo = null;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public NodoLista getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoLista siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}


