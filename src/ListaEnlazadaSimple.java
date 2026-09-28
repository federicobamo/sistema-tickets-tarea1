import java.time.LocalDateTime;

public class ListaEnlazadaSimple {

    private NodoLista primero;

    public ListaEnlazadaSimple() {
        this.primero = null;
    }

    private NodoLista getPrimero() {
        return primero;
    }

    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public boolean estaVacio() {
        return primero == null;
    }

    // METODOS - AGREGAR - BUSCAR - MOSTRAR TODOS

    // Teniendo el primer nodo, se revisa si hay algo en el siguiente // si es null se crear un siguiente
    public void agregar(Ticket ticket) {

        NodoLista nodo = new NodoLista(ticket);

        if (estaVacio()) {
        setPrimero(nodo);
        } else {
            NodoLista actual = getPrimero();

            while (actual.getSiguienteNodo() != null) {
                actual = actual.getSiguienteNodo();
            }
            actual.setSiguienteNodo(nodo);
        }
    }

    // Busca por id del nodo para  encontrar el ticket
    public Ticket buscar(int id) {

        if (estaVacio()) {
            return null;
        }

        NodoLista temp = primero;

        while (temp != null) {
            if (id == temp.getTicket().getId()) {
                return temp.getTicket();
            }
            temp = temp.getSiguienteNodo();
        }
        return null;
    }

    public void mostrarTodos() {

        if (estaVacio()) {
            System.out.println("No hay tickets resueltos todavía.");
            return;
        }

        NodoLista temp = primero;

        while (temp != null) {

            System.out.println(temp.getTicket());
            temp = temp.getSiguienteNodo();
        }
    }




    }







