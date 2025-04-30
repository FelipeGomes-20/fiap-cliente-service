package org.fiap.api.controller.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnderecoJson {

    @NotBlank(message = "Rua vazia! Insira uma rua válida.")
    private String rua;

    @NotBlank(message = "Número vazio! Insira um número válido.")
    private int numero;

    private String complemento;

    @NotBlank(message = "Bairro vazio! Insira um bairro válido.")
    private String bairro;

    @NotBlank(message = "Cidade vazia! Insira uma cidade válida.")
    private String cidade;

    @NotBlank(message = "Estado vazio! Insira um estado válido.")
    private String estado;

    @NotBlank(message = "CEP vazio! Insira um CEP válido.")
    @Pattern(regexp = "^\\d{8}$", message = "O CEP deve conter exatamente 8 dígitos numéricos! Insira um CEP válido.")
    private String cep;
}
