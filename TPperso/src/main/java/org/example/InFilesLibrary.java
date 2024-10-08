package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static org.example.PlaygroundFile.linesOfFile;

public class InFilesLibrary implements Library {

    static List<String> linesOfFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //return br.readLine();
            return br.lines().toList();
        }


    }
    static void writeToFile(String path,Manga content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
            //return br.readLine();
            bw.write(content.getName()+"," +content.getTome()+","+content.getAcquis()+",");
        }
    }
    //son but : enregistrer
    @Override
    public void add(String collectionTitle, Manga manga) throws IOException {
        var path = "C:\\Users\\crush\\Desktop\\TPperso\\TPperso\\" + collectionTitle + ".csv";
        writeToFile(path,manga);
//ajouter une ligne dans le CSV à la fin
    }

    @Override
    public void delete(String collectionTitle, String mangaName) throws IOException {
        var path = "C:\\Users\\crush\\Desktop\\TPperso\\TPperso\\" + collectionTitle + ".csv";
        List<String> lines= linesOfFile(path);
        var lineRank = lines.getFirst();
        System.out.println(lineRank);
        //lines.get(lineRank);
        File deletedFile = new File(path);
        deletedFile.delete();
        for (String line : lines) {
            try (FileWriter writer = new FileWriter(new File(path), true)) {
                writer.append(line);
            }

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
