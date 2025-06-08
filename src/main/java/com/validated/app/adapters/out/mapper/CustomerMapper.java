package com.validated.app.adapters.out.mapper;

import com.validated.app.adapters.in.consumer.message.CustomerMessage;
import com.validated.app.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerMessage toCustomerMessage(Customer customer);
}
