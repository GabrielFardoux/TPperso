test

<h1>test</h1>

# test

- item1
- item2

_Quelquechose_

*je suis gras*

[quelquechose.quelcquechose](https://google.com)

![test]()

```java
    public Manga(java.lang.String name, int tome,boolean acquis) {
        this.name = name;
        this.tome = tome;
        this.acquis = acquis;
    }
```
```java
    void add(String collectionTitle,Manga manga){
//        collections.put(collectionTitle,List.of(manga));
        collections.computeIfPresent(collectionTitle,
                (key,currentMangas)->{
                    var newMangas = new ArrayList<>(currentMangas);
                    newMangas.add(manga);
                    return newMangas;

                });
    }
```

on donne des noms en anglais 

# comment on construit une classe
- en premier les attributs (en private)
- puis les moyen de le construire 
- puis les assesseurs (getter setter)

*POJO* Plain Old Java Object



## methode
d'abord en private 
SI besoin a l'exterieur on donne plus de droit

meilleure methode pour créer une interface,
la créer d'abord sous forme de classe


# Une interface
une interface permet a des classes implémenté d'utiliser des Contrats 
sous forme de méthodes et ainsi utiliser ces méthodes librement
