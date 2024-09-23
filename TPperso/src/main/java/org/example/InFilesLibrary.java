package org.example;

public class InFilesLibrary implements Library {
    //son but : enregistrer
    @Override
    public void add(String collectionTitle, Manga manga) {
//ajouter une ligne dans le CSV à la fin
    }

    @Override
    public void delete(String collectionTitle, String mangaName) {
    //soit, réécrire le fichier sans la ligne => stream
        //tu l
    }

    @Override
    public void acquire(String collectionTitle, Manga manga) {
    // tu prend la liste et tu réécris le fichier en mettant l'acquire a true
    }
}
