package com.cleiton.sale.application.core.usecase;

import com.cleiton.sale.application.core.domain.Sale;
import com.cleiton.sale.application.core.domain.enums.SaleEvent;
import com.cleiton.sale.application.core.domain.enums.SaleStatus;
import com.cleiton.sale.application.ports.in.CreateSaleInputPort;
import com.cleiton.sale.application.ports.out.SaveSaleOutputPort;
import com.cleiton.sale.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort,
                             SendCreatedSaleOutputPort sendCreatedOutputPort){
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedOutputPort = sendCreatedOutputPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }

}
