public class BSTBook {
  /** Define data field from BSTBookNode*/
  private BSTBookNode root;
   /** Constructors */
   public BSTBook (){
       root=null;
   } 
 /**---------------------------------------------------------------------------*/
     public void bookADD(String bookName){
    /**Method that call abookADD private method*/      
 BSTBookNode newBook=new BSTBookNode (1,bookName); //add a book with one copy 
       root=bookADD(root,newBook);
   }
    private BSTBookNode bookADD(BSTBookNode root,BSTBookNode newBook){
        /**Method that add book in list using book name*/
       if(root==null)
           return newBook;
       
       else{
       if(newBook.getBookName().compareTo(root.getBookName())<0)//samller
            root.setLeft(bookADD(root.getLeft(),newBook));//left nodes
       else 
            root.setRight(bookADD(root.getRight(),newBook));
       }
       return root;//return tree after adding
   } 
 /**---------------------------------------------------------------------------*/
    public int bookSearch(String bookName){
    /**Method that call bookSearch private method*/     
       return bookSearch(root,bookName);
   } 
 private int bookSearch(BSTBookNode root,String bookName){
      /**Method that search for book in list using book name*/  
     if(root==null)//empty
         return 0;
     else{
         if(bookName.matches(root.getBookName()))
         return root.getNumOfCopies(); //return number of copies of this book
         
         else if(bookName.compareTo(root.getBookName())<0)
             return bookSearch(root.getLeft(),bookName);//complete searching on left node
          else 
           return bookSearch(root.getRight(),bookName);//complete searching on right node
     }
   }
 /**---------------------------------------------------------------------------*/
   public void updateCopies(String bookName){
  /**Method that call updateCopies private method*/     
  updateCopies(root,bookName);
 }
 private void updateCopies(BSTBookNode root,String bookName){
    /**Method that update number of copies for book in list by increment using book name*/  
   if(root!=null){
     updateCopies(root.getRight(),bookName);//right nodes
  
     if(root.getBookName().matches(bookName))
     root.setNumOfCopies(root.getNumOfCopies()+1);//increment number of copies
     
         updateCopies(root.getLeft(),bookName);//left nodes
     }
 }
 /**---------------------------------------------------------------------------*/
   public void updateBorrowedbooks(String bookName){
      /**Method that call updateBorrowedbooks private method*/     
    updateBorrowedbooks(root,bookName);
 }
 private void updateBorrowedbooks(BSTBookNode root,String bookName){
   /**Method that update number of available books to borrow in the list by decrement using book name*/  
   if(root!=null){
   updateBorrowedbooks(root.getRight(),bookName);
  
     if(root.getBookName().matches(bookName))
     root.setNumOfCopies(root.getNumOfCopies()-1);//decrement number of available copies
     
         updateBorrowedbooks(root.getLeft(),bookName);
 }
 }
 /**---------------------------------------------------------------------------*/   
  public String inorder(){
   /**Method that call inorder private method*/     
   return inorder(root);
}
private String inorder(BSTBookNode root){
   /**method that print book information in order*/ 
 String bookInfo="";  //save information 
    if(root!=null){
  bookInfo+=inorder(root.getLeft());
  
       if(root.getNumOfCopies()>1)//if the copies are more than one 
    bookInfo+=root.getBookName()+": "+root.getNumOfCopies()+" copies\r\n";    
      
       else
       bookInfo+=root.getBookName()+": "+root.getNumOfCopies()+" copy\r\n";
       
       bookInfo+=inorder(root.getRight());//right nodes
      
    }
  return bookInfo;//return information    
}
/**---------------------------------------------------------------------------*/ 
public void delete(String bookName) {
    root = delete(root,bookName);
	}

private BSTBookNode delete(BSTBookNode root,String bookName) {
  BSTBookNode node2delete, newnode2delete, node2save, parent;
  String saveValue="";
  // Step 1: Find the node we want to delete            
  node2delete=findNode(root,bookName);
     if (node2delete == null)
	return root;
     
   // Step 2: Find the parent of the node we want to delete
    parent = parent(root, node2delete);

    // Step 3: Perform Deletion based on three possibilities
   if (isLeaf(node2delete)) {
       if (parent == null)
	   return null; 
	
    if (bookName.compareTo(root.getBookName())>0)
	parent.setLeft(null);
	else
	parent.setRight(null);
	return root;
		}
   if (hasOnlyLeftChild(node2delete)) {
	if (parent == null)
	return node2delete.getLeft();
    
        if (bookName.compareTo(root.getBookName())>0)
	 parent.setLeft(parent.getLeft().getLeft());
	 
        else
	parent.setRight(parent.getRight().getLeft());
	return root;
		}
		
        if (hasOnlyRightChild(node2delete)) {
	  if (parent == null)
	  return node2delete.getRight();
	
          if (bookName.compareTo(root.getBookName())>0)
	     parent.setLeft(parent.getLeft().getRight());
		else
	  parent.setRight(parent.getRight().getRight());
		return root;
		}
		
	newnode2delete = minNode(node2delete.getRight());
		saveValue = newnode2delete.getBookName();
		
                root = delete(root, saveValue);
		
                node2delete.setBookName(saveValue);
		return root;
	}
/**---------------------------------------------------------------------------*/ 
  public BSTBookNode findNode(String bookName) {
		return findNode(root, bookName);
	}
	private BSTBookNode findNode(BSTBookNode root, String bookName ) {
		if (root == null)
			return null;
		else {
			// if the data we are searching for is found at p (at the current root)
			if (bookName.equals(root.getBookName()))
				return root;
                        
			else if (bookName.compareTo(root.getBookName())<0)
				return findNode(root.getLeft(), bookName);
			else
				return findNode(root.getRight(),bookName);
		}
	}
/**---------------------------------------------------------------------------*/ 	
      public BSTBookNode parent(BSTBookNode p) {
     /**method that call private parentmethod*/     
		return parent(root, p);
	}
	private BSTBookNode parent(BSTBookNode root,BSTBookNode p) {
		// Take care of NULL cases
		if (root == null || root == p)
			return null; // because there is on parent
		
		// If root is the actual parent of node p
		if (root.getLeft()==p || root.getRight()==p)
			return root; // because root is the parent of p
		
		// Look for p's parent in the left side of root
		if (p.getBookName().compareTo(root.getBookName())<0)
			return parent(root.getLeft(), p);
		
		// Look for p's parent in the right side of root
		else if (p.getBookName().compareTo(root.getBookName())>0)
			return parent(root.getRight(), p);
		
		// Take care of any other cases
		else
		return null;
	}
	
/**---------------------------------------------------------------------------*/ 
        public boolean isLeaf(BSTBookNode root) {
            /**method that check if it is leaf or ot*/
		return (root.getLeft()==null && root.getRight()==null);
	}
	
/**---------------------------------------------------------------------------*/ 	
	public boolean hasOnlyLeftChild(BSTBookNode root) {
           /**method that return if it has only left child or not*/
return (root.getLeft()!=null && root.getRight()==null);
	}
	
/**---------------------------------------------------------------------------*/ 	
	public boolean hasOnlyRightChild(BSTBookNode root) {
          /**method that return if it has only right child or not*/
		return (root.getLeft()==null && root.getRight()!=null);
	}
/**---------------------------------------------------------------------------*/ 
 public BSTBookNode minNode(BSTBookNode root) {
  /** method that return the smallest node */   
        if (root == null) {//if empty
            return null;
        }
        else {
            if (root.getLeft() == null) {//only root
                return root;
            }
            else {
                return minNode(root.getLeft());
            }
        }
    }
/**---------------------------------------------------------------------------*/ 

}





