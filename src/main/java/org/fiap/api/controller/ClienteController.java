package org.fiap.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.controller.json.EnderecoJson;
import org.fiap.api.domain.Cliente;
import org.fiap.api.domain.Endereco;
import org.fiap.api.usecase.CadastrarClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private CadastrarClienteUseCase cadastrarCliente;

    @PostMapping
    public ResponseEntity<ClienteJson> criar(@Valid @RequestBody ClienteJson clienteJson) {
        ClienteJson clienteSalvo = cadastrarCliente.cadastrar(mapToDomain(clienteJson));
        return ResponseEntity.created(URI.create("/clientes/" + clienteSalvo.getId())).body(clienteSalvo);
    }

    private Cliente mapToDomain(ClienteJson json) {
        return new Cliente(
                json.getId(), json.getNome(),
                json.getCpf(), json.getDataNascimento(),
                json.getEnderecos().stream()
                        .map(this::mapEnderecoJsonToDomain)
                        .collect(Collectors.toList())
        );
    }

    private Endereco mapEnderecoJsonToDomain(EnderecoJson json) {
        return new Endereco(
                json.getRua(), json.getNumero(),
                json.getComplemento(), json.getBairro(),
                json.getCidade(), json.getEstado(), json.getCep()
        );
    }

    private EnderecoJson mapEnderecoToJson(Endereco domain) {
        return new EnderecoJson(
                domain.getRua(), domain.getNumero(),
                domain.getComplemento(), domain.getBairro(),
                domain.getCidade(), domain.getEstado(), domain.getCep()
        );
    }
}