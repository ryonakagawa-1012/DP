import java.util.ArrayList;

public class FibonacciList {
    void run(String[] args){
      Integer maxIndex = 10;
      
      if(args.length > 0){
        maxIndex = Integer.valueOf(args[0]);
      }

      ArrayList<Integer> list = getFibonacciList(maxIndex);
      System.out.println(list);

    }

    ArrayList<Integer> getFibonacciList(Integer maxIndex){
      ArrayList<Integer>Fibonacci = new ArrayList<>();
      
      for(Integer i = 0;i < maxIndex; i++){
        if(i < 2){
          Fibonacci.add(1);
        }else{
          Fibonacci.add(Fibonacci.get(i-1) + Fibonacci.get(i-2));
        }
      }
      return Fibonacci;
    }

    public static void main(String[] args) {
      FibonacciList app = new FibonacciList();
      app.run(args);
    }
  }
