public class NameReverser {
    public static void main(String[] args){
        String name = "Nakagawa Ryo";

        System.out.println(name);

        for (Integer i = name.length()-1; 0 <= i; i--){
//            System.out.print(i);
            System.out.printf("%c", name.charAt(i));
        }
    }
}
