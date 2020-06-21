package com.company;

import java.util.ArrayList;
import java.util.List;

public class FuncionesAuxiliares {
    FuncionesAuxiliares(){}
    ///Usuarios
    public int validarUsuario(List<Usuario> usuarios, Usuario usuario) {
        int validacion = 0;
        for (Usuario user : usuarios) {
            if (user.equals(usuario) == true) {
                validacion = 1;
            }
        }
        return validacion;
    }
}
