package org.example;

import java.util.*;

public class AlgoritmoGenetico {
    private int TAMANHO_POPULACAO;
    private double TAXA_MUTACAO;
    private int TAMANHO_EQUIPE;
    private List<Candidato> todosCandidatos;
    Set<String> habilidadesNecessarias;

    public AlgoritmoGenetico(int TAMANHO_POPULACAO, double TAXA_MUTACAO, int TAMANHO_EQUIPE, List<Candidato> todosCandidatos, Set<String> habilidadesNecessarias) {
        this.TAMANHO_POPULACAO = TAMANHO_POPULACAO;
        this.TAXA_MUTACAO = TAXA_MUTACAO;
        this.TAMANHO_EQUIPE = TAMANHO_EQUIPE;
        this.todosCandidatos = todosCandidatos;
        this.habilidadesNecessarias = habilidadesNecessarias;
    }


    public List<Equipe> inicializarPopulacao(List<Candidato> todosCandidatos) {
        List<Equipe> populacao = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            List<Candidato> equipe = new ArrayList<>();
            for (int j = 0; j < TAMANHO_EQUIPE; j++) {
                Candidato novoCandidato;
                do {
                    novoCandidato = todosCandidatos.get(rand.nextInt(todosCandidatos.size()));
                } while (equipe.contains(novoCandidato));

                equipe.add(novoCandidato);
            }
            populacao.add(new Equipe(equipe, habilidadesNecessarias));
        }

        return populacao;
    }

    public List<Equipe> selecionar(List<Equipe> populacao) {
        populacao.sort((e1, e2) -> Double.compare(e2.fitness, e1.fitness));
        return populacao.subList(0, TAMANHO_POPULACAO / 2);
    }

    public Equipe crossover(Equipe pai1, Equipe pai2) {
        Random rand = new Random();
        List<Candidato> filho = new ArrayList<>();

        for (int i = 0; i < TAMANHO_EQUIPE; i++) {
            Candidato candidatoPai1 = pai1.candidatos.get(i);
            Candidato candidatoPai2 = pai2.candidatos.get(i);

            Candidato candidatoEscolhido = rand.nextBoolean() ? candidatoPai1 : candidatoPai2;

            if (filho.contains(candidatoEscolhido)) {
                candidatoEscolhido = (candidatoEscolhido == candidatoPai1) ? candidatoPai2 : candidatoPai1;
            }
            filho.add(candidatoEscolhido);
        }

        return new Equipe(filho, habilidadesNecessarias);
    }

    public void mutar(Equipe equipe) {
        Random rand = new Random();
        for (int i = 0; i < TAMANHO_EQUIPE; i++) {
            if (rand.nextDouble() < TAXA_MUTACAO) {
                Candidato novoCandidato;
                do {
                    novoCandidato = todosCandidatos.get(rand.nextInt(todosCandidatos.size()));
                } while (equipe.candidatos.contains(novoCandidato));

                equipe.candidatos.set(i, novoCandidato);
            }
        }
    }


}



