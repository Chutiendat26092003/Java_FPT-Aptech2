package ss7;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinApplication extends RecursiveTask<Integer> {

    private static final int SEQUENTiAL_THRESHOLD = 5;
    private final int [] data;
    private final int startData;
    private final int endData;

    public ForkJoinApplication(int[] data, int startData, int endData) {
        this.data = data;
        this.startData = startData;
        this.endData = endData;
    }

    public ForkJoinApplication(int [] data) {
        this(data, 0, data.length);
    }

    @Override
    protected Integer compute() {
        final int length = endData - startData;
        if (length < SEQUENTiAL_THRESHOLD) {
            return computeDirectly();
        }
        final int midValue = length/2;
        final ForkJoinApplication leftValues = new ForkJoinApplication(data, startData, startData+midValue);
        leftValues.fork();

        final ForkJoinApplication rightValues = new ForkJoinApplication(data, startData + midValue, endData);
        return  Math.max(rightValues.compute(), leftValues.join());
    }

    private  Integer computeDirectly() {
        System.out.println(Thread.currentThread() + "computing: " + startData + " to " + endData);
        int max = Integer.MAX_VALUE;
        for (int i = startData; i < endData; i++) {
            if (data [i]  > max) {
                max = data[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        final int[] value = new  int[20];
        final Random ranObj = new Random();
        for (int i = 0; i < value.length; i++) {
            value[i] = ranObj.nextInt(100);
        }
        final ForkJoinPool pool = new ForkJoinPool(4);
        final ForkJoinApplication maxFindObj = new ForkJoinApplication(value);

        System.out.println("Maximum value after computing is:"+ pool.invoke(maxFindObj));
    }
}
