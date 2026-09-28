public class ColaPrioridad {


    private NodoLista frente;

    public ColaPrioridad() {
        this.frente = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Ticket ticket) {
        NodoLista nodo = new NodoLista(ticket);

        if (estaVacia()) {
            frente = nodo;
        } else {
            NodoLista actual = frente;

            while (actual.getSiguienteNodo() != null) {
                actual = actual.getSiguienteNodo();
            }
            actual.setSiguienteNodo(nodo);
        }
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getTicket();
    }

    public Ticket resolverFrente() {
        if (estaVacia()) {
            return null;
        }
        Ticket ticket = frente.getTicket();
        ticket.resolver();
        frente = frente.getSiguienteNodo();
        return ticket;
    }

}


















