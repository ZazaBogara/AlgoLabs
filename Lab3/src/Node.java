public class Node {
    public void setValue(int value) {
        this.value = value;
    }

    private int value;
    private int sum;
    public Node(int value) {
        this.value = value;
        sum=0;
    }


    public int getValue() {
        return value;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
