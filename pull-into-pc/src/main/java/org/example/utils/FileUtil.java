package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtil {

    public static String calculateHash(String filePath) throws Exception {
        File file = new File(filePath);

        // Verifica se o caminho é válido e imprime o conteúdo
        if (!file.exists()) {
            throw new IOException("O caminho especificado não existe: " + filePath);
        }

        System.out.println("Conteúdo do diretório: ");
        if (file.isDirectory()) {
            // Se for um diretório, listamos os arquivos antes de calcular o hash
            listDirectoryContent(file);
            return calculateDirectoryHash(file);
        } else {
            // Se for um arquivo, calculamos o hash diretamente
            return calculateFileHash(file);
        }
    }

    // Calcula o hash de um único arquivo
    private static String calculateFileHash(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[1024];
            int bytesCount;
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
        }

        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Calcula o hash de todos os arquivos dentro de um diretório, recursivamente
    private static String calculateDirectoryHash(File directory) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Percorrer todos os arquivos e subdiretórios dentro do diretório
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                // Se for subdiretório, chamamos recursivamente
                digest.update(calculateDirectoryHash(file).getBytes());
            } else {
                // Se for arquivo, calculamos o hash
                digest.update(calculateFileHash(file).getBytes());
            }
        }

        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Lista o conteúdo de um diretório
    private static void listDirectoryContent(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath() + (file.isDirectory() ? " [DIR]" : ""));
            }
        }
    }
}
