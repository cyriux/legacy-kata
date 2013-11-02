package fr.arolla.atelier.legacy;

import java.util.UUID;

/**
 * models
 */
public class Model {


    public static class BddEntity {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    public static class Labeled extends BddEntity {
        private String label;


        public String getLabel() {
            return label;
        }

        public void setName(String name) {
            this.label = name;
        }
    }
    public static class Fact extends Labeled {
        private Date date;

        public String toString(){
            return date.toString().concat(" - ").concat(getLabel());
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public boolean equals(Object o){
            return (getLabel().equals(((Fact)o).getLabel()) && getDate().getLabel().equals(((Fact)o).getDate().getLabel()));
        }
    }

    public static class Date extends Labeled {

        public Date(String date){
           setName(date);
        }
        public String toString(){
            return getLabel();
        }

    }

}
