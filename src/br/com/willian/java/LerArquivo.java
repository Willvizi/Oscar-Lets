package br.com.willian.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LerArquivo {

    private final List<Celebridades> celebridadesList;

    public LerArquivo(String filename) {this.celebridadesList = lerArquivo(filename);}

    private List<Celebridades> lerArquivo(String filename) {
        try (Stream<String> fileLines = Files.lines(Paths.get(filename))) {
            return fileLines
                    .skip(1)
                    .map(Celebridades::of)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }


        }



    public List<Celebridades> getCelebridadesList() {return celebridadesList; }
}



