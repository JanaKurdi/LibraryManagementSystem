//8/4/2021
import java.io.*;//for files
import java.util.Scanner;//for scanner
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File inFile=new File("Library.in.txt");
           if(!inFile.exists()){//if input file dose not exsist
            System.out.println("input file does not exsist!");
            System.exit(0);
        }
        
   Scanner input=new Scanner(inFile);//read input file
   PrintWriter output=new PrintWriter("Library.out.txt");//crate output file
   
   /** Declare linkedlists */
   BSTStudent studentList=new BSTStudent(); 
   BSTBook bookList=new BSTBook();
   
   
   String command;
   while(input.hasNext()){//read from infile while it has next
       command=input.next();//read from inFile
       
       if (command.matches("CREAT_STUD_BST")){
           /** Command #1 */
        String stu[]=input.next().split(",");//save IDs in array
        for(int i=0;i<stu.length;i++){
           studentList.addStu(Integer.parseInt(stu[i]));//add IDs in the student list
        }
       output.println("Student BST is successfully created");
       }
       
       if (command.matches("ADD")){
           /** Command #2 */
        String book=input.nextLine().trim();//read book name
        if(bookList.bookSearch(book)==0){//if book is not found
            bookList.bookADD(book);//add the book in the book list
       output.println(book+" is added in the library: 1 copy in the library");
       
        }else{//if book is found
          bookList.updateCopies(book);//increment the number of copies
         int count=bookList.bookSearch(book);//count the number of copies
          output.println(book+" is added in the library: "+count+" copies in the library");
        }
       }
     
       if (command.matches("BORROW")){
           /** Command #3 */
         int id=input.nextInt();//read student id
         String book=input.nextLine().trim();//read book name
         if(bookList.bookSearch(book)==0)//if book is not found
          output.println("Sorry, "+book+" is not available in the library");
         
         else if(studentList.stuSearch(id)==3)//if student borrowed 3 books 
         output.println("Sorry, you have already borrowed 3 books");
         
        else{
         studentList.bookBorrowed(id,book);//add a the book to borrow  
         bookList.updateBorrowedbooks(book);//update available copies
         output.println(book+" is borrowed by Student "+id);  
         output.println("Student "+id+" has borrowed "+studentList.stuSearch(id)+" book");
       
         if(bookList.bookSearch(book)==0){//if book is not found
            bookList.delete(book);
          output.println(book+" is now deleted from the library");
         
         }else
            if(bookList.bookSearch(book)>1)//more than one copy
            output.println(bookList.bookSearch(book)+" copies of "+book+" are now available in the library");
            else//one copy
              output.println(bookList.bookSearch(book)+" copy of "+book+" is now available in the library");
        }
       }
       
       if (command.matches("RETURN")){
           /** Command #4 */
           int id=input.nextInt();//read id
           String book=input.nextLine().trim();//read book name
           studentList.stuReturn(id, book);
         output.println("Student "+id+" has returned "+book+"");
         output.println("Student "+id+" has borrowed "+studentList.stuSearch(id)+" books");

       if(bookList.bookSearch(book)>1){//more than one copy
           bookList.updateCopies(book);//increment number of copies
       output.println(bookList.bookSearch(book)+" copies of "+book+" are now available in the library");
   
     }else{//if book is not found
           bookList.bookADD(book);//add the book to the list
           bookList.updateCopies(book);//increment number of copies
     output.println(book+" is added in the library: "+bookList.bookSearch(book)+" copy in the library");
     }
       }
       
       if (command.matches("DISPLAY_ALL_BOOKS")){
           /** Command #5 */
          output.println("The following books are in the library"); 
          output.print(bookList.inorder());//print available books and number of copies
          output.println("---------------------------------------------");
      } 
           
       if (command.matches("DISPLAY_RECORD_OF")){
           /** Command #6 */
       int id=input.nextInt();//read id
       output.println(id+" has borrowed the following "+studentList.stuSearch(id)+" books");
       output.print(studentList.inorder(id));//print the borrowed book of student
       output.println("----------------------------------------");
           
       }
   }

  output.close();//close output file
  input.close();//close input file
}
}
    