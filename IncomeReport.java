
import java.util.Scanner;

public class IncomeReport {

    public static void main(String[] args) {
   
        String name;
        String id; 
        String incomeType;
        double amount;
        double tax;
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Staff Name: ");
        name = input.nextLine();
        System.out.print("Enter Staff ID: ");
        id = input.nextLine();
        System.out.print("Enter Income Type: ");
        incomeType = input.nextLine();
        System.out.print("Enter Income Amount: ");
        amount = input.nextDouble();
        System.out.print("Enter Income Tax Percentage: ");
        tax = input.nextDouble();

        Income info = new Income(incomeType,amount,tax);
        Staff details = new Staff(name, id, info);
        details.displayStaffInfo();
        details.displayIncomeInfo();
    }
}

class Income{

    private String incomeType;
    private double amount,tax,totalTax;

    public Income(String incomeType, double amount, double tax){
        this.incomeType = incomeType;
        this.amount = amount;
        this.tax = tax;
    }

    public String getIncomeType(){
            return incomeType;
    }

    public double getAmount(){
        return amount;
    }

    public double getTax(){
        return tax;
    }

    public double getTotalTax(){
        totalTax = (tax/100)*amount;
        return totalTax;
    }
}

class Staff{

    private String name,id;
    private Income income;

    public Staff(String name, String id, Income income){
        this.name = name;
        this.id = id;
        this.income = income;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public double calculateNetIncome(){
        double netIncome = income.getAmount()-income.getTotalTax();
        return netIncome;
    }

    public void displayStaffInfo(){
        System.out.printf("\n********Staff Info********\n");
        System.out.println("Staff Name: " + getName());
        System.out.println("Staff ID: " + getId());
    }

    public void displayIncomeInfo(){
        System.out.printf("\n********Income Info********\n");
        System.out.println("Income Type: " + income.getIncomeType());
        System.out.printf("Income Amount: RM %.2f\n", income.getAmount());
        System.out.println("Income Tax Percentage: " + income.getTax() + "%");
        System.out.printf("Total Tax Paid: RM %.2f\n" , income.getTotalTax());
        System.out.printf("Total Net Income: RM %.2f\n" ,calculateNetIncome());
    }
}
