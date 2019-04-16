public class BinarySearchTree {
    private Integer data;
    private BinarySearchTree left;
    private BinarySearchTree right;
    public BinarySearchTree(){
        data = null;
        left = null;
        right = null;
    }
    public BinarySearchTree(int data){
        this.data = data;
        left = null;
        right = null;
    }
    public void add(int item){
        if(data == null){
            data = item;
        }else if(item <= data){
            if(left == null){
                left = new BinarySearchTree(item);
            }else{
                left.add(item);
            }
        }else{
            if (right == null){
                right = new BinarySearchTree(item);
            }else{
                right.add(item);
            }
        }
    }
    public void inOrder(){
        if(data != null){
            if(left != null){
                left.inOrder();
            }
            System.out.println(data);
            if(right != null){
                right.inOrder();
            }
        }
    }
    public BinarySearchTree find(int item){
        if(data == null){
            return null;
        }
        if(data == item){
            return this;
        }
        if(item <= data){
            if(left == null){
                return null;
            }
            return left.find(item);
        }
        if(right == null){
            return null;
        }
        return right.find(item);
    }
}
