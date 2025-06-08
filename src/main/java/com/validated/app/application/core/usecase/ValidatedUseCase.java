package com.validated.app.application.core.usecase;

import com.validated.app.application.core.domain.Customer;
import com.validated.app.application.core.utils.CpfValidatedUtils;
import com.validated.app.application.ports.in.ValidatedInputPort;
import com.validated.app.application.ports.out.CpfValidatedOutPutPort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidatedUseCase implements ValidatedInputPort {

    private final CpfValidatedOutPutPort cpfValidatedOutPutPort;

    public ValidatedUseCase(CpfValidatedOutPutPort cpfValidatedOutPutPort) {
        this.cpfValidatedOutPutPort = cpfValidatedOutPutPort;
    }


    @Override
    public void validatedCpfAndCnpj(Customer customer) {
        if(Objects.nonNull(customer.cpf())){
            var cpf = customer.cpf();
            if(cpf.length() == 11 && CpfValidatedUtils.isValidCpf(cpf)){
                var customerValidated = new Customer(
                        customer.id(),
                        customer.name(),
                        customer.address(),
                        cpf,
                        true
                );
                cpfValidatedOutPutPort.sendCpfValidated(customerValidated);
            }
        }
    }
}
