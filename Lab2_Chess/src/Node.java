
public class Node {
    private int move;
    private int place[];

    public Node(int place[], int move){
        this.place = place;
        this.move = move;
    }
    public void setMove(int move){
        this.move = move;
    }
    public int getMove(){
        return move;
    }
    public int get(int index){
        return place[index];
    }
    public int[] getPlace(){
        return place;
    }
}
