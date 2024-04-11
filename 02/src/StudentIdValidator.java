public class StudentIdValidator {
    void run(String[] args){
        for (Integer i = 0; i < args.length; i++){
            validate(args[i]);
        }
    }

    void validate(String id){
        if (id.length() != 6){
            System.out.printf("%s: not student id%n", id);
        }
        else {
            this.validateId(Integer.valueOf(id));
        }
    }

    void validateId(Integer id){
        String idString = id.toString();

        Integer sum = 0;
        for (int i = 0; i < 6; i++){
            sum += Character.getNumericValue(idString.charAt(i));
        }

        System.out.printf("%d: ", id);
        if (sum % 10 == 0){
            System.out.println("valid");
        }
        else {
            System.out.println("invalid");
        }
    }

    public static void main(String[] args){
        StudentIdValidator application = new StudentIdValidator();
        application.run(args);
    }
}
