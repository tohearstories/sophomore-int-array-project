package week1arrayproject;

/**
 * week1arrayproject 
 * created for CSCI 211 
 * last modified 01/13/15
 * @author George Oster
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Week1ArrayProject {

    public static void main(String[] args) throws Exception {

        int howmanylines = lineCounter("enrollments.txt"); // will hold how many lines are in the text file
        int enrollment[] = arrayLoader("enrollments.txt", howmanylines); // declare and initialize enrollment[]
        int stats[] = statsFinder(enrollment, howmanylines); // stats[0] = min, stats[1] = avg, stats[2] = max
        writeToFile("EnrollmentAnalysis.txt", howmanylines, stats); // write results to a simple text file
        
        System.out.println("There are " + howmanylines + " sections of CIS103.");
        System.out.println("The minimum number of students for a section of CIS103 is " + stats[0] + ".");
        System.out.println("The maximum number of students for a section of CIS103 is " + stats[2] + ".");
        System.out.println("The average class size for all sections of CIS103 is " + stats[1] + ".");
        System.out.println("For your convenience, the results have been written to EnrollmentAnalysis.txt,");
        System.out.println("which is located in the netbeans folder for this program.");

    }//end main method

    
    
    public static int lineCounter(String filename) throws Exception {
        
        int toreturn = 0;
        BufferedReader reader = new BufferedReader( new FileReader(filename) );
        
        while ( reader.readLine() != null )
            toreturn++;
        
        reader.close();
        return toreturn;
        
    }//end lineCounter()

    
    
    
    public static int[] arrayLoader(String filename, int howmanylines) throws FileNotFoundException{
        
        int toreturn[] = new int[howmanylines];
        Scanner infile = new Scanner( new java.io.File(filename) );
        
        int i;
        for (i = 0; i < howmanylines; i++) 
            toreturn[i] = Integer.parseInt( infile.nextLine() );
        
        return toreturn;
        
    }//end arrayLoader()
    
    
    
    
    public static int[] statsFinder(int[] enrollment, int howmanylines){
        // toreturn[0] = min, toreturn[1] = avg, toreturn[2] = max
    	int[] toreturn = {enrollment[0],0,0};
    	int i;
        
    	for (i=0; i<howmanylines; i++){
    		if (enrollment[i] < toreturn[0])
    			toreturn[0] = enrollment[i];
    		if (enrollment[i] > toreturn[2])
    			toreturn[2] = enrollment[i];
    		toreturn[1] = toreturn[1] + enrollment[i];
    	}
        
    	toreturn[1] = toreturn[1] / howmanylines;
        
    	return toreturn;
        
    }//end statsFinder()
    

    
    
    public static void writeToFile(String filename, int howmanylines, int[] stats) throws FileNotFoundException{
       
        java.io.PrintWriter write = new java.io.PrintWriter( new java.io.File(filename) );
        write.println("There are " + howmanylines + " sections of CIS103.");
        write.println("The minimum number of students for a section of CIS103 is " + stats[0] + ".");
        write.println("The maximum number of students for a section of CIS103 is " + stats[2] + ".");
        write.println("The average class size for all sections of CIS103 is " + stats[1] + ".");
        write.close(); 
        
    }//end writeToFile()

}//end class Week1ArrayProject
