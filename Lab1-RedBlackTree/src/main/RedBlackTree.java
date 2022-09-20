package main;

public class RedBlackTree {
    public Node root = null;

    public RedBlackTree() {
    }

    private void leftRotate(Node cur) {
        if(cur.leftChild!=null){
            cur.parent.rightChild = cur.leftChild;
            cur.leftChild.parent = cur.parent;
        }
        Node parent = cur.parent;
        if (cur.parent==root) {
            root=cur;
            cur.leftChild = cur.parent;
            cur.leftChild.parent = cur;
            cur.rightChild.grand = null;
            cur.parent=null;
        } else if (cur.grand.rightChild==cur.parent) {
            cur.parent = cur.grand;
            cur.grand = cur.parent.parent;
            cur.parent.rightChild = cur;
            parent.parent = cur;
            parent.rightChild = cur.leftChild;
            cur.leftChild = parent;
            cur.leftChild.grand = cur.parent;
            cur.rightChild.grand = cur.parent;
        } else {
            cur.parent = cur.grand;
            cur.grand = cur.parent.parent;
            cur.parent.leftChild = cur;
            parent.parent = cur;
            cur.leftChild = parent;
        }
    }
    private void rightRotate(Node cur) {
        if(cur.rightChild!=null){
            cur.parent.leftChild = cur.rightChild;
            cur.rightChild.parent = cur.parent;
        }
        Node parent = cur.parent;
        if (cur.parent==root) {
            root=cur;
            cur.parent.leftChild = cur.rightChild;
            cur.rightChild = cur.parent;
            cur.rightChild.parent = cur;
            cur.leftChild.grand = null;
            cur.parent=null;
        } else if (cur.grand.rightChild==cur.parent) {
            cur.parent = cur.grand;
            cur.grand = cur.parent.parent;
            cur.parent.rightChild = cur;
            parent.parent = cur;
            parent.leftChild = cur.rightChild;
            cur.rightChild = parent;
            cur.leftChild.grand = cur.parent;
            cur.rightChild.grand = cur.parent;
        } else {
            cur.parent = cur.grand;
            cur.grand = cur.parent.parent;
            cur.parent.leftChild = cur;
            parent.parent = cur;
            cur.rightChild = parent;
        }
    }
    private void insertFix(Node cur) {
        if(cur==root)
        {
            if(cur.color=="red")
                cur.color="black";
        }else while (cur.parent.color == "red") {
            if(cur.parent==root){
                cur.parent.color="black";
            }
            else if(cur.parent==cur.grand.leftChild){
                if((cur.color=="red")&&(cur.parent.color=="red")&&(cur.grand.rightChild==null))
                {
                    rightRotate(cur.parent);
                    cur.parent.color="black";
                    cur.parent.rightChild.color = "red";
                }
                else if(cur.grand.rightChild.color=="red"){
                    cur.grand.rightChild.color="black";
                    cur.grand.leftChild.color="black";
                    cur.grand.color="red";
                    cur = cur.grand;
                    if((cur==root)&&(cur.color=="red"))
                    {
                        cur.color="black";
                        return;
                    }
                }
                else if(cur.parent.rightChild==cur) {
                    leftRotate(cur);
                    rightRotate(cur);
                    cur.rightChild.color="red";
                    cur.color="black";
                }
            }
            else{
                if((cur.color=="red")&&(cur.parent.color=="red")&&(cur.grand.rightChild==null))
                {
                    leftRotate(cur.parent);
                    cur.parent.color="black";
                    cur.parent.leftChild.color = "red";
                }
                else if(cur.grand.leftChild.color=="red"){
                    cur.grand.rightChild.color="black";
                    cur.grand.leftChild.color="black";
                    cur.grand.color="red";
                    cur = cur.grand;
                    if((cur==root)&&(cur.color=="red"))
                    {
                        cur.color="black";
                        return;
                    }
                }
                else if(cur.parent.leftChild==cur){
                    rightRotate(cur);
                    leftRotate(cur);
                    cur.leftChild.color="red";
                    cur.color="black";
                }
            }
            if(cur==root)
            {
                if(cur.color=="red")
                    cur.color="black";
                break;
            }
        }
    }
    private void leftRightRotation(Node cur) {
        leftRotate(cur);
        rightRotate(cur);
    }
    private void rightLeftRotation(Node cur) {
        rightRotate(cur);
        leftRotate(cur);
    }
    public void print(){
        System.out.println("Root:" + root.value + (root.color == "red" ? "r" : "b"));
        if((root.leftChild != null) || (root.rightChild != null)) {
            printRecurs(root);
        }
    }
    private void printRecurs(Node cur){
        if(cur.leftChild != null){
            printRecurs(cur.leftChild);
        }
        System.out.print(cur.value + (cur.color == "red" ? "r" : "b"));
        if(cur.rightChild != null){
            printRecurs(cur.rightChild);
        }

    }
    public void insert(Node add) {
        Node par_of_cur = new Node(-1);
        if (root == null) {
            root = add;
            add.color = "black";
        } else {
            Node cur = root;
            while (cur!=null) {
                par_of_cur = cur;
                if (add.value > cur.value)
                    cur = cur.rightChild;
                else
                    cur = cur.leftChild;
            }
            cur = par_of_cur;
            add.parent = cur;
            if(cur.parent!=null)
                add.grand = cur.parent;
            if (add.value > cur.value) {
                cur.rightChild = add;
            } else {
                cur.leftChild = add;
            }
            insertFix(add);
        }
    }
}

