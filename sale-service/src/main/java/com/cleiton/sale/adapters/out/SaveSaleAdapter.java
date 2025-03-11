package com.cleiton.sale.adapters.out;

import com.cleiton.sale.adapters.out.repository.SaleRepository;
import com.cleiton.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.cleiton.sale.application.core.domain.Sale;
import com.cleiton.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveSaleAdapter implements SaveSaleOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
