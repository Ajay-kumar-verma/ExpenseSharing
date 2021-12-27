// EXPENSE SHARING AMONG GROUP 
// EXPESE DETAILS AND SHARING 
import java.util.Scanner;
public class Main 
{
public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter No of Member : ");
    int no=sc.nextInt();
            sc.nextLine();  
    Member members[]=new Member[no];
  
  for(int i=0;i<no;i++)
   { 
    System.out.print("Enter name of "+(i+1)+" member : ");
       String name= sc.nextLine();
        members[i]=new Member(name);  
   }
 sc.close();

 for(int i=0;i<no;i++)
   { 
    System.out.println(members[i].Member_name);
    //    String name= sc.nextLine();
        // members[i]=new Member(name);  
   }


 


        
  }
}


// Member SHARING
class Member{

 String Member_name;   
   Member(String name)
   {
   Member_name=name;
   }
 
 Expense expese=null;  

}





// Expense SHARING
class Expense{
String place;
String item;
int amount;

Expense(String name,String place,int amount)
{
    this.item=name;
    this.place=place;
    this.amount=amount;
}

Expense next=null;

} 