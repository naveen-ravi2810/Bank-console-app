import java.util.Scanner;
class Account{
    String Name;
    private int Phone;
    private int Pin;
    private float Balance;

    Account(String name, int phone, int balance, int pin){
        Name = name;
        this.Phone = phone;
        this.Balance = balance;
        this.Pin = pin;
    }

    void getAccountInfo(){
            System.out.println("---------------------------- "+this.Name+" ----------------------------");
            System.out.println("---------------------------- "+this.Phone+" ----------------------------");
            System.out.println("---------------------------- "+this.Balance+" ----------------------------");
    }

    void accountDebit(int amount){
        if(this.Balance >= amount){
            this.Balance = this.Balance-amount;
            System.out.println("-------------------------------- The amount has been debited---------------------------- \n------------------------ Now the balance is "+this.Balance+" ------------------------------");
        } else {
            System.out.println("---------------------------------- The Amount you entered in more than your Balance --------------------------------------");
        }
    }

    void changePin(int pin){
        this.Pin = pin;
    }

    boolean checkPassword(int pin){
        if (this.Pin == pin){
            return true;
        } return false;
    }

}

class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Account a1 = new Account("Naveen", 1234567890, 2023, 1234);
        try {
            while (true){
                System.out.println("Hi "+a1.Name+", \nKindly enter the 4-digit Pin");
                int Pin = scanner.nextInt();
                if ( a1.checkPassword(Pin) ){
                    boolean status = true;
                    while(status){
                        System.out.println("1-> To get account Info\n"+
                                            "2-> To Detabit the Amount\n"+
                                            "9-> To change the pin\n"+
                                            "0-> To Exit");
                        int choice = scanner.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("=======================================================================");
                                a1.getAccountInfo();
                                System.out.println("=======================================================================");
                                break;
                            case 2: 
                                System.out.println("=======================================================================");
                                System.out.println("Enter the Amount to be Debited");
                                int debit_amount = scanner.nextInt();
                                a1.accountDebit(debit_amount);
                                System.out.println("=======================================================================");
                                break;
                            case 9:
                                System.out.println("=======================================================================");
                                System.out.println("Enter the new Pin to get Updated");
                                int new_pin = scanner.nextInt();
                                a1.changePin(new_pin);
                                System.out.println("=======================================================================");
                                status = false;
                                break;
                            case 0:
                                status = false;  
                                break;
                            default:
                                System.out.println("=======================================================================");
                                System.out.println("Enter the Correct Option");
                                System.out.println("=======================================================================");
                                break;
                        }
                    }
                } else {
                    System.out.println("The Pin you entered in Wrong");
                }
            }
        }catch (Exception e){
            System.out.println(e);
            // break;
        }
    }
}


