
import java.io.*;

public class Project2 {

    public static void main (String[] args) {
        parser p = new parser();
        try {
            p.parse();
            System.out.println("\n[accept]");
        } catch (Exception e) {
            System.out.println("\n[reject]");
        }
    }
}