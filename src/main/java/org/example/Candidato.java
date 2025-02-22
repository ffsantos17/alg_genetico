package org.example;

import java.util.Set;

public class Candidato {
    String nome;
    Set<String> habilidades;

    Candidato(String nome, Set<String> habilidades) {
        this.nome = nome;
        this.habilidades = habilidades;
    }
}
