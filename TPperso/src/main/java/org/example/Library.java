package org.example;

public interface Library {
    void add(String collectionTitle, Manga manga);

    void delete(String collectionTitle, String mangaName);

    void acquire(String collectionTitle, Manga manga);
}
