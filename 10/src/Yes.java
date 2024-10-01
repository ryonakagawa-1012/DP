public class Yes{
    void run(String[] args) {
        String string;

        if(args.length == 0){
            string = "y";
        }else{
            string = args[0];
        }

        while(true){
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        Yes yes = new Yes();
        yes.run(args);
    }
}