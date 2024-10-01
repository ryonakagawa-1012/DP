import java.io.*;
import java.util.HashMap;

public class ZipCode {
    HashMap<Integer, String> zipCodes = new HashMap<>();

    void run(String[] args) throws IOException {
        initialize();

        for(Integer i = 0; i < args.length; i ++){
            searchAndPrint(args[i]);
        }
    }

    void initialize() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("zipcode.csv")));
        String line;
        String[] strs;
        String name;
        Integer value;

        while((line = in.readLine()) != null){
            strs = line.split(",");
            value = Integer.valueOf(stripQuote(strs[2]));
            name = stripQuote(strs[6]) + stripQuote(strs[7]) + stripQuote(strs[8]);

            zipCodes.put(value, name);
        }
    }

    String stripQuote(String item){
        if(item.matches("\".*\"")){
            return item.substring(1, item.length() - 1);
        }
        return item;
    }

    void searchAndPrint(String inNumber) {
        String name = this.zipCodes.get(Integer.valueOf(inNumber));

        if(name == null){
            System.out.printf("%s: 見つかりませんでした。%n", inNumber);
        }else{
            System.out.printf("%s: %s%n", inNumber, name);
        }
    }

    public static void main(String[] args) throws IOException {
        ZipCode zipCode = new ZipCode();
        zipCode.run(args);
    }
}