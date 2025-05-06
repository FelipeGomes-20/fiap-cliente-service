package org.fiap.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.usecase.CadastrarClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private CadastrarClienteUseCase cadastrarCliente;

    @PostMapping
    public ResponseEntity<ClienteJson> criar(@Valid @RequestBody ClienteJson clienteJson) {
        ClienteJson clienteSalvo = cadastrarCliente.executar(clienteJson);
        return ResponseEntity.created(URI.create("/clientes/" + clienteSalvo.getId())).body(clienteSalvo);
    }
}
