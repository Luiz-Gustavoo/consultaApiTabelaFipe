package br.com.alura.consultaFipe.Modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(@JsonAlias ("modelos") Modelo[] modelos) {
}
