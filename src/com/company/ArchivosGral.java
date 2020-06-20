package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ArchivosGral {
    public void agregarAarchivo(File correspondiente, Object generico) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(correspondiente, generico);
    }
    public Object retirarObjeto(File)
}