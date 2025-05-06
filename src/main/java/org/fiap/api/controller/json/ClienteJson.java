package org.fiap.api.controller.json;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ClienteJson {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Past(message = "Data de nascimento deve ser no passado")
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Size(min = 1, message = "Pelo menos um endereço é necessário")
    @NotNull(message = "Endereços são obrigatórios")
    private List<EnderecoJson> enderecos;
}
