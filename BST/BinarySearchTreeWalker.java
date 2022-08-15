package BST;

public class BinarySearchTreeWalker {
    import java.util.ArrayList;
import java.util.List;



public class BinaryTreeWalker<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private BinarySearchTree<Key, Value> bst;
  
    public BinaryTreeWalker(BinarySearchTree<Key, Value> bst) {
        this.bst = bst;
    }

    public List<Key> inOrder() {
        return this.inOrder(bst.getRoot());
    }

    private List<Key> inOrder(Node<Key, Value> x) {
        List<Key> retVale = new ArrayList<Key>();
        
        if(x != null) {
       retVale.addAll(inOrder(x.getLeft()));
       retVale.add(x.getKey());
       retVale.addAll(inOrder(x.getRight()));
       
        }
        return retVale;
    }

    public List<Key> breadthFirst() {
        return breadthFirst(bst.getRoot());
    }

    private List<Key> breadthFirst(Node<Key, Value> x) {
        List<Key> retVale = new ArrayList<Key>();
         if (x == null) {
              return retVale;
         }
            List<Node<Key, Value>> queue = new ArrayList<Node<Key, Value>>();
            queue.add(x);
            while (!queue.isEmpty()) {
                Node<Key, Value> node = queue.remove(0);
                retVale.add(node.getKey());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            return retVale;
    }

    public List<Key> postorder() {
        
        return postorder(bst.getRoot());
    }

    private List<Key> postorder(Node<Key, Value> x) {
        List<Key> retVale = new ArrayList<Key>();
       
        if(x != null) {
        retVale.addAll(postorder(x.getLeft()));
        retVale.addAll(postorder(x.getRight()));
        retVale.add(x.getKey());
       
        }
        return retVale;

    }

    public List<Key> preorder() {
        return preorder(bst.getRoot());
    }

    private List<Key> preorder(Node<Key, Value> x) {
        List<Key> retVale = new ArrayList<Key>();
        if(x != null) {
        retVale.add(x.getKey());
        retVale.addAll(preorder(x.getLeft()));
        retVale.addAll(preorder(x.getRight()));
        
        }
        return retVale;
    }

    }



}
