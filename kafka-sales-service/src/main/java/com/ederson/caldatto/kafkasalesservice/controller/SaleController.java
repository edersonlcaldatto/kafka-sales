package com.ederson.caldatto.kafkasalesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ederson.caldatto.kafkasalesservice.domain.Sale;
import com.ederson.caldatto.kafkasalesservice.service.SaleService;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public void saveSale(@RequestBody Sale sale) {

        saleService.save(sale);
    }

}
