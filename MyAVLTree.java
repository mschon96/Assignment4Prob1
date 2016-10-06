/*
Name : Mariah Schon
Class : 3320-001
Program # : Assignment 4
Due Date : Oct 6
Honor Pledge: On my honor as a student of the University
of Nebraska at Omaha, I have neither given nor received
unauthorized help on this homework assignment.
NAME: Mariah Schon
NUID: 581
EMAIL: mschon@unomaha.edu
PARTNERS: CSLC
Description: AVL Tree
*/
public class MyAVLTree{
    private AVLNode root;

    public MyAVLTree(){
        root=null;
    }

    public AVLNode getRoot() {
        return root;
    }

    public int findMin(){
        return findMin(root).key;
    }

    private AVLNode findMin(AVLNode t){
        if ( t==null)
            return null;
        if (t.left == null)
            return t;

        return t.left;
    }

    public int findMax(){
        return findMax(root).key;
    }
 private AVLNode findMax(AVLNode t){
        if (t == null)
            return null;
        if (t.right == null)
            return t;
        return findMax(t.right);
    }

    public boolean find(int x ){
        return find (root,x);
    }
    private boolean find(AVLNode t, int x){
        if (t == null)
            return false;
        if (x< t.key)
            return find(t.left, x);
        else if (x> t.key)
            return find(t.right, x);
        else
            return true;
    }

    public void insert(int x){
        root = insert(root, x);
    }

    private AVLNode insert(AVLNode t, int x){
        if ( t == null)
            return new AVLNode(x, null, null);
        if (x< t.key)
            t.left = insert (t.left, x);
        else if (x> t.key)
            t.right = insert(t.right, x);
        else;

        return balance(t);
    }
 public void remove (int x){
        root = remove (root, x);
    }

    private AVLNode remove (AVLNode t, int x){
        if (t==null)
            return t;
        if (x< t.key)
            t.left = remove(t.left, x);
        else if (x> t.key)
            t.right = remove(t.right, x);
        else
            if((t.left!=null) && (t.right!= null)){
                t.key = findMin(t.right).key;
                t.right = remove(t.right, t.key);
            }
        if(t.left != null)
            t = t.left;
        else
            t = t.right;

        return balance(t);
    }

    public void printTree(){
        printTree(root);
    }

    private AVLNode printTree(AVLNode t){
        if (t!= null){
            printTree (t.left);
            System.out.printf("%d ",t.key);
            printTree(t.right);
        }
        return t;
    }

/*
       Function Name : levelOrder()
Parameters :    root
Return value(s) : NA
Partners : CSLC
Description : This function prints out the level order traversal of this binary search tree; starting at root, then depth 1, and then 2, and so on.
*/

    public void levelOrder(){
        // q= tree.insert(root);
        MyQueue q = new MyQueue();
        q.enque(root);

        while(q.isEmpty() ==false)
        {
            AVLNode our_node = q.deque();
            System.out.printf("%d ", our_node.key);
            if( our_node.left != null)
                q.enque(our_node.left);
            if(our_node.right!= null)
                q.enque(our_node.right);

        }
    }

    /*
       Function Name : sRLL ( Single Rotate Left child's left subtree)
Parameters :    AVLNode k2
Return value(s) : k1
Partners : NA
Description : Rotates the tree to make sure it is balanced, depending on current situation
*/
    private AVLNode sRLL(AVLNode k2){
        AVLNode k1 = k2.left;
        k2.left = k1.right;     //y
        k1.right = k2;          //k2
        k2.height = Math.max(height(k2.left), height(k2.right) + 1);
        k1.height = Math.max(height(k1.left), height(k1.right) + 1);

        return k1;
    }
/*
       Function Name : sRRR ( Single Rotate right child's right subtree)
Parameters :    AVLNode k2
Return value(s) : k2
Partners : NA
Description : Rotates the tree to make sure it is balanced, depending on current situation
*/
    private AVLNode sRRR(AVLNode k1){
        AVLNode k2 = k1.right;
        k1.right = k2.left;     //y
        k2.left = k1;
        k2.height = Math.max(height(k2.left), height(k2.right) + 1);
        k1.height = Math.max(height(k1.left), height(k1.right) + 1);

        return k2;
    }

    /*
       Function Name : dRLR ( Double Rotate left child's right subtree)
Parameters :    AVLNode k3
Return value(s) : Single Rotate of LL (passing k3)
Partners : NA
Description : Rotates the tree to make sure it is balanced, depending on current situation
*/
    private AVLNode dRLR(AVLNode k3){
        k3.left = sRRR(k3.left);
        return sRLL(k3);
    }

    /*
       Function Name : dRLR ( Double Rotate left child's right subtree)
Parameters :    AVLNode k1
Return value(s) : Single Rotate of RR ( passing in k1)
Partners : NA
Description : Rotates the tree to make sure it is balanced, depending on current situation
*/
    private AVLNode dRRL(AVLNode k1){
        k1.right = sRLL(k1.right);
        return sRRR(k1);
    }


    private static final int ALLOWED_INBALANCE = 1;

    private AVLNode balance(AVLNode t){
        //Empty
        if ( t == null)
            return t;
        //Positive
        if (height(t.left) - height(t.right) > ALLOWED_INBALANCE){
            if(height(t.left.left) >= height(t.left.right))
                t = sRLL(t);
            else
                t= dRLR(t);
        }

        //Negative
        else if(height(t.right) - height(t.left) > ALLOWED_INBALANCE){
            if( height( t.right.right ) >= height( t.right.left ) )
                t = sRRR( t );
            else
                t = dRRL( t );
        }

        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }


    private int height(AVLNode t){
        if (t== null)
            return -1;

        else
            return t.height;
    }


}

