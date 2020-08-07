package JoinFork;

import javafx.scene.transform.Transform;

import java.util.concurrent.ForkJoinPool;

public class FJExperiment {

    public static void main (String[] args){
        int pLevel;
        int thereshold;

        if (args.length !=  2){
            System.out.println("Использование : FJexperiment парралелизм порог ");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        thereshold = Integer.parseInt(args[1]);

        long beginT,endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double [] nums = new double[1000000];
        for (int i =0 ; i< nums.length; i++){
            nums[i] = (double) i;
        }
            TransformMas task = new TransformMas (nums,0,nums.length,thereshold);
        beginT = System.currentTimeMillis();
        fjp.invoke(task);
        endT = System.currentTimeMillis();
        System.out.println("Уровень парралелизма:  "+ pLevel);
        System.out.println("Порог последовательной обработки:  "+ thereshold);
        System.out.println("Прошедшее время:  "+ (endT-beginT)+"  мили секнд");
        System.out.println();
    }

}
