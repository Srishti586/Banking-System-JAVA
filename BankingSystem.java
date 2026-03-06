import java.util.Scanner;
import java.util.ArrayList;

public class BankingSystem
{
  static  class Accounts
 {
    public String name;
    public long accno;
    public double balance;
   Accounts(String name,long accno,double balance)
   {
     this.name=name;
     this.accno=accno;
     this.balance=balance;

   }
   public void deposit(double amount)
   {
      if(amount>0)
      {
        balance+=amount;
        System.out.println("Amount Successfully Deposited");
      }
      else
      {
        System.out.println("****************Invalid Amount**********************");
      }

   }
   public void withdraw(double amount)
   {
    if(amount<=balance)
    {
        balance-=amount;
        System.out.println("Amount deducted Successfully");

    }
    else
    {
        System.out.println("*************Insufficient balance*************");
    }
   }
   public void checkAccount()
   {

    System.out.println("Account holder's name="+name);
    System.out.println("Account Balance=Rs"+balance);
   }
   
 }
 public static  Accounts searchAcc(ArrayList<Accounts>account,Long accno)
 {
  for(Accounts a:account)
  {
    if(a.accno==accno)
    {
      return a;
    }
  }
  return null;
 }
 public static void allAccounts(ArrayList<Accounts>account)
   {
    if (account.isEmpty())
    {
      System.out.println("************No Account details available****************");
      return ;
    }
    else
    {
     for(Accounts acc:account)
     {
      System.out.println("Account holder's name="+acc.name);
      System.out.println("Account no.="+acc.accno);
      System.out.println("Account Balance=Rs"+acc.balance);
      System.out.println("---------------------------------------------------------------------------------");
     }
    }
   }

 public static void main(String[] args)
 {
    Scanner r=new Scanner(System.in);
    ArrayList<Accounts> account=new ArrayList<>();
    while(true)
    {
        System.out.println("------------------------------BANKING SYSTEM---------------------------------");
        System.out.println("1.Create Account \n 2.Deposit Money \n 3.Withdraw Money \n 4.Check Account details\n 5.Dispaly all accounts details \n 6.Exit");
        System.out.println("Enter choice");
        int ch=r.nextInt();
        switch(ch)
        {
            case 1:
                  r.nextLine();
                  System.out.println("Enter Account holder name=");
                  String name=r.nextLine();
                  System.out.println("Enter Account no.= ");
                  long accno=r.nextLong();
                  System.out.println("Enter current balance=");
                  double balance=r.nextDouble();
                  account.add(new Accounts(name,accno,balance));
                  System.out.println("Account created successfully");
                  break;
            case 2:
                  System.out.println("Enter Account no=");
                  accno=r.nextLong();
                  Accounts acc=searchAcc(account,accno);
                  if(acc!=null)
                  {
                    System.out.println("Enter amount to be deposited=");
                    double amount=r.nextDouble();
                    acc.deposit(amount);
                  }
                  else
                  {
                    System.out.println("*******************Account not found********************");

                  }
                  break;
            case 3:
                  System.out.println("Enter Account no=");
                  accno=r.nextLong();
                  acc=searchAcc(account,accno);
                  if(acc!=null)
                  {
                    System.out.println("Enter amount to Withdraw=");
                    double amount=r.nextDouble();
                    acc.withdraw(amount);
                  }
                  else
                  {
                    System.out.println("*******************Account not found********************");

                  }
                  break;
            case 4:
                  System.out.println("Enter Account no=");
                  accno=r.nextLong();
                  acc=searchAcc(account,accno);
                  if(acc!=null)
                  {
                    acc.checkAccount();

                  }
                  else
                  {
                    System.out.println("*******************Account not found********************");

                  }
                  break;
            case 5:
                  allAccounts(account);
                  break;      
            case 6:
                System.out.println("******************THANK YOU**********************");
                r.close();
                return;
                
            default:
                System.out.println("**********************ERROR INVALID CHOICE*****************************");
                break;


        }       

    }
 }
}