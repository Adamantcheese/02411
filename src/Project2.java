
import java.io.FileNotFoundException;

public class Project2 {

    public static void main (String[] args) {
        //Prevents additional output for parsing errors
        System.err.close();
        parser p;
        //Parse the first file
        /*System.out.println("FIRST FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }

        //Parse the second file
        System.out.println("\nSECOND FILE PARSING OUTPUT");
        try {
            p = new parser(new ToyScanner("ToyTestFile2.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }*/

        try {
            p = new parser(new ToyScanner("Test.toy"));
            p.parse();
            System.out.println("\n[accept]");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }
    }
}