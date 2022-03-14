package br.com.willian.java;

import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicação {

    private static LerArquivo ator;
    private static LerArquivo atriz;
    private static LerArquivo todos;
    private static LerArquivo Agrupar;

    public Aplicação() {
    }
    public static void main(String[] args) {



        //lerarquivo
        ator = new LerArquivo("oscar_age_male.csv");
        atriz = new LerArquivo("oscar_age_female.csv");


        //desafio 1, ator mais jovem
        atormaisjovem();

        //desafio 2, atriz que mais ganhou
        atrizquemaisganhou();

        //desafio 3, atriz entre 20 e 30 mais premiada
        atrizentre30e20();

        //desafio 4
        //List<Celebridades> todos = new ArrayList<>();
        //todos.addAll(homens);
        //todos.addAll(mulheres);
        pessoasmaisoscar();

        //desafio 5
        //String nomeBuscado = inserirNome();
        //buscarNome(nomeBuscado, ator);

    }

    private static void atormaisjovem(){
        List<Celebridades> celebridadesList = ator.getCelebridadesList();
       Optional<Celebridades> celebridadesOptional = celebridadesList.stream()
               .min(Comparator.comparing(Celebridades::getIdade));
       celebridadesOptional.ifPresent(it -> System.out.println("O ator mais novo a receber o Oscar é o "+ it.getNome() + " com " + it.getIdade() + " anos de idade"));
    }

    private static void atrizquemaisganhou(){
        List<Celebridades> celebridadesList = atriz.getCelebridadesList();
          atriz.getCelebridadesList().stream()
                  .map(Celebridades::getNome)
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                  .entrySet().stream()
                  .max(Comparator.comparing(Map.Entry::getValue))
                  .ifPresent(x -> System.out.println ("A atriz que mais obteve Oscars foi " + x.getKey() + "Com " + x.getValue() + " Oscars"));

    }

    private static void atrizentre30e20(){
        ator.getCelebridadesList().stream();
        atriz.getCelebridadesList().stream()
                .filter(atriz -> atriz.getIdade() >=20 && atriz.getIdade() <=30)
                .map(Celebridades::getNome)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(x -> System.out.println("A atriz entre 20 e 30 anos com mais oscars é: " + x.getKey() + " com " + x.getValue() + " Oscars " ));
    }

    private static void pessoasmaisoscar(){
        System.out.println("Celebridades que ganharam mais de um oscar: ");
        ator.getCelebridadesList().stream()
                .map(Celebridades::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x.getKey() + " com " + x.getValue() + " Oscars "));


    }

 /*   public static String inserirNome(String Buscar) {
        Scanner scanner = new Scanner((System.in));
        return scanner.nextLine();
    }

    public static void  buscarNome(String retornoNome){
        ator.getCelebridadesList().stream()
                .filter(x -> x.getNome().trim().toUpperCase()
                        .equals(retornoNome.trim().toUpperCase()));
        if(retornoNome != null){
            ator.getCelebridadesList()
                    .forEach(x -> System.out.println(x.getClass()));
        }*/


    }


