package org.fiap.api.exception;

public class ClienteJaExistenteException extends RuntimeException{
    public ClienteJaExistenteException(String cpf) {
        super("Cliente com CPF " + cpf + " já existe.");
    }
}
