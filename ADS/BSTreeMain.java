    class BinarySearchTree{
        static class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                this.data=data;
                this.left=null;
                this.right=null;
            }
        }
        private Node root;
        BinarySearchTree(){
            root=null;
        }
        void add(int data){
            Node newNode=new Node(data);
            if(root==null)
                root=newNode;
            else{
                Node trav=root;
                while(true){
                    if(data<trav.data){
                        if(trav.left!=null)
                            trav=trav.left;
                        else{
                            trav.left=newNode;
                            break;
                        }
                    }else{
                        if(trav.right!=null)
                            trav=trav.right;
                        else{
                            trav.right=newNode;
                            break;
                        }
                    }
                }
            }
        }
        public void preOrder(Node trav){
            if(trav==null)
                return;
            System.out.print(trav.data+", ");
            preOrder(trav.left);
            preOrder(trav.right);
        }
        public void preOrder(){
            preOrder(root);
        }
        public void inOrder(Node trav){
            if(trav==null)
                return;
            inOrder(trav.left);
            System.out.print(trav.data+", ");
            inOrder(trav.right);
        }
        public void inOrder(){
            inOrder(root);
        }
        public void postOrder(Node trav){
            if(trav==null)
                return;
            postOrder(trav.left);
            postOrder(trav.right);
            System.out.print(trav.data+", ");

        }
        public void postOrder(){
            postOrder(root);
        }
        public void deleteAll(Node trav){
            if(trav==null)
                return;
            deleteAll(trav.left);
            deleteAll(trav.right);
            trav.left=null;
            trav.right=null;
            trav=null;
        }
        public void deleteAll(){
            deleteAll(root);
            root=null;
        }

        public int Height(Node trav){
            if(trav==null)
                return -1;
            int hl=Height(trav.left);
            int hr=Height(trav.right);
            int max;
            if(hl>hr)
                max=hl;
            else
                max=hr;
            return max+1;
        }
        public int Height(){
            return Height(root);
        }

        public void search(int data){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data+"->");

                if(data==temp.data){
                    System.out.println("Value found");
                    return;
                }
                if(data<temp.data)
                    temp=temp.left;
                else
                    temp=temp.right;
            }
            System.out.println("Value Not Found");
        }

        public void max(){
            Node temp=root;
            if(temp==null){
                System.out.println("tree is empty");
                return;
            }

            while (temp.right!=null){
                temp=temp.right;
            }
            System.out.println(temp.data);
        }
        public void min(){
            Node temp=root;
            if(temp==null){
                System.out.println("tree is empty");
                return;
            }

            while (temp.left!=null){
                temp=temp.left;
            }
            System.out.println(temp.data);
        }
    }
    public class BSTreeMain {
        public static void main(String[] args) {
            BinarySearchTree tree=new BinarySearchTree();
            tree.add(50);
            tree.add(30);
            tree.add(10);
            tree.add(90);
            tree.add(100);
            tree.add(40);
            tree.add(70);
            tree.add(80);
            tree.add(60);
            tree.add(20);

            System.out.print("PreOrder: ");
            tree.preOrder();
            System.out.println();

            System.out.print("postOrder: ");
            tree.postOrder();
            System.out.println();

            System.out.print("inOrder: ");
            tree.inOrder();
            System.out.println();

            System.out.println("Height: "+tree.Height());

            System.out.print("Serach: ");
            tree.search(80);

            System.out.print("Max: ");
            tree.max();

            System.out.print("Min: ");
            tree.min();

            tree.deleteAll();
            System.out.print("inOrder: ");
            tree.inOrder();
            System.out.println();

            System.out.println("Height: "+tree.Height());
        }
    }
