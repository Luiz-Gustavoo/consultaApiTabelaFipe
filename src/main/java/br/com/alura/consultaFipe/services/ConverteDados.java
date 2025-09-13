package br.com.alura.consultaFipe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConverteDados implements IOConverteDados{
    @Override
    public <T> T converteDados(String json, Class<T> classe) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(json, classe);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
