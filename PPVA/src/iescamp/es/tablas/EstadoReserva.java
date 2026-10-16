package iescamp.es.tablas;

public enum EstadoReserva {
    PENDIENTECONFIRMAR,
    ESPERANDORECOGIDA,
    ENUSO,
    FINALIZADA,
    CANCELADA,
    VENCIDA;

    public static EstadoReserva convertirOpcionEnEstadoReserva(int estado) {
        EstadoReserva estadoReserva = null;
        switch (estado) {
            case 1: estadoReserva = EstadoReserva.PENDIENTECONFIRMAR; break;
            case 2: estadoReserva = EstadoReserva.ESPERANDORECOGIDA; break;
            case 3: estadoReserva = EstadoReserva.ENUSO; break;
            case 4: estadoReserva = EstadoReserva.FINALIZADA; break;
            case 5: estadoReserva = EstadoReserva.CANCELADA; break;
            case 6: estadoReserva = EstadoReserva.VENCIDA; break;
        }
        return estadoReserva;
    }
}
