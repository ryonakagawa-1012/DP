import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    HashMap<String, String> pb = new HashMap<>();

    void run(String[] args) {
        SimpleConsole console = new SimpleConsole();

        while(true){
            String in = console.readLine();
            String[] ins = in.split(" ");

            if(ins[0].equals("add")){
                pb.put(ins[1], ins[2]);
            }else if(ins[0].equals("list")){
                print();
            }else if(ins[0].equals("find")){
                find(ins[1]);
            }else if(ins[0].equals("remove")){
                pb.remove(ins[1]);
            }else if(ins[0].equals("exit")){
                break;
            }
        }
    }

    void print() {
        for(Map.Entry<String, String> entry: pb.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " " + value);
        }
    }

    void find(String name) {
        System.out.println(name + " " + pb.get(name));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.run(args);
    }
}