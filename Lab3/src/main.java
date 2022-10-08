import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        int l;
        Path path = Paths.get("file.txt");

        l = Integer.parseInt(Files.readAllLines(path).get(0));
        int[][] place = new int[l][];
        for(int i=1;i<l+1;i++){
            String[] temp = Files.readAllLines(path).get(i).split(" ");
            place[i-1] = new int[i];
            for(int j=0;j<i;j++) {
                place[i - 1][j] = Integer.parseInt(temp[j]);
                System.out.print(place[i-1][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        Graph gr = new Graph(place, l);
        System.out.println(gr.getBiggestExp());
        return;
    }
}
