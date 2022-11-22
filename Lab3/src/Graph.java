import java.util.Vector;

public class Graph {
    private int l;
    private Node[][] arr;

    public Graph(int[][] arr, int l) {
        this.l = l;
        this.arr = new Node[l][];
        for(int i=0;i<l;i++)
        {
            this.arr[i] = new Node[i+1];
            for(int j=0;j<i+1;j++)
                this.arr[i][j] = new Node(arr[i][j]);
        }
        this.arr[0][0].setSum(this.arr[0][0].getValue());
    }

    public int getBiggestExp() {
        Vector<int[]> queue = new Vector<>();
        int[] temp = new int[2];
        int[] now = new int[2];
        Node rightNode= new Node(-1), leftNode = new Node(-1), curNode ;
        temp[0] = 0;
        temp[1] = 0;
        queue.add(temp);
        if(l!=1)
        while (true) {
            now = queue.remove(0);
            curNode = arr[now[0]][now[1]];
            if(now[0]<l-1) {
                leftNode = arr[now[0] + 1][now[1]];
                rightNode = arr[now[0] + 1][now[1] + 1];
                temp = new int[2];
                temp[0] = now[0] + 1;
                temp[1] = now[1];
                queue.add(temp);
                temp = new int[2];
                temp[0] = now[0] + 1;
                temp[1] = now[1] + 1;
                queue.add(temp);
            }
            if ((curNode.getSum() + leftNode.getValue()) > (leftNode.getSum()))
                leftNode.setSum(curNode.getSum() + leftNode.getValue());
            if ((curNode.getSum() + rightNode.getValue()) > (rightNode.getSum()))
                rightNode.setSum(curNode.getSum() + rightNode.getValue());
            if ((now[0] == l-2) && (now[1] == l-2)) {
                break;
            }
        }
        int result = 0;
        for(int i=0;i<l;i++)
            if(result<arr[l-1][i].getSum())
                result = arr[l-1][i].getSum();
        return result;
    }
}
