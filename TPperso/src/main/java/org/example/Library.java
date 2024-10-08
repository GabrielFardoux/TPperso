package org.example;

import java.io.IOException;

public interface Library {
    void add(String collectionTitle, Manga manga) throws IOException;

    void delete(String collectionTitle, String mangaName) throws IOException;

    void acquire(String collectionTitle, Manga manga);
}
