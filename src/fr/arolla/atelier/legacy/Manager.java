package fr.arolla.atelier.legacy;


import java.util.List;

public class Manager {

    private FactUtils factUtils;
    public Manager(){
        factUtils=new FactUtils();
    }

    public Model.Fact get(String input){

        Model.Fact fact=null;
        int dm=999999999;
        List<Model.Fact> l = factUtils.getAll();
        for (Model.Fact f:l){
            String[] w_a = input.split("[' ,._/]", 6);
            String[] w_b = f.getLabel().split("[' ,._/]", 6);
            int d = 0;

            for (int a = 0; a < w_a.length; a++)
            {
                int min_index = -1;
                int dist = Integer.MAX_VALUE;
                for (int b = 0; b < w_b.length; b++)
                {
                    if (w_b[b] != null)
                    {
                        int local_dist = factUtils.distance(w_a[a], w_b[b]);

                        if (local_dist < dist)
                        {
                            min_index = b;
                            dist = local_dist;
                        }
                    }
                }
                d += dist;
                w_b[min_index] = null;

            }

            System.out.println("("+input+"/"+f.getLabel()+") = "+d);
            if(d<=dm){
                dm=d;
                fact=f;
            }
        }
        return fact;
    }


    public Model.Fact related(Model.Fact fact){
        Model.Fact f=null;
        if(factUtils.randomTwo()==1){
            List<Model.Fact> l = factUtils.getAll();
            for (Model.Fact f1:l){
                if(fact.getDate().getId()==f1.getDate().getId()){
                    if(!fact.equals(f1)){
                        f=f1;
                    }
                }
            }
        }
        if(f!=null){
            return f;
        }
        int dv=factUtils.randomTen()+1;
        if(f==null){
            List<Model.Fact> l = factUtils.getAll();
            for (Model.Fact f2:l){
                String[] w_a = f2.getLabel().split("[' ,._/]", 6);
                String[] w_b = fact.getLabel().split("[' ,._/]", 6);
                int d = 0;
                // -------- Boucle primaire
                for (int a = 0; a < w_a.length; a++)
                {
                    int min_index = -1;
                    int dist = Integer.MAX_VALUE;
                    // -------- Boucle secondaire
                    for (int b = 0; b < w_b.length; b++)
                    {
                        if (w_b[b] != null)
                        {
                            int local_dist = FactUtils.distance(w_a[a], w_b[b]);

                            if (local_dist < dist){
                                min_index = b;
                                dist = local_dist;
                            }
                        }
                    }
                    d += dist;
                    if(min_index !=-1){
                        w_b[min_index] = null;
                    }
                }

                System.out.println("("+f2.getLabel()+"/"+fact.getLabel()+") = "+d);
                if(d==dv){
                   f=f2;
                }
            }
            if(f==null){
                int dm=999999999;
                for (Model.Fact f3:l){
                    String[] w_a = f3.getLabel().split("[' ,._/]", 6);
                    String[] w_b = fact.getLabel().split("[' ,._/]", 6);
                    int d = 0;
                    // -------- Boucle primaire
                    for (int a = 0; a < w_a.length; a++)
                    {
                        int min_index = -1;
                        int dist = Integer.MAX_VALUE;
                        // -------- Boucle secondaire
                        for (int b = 0; b < w_b.length; b++)
                        {
                            if (w_b[b] != null)
                            {
                                int local_dist = FactUtils.distance(w_a[a], w_b[b]);

                                if (local_dist < dist)
                                {
                                    min_index = b;
                                    dist = local_dist;
                                }
                            }
                        }
                        d += dist;

                        if(min_index!=-1){
                            w_b[min_index] = null;
                        }

                    }

                   System.out.println("("+fact.getLabel()+"/"+f3.getLabel()+") = "+d);
                    if(d<=dm){
                        if(!fact.equals(f3)){
                            dm=d;
                            f=f3;
                        }
                    }
                }
            }
        }
        return f;
    }



}
