package org.fiap.api.controller.json;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class ClienteJson {

    private Long id;

    @NotBlank(message = "Nome vazio! Insira um nome válido.")
    private String nome;

    @NotBlank(message = "CPF vazio! Insira um CPF válido.")
    @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos! Insira um CPF válido.")
    //@CPF(message = "") substituir depois
    private String cpf;

    @NotNull(message = "Data vazia! Insira uma data válida.")
    private LocalDate dataNascimento;

    @Valid
    private List<EnderecoJson> enderecos;
}
