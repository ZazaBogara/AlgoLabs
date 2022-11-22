import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int distance = in.nextInt();
        List<Integer> x = new ArrayList<>();
        String tmp = in.nextLine();
        tmp = in.nextLine();
        for(String t : tmp.split(" "))
            x.add(Integer.parseInt(t));
        Electr e = new Electr(distance, x);
        System.out.printf("%.2f", e.do_it());
    }

}