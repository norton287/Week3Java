package annualsalary;

/* Importing these packages for the FileWriter, the IOException in the try..catch block and
for the Scanner object to read the console data.
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author John Norton
 */
public class AnnualSalary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* The actual method that creates the input and output to the console and file
        SalesReport.txt.  It instantiates an instance of ComputeEmployeeData to get the sales
        figures for ouputting to the file and console.
        */
        Compensation();
    }
    
    static void Compensation() {
        //Name file to write text to
        final String FileName = "SalesReport.txt";
        //Scanner reads data from sources, in this case the console.
        Scanner in = new Scanner(System.in);
        //Filewritee initilization, setting it to null for now
        FileWriter fileWriter = null;
        //Establish and initialize choice variable with a default value
        char choice = 0;
        //Get/print/write the annual sales numbers in this do..while loop
        do {
            //Query the user for the annual sales for the salesperson
            System.out.print("Enter the annual sales for the salesperson: $");
            double annualSales = Double.parseDouble(in.nextLine());
            
            //Create a ComputeEmployeeData Instance and call the constructor with the annualSales parameter
            ComputeEmployeeData salesData = new ComputeEmployeeData(annualSales);

            /* Outputs the information from the salesData.toString method to the console.
            Adding two "\n" to put some spacing before and after the output to console.
            */
            System.out.println("\n" + salesData.toString() + "\n");
            
            /*Cannot find the reference information for research in code but this try block idea is from
            https://journaldev.com/881/java-append-to-file
            Java Append to File
            Pankaj
            Unknown publishing date
             */
            try {
                //Opening the file in append mode
                fileWriter = new FileWriter(FileName, true);
                /*Outputs to the file the information retrieved from salesData.toString()
                method
                */
                fileWriter.write(salesData.toString());
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    //Dispose of the fileWriter object
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            //Report that the file has been written to the user and what the filename is.
            System.out.println("The sales persons information has been successfully written to file: " + FileName);

            //Prompt the user if they want to continue...
            System.out.print("\nWant to determine the  total annual compensation for another sales employee? [y/n]: ");
            
            /* Assigns choice with the console input at index 0 of the char.  Choice determines
            if the loop repeats or stops based on y or n answers.  toUpperCase converts the char at index 0
            to upper case to not have to check for both lower and upper case characters.
            */
            choice = Character.toUpperCase(in.nextLine().charAt(0));
            
            //Print new line to add space between console output
            System.out.println();
            
          //If choice anything other than N then the do..while loop will repeat and continue
        } while (choice != 'N');
    }
}
