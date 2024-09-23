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

```
java
 return currentMangas.stream()
                            .map(m -> {
                                if (m.getName().equals(manga.getName())) {
                                    return new Manga(manga.getName(), manga.getTome(), true);
                                }
                                return m;
                            })
                            .toList();
```
## Explication : 
list "currentManga" on en fait un stream 
puis un map avec pour condition si le getName de lambda m est EGAL au nom du manga de la fonction
alors il retourne un nouveau manga avec le getName et le getTome du manga en changeant son acquisition en true 


    

lecon du  23/09/2024

J2E
JEE
Java Enterprise Edition
jakarta

- Extraire dans un comtrat d'interface
- Soit on persiste dans un fichier -(pour faire joujou avec fichier)
  - moins gratifiant pcq pas d'avancée constatée
- soit on persiste dans SQLite 

rendre abstrait = etat intermediaire entre interface et la classe

but heritage = partager du code

mission potentielle : faire en sorte que ca s'enregistre en arborescence

file reader => lit le fichier
un buffer => api permettant de lire une partie d'un fichier
si tu ferme pas c'est un memory leak prend la place en mémoire, + faille de sécu TOUJOURS CLOSE LES INPÜT ET OUTPUT

```
java
  static List<String> LinesOfFile(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //return br.readLine();
            lines.addAll(br.lines().toList());
        }
        return lines;
```

dans in filesMemory, faire ce qu'on a écrit dans playground
api a utiliser => paths ou files 

