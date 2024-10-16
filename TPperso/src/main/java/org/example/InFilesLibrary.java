package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class aims to store in the following manner books:
 * 
 * <pre>{@code
 * FairyTail;55;false;\n
 * FairyTail56;56;true;\n
 * FairyTail57;56;true;\n
 * }</pre>
 */
public class InFilesLibrary implements Library {

    private static final String ROOT_PATH = "/Users/tigranslama/projects/TPperso/TPperso";
    private static final Set<String> COLLECTION_NAME_FILES = new HashSet<>();

    @Override
    public String toString() {
        final List<String> books = COLLECTION_NAME_FILES.stream()
                .flatMap(file -> {
                    final List<String> lines = new ArrayList<>(linesOfFileSafe(file));
                    lines.add("\n");
                    return lines.stream();
                })
                .toList();
        return "Library: " + books;
    }

    List<String> lireLignes(String nomFichier) throws IOException {
        Path path = Paths.get(nomFichier);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public static List<String> stringToListOfString(List<String> list) {
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i <= list.size() - 1; i++) {
            String[] temp = list.get(i).split("\\s+");
            wordList.addAll(Arrays.asList(temp));
        }
        return wordList;

    }

    static List<String> linesOfFileSafe(String path) {
        try {
            return linesOfFile(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not read file " + path, e);
        }
    }


    static List<String> linesOfFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //return br.readLine();
            return br.lines().toList();
        }


    }

    static void writeToFile(String path, Manga content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            //return br.readLine();
            bw.write(content.getName() + ";" + content.getTome() + ";" + content.getAcquis() + ";" + "\n");
        }
    }

    //son but : enregistrer
    @Override
    public void add(String collectionTitle, Manga manga) throws IOException {
        var path = ROOT_PATH + collectionTitle + ".csv";
        COLLECTION_NAME_FILES.add(path);
        writeToFile(path, manga);
//ajouter une ligne dans le CSV à la fin
    }

    @Override
    public void delete(String collectionTitle, String mangaName) throws IOException {
        var path = ROOT_PATH + collectionTitle + ".csv";

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        List<String> lines = lireLignes(path);
        System.out.println(lines);


        List elementOfFiles = stringToListOfString(lines);
        System.out.println(elementOfFiles);
        var deletedStringRank = elementOfFiles.indexOf(mangaName);
        System.out.println(deletedStringRank);
        elementOfFiles.remove(deletedStringRank);

        var lineRank = lines.getFirst();
        System.out.println(lineRank);
        //lines.get(lineRank);
        File deletedFile = new File(path);
        deletedFile.delete();
        for (int i = 0; i <= elementOfFiles.size() - 1; i++) {
            String element = elementOfFiles.toString();
            FileWriter writer = new FileWriter(new File(path), true);

            writer.append(element);
        }


         /*var newMangas = new ArrayList<>(currentMangas);
                    var mangaRank = newMangas.indexOf(mangaName);

                    return newMangas;*/


        // writeToFile(path,lines);
        //soit, réécrire le fichier sans la ligne => stream
        //tu l
    }

    @Override
    public void acquire(String collectionTitle, Manga manga) {
        // tu prend la liste et tu réécris le fichier en mettant l'acquire a true
    }
}
