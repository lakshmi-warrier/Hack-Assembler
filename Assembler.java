import java.util.*;
import java.io.*;

public class Assembler {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the input asm file path");
        String source_file = sc.nextLine().trim();

        while(!source_file.substring(source_file.length()-4, source_file.length()).equals(".asm"))
        {
            System.out.println("Input is not an asm file");
            source_file = sc.nextLine();
        }

        System.out.println("\nEnter the output hack file path");
        String target_file = sc.nextLine().trim();
        
        while(!target_file.substring(target_file.length()-5, target_file.length()).equals(".hack"))
        {
            System.out.println("Output file is not a hack file");
            source_file = sc.nextLine();
        }

        Parser p1 = new Parser(source_file);

        try {
            FileWriter fw = new FileWriter(target_file);
            fw.write(p1.translate());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
