package fr.arolla.atelier.legacy;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 */
public class FactUtils {

    private Dao dao=new Dao();

    public static int randomTen(){
        return new Random().nextInt(10);
    }

    public static int randomTwo(){
        return new Random().nextInt(2);
    }

    public static int computeWordDistance(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int[][] d = new int[n + 1][ m + 1];
        if (n == 0) return m;
        if (m == 0) return n;
        for (int i = 0; i <= n; d[i][ 0] = i++) { }
        for (int j = 0; j <= m; d[0][ j] = j++) { }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                int cost = (t.charAt(j - 1) == s.charAt(i - 1)) ? 0 : 1;
                d[i][ j] = Math.min(Math.min(d[i - 1][ j] + 1, d[i][ j - 1] + 1), d[i - 1][ j - 1] + cost);
            }
        }
        return d[n][ m];
    }

    public static void testDistance()
    {
        test("titi", "toto");
        test("Anticonstitutionnellement", "Anticonstitutionellement");
        test("", "Anticonstitutionellement");
    }

    private static void test(String string1, String string2) {
        System.out.println("distance "+string1+" "+string2+" = "+computeWordDistance(string1, string2));
    }


    public static int distance(String a, String b)
    {
        return computeWordDistance(a, b);
    }

    public static int distancePercent(String a, String b)
    {
        float m = a.length();
        if (b.length() > m) m = b.length();
        return (int)(((float) computeWordDistance(a, b) / m) * 100f);
    }


    public static int differency(String target, String src)
    {
        return computeWordDistance(target, src);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }


    public List<Model.Fact> getAll() {
        return dao.all();
    }
}
