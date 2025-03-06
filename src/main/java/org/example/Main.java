package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int TAMANHO_POPULACAO = 100;
        double TAXA_MUTACAO = 0.11;
        int NUMERO_GERACOES = 1000;
        int TAMANHO_EQUIPE = 5;
        Set<String> habilidadesNecessarias = new HashSet<>(Arrays.asList("Java", "Python", "SQL Server", "Dart", "JavaScript", "HTML", "Flutter", "TypeScript", "React"));

        List<Candidato> todosCandidatos = Arrays.asList(
                new Candidato("Candidato1", new HashSet<>(Arrays.asList("Java", "Spring Boot"))),
                new Candidato("Candidato2", new HashSet<>(Arrays.asList("PHP", "SQL Server", "Java"))),
                new Candidato("Candidato3", new HashSet<>(Arrays.asList("Java", "SQL Server"))),
                new Candidato("Candidato4", new HashSet<>(Arrays.asList("Python", "PHP"))),
                new Candidato("Candidato5", new HashSet<>(Arrays.asList("Java", "Dart", "Python"))),
                new Candidato("Candidato6", new HashSet<>(Arrays.asList("SQL Server", "Python", "MySQL"))),
                new Candidato("Candidato7", new HashSet<>(Arrays.asList("HTML", "JavaScript", "MySQL"))),
                new Candidato("Candidato8", new HashSet<>(Arrays.asList("C#", "C++"))),
                new Candidato("Candidato9", new HashSet<>(Arrays.asList("C++", "Java"))),
                new Candidato("Candidato10", new HashSet<>(Arrays.asList("Python", "Django"))),
                new Candidato("Candidato11", new HashSet<>(Arrays.asList("JavaScript", "React"))),
                new Candidato("Candidato12", new HashSet<>(Arrays.asList("TypeScript", "Node.js"))),
                new Candidato("Candidato13", new HashSet<>(Arrays.asList("Go", "PostgreSQL"))),
                new Candidato("Candidato14", new HashSet<>(Arrays.asList("Ruby on Rails", "JavaScript"))),
                new Candidato("Candidato15", new HashSet<>(Arrays.asList("Kotlin", "Android"))),
                new Candidato("Candidato16", new HashSet<>(Arrays.asList("Swift", "iOS"))),
                new Candidato("Candidato17", new HashSet<>(Arrays.asList("Perl", "Linux"))),
                new Candidato("Candidato18", new HashSet<>(Arrays.asList("SQL Server", "Azure"))),
                new Candidato("Candidato19", new HashSet<>(Arrays.asList("Python", "Machine Learning"))),
                new Candidato("Candidato20", new HashSet<>(Arrays.asList("Java", "Spring Boot"))),
                new Candidato("Candidato21", new HashSet<>(Arrays.asList("Flutter", "Firebase"))),
                new Candidato("Candidato22", new HashSet<>(Arrays.asList("Vue.js", "PHP"))),
                new Candidato("Candidato23", new HashSet<>(Arrays.asList(".NET", "C#"))),
                new Candidato("Candidato24", new HashSet<>(Arrays.asList("Rust", "Blockchain"))),
                new Candidato("Candidato25", new HashSet<>(Arrays.asList("HTML", "CSS", "JavaScript"))),
                new Candidato("Candidato26", new HashSet<>(Arrays.asList("Angular", "TypeScript"))),
                new Candidato("Candidato27", new HashSet<>(Arrays.asList("Laravel", "PHP"))),
                new Candidato("Candidato28", new HashSet<>(Arrays.asList("Node.js", "MongoDB"))),
                new Candidato("Candidato29", new HashSet<>(Arrays.asList("Python", "Data Science"))),
                new Candidato("Candidato30", new HashSet<>(Arrays.asList("Java", "Kubernetes"))),
                new Candidato("Candidato31", new HashSet<>(Arrays.asList("C", "Embedded Systems"))),
                new Candidato("Candidato32", new HashSet<>(Arrays.asList("Scala", "Big Data"))),
                new Candidato("Candidato33", new HashSet<>(Arrays.asList("Dart", "Flutter"))),
                new Candidato("Candidato34", new HashSet<>(Arrays.asList("Elixir", "Phoenix"))),
                new Candidato("Candidato35", new HashSet<>(Arrays.asList("COBOL", "Mainframe"))),
                new Candidato("Candidato36", new HashSet<>(Arrays.asList("Fortran", "Numerical Computing"))),
                new Candidato("Candidato37", new HashSet<>(Arrays.asList("Python", "TensorFlow"))),
                new Candidato("Candidato38", new HashSet<>(Arrays.asList("Java", "Microservices"))),
                new Candidato("Candidato39", new HashSet<>(Arrays.asList("PHP", "MySQL"))),
                new Candidato("Candidato40", new HashSet<>(Arrays.asList("JavaScript", "Vue.js"))),
                new Candidato("Candidato41", new HashSet<>(Arrays.asList("Swift", "macOS"))),
                new Candidato("Candidato42", new HashSet<>(Arrays.asList("Ruby", "Sinatra"))),
                new Candidato("Candidato43", new HashSet<>(Arrays.asList("Kotlin", "Multiplatform"))),
                new Candidato("Candidato44", new HashSet<>(Arrays.asList("Java", "Hibernate"))),
                new Candidato("Candidato45", new HashSet<>(Arrays.asList("Python", "FastAPI"))),
                new Candidato("Candidato46", new HashSet<>(Arrays.asList("C++", "Game Development"))),
                new Candidato("Candidato47", new HashSet<>(Arrays.asList("JavaScript", "Svelte"))),
                new Candidato("Candidato48", new HashSet<>(Arrays.asList("Go", "Docker"))),
                new Candidato("Candidato49", new HashSet<>(Arrays.asList("C#", ".NET Core"))),
                new Candidato("Candidato50", new HashSet<>(Arrays.asList("Python", "Pandas"))),
                new Candidato("Candidato51", new HashSet<>(Arrays.asList("TypeScript", "Python"))),
                new Candidato("Candidato52", new HashSet<>(Arrays.asList("TypeScript", "C#")))
        );


        AlgoritmoGenetico gen = new AlgoritmoGenetico(TAMANHO_POPULACAO, TAXA_MUTACAO, TAMANHO_EQUIPE, todosCandidatos, habilidadesNecessarias);
        List<Equipe> populacao = gen.inicializarPopulacao(todosCandidatos);

        Equipe melhorEquipe = gen.encontrarMelhorEquipe(NUMERO_GERACOES, populacao);

        System.out.println("Melhor equipe encontrada:");
        for (Candidato candidato : melhorEquipe.candidatos) {
            System.out.println(candidato.nome + " - " + candidato.habilidades);
        }
        System.out.println("Fitness: " + melhorEquipe.fitness);
    }
}

