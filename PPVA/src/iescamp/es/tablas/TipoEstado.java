package iescamp.es.tablas;

public enum TipoEstado {
    DISPONIBLE, RESERVADO, ENUSO, FUERASERVICIO;

    public static TipoEstado convertirOpcionEnTipoEstado(int estado) {
        TipoEstado tipoEstado = null;
        switch (estado) {
            case 1: tipoEstado = TipoEstado.DISPONIBLE; break;
            case 2: tipoEstado = TipoEstado.RESERVADO; break;
            case 3: tipoEstado = TipoEstado.ENUSO; break;
            case 4: tipoEstado = TipoEstado.FUERASERVICIO; break;
        }
        return tipoEstado;
    }
}


