package com.navas.pelisnavas.repository.interfaces;

import java.time.LocalDate;

public interface PrestamoRepository {
   // PrestamoResponse solicitarPrestamo(InformacionPrestamo informacionPrestamo);

    //InformacionPrestamo obtenerInformacionPrestamo(int id);

    LocalDate obtenerUltimaFechaPorCliente(String cliente) ;

}
