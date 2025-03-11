package com.cleiton.sale.config.usecase;

import com.cleiton.sale.adapters.out.SaveSaleAdapter;
import com.cleiton.sale.adapters.out.SendCreatedSaleAdapter;
import com.cleiton.sale.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ){
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
