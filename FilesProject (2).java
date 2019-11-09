package filesproject;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FilesProject {

        //this method is populating the files with random numbers 
        //the user decides the number of files and the number of integers in the file
    public static void populateFiles(int n, int s)throws FileNotFoundException{
           for(int i = 1; i<=n; i++){
                PrintWriter outFile = new PrintWriter("numbers_" +i + ".txt");
                Random rand= new Random();
           
                for(int j = 0; j< s; j++){
                    outFile.println(rand.nextInt(9));
                }
                 outFile.close();
            }
    }
    //This method is taking all of the files and adding up the random integers 
    //created in populateFiles and finding their average
    //it is printing the results to stats.txt
    public static void calculateStat(int n, int s)throws FileNotFoundException{
           PrintWriter outfile = new PrintWriter("stats.txt");
           
           for(int i =1; i<=n;i++)
           {
                int intSum=0;
                float average=0;
                
                File inputFile= new File("numbers_" +i + ".txt");
                Scanner in = new Scanner(inputFile);
                
                while(in.hasNextInt())
                {                
                      intSum += in.nextInt();
                      average= (float)intSum/s;
                }
                
                outfile.printf("%s\t%d\t%.3f%n","numbers_" +i + ".txt",intSum,average); 
           }
           
           outfile.close();
    }
    //Ask the user for the number of files and number of integers to put in the files.
    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("Please enter the number of files.");
        Scanner in = new Scanner(System.in);
        int numberFiles= in.nextInt();
        
        System.out.println("Please enter the size of files.");   
        int size = in.nextInt();
        
        populateFiles(numberFiles, size);
        calculateStat(numberFiles, size);
    }
    
}
