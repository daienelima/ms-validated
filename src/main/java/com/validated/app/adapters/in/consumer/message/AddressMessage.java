package com.validated.app.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressMessage {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}

