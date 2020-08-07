package JoinFork;


import java.util.concurrent.RecursiveAction;

public class TransformMas extends RecursiveAction {

    int seqThreshold;
    double[] data;
    int start,end;

    TransformMas(double[] vals, int s, int e, int t){
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        if ((end-start) < seqThreshold){
            for (int i = start ; i<end;i++){
                if ((data[i]%2)==0){
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }

            }
        }else {
            int middle  = (start+end)/2;
            invokeAll(new TransformMas(data,start,middle,seqThreshold),
                    new TransformMas(data,middle,end,seqThreshold));
        }
    }
}
