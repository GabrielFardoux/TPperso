package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var fairyTail55 = new Manga("FairyTail",55,false);
        var fairyTail56 = new Manga("FairyTail56",56,true);
        var fairyTail57 = new Manga("FairyTail57",56,true);
        var fairyTail58 = new Manga("FairyTail58",56,true);
        var fairyTail59 = new Manga("FairyTail59",56,true);//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<Manga> fairyTail = new LinkedList<>();
        fairyTail.add(fairyTail55);
        fairyTail.add(fairyTail56);
        fairyTail.add(fairyTail57);
        fairyTail.add(fairyTail58);
        fairyTail.add(fairyTail59);

        /*List<Manga> listeManga2= new ArrayList<>();
        for(Manga manga : fairyTail){
            if (manga.getAcquis()) {
                listeManga2.add(manga);
            }
        }*/
        System.out.println(fairyTail);
        var maListeManga =  fairyTail.stream().filter(Manga::getAcquis).map(m->m.getName()).toList();


        System.out.println(maListeManga);
        /*for (int i=0 ;i< FairyTail.size();i=i+1 )
        {
            System.out.printf(FairyTail.get(i)+"\n");
        }*/

    var mangas = List.of(fairyTail56,fairyTail55);
    var library = new Library();
    library.add("FairyTail",fairyTail55);
        library.add("FairyTail56",fairyTail55);
        System.out.println(library);
    }
}