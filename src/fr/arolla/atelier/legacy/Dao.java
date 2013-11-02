package fr.arolla.atelier.legacy;


import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import fr.mad.company.*;

public class Dao {
    public Dao(){
        repository=new DistantRepository();
    }
    private DistantRepository repository;

    List<Model.Fact> factsMock=new ArrayList<Model.Fact>();
    {   Model.Date date = getDate("8 janvier 1935");
        addFact(date, "Naissance d'Elvis Presley");
        addFact(date, "Mort d'Ulric Voyer");

        Model.Date date2 = getDate("16 aout 1977");
        addFact(date2, "Mort d'Elvis Presley");

        Model.Date date3 = getDate("5 janvier 1892");
        addFact(date3, "Naissance d'Ulric Voyer");

        Model.Date date4 = getDate("1 novembre 1929");
        addFact(date4, "Premier film parlant du cinéma français");

        Model.Date date5 = getDate("1 novembre 1952");
        addFact(date5, "Explosion de la première bombe H");

        Model.Date date6 = getDate("30 octobre 1980");
        addFact(date6, "Coluche annonce sa candidature à l’élection");

        Model.Date date7= getDate("30 octobre 1938");
        addFact(date7, "Orson Welles terrorise l’Amérique");

        Model.Date date8= getDate("28 octobre 1886");
        addFact(date8, "inauguration de la statue de la liberté");

        Model.Date date9= getDate("24 octobre 1915");
        addFact(date9, "Naissance de Bob Kane, créateur de Batman");

        Model.Date date10= getDate("21 octobre 1934");
        addFact(date10, "Première parution du journal de Mickey");

        Model.Date date11= getDate("12 octobre 1492");
        addFact(date11, "Christophe Colomb découvre l’Amérique");

    }

    private Model.Date getDate(String label) {
        Model.Date date = new Model.Date(label);
        date.setId(FactUtils.getUUID());
        return date;
    }

    private void addFact(Model.Date date, String factLabel) {
        Model.Fact f1=new Model.Fact();
        f1.setName(factLabel);
        f1.setDate(date);
        factsMock.add(f1);
    }


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public List<Model.Fact> all(){
         if(System.getenv("ENV").equals("DEV")){
            return factsMock;
          }
        return readDataBase();
    }

    public List<Model.Fact> readDataBase()  {
        return repository.retrieveData();
   }
}
