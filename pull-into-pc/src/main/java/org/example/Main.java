package org.example;

import org.example.utils.FileUtil;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui ja calcula o hash
        String PASTA_ARQUIVOS = "C:\\ws\\jr-p2p-pull\\pull-into-pc\\meu-first-pull\\package\\Boa noite\\index.txt";
        String PASTA_ARQUIVOS2 = "C:\\ws\\jr-p2p-pull\\pull-into-pc\\meu-first-pull\\package\\Boa noite2\\index.txt";

        String hash = FileUtil.calculateHash(PASTA_ARQUIVOS);

        System.out.println("Hash do diretório: " + hash);
        String hash2 = FileUtil.calculateHash(PASTA_ARQUIVOS2);

        if(hash.equals(hash2)){
            System.out.print("Sim deu bom");
        }else{
            System.out.print("Deu melhor\n");
        }

        List<String> linhas1 = Files.readAllLines(Paths.get(PASTA_ARQUIVOS));
        List<String> linhas2 = Files.readAllLines(Paths.get(PASTA_ARQUIVOS2));

        for (int i = 0; i < Math.max(linhas1.size(), linhas2.size()); i++) {
            String linha1 = i < linhas1.size() ? linhas1.get(i) : "Linha ausente no primeiro arquivo";
            String linha2 = i < linhas2.size() ? linhas2.get(i) : "Linha ausente no segundo arquivo";

            if (!linha1.equals(linha2)) {
                System.out.println("Diferença na linha " + (i + 1) + ":");
                System.out.println("Arquivo 1: " + linha1);
                System.out.println("Arquivo 2: " + linha2);
            }
        }

    }
}