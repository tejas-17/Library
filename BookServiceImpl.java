
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface {
	//vinod
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
   // Scanner sc=new Scanner(System.in);
    Validator validator=new Validator();
    List<Book> books=new ArrayList<>();

    @Override
    public void addBook() {//vipin

       String bookid= validator.validateId();
       String Author=validator.validateAuthorTitle("Author");//method
       String Title=validator.validateAuthorTitle("Title");
       String year=validator.validatePublishYear();
       String quantity=validator.validateQuantity();
       String borrowed="0";
       String cost=validator.validateCost();
        Book book=new Book(bookid,Title,Author,year,quantity,"Available",borrowed,cost);
        books.add(book);
        System.out.println(GREEN+"Book Added Successfully !!!"+RESET);

    }
    @Override
    public void showAllBooks() {//doel
        boolean flag=false;
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%30s%30s%30s%30s%30s%30s%30s","ID","TITLE","AUTHOR","PUBLISH YEAR", "QUANTITY","STATUS","COST","BORROWED"+RESET);
       System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

          for (Book book:books){
              System.out.format("%s%30s%30s%30s%30s%30s%30s%30s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getQuantity(),book.getStatus(),
            		 book.getCost(),book.getBorrowed());
              System.out.println();
              flag=true;
            }
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       if(flag==false)
           System.out.println(RED+"There are no Books in Library"+RESET);
    }
    public void showAllAvailableBooks(){//doel
        boolean flag=false;
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%30s%30s%30s%30s%30s%30s%30s","ID","TITLE","AUTHOR","PUBLISH YEAR","QUANTITY","STATUS","COST","BORROWED"+RESET);
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if(books.size()>0){
            for (Book book:books){
                if(book.getStatus()=="Available"){
                    System.out.format("%s%30s%30s%30s%30s%30s%30s%30s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getQuantity(),book.getStatus(),book.getCost(),book.getBorrowed(),"\r\n"
                    		+book.getCost(),book.getBorrowed());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else{
            System.out.println(RED+"No Books Available in the library"+RESET);
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no books with status Available"+RESET);

    }
    
    public void borrowBook(){//shivam
       String bookid= validator.validateId();
       boolean flag=false;
       for(Book book:books){
           if(book.getId().equals(bookid) && book.getStatus().equals("Available")){
               flag=true;
               System.out.println(GREEN+"Book Borrowed Successfully !!!"+RESET);
               book.setQuantity(String.valueOf(Integer.valueOf(book.getQuantity())-1));
               book.setBorrowed(String.valueOf(Integer.valueOf(book.getBorrowed())+1));
               if(Integer.valueOf(book.getQuantity()) <= 0 ) {
            	   book.setStatus("Not Available");
               }
               System.out.println("Borrowed Book Details: "+book);
           }
          }
       if(flag==false)
           System.out.println(RED+"This book is not available to borrow"+RESET);

    }
    public void returnBook(){//shivam
        boolean flag=false;
        String bookid= validator.validateId();
        for(Book book:books){
            if(book.getId().equals(bookid) && Integer.valueOf(book.getBorrowed()) > 0){
                flag=true;
                System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                book.setQuantity(String.valueOf(Integer.valueOf(book.getQuantity())+1));
                book.setBorrowed(String.valueOf(Integer.valueOf(book.getBorrowed())-1));
                book.setStatus("Available");
                System.out.println("Returned Book Details: "+book);
            }

        }
        if(flag==false)
            System.out.println(RED+"We can not return this book"+RESET);

    }


}
