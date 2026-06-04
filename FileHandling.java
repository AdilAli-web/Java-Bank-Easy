
import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public static void main(String[] args) {
        // Code for file handling will go here
        filing f = new filing();
        try {
            f.create();
            f.read();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());

        }

    }

}

class filing {

    public void create() throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter("D:\\JAVA\\java\\Project\\data.txt", true));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text : ");

        String str = sc.nextLine();
        try {

            br.write(str);
            br.close();   // ✅ close karna zaroori hai
        } catch (Exception e) {
        }

    }

    public void read() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA\\java\\Project\\data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
