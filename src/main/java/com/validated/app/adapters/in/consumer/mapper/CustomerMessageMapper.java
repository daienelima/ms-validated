package com.validated.app.adapters.in.consumer.mapper;


import com.validated.app.adapters.in.consumer.message.CustomerMessage;
import com.validated.app.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMessageMapper {

    CustomerMessageMapper INSTANCE = Mappers.getMapper(CustomerMessageMapper.class);

    Customer toCustomer(CustomerMessage customerMessage);
}