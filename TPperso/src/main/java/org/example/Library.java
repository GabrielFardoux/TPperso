package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Library {
    private Map<String, List<Manga>> collections;

    public Library(){
        this.collections = new HashMap<>();
    }
    void add(String collectionTitle,Manga manga){
//        collections.put(collectionTitle,List.of(manga));

        collections.computeIfPresent(collectionTitle,
                (key,currentMangas)->{
                    var newMangas = new ArrayList<>(currentMangas);
                    newMangas.add(manga);
                    return newMangas;

                });
        collections.putIfAbsent(collectionTitle,List.of(manga));
    }
    void delete(String collectionTitle,String mangaName){
//trouver la collection
// filtrer la liste pour enlever le manga en trop
// supprimer le manga
    }
    void acquire(String collectionTitle,String mangaName){
        //trouver la collection
        //trouver l'item
        //modifier le boolean pour le passer en acquire
    }

    @Override
    public String toString() {
        return "Library : "+collections+" ";
    }
}
