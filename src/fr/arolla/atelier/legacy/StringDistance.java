package fr.arolla.atelier.legacy;

public class StringDistance {


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

    public static int computeMultiWordsDistance(String s, String t)
    {
        String separators = "[' ,._/]";
        String[] w_a = s.split(separators, 6);
        String[] w_b = t.split(separators, 6);
        int result = 0;
        // -------- Boucle primaire
        for (int ia = 0; ia < w_a.length; ia++)
        {
            int min_index = -1;
            int dist = Integer.MAX_VALUE;
            // -------- Boucle secondaire
            for (int ib = 0; ib < w_b.length; ib++)
            {
                if (w_b[ib] != null)
                {
                    int local_dist = computeWordDistance(w_a[ia], w_b[ib]);

                   if (local_dist < dist)
                    {
                        min_index = ib;
                        dist = local_dist;
                    }
                }
            }
            result += dist;
            if(min_index>=0){
                w_b[min_index] = null;
            }
        }
        return result;
    }

    public static int distance(String a, String b)
    {
        return computeMultiWordsDistance(a, b);
    }

    public static int distancePercent(String a, String b)
    {
        float m = a.length();
        if (b.length() > m) m = b.length();
        return (int)(((float) computeMultiWordsDistance(a, b) / m) * 100f);
    }

    public static void testDistance()
    {
        test("titi", "toto");
        testMulti("titi", "toto");
        testMulti("monde -potter de Le","Le monde de harry potter");
        test("Anticonstitutionnellement", "Anticonstitutionellement");
        test("", "Anticonstitutionellement");
    }

    private static void test(String string1, String string2) {
        System.out.println("distance "+string1+" "+string2+" = "+computeWordDistance(string1, string2));
    }
    private static void testMulti(String string1, String string2) {
        System.out.println("distance "+string1+" "+string2+" = "+ computeMultiWordsDistance(string1, string2));
    }

    public static int differency(String target, String src)
    {
        return computeMultiWordsDistance(target, src);
    }
}