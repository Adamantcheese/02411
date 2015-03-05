
import java.io.*;

public class Project2 {

    public static void main (String[] args) {
        parser p = new parser();
        try {
            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}