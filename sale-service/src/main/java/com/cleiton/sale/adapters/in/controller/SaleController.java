package com.cleiton.sale.adapters.in.controller;

import com.cleiton.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.cleiton.sale.adapters.in.controller.request.SaleRequest;
import com.cleiton.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/sales")
public class SaleController {

    private static final Logger log = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private CreateSaleInputPort createSaleInputPort;

    @Autowired
    private SaleRequestMapper saleRequestMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateSale(@Valid @RequestBody SaleRequest saleRequest){
        log.info("Criando a venda... ");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Venda criada com sucesso. ");
    }
}
