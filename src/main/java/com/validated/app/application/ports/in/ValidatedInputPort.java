package com.validated.app.application.ports.in;

import com.validated.app.application.core.domain.Customer;

public interface ValidatedInputPort {
    void validatedCpfAndCnpj(Customer customer);
}
