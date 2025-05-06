package org.fiap.api.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(Long id) {
        super("Cliente do id " + id + " não encontrado.");
    }
}
