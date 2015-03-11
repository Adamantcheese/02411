
import java.io.FileNotFoundException;

public class Project2 {

    public static void main (String[] args) {
        //Prevents additional output for parsing errors
        System.err.close();
        parser p;

        //Parse each file one at a time, showing output as needed.

        //ToyTestFile is the file given from Project1. It will always reject due to syntax errors.
        System.out.println("FIRST FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }

        //ToyTestFile2 is a test of operator precedence. If you draw the tree made, it will be correct and it will accept.
        System.out.println("\nSECOND FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile2.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }

        //ToyTestFile3 is a test of different declarations and optional statements. Not completely thorough, but it will accept.
        System.out.println("\nTHIRD FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile3.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }

        //ToyTestFile4 is a test of incorrect syntax for for loops. It will never accept.
        System.out.println("\nFOURTH FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile4.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }

        //ADD OTHER TEST FILES HERE WITH THIS FORMAT:
        /*System.out.println("\n<INSERT FILE NUMBER HERE> FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile<NUMBER>.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }*/
    }
}