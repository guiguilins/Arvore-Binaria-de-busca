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
}

