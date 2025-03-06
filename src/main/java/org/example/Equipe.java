package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipe {
    List<Candidato> candidatos;
    double fitness;
    Set<String> habilidadesNecessarias;

    Equipe(List<Candidato> candidatos, Set<String> habilidadesNecessarias) {
        this.candidatos = candidatos;
        this.habilidadesNecessarias = habilidadesNecessarias;
        this.fitness = calcularFitness();
    }

    double calcularFitness() {
        Set<String> habilidadesEquipe = new HashSet<>();

        for (Candidato candidato : candidatos) {
            habilidadesEquipe.addAll(candidato.habilidades);
        }
        Set<String> habilidadesCorrespondentes  = new HashSet<>();
        habilidadesEquipe.forEach(elemento -> {
                    if (habilidadesNecessarias.contains(elemento)) {
                        habilidadesCorrespondentes.add(elemento);
                    }
                }
        );
        return (double) habilidadesCorrespondentes.size() / habilidadesNecessarias.size();
    }
}