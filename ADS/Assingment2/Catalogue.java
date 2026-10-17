package Assingment2;

public class Catalogue {
    static class BookNode{
        int id;
        String title;
        BookNode left;
        BookNode right;

        BookNode(int id,String title){
            this.id=id;
            this.title=title;
            this.left=null;
            this.right=null;
        }
    }
    private BookNode root;

    Catalogue(){
        this.root=null;
    }
    public void insert(int id, String title) {
        root = insert(root, id, title);
    }
    public BookNode insert(BookNode node,int id,String title){
        BookNode newBook=new BookNode(id,title);
        if(node==null){
            node=newBook;
        }else{
            if(id<node.id){
                node.left=insert(node.left,id,title);
            }else if(id>node.id){
                node.right=insert(node.right,id,title);
            }else{
                System.out.println("Duplicate Book ID");
            }
        }
        return node;
    }
    public BookNode search(int id){
        BookNode current=root;
        System.out.print("Path: ");
        while (current!=null){
            System.out.print(current.id);
            if(id==current.id){
                System.out.println();
                System.out.println("Found");
                return current;
            }
            if(id< current.id){
                System.out.print("->");
                current=current.left;
            }else{
                System.out.print("->");
                current=current.right;
            }
        }
        System.out.println("->(no child)");
        System.out.println("Not found");

        return null;
    }
    public void inOrder(BookNode n){
        if(n==null){
            return;
        }
        inOrder(n.left);
        System.out.print(n.id+" ");
        inOrder(n.right);
    }
    public void preOrder(BookNode n){
        if(n==null){
            return;
        }
        System.out.print(n.id+" ");
        inOrder(n.left);
        inOrder(n.right);
    }
    public void postOrder(BookNode n){
        if(n==null){
            return;
        }
        inOrder(n.left);
        inOrder(n.right);
        System.out.print(n.id+" ");
    }
    public int count(BookNode n){
        if(n==null){
            return 0;
        }
        return 1+count(n.left)+count(n.right);
    }
    public int Height(BookNode n){
        if(n==null){
            return -1;
        }
        int hl=Height(n.left);
        int hr=Height(n.right);
        int max;
        if(hl>hr)
            max=hl;
        else
            max=hr;
        return max+1;
    }
    public int max(){
        if(root==null){
            return -1;
        }
        BookNode current=root;
        while(current.right!=null){
            current=current.right;
        }
        return current.id;
    }
    public int min(){
        if(root==null){
            return -1;
        }
        BookNode current=root;
        while(current.left!=null){
            current=current.left;
        }
        return current.id;
    }

    public static void main(String[] args) {
        Catalogue c=new Catalogue();
        c.insert(105,"java");
        c.insert(62,"c++");
        c.insert(148,"python");
        c.insert(40,"DSA");
        c.insert(87,"DataBase");
        c.insert(120,"HTML");
        c.insert(173,"javaScript");
        c.insert(95,"Spring");

        System.out.print("InOrder: ");
        c.inOrder(c.root);
        System.out.println();

        System.out.print("preOrder: ");
        c.preOrder(c.root);
        System.out.println();

        System.out.print("postOrder: ");
        c.postOrder(c.root);
        System.out.println();

        System.out.println();
        c.search(95);
        System.out.println();
        c.search(100);
        System.out.println();

        System.out.println("Minimum ID: " + c.min());
        System.out.println("Maximum ID: " + c.max());
        System.out.println("Count: " + c.count(c.root));
        System.out.println("Height: " + c.Height(c.root));
    }
}
