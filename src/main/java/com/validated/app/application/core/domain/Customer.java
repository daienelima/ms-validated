package com.validated.app.application.core.domain;

public record Customer(String id, String name, Address address, String cpf, Boolean isValidCpf) {

}
