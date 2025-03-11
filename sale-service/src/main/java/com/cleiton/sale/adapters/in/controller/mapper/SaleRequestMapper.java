package com.cleiton.sale.adapters.in.controller.mapper;

import com.cleiton.sale.adapters.in.controller.request.SaleRequest;
import com.cleiton.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
