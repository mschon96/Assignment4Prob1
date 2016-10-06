public class AVLNode {
    public int key;
    public int level;
    public AVLNode left;
    public AVLNode right;
    public int height;

    AVLNode(int x){
        level++;
        key = x;
        left = right= null;
    }

    AVLNode(int x, AVLNode l, AVLNode r){
        key= x; left = l; right = r;
    }

}
