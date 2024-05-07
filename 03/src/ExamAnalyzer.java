import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExamAnalyzer{
    void run(){
        ArrayList<ExamScore> examScoreArrayList = new ArrayList<>();

        for (Integer i = 0; i < 10; i++){
            examScoreArrayList.add(createRandomScore(String.valueOf(i)));
        }

        List<Integer> sum = Arrays.asList(0, 0, 0);
        List<Integer> max = Arrays.asList(0, 0, 0);
        List<Integer> min = Arrays.asList(101, 101, 101);

        for (Integer i = 0; i < 10; i++){
            Integer math = examScoreArrayList.get(i).math;
            sum.set(0, sum.getFirst() + math);
            max.set(0, math > max.getFirst() ? math : max.getFirst());
            min.set(0, math < min.getFirst() ? math : min.getFirst());

            Integer physics = examScoreArrayList.get(i).physics;
            sum.set(1, sum.get(1) + physics);
            max.set(1, physics > max.get(1) ? physics : max.get(1));
            min.set(1, physics < min.get(1) ? physics : min.get(1));

            Integer english = examScoreArrayList.get(i).english;
            sum.set(2, sum.get(2) + english);
            max.set(2, english > max.get(2) ? english : max.get(2));
            min.set(2, english < min.get(2) ? english : min.get(2));
        }

        System.out.println("       math   phys   eng   ave");
        System.out.printf("ave %6.3f %6.3f %6.3f\n", sum.get(0) / 10.0, sum.get(1) / 10.0, sum.get(2) / 10.0);
        System.out.printf("max %6d %6d %6d\n", max.get(0), max.get(1), max.get(2));
        System.out.printf("min %6d %6d %6d\n", min.get(0), min.get(1), min.get(2));

        for (Integer i = 0; i < 10; i++){
            ExamScore examScore = examScoreArrayList.get(i);
            Double average = (examScore.math + examScore.physics + examScore.english) / 3.0;
            System.out.printf("%s   %6d %6d %6d   %6.3f\n", examScore.name, examScore.math, examScore.physics, examScore.english, average);
        }
    }

    ExamScore createRandomScore(String name){
    Random random = new Random();
    Integer math = random.nextInt(101);
    Integer physics = random.nextInt(101);
    Integer english = random.nextInt(101);
    return this.createExamScore(math, physics, english, name);
    }

    ExamScore createExamScore(Integer math, Integer physics, Integer english, String name){
        ExamScore examScore = new ExamScore();
        examScore.math = math;
        examScore.physics = physics;
        examScore.english = english;
        examScore.name = name;

        return examScore;
    }

    public static void main(String[] args){
        ExamAnalyzer application = new ExamAnalyzer();
        application.run();
    }
}