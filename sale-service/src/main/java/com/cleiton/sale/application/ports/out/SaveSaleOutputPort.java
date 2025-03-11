package com.cleiton.sale.application.ports.out;

import com.cleiton.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    Sale save(Sale sale);
}
