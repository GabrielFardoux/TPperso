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

        collections.computeIfPresent(collectionTitle,
                (key,currentMangas)->{
                    var newMangas = new ArrayList<>(currentMangas);
                    var mangaRank = newMangas.indexOf(mangaName);
                    newMangas.remove(mangaRank);
                    return newMangas;
                });

//trouver la collection
// filtrer la liste pour enlever le manga en trop
// supprimer le manga
    }
    void acquire(String collectionTitle,Manga manga){
        collections.computeIfPresent(collectionTitle,
                (key,currentMangas)->{
                    var wantingName = manga.getName();
                    var newMangas = new ArrayList<>(currentMangas);
                    var mangaRank = newMangas.indexOf(wantingName);
                    var mangaContent=newMangas.get(mangaRank);
                    var mangaContentName= mangaContent.getName();
                    var mangaContentTome= mangaContent.getTome();
                    var updatedManga = new Manga(mangaContentName,mangaContentTome,true);
                    newMangas.set(mangaRank,updatedManga);
                    return newMangas;
                });
        //trouver la collection
        //trouver l'item
        //modifier le boolean pour le passer en acquire
    }

    @Override
    public String toString() {
        return "Library : "+collections+" ";
    }
}
