package func;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tag {
    public static String generate(String[] tags,String step){
        String result = "";
        for (String tag : tags) {
            result += tag+"+";
        }
        return result;
    }
    public static String[] read(File file){
        try {
            String textFile = "";
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                textFile += scan.nextLine()+"\n";
            }
            scan.close();
            return textFile.split("\n");
        } catch (FileNotFoundException e) {
            System.err.println("scan not found");
            return null;
        }
    }
}
