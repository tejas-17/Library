import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {//tejas
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern AuthorTitle_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern PublishYear_Pattern=Pattern.compile("^\\d{4}$");
    private static Pattern COST_PATTERN = Pattern.compile("^\\d+$");
    private static Pattern Quantity_Pattern=Pattern.compile("^\\d{1,2}$");
    Scanner sc = new Scanner(System.in);

    public String validateId() {//tejas
        String id;
        while (true) {
        	System.out.println("Enter Book ID ");
            id = sc.nextLine();
            if (!ID_PATTERN.matcher(id).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID "+RESET);
            } else {
                break;
            }
        }
        return id;
    }
    
    
    
    public String validateCost() {//tejas
        String bookCost;
        while (true) {
            System.out.println("Enter Book cost ");
            bookCost= sc.nextLine();
            if (!COST_PATTERN.matcher(bookCost).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK COST "+RESET);
            } else {
                break;
            }
        }
        return bookCost;
    }

    public String validateAuthorTitle(String input){//vinod
        String result;
        while (true){
            if(input=="Title"){
                System.out.println("Enter Title");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!AuthorTitle_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }
    public String validatePublishYear(){//umesh 
        String year;
        while(true){
            System.out.println("Enter Publish Year of Book ");
            year=sc.nextLine();
            if(!PublishYear_Pattern.matcher(year).matches()){
                System.out.println(RED+"Enter valid Publish Year"+RESET);
            }
            else{
                break;
            }
        }
        return year;
    }
    
    public String validateQuantity() {//umesh
    	String quantity;
    	while(true) {
    		System.out.println("Enter Quantity of Book");
    		quantity = sc.nextLine();
    		if(!Quantity_Pattern.matcher(quantity).matches()) {
    			System.out.println(RED+"Enter valid Quantity"+RESET);
    		}
    		else {
    			break;
    		}
    	}
    	return quantity;
    }
  
}