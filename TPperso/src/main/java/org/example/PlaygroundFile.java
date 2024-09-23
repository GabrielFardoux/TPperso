package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class PlaygroundFile {
    public static void main(String[] args) throws IOException {
        String firstLine = firstLineOfFile("C:\\Users\\Gabriel\\IdeaProjects\\TPperso\\TPperso\\leconTigrou.md");
        System.out.println(firstLine);
        List<String> Lines = linesOfFile("C:\\Users\\Gabriel\\IdeaProjects\\TPperso\\TPperso\\leconTigrou.md");
        System.out.println(Lines);
        writeToFile("C:\\Users\\Gabriel\\IdeaProjects\\TPperso\\TPperso\\playGroundLecon.md",firstLine);
        String writedLine = firstLineOfFile("C:\\Users\\Gabriel\\IdeaProjects\\TPperso\\TPperso\\playGroundLecon.md");
        System.out.println(writedLine);
    }
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    static List<String> linesOfFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //return br.readLine();
            return br.lines().toList();
        }


    }
   static void writeToFile(String path,String content) throws IOException {
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
           //return br.readLine();
            bw.write(content);
       }
   }

}
