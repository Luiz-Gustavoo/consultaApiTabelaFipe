package br.com.alura.consultaFipe.Modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias ("TipoVeiculo") int tipoVeiculo,
                      @JsonAlias("Valor") String valor,
                      @JsonAlias("Marca") String marca,
                      @JsonAlias("Modelo") String modelo,
                      @JsonAlias("AnoModelo") int anoModelo,
                      @JsonAlias("Combustivel") String Combustivel,
                      @JsonAlias("CodigoFipe") String CodigoFipe,
                      @JsonAlias("MesReferencia") String MesReferencia,
                      @JsonAlias("SiglaCombustivel") String SiglaCombustivel)
{
}
