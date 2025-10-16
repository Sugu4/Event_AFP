package com.dto;


import java.math.BigDecimal;

import lombok.Data;


@Data
public class TicketKategorieDto {
    private Long id;
    private String name;
    private BigDecimal preis;
    private Integer kontingentMax;
    
    // Die berechneten Felder:
    private Long verkauft; 
    private Integer verfuegbar;
}
