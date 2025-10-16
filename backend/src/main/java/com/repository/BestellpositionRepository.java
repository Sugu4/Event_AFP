package com.repository; 


import com.model.Bestellposition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface BestellpositionRepository extends JpaRepository<Bestellposition, Long> {

    @Query("SELECT COALESCE(SUM(bp.menge), 0) FROM Bestellposition bp " +
           "JOIN bp.bestellung b " +
           "WHERE bp.ticketKategorie.id = :ticketKatId AND " +
           "(b.status = 'PAID' OR b.status = 'RESERVED')")
    Long sumSoldTicketsByTicketKategorieId(@Param("ticketKatId") Long ticketKatId);
}