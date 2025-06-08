package com.validated.app.adapters.out;

import com.validated.app.adapters.in.consumer.message.CustomerMessage;
import com.validated.app.adapters.out.mapper.CustomerMapper;
import com.validated.app.application.core.domain.Customer;
import com.validated.app.application.ports.out.CpfValidatedOutPutPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CpfValidatedAdapter implements CpfValidatedOutPutPort {

    private final KafkaTemplate<String, CustomerMessage> kafkaTemplate;
    private final String topic;

    public CpfValidatedAdapter(KafkaTemplate<String, CustomerMessage> kafkaTemplate,
                               @Value("${kafka.topic.received-cpf}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void sendCpfValidated(Customer customer) {
        log.info("Send cpf validation: {}", customer.cpf());
        var customerMessage = CustomerMapper.INSTANCE.toCustomerMessage(customer);
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), customerMessage);
    }
}
