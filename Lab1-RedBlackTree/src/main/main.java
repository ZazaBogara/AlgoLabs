package main;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        Node tmp;
        int i=-1;
        while(i!=0){
            System.out.print("\n1 - insert\n2 - show\nWhat to do:");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            if(i==1){
                scanner = new Scanner(System.in);
                int temp = scanner.nextInt();
                tmp = new Node(temp);
                tree.insert(tmp);
            }else if(i==2){
                tree.print();
            }
        }
    }
}
