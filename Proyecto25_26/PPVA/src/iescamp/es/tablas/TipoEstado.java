package iescamp.es.tablas;

public enum TipoEstado {
    DISPONIBLE, RESERVADO, ENUSO, FUERASERVICIO;

    public static TipoEstado convertirOpcionEnTipoEstado(int estado) {
        TipoEstado tipo = null;
        switch (estado) {
            case 1: tipo = TipoEstado.DISPONIBLE;
            break;
            case 2: tipo = TipoEstado.RESERVADO;
            break;
            case 3: tipo = TipoEstado.ENUSO;
            break;
            case 4: tipo = TipoEstado.FUERASERVICIO;
            break;
        }
        return tipo;
    }
}
