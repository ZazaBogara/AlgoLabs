import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class main {
    public static void main(String[] args) throws IOException {
        int[] start = new int[2];
        int[] end = new int[2];
        int size;
        //reading
        {
            Path path = Paths.get("fileTest.txt");
            String read;
            read = Files.readAllLines(path).get(0);
            size = Integer.parseInt(read);

            read = Files.readAllLines(path).get(1);
            String[] tmp = read.split(" ");
            start[0] = Integer.parseInt(tmp[0]);
            start[1] = Integer.parseInt(tmp[1]);

            read = Files.readAllLines(path).get(2);
            tmp = read.split(" ");
            end[0] = Integer.parseInt(tmp[0]);
            end[1] = Integer.parseInt(tmp[1]);

            System.out.println(size);
            System.out.println(start[0] + " " + start[1]);
            System.out.println(end[0] + " " + end[1]);
        }

        Node resultNode = new Node(end, 0);
        int resultMove;
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Node> weWas = new ArrayList<>();

        queue.add(new Node(start, 0));
        //doing
        {
            Node[] toAdd = new Node[8];
            int i = 0;
            while ((queue.get(i).getPlace()[0] != resultNode.getPlace()[0]) || (queue.get(i).getPlace()[1] != resultNode.getPlace()[1])) {
                Node now = queue.remove(0);
                toAdd = getNodesOnNextMove(now);
                weWas.add(now);
                int curMove = now.getMove();

                for(int j=0;j<8;j++){
                    toAdd[j].setMove(curMove+1);
                    boolean state = false;//was we here? and is it bad for chess board?
                    for(int k=0;k<weWas.size();k++) {
                        if ((toAdd[j].getPlace()[0] == weWas.get(k).getPlace()[0]) && (toAdd[j].getPlace()[1] == weWas.get(k).getPlace()[1]))
                            state = true;
                        if((toAdd[j].getPlace()[0] < 0) || (toAdd[j].getPlace()[0] > size) || (toAdd[j].getPlace()[1] < 0) || (toAdd[j].getPlace()[1] > size))
                            state = true;
                    }

                    if(!state){//if not add it to queue
                        queue.add(toAdd[j]);
                    }
                }
            }
            resultMove = queue.get(0).getMove();
        }

        //output
        {
            FileWriter myWriter = new FileWriter("out.txt");
            myWriter.write(Integer.toString(resultMove));
            myWriter.close();
            System.out.println();
            System.out.println(resultMove);
        }

    }

    protected static Node[] getNodesOnNextMove(Node in) {
        Node[] out = new Node[8];
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};
        for (int i = 0; i < 8; i++) {
            int[] place = new int[2];
            place[0] = in.get(0) + row[i];
            place[1] = in.get(1) + col[i];
            out[i] = new Node(place, in.getMove());
        }
        return out;
    }
}

