package com.ederson.caldatto.kafkasalesservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Sale implements Serializable {

    private Long id;

    private LocalDate saleDate;

    private String clientName;

    private BigDecimal ammount;

}
