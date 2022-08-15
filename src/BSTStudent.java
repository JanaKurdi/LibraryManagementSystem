public class BSTStudent {
  /** Define data field from BSTStudentNode*/
     private BSTStudentNode root;
    /** Constructors */
   public BSTStudent (){
       root=null;
   } 
   /**---------------------------------------------------------------------------*/
    public void addStu(int id){
    /**Method that call addstu private method*/      
    BSTStudentNode newStu= new BSTStudentNode(id);    
      root=addStu(root,newStu);
   }
   private BSTStudentNode addStu(BSTStudentNode root,BSTStudentNode newStu){
   /**Method that add student in list using ID*/      
    if(root==null){//if the tree is empty
        return newStu;
   }
   else{
       if(newStu.getStudentID()<root.getStudentID()){//if the entered id is smaller the the id in the root
           root.setLeft(addStu(root.getLeft(),newStu));//set id on the left
           
       }else{//if it is bigger 
          root.setRight(addStu(root.getRight(),newStu));//add it to the right
       }
   }
  return root; //return tree after adding 
}
   /**---------------------------------------------------------------------------*/
  public int stuSearch(int id){
    /**Method that call stuSearch private method*/      
       return stuSearch(root,id);
   } 
 private int stuSearch(BSTStudentNode root,int id){
   /**Method that search for student in list using ID*/      
    if(root==null)//if not found
         return 0;
     else{//if found
         if(id==root.getStudentID())//if id equals to the root
         return root.getBorrowBooks(); //return student borrowed book
         
         else if(id<root.getStudentID())//if id is smaller than root
             return stuSearch(root.getLeft(),id);//complete searching on left node
          else //if id is bigger than root
           return stuSearch(root.getRight(),id); //complete searching on right node
     }
   }
  /**---------------------------------------------------------------------------*/
 public void bookBorrowed(int id,String bookName){
  /**Method that call bookBorrowed private method*/      
    bookBorrowed (root,id,bookName);
 }
  private void bookBorrowed(BSTStudentNode root,int id,String bookName){
 /**Method that return book Borrowed using IDs and book name*/      
  if(root!=null){
       bookBorrowed(root.getLeft(),id,bookName); //left nodes
      
      if(root.getStudentID()==id){//if the ids are equal
        root.setBorrwwedArr(bookName,this.stuSearch(id));
        root.setBorrowBooks(root.getBorrowBooks()+1);//icrement
}
        bookBorrowed(root.getRight(),id,bookName); //right nodes  
  }
  }
  /**---------------------------------------------------------------------------*/
  public String inorder(int id){   
      /**Method that call inorder private method*/     
     return inorder(root,id);
 }
 private String inorder(BSTStudentNode root,int id){
    /**method that print all books borrowed by the particular student */ 
    String student="";//save information
    if(root!=null){
     student+=inorder(root.getLeft(),id);//left nodes
  
       if(root.getStudentID()==id){
      for(int i=this.stuSearch(id)-1;i>=0;i--)
     student+=root.getBorrwwedArr()[i]+"\r\n";
    }
       student+=inorder(root.getRight(),id);//left nodes
    }
     return student;
 }
  /**---------------------------------------------------------------------------*/
public void stuReturn(int id,String bookName){
     stuReturn(root,id,bookName);
}
private void stuReturn(BSTStudentNode root,int id,String bookName){
    if(root!=null){
    stuReturn(root.getRight(),id,bookName);
    
        if(root.getStudentID()==id){
            root.setBorrowBooks(root.getBorrowBooks()-1);//decrement
        }
     stuReturn(root.getLeft(),id,bookName);   
 }
}
/**---------------------------------------------------------------------------*/

}

