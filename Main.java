// EXPENSE SHARING AMONG GROUP 
// EXPESE DETAILS AND SHARING 

import java.util.*;
public class Main 
{
public static void main(String args[]){
  // funs.add_member();   
     for(;;){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your choice ....!");
        System.out.println("2: Add member \t2:  Add expense");
        System.out.println("3: Member Details \t4: Result");
        System.out.println("5: Reset");
        try{
        int choice=sc.nextInt();
        switch(choice)
        {
         case 1:funs.add_member();break;
         case 2:funs.add_expense(); break;
         case 3:funs.detail();break; 
         case 4:funs.result();break; 
         case 5:funs.reset();break; 
         default:
         System.out.println("Invalid choice....!");
          break;
        }
        System.out.println("---------------------------------------");
     }catch(Exception e){System.out.println(e);}
    }
  
 }
  
// End of Main class 
}




class funs{
static ArrayList<Member> list=new ArrayList<>();
 static int  memNo=0;

  static void reset(){list.clear();
  System.out.println("Reset");
  }

static void add_member(){
  list.clear();
  System.out.print("Enter no of member :  ");
  Scanner sc=new Scanner(System.in);
  int count=sc.nextInt();sc.nextLine();
   memNo=count;
   if(count==0)
        return; 

   
  int i=1;
   while(i<=count){
    System.out.print("Id is "+i++ +"  Enter  member name: ");
    String name=sc.next();sc.nextLine();
    list.add(new Member(name));
  }
    

  System.out.println("member added....!");
}


static void add_expense(){
 if(list.isEmpty()){
  System.out.println("No member is added...!");
  return;
 }   
  System.out.println("----------------------------");
 System.out.println("Member details :\nName\t\tID");
 Iterator l=list.iterator();
 int count =1;
 while(l.hasNext()){
   Member memb=(Member)l.next();
   System.out.println(memb.name+"\t\t"+count++);
 }
 
  System.out.print("Enter id of member : ");
  Scanner sc= new Scanner(System.in);
  int id=sc.nextInt();
  Member mem=list.get(id-1);
  System.out.println("Member name is : "+mem.name);
  System.out.print("Enter expense\tPlace  Item  Amount : ");
  String place=sc.next();
  String item=sc.next();
  int amount=sc.nextInt();
  sc.nextLine();
mem.expense.add(new Expense(place,item,amount));

}
//  ADD EXPENSE 


static void result(){
  if(list.isEmpty()){
    System.out.println("Member not added yet ..!");
     return;
  }

  if(list.size()==1){
    Iterator i =list.iterator();
    Member m=(Member)i.next();
    long spendAmount=m.TotalSpend();
    System.out.println("One member is there: "+m.name+", SpentAmout is: "+spendAmount);
   return;
  } 

  long avg=spend()/memNo; 
    if(avg==0){
     System.out.println("No Expense ...!");
         return;
    }

    System.out.println("Member Expense  details ...!");
    Iterator i =list.iterator();
    while(i.hasNext()){
    Member m=(Member)i.next();
    long spendAmount=m.TotalSpend()-avg;
     if(spendAmount>0){
       System.out.println(m.name+" will get : "+(spendAmount));
     }   
     else if(spendAmount<0){
      System.out.println(m.name+" has to pay : "+(-1*spendAmount));
     }else{continue;}
 
     

    }  
 


  System.out.println("Result....!");
}


// This is for total spend 
static long spend(){
  Iterator i =list.iterator();
  long TotalSpend=0;  
  while(i.hasNext()){
    Member m=(Member)i.next();
      TotalSpend+=m.TotalSpend();
  }  
  return TotalSpend;
// End of spend
} 



static void detail(){
  if(list.isEmpty()){
     System.out.println("Member is not registered yet ...!");
      return;
   }

 Iterator l=list.iterator();
 System.out.println("----------------------------");
 System.out.println("Member details :\nName\t\tID");

 int count =1;
 while(l.hasNext()){
   Member memb=(Member)l.next();
   System.out.println(memb.name+"\t\t"+count++);
 }
 

  System.out.print("Enter member id : ");
  Scanner sc= new Scanner(System.in);
  int id=sc.nextInt();
  Member mem=list.get(id-1);
  LinkedList<Expense> exp=mem.expense;
   if(exp.size()==0) return;
  System.out.println("________________________________");
  System.out.println("Member name is : "+mem.name);  
  System.out.println("Place\tItem\tamount");
    

  Iterator i=exp.iterator();
  while(i.hasNext()){
    Expense e=(Expense)i.next();
   System.out.println(e.place+"\t"+e.item+"\t"+e.amount);
 }  

 System.out.println("Totol Expense is : "+mem.TotalSpend());
 System.out.println("________________________________");

}



// End of Function ....
}











// Member SHARING
class Member{

  String name;   
  Member(String name)
   {this.name=name;}
  
  
 LinkedList<Expense> expense=new LinkedList<Expense>();

 public  long TotalSpend(){

   Iterator i=expense.iterator();

   long amount=0;
   while(i.hasNext()){
    Expense e=(Expense)i.next();
    amount+=e.amount;
  }
 return amount;
}


}



// Expense SHARING
class Expense{
String place;
String item;
int amount;

Expense(String place,String item,int amount)
{
    this.item=item;
    this.place=place;
    this.amount=amount;
}
Expense next=null;

} 