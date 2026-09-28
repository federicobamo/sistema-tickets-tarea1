import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private static int cantidad = 1;
    private int id;

    public Ticket(String nombreCompleto, String descripcion) {
        this.nombreCompleto = nombreCompleto;
        this.descripcion = descripcion;
        this.id = cantidad++;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void resolver() {
        this.fechaResolucion = LocalDateTime.now();
    }

    public boolean estaResuelto() {
        return fechaResolucion != null;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String resolucion = estaResuelto() ? fechaResolucion.format(formato) : "Pendiente";

        return "Ticket #" + id +
                "\n  Nombre completo: " + nombreCompleto +
                "\n  Descripcion: " + descripcion +
                "\n  Fecha de creación: " + fechaCreacion.format(formato) +
                "\n  Fecha de resolución: " + resolucion;
    }
}