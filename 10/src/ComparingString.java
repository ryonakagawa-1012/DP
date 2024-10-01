import java.util.Objects;

public class ComparingString {
    void run(String[] args) {
        for(Integer i = 0; i < args.length; i ++){
            if(Objects.equals(args[i], "KSU_AP")){
                System.out.println("渡された文字列は\"KSU_AP\"です.");
            }else{
                System.out.println("渡された文字列は\"KSU_AP\"ではなく\"" + args[i] + "\"です.");
            }
        }
    }

    public static void main(String[] args) {
        ComparingString comparigString = new ComparingString();
        comparigString.run(args);
    }
}