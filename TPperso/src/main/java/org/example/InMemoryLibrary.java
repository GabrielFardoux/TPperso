package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryLibrary implements Library {
    private Map<String, List<Manga>> collections;

    public InMemoryLibrary() {
        this.collections = new HashMap<>();
    }

    @Override
    public void add(String collectionTitle, Manga manga) {
//        collections.put(collectionTitle,List.of(manga));

        collections.computeIfPresent(collectionTitle,
                (key, currentMangas) -> {
                    var newMangas = new ArrayList<>(currentMangas);
                    newMangas.add(manga);
                    return newMangas;

                });
        collections.putIfAbsent(collectionTitle, List.of(manga));
    }

    @Override
    public void delete(String collectionTitle, String mangaName) {

        collections.computeIfPresent(collectionTitle,
                (key, currentMangas) -> {
                    return currentMangas.stream()
                            .filter(m -> !m.getName().equals(mangaName))
                            .toList();

                    /*var newMangas = new ArrayList<>(currentMangas);
                    var mangaRank = newMangas.indexOf(mangaName);
                    newMangas.remove(mangaRank);
                    return newMangas;*/
                });

//trouver la collection
// filtrer la liste pour enlever le manga en trop
// supprimer le manga
    }

    @Override
    public void acquire(String collectionTitle, Manga manga) {
        collections.computeIfPresent(collectionTitle,
                (key, currentMangas) -> {
                    //var wantingName = manga.getName();
                    return currentMangas.stream()
                            .map(m -> {
                                if (m.getName().equals(manga.getName())) {
                                    return new Manga(manga.getName(), manga.getTome(), true);
                                }
                                return m;
                            })
                            .toList();
                    //version en vieux java
                    /*var newMangas = new ArrayList<>(currentMangas);
                    var mangaRank = newMangas.indexOf(manga);
                    var mangaContent=newMangas.get(mangaRank);
                    var updatedManga = new Manga(mangaContent.getName(),mangaContent.getTome(),true);
                    newMangas.set(mangaRank,updatedManga);
                    return newMangas;*/
                });

        //trouver la collection
        //trouver l'item
        //modifier le boolean pour le passer en acquire
    }

    @Override
    public String toString() {
        return "Library : " + collections + " ";
    }
}
