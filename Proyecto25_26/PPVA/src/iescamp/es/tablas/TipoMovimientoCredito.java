package iescamp.es.tablas;

public enum TipoMovimientoCredito {
    RecargaDinero, AportaRecurso, AjusteAdmin, Penalización;

    public static TipoMovimientoCredito convertirOpcionEnTipoMov(int estado) {
        TipoMovimientoCredito tipo = null;
        switch (estado) {
            case 1: tipo = TipoMovimientoCredito.RecargaDinero;
                break;
            case 2: tipo = TipoMovimientoCredito.AportaRecurso;
                break;
            case 3: tipo = TipoMovimientoCredito.AjusteAdmin;
                break;
            case 4: tipo = TipoMovimientoCredito.Penalización;
                break;
        }
        return tipo;
    }
}
