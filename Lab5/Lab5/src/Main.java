
public class Main {
    public static void main(String[] args) {
        String txt = "zack Zack    ZacZackZack";
        String pat = "Zack";
        RabinKarp rabinKarp = new RabinKarp(txt, pat);
        System.out.printf("%s%d", "Count of matches: ", rabinKarp.search());
    }
}