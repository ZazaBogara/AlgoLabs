package main;

public class Node {
    public boolean isRoot = false;
    public boolean isLeftChild = false;
    public Node grand = null;
    public Node parent = null;
    public Node uncle = null;
    public Node leftChild = null;
    public Node rightChild = null;
    public int value;
    public String color = "red";

    public Node(int value) {
        this.value = value;
    }
}
