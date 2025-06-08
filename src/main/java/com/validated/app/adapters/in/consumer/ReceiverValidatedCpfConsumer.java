package com.validated.app.adapters.in.consumer;

import com.validated.app.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.validated.app.adapters.in.consumer.message.CustomerMessage;
import com.validated.app.application.ports.in.ValidatedInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiverValidatedCpfConsumer {

    private final ValidatedInputPort validatedInputPort;

    public ReceiverValidatedCpfConsumer(ValidatedInputPort validatedInputPort) {
        this.validatedInputPort = validatedInputPort;
    }

    @KafkaListener(
            topics = "${kafka.topic.cpf-validate}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void receiverValidatedCpf(CustomerMessage customerMessage)  {
        log.info("[CONSUMIDO] cpf validado id {}, cpf {}", customerMessage.getId(), customerMessage.getCpf());

        var custumer = CustomerMessageMapper.INSTANCE.toCustomer(customerMessage);

        validatedInputPort.validatedCpfAndCnpj(custumer);

    }
}