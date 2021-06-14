public class randomPermutation
{

    public static String[] next(String[] s)
    {
        String[] p = new String[s.length]; //Encountered same problem as teacher, glad I asked for the video ahead of time
        String[] r = new String[s.length];
        int counter = s.length;
        int i = 0;

        for (String str : s) //To keep the original string, so that it does not change if we need to use it more than once
        {
            p[i] = str;
            i++;
        }

        for (i = 0; i < r.length; i++) 
        {
            int random = (int)(Math.random() * counter);
            r[i] = p[random];
            p[random]=p[counter-1];
            counter--;
        }
        return r;
    }
}
