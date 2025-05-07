package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.domain.Cliente;
import org.fiap.api.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarClienteUseCase {

    @Autowired
    private ClienteGateway gateway;

    public CadastrarClienteUseCase(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public ClienteJson cadastrar(Cliente cliente) {
        return gateway.cadastrar(cliente);
    }
}
