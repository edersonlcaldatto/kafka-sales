package com.ederson.caldatto.kafkainventoryservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sale implements Serializable {

    private Long id;

    private LocalDate saleDate;

    private String clientName;

    private BigDecimal ammount;

}
