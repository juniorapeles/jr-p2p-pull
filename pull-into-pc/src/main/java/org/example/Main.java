package org.example;

import org.example.utils.FileUtil;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui ja calcula o hash
        String PASTA_ARQUIVOS = "C:\\ws\\jr-p2p-pull\\pull-into-pc\\meu-first-pull";
        String hash = FileUtil.calculateHash(PASTA_ARQUIVOS);
        System.out.println("Hash do diretório: " + hash);
        String hash2 = FileUtil.calculateHash(PASTA_ARQUIVOS);
        if(hash.equals("f796d36b56f798ebf20d3869b63ebdc1f750ec899650d9a36e26b094d725ba5a")){
            System.out.print("Sim deu bom");
        }else{
            System.out.print("Deu melhor");
        }

    }
}