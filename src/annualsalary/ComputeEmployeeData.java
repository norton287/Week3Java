package annualsalary;

/* SalesEmployee class is designed to handle all the data and formating output for
the AnnualSalary class that creates an instance of this class
*/
public class ComputeEmployeeData {
    
    //Establish the variables to be used
    private static double salary, commission;
    private static double annualSales, computedCommission, commissionAmount, totalAnnualSalary;
   
    /*The constructor that accepts annualSales as a parameter.  It also
    establishes the other static variables for the ComputeAnnualSalary method.
    */
    public ComputeEmployeeData(double annualSales) {
        //Static variables
        salary = 30000;
        commission = 7;
        ComputeEmployeeData.annualSales = annualSales;
    }
    /* Calculates the computedCommission, the commissionAmount, and totalAnnualSalary.
    This method when called returns the totalAnnualSalary */
    private static double setComputeAnnualSalary(){
        computedCommission = (commission / 100);
        commissionAmount = (computedCommission * ComputeEmployeeData.annualSales);
        totalAnnualSalary = (salary + commissionAmount);
        return totalAnnualSalary;
    }
    /*Outputs the data in string format to be printed to the console and the file.
    The @Override overrides the toString method */
    @Override
    public String toString() {
        return ("\nTotal Annual Sales For Employee: $" + String.format("%.2f", ComputeEmployeeData.annualSales) +
                "\nTotal Annual Salary With Commission: $" + String.format("%.2f", setComputeAnnualSalary()) + "\n");
    }
}
