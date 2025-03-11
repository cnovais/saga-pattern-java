package com.cleiton.sale.application.ports.in;

import com.cleiton.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {
    void create(Sale sale);
}
