package BST;
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;
    
   
    public void put(Key key, Value value) {
        this.root = put(key, value, this.root);
     }
 
     private Node<Key, Value> put(Key key, Value value, Node<Key, Value> x) {
         if(x == null){
             return new Node<Key,Value>(key, value, 1);
         }
         int cmp = key.compareTo(x.getKey());
         if (cmp < 0){
              Node<Key, Value> leftNode = this.put(key, value, x.getLeft());
              x.setLeft(leftNode);
         }else if (cmp > 0){
             Node<Key, Value> rightNode = this.put(key, value, x.getRight());
             x.setRight(rightNode);
         }else{
             x.setValue(value);
         }
         int newSize = 1 + this.size(x.getLeft()) + this.size(x.getRight());
         x.setSize(newSize);
         return x;
     }
 
 
     public Value get(Key key) {
         return this.get(key, this.root);
     }
 
     private Value get(Key key, Node<Key, Value> x) {
         if(x == null){
             return null;
         }
         int cmp = key.compareTo(x.getKey());
         if (cmp < 0){
             return this.get(key, x.getLeft());
         }else if (cmp > 0){
             return this.get(key, x.getRight());
         }else{
             return x.getValue();
         }
     }
 
     public int size() {
         return this.size(this.root);
     }
 
     private int size(Node<Key, Value> x) {
         if (x == null) {
             return 0;
         } 
         else { 
         return 1 + this.size(x.getLeft()) + this.size(x.getRight()); 
         } 
     }
 
         public Key min() {
             Node<Key, Value> min = this.min(this.root);
             if(min == null) {
                 return null;
             }
             return min.getKey();
     }
 
         private Node<Key, Value> min(Node<Key, Value> x) {
             if (x == null) {
                 return null;
             }
             if (x.getLeft() == null) {
             return x;
         }
         return this.min(x.getLeft());
         }
     
         public Key max() {
             Node<Key, Value> max = this.max(this.root);
             if (max == null) {
                 return null;
             }
             return max.getKey();
         }
 
         private Node<Key, Value> max(Node<Key, Value> x) {
             if (x == null) {
                 return null;
             }
             if (x.getRight() == null) {
                 return x;
             }
            return this.max(x.getRight());
             }
       
 
     public Key select(int rank) {
         return this.select(rank, this.root);
     }
 
 
     private Key select(int rank, Node<Key, Value> x) {
         if (x == null) {
             return null;
         }
         int t = size(x.getLeft());
         if (t > rank) {
             return select(rank, x.getLeft());
         }
         if (t < rank) {
             return select(rank-t-1, x.getRight());
         }
         else {
             return x.getKey();
         }
 
     }
 
     private Node<Key, Value> deleteMin(Node<Key, Value> x) {
       if(x == null)  {
           return null;
       }
       boolean isMin = x.getLeft() == null;
       if (isMin) {
         return x.getRight();
       }
         Node<Key, Value> leftSubTreeWithioutMin = deleteMin(x.getLeft());
         x.setLeft(leftSubTreeWithioutMin);
         int newSize = 1 - this.size(x.getLeft()) + this.size(x.getRight());
         x.setSize(newSize);
         return x;
     }
 
        public void delete(Key key) {
         this.root = this.delete(this.root, key);
     }
 
     private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
         if (x == null) {
             return null;
         }
         int cmp = key.compareTo(x.getKey());
         if (cmp < 0){
             x.setLeft(delete(x.getLeft(), key));
         }else if (cmp > 0){
             x.setRight(delete(x.getRight(), key));
         }else{
             if(x.getLeft() == null) {
                 return x.getRight();
             }
             if(x.getRight() == null) {
                 return x.getLeft();
             }
             Node<Key, Value> nodeToDelete = x;
             x = min(nodeToDelete.getRight());
             x.setRight(deleteMin(nodeToDelete.getRight()));
             x.setLeft(nodeToDelete.getLeft());
             }
             int newSize = (size(x.getLeft()) + size(x.getRight())) + 1;
             x.setSize(newSize);
             return x;
     }
 
     public Node<Key, Value> getRoot() {
         return root;
     }
 }