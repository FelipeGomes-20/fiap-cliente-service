package org.fiap.api.gateway.database.jpa;

import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.domain.Cliente;
import org.fiap.api.gateway.ClienteGateway;
import org.fiap.api.gateway.database.jpa.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteJpaGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteJson cadastrar(Cliente cliente) {
        return null;
    }
}
