package br.com.alura.consultaFipe.services;

public interface IOConverteDados {
    <T> T converteDados(String json, Class<T> classe);
}
