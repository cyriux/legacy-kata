package fr.arolla.atelier.legacy;

/**
 * models
 */
public class Model {


    public static class Object {
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
    public static class Named extends Object {
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static class Book extends Named {
        private Author author;

        public String toString(){
            return getName().concat(", ").concat(author.toString());
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }

    public static class Author extends Named {
        private String prename;

        public String getPrename() {
            return prename;
        }

        public void setPrename(String prename) {
            this.prename = prename;
        }

        public String toString(){
            return getName().concat(" ").concat(prename);
        }

    }

}
