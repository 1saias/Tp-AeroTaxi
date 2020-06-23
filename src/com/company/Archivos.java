package com.company;

import com.company.Aeronaves.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Archivos {
    public void agregarUser(File file, Usuario user) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file,user);
    }

    public Usuario recuperarUno2(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Usuario aux = mapper.readValue(file,Usuario.class);
        return aux;
    }
    public void agregarAvionBronce(File file,Bronze avion) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file,avion);
    }

    public Bronze recuperarUno(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Bronze aux = mapper.readValue(file,Bronze.class);
        return aux;
    }
}
