public class BSTStudentNode {
   /** Define the BSTStudentNode data fields */
    private int studentID;
    private int borrowBooks;
    private String borrwwedArr[]=new String[3];
    private BSTStudentNode left;
    private BSTStudentNode right;
    
     /** Constructors */
    private BSTStudentNode (){
        left=right=null;
    }

    public BSTStudentNode(int StudentID) {
        this.studentID = StudentID;
        left=right=null;
   }

  public BSTStudentNode(int StudentID,BSTStudentNode l,BSTStudentNode r ) {
   this.studentID=StudentID;
    this.left=l;
    this.right=r;  
     }
  
   public int getStudentID(){
    /** Return the student ID */
       return studentID;
  }
   
   public void setStudentID(int studentID){
    /** set a new student ID */
     this.studentID=studentID;
}
    public int getBorrowBooks() {
     /** Return the number of borrowded book */
      return borrowBooks;
    }

    public void setBorrowBooks(int borrowBooks) {
      /** set a new number of borrowded book */
       this.borrowBooks = borrowBooks;
    }

    public String[] getBorrwwedArr() {
      /** Return the borrowed books*/
        return borrwwedArr;
    }

    public void setBorrwwedArr(String borrwwedArr,int index) {
       /** set a new a borrowded book in specific index */
       this.borrwwedArr[index]=borrwwedArr;
    }

    public BSTStudentNode getLeft() {
      /** Return the left node */
        return left;
    }

    public void setLeft(BSTStudentNode left) {
      /** set a new left node */
        this.left = left;
    }

    public BSTStudentNode getRight() {
     /** Return the right node */
        return right;
    }

    public void setRight(BSTStudentNode right) {
      /** set a new right node */
        this.right = right;
    }
  
  
}
