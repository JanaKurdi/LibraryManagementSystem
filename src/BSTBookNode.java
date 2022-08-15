public class BSTBookNode {
 /** Define the BSTBookNode data fields */
    private String bookName;
    private int numOfCopies;
    private BSTBookNode left;
    private BSTBookNode right;
  
   /** Constructors */
   public BSTBookNode (){
       left=right=null;
    }
    
public BSTBookNode(int numOfCopies,String bookName ) {
    this.numOfCopies=numOfCopies;
    this.bookName=bookName;
    this.left=null;
    this.right=null;
}

public BSTBookNode(int numOfCopies,String bookName,BSTBookNode l,BSTBookNode r ) {
    this.numOfCopies=numOfCopies;
    this.bookName=bookName;
    this.left=l;
    this.right=r;  
}

    public String getBookName() {
    /** Return the book name */
        return bookName;
    }

    public void setBookName(String bookName) {
     /** set a new book name */
        this.bookName = bookName;
    }

    public int getNumOfCopies() {
    /** Return the number of copies*/
       return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
     /** set a new number of copies */
       this.numOfCopies = numOfCopies;
    }

    public BSTBookNode getLeft() {
      /** Return the left node */
           return left;
    }

    public void setLeft(BSTBookNode left) {
       /** set a new left node */
    this.left = left;
    }

    public BSTBookNode getRight() {
    /** Return the right node */
         return right;
    }

    public void setRight(BSTBookNode right) {
    /** set a new right node */
      this.right = right;
    }
    
     
    
    
}
