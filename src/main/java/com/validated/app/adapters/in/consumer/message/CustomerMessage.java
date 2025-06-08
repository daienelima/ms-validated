package com.validated.app.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private String id;

    private String name;

    private AddressMessage address;

    private String cpf;

    private Boolean isValidCpf;

}