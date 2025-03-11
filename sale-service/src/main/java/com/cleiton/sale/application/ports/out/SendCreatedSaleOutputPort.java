package com.cleiton.sale.application.ports.out;

import com.cleiton.sale.application.core.domain.Sale;
import com.cleiton.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {
    void send(Sale sale, SaleEvent event);
}
