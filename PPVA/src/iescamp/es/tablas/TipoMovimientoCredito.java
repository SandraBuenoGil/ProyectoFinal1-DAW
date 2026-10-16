package iescamp.es.tablas;

public enum TipoMovimientoCredito {
    RecargaDinero,
    AportaRecurso,
    AjusteAdmin,
    Penalización;

    public static TipoMovimientoCredito convertirOpcionEnTipoMovimiento(int estado) {
        TipoMovimientoCredito tipoMovimiento = null;
        switch (estado) {
            case 1: tipoMovimiento = TipoMovimientoCredito.RecargaDinero; break;
            case 2: tipoMovimiento = TipoMovimientoCredito.AportaRecurso; break;
            case 3: tipoMovimiento = TipoMovimientoCredito.AjusteAdmin; break;
            case 4: tipoMovimiento = TipoMovimientoCredito.Penalización; break;
        }
        return tipoMovimiento;
    }
}
