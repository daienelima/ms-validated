package com.validated.app.application.ports.out;

import com.validated.app.application.core.domain.Customer;

public interface CpfValidatedOutPutPort {
    void sendCpfValidated(Customer customer);
}