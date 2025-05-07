package org.fiap.api.gateway;

import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.domain.Cliente;

public interface ClienteGateway {
    ClienteJson cadastrar(Cliente cliente);
}
