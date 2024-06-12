import java.util.Arrays;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        double[] R1 = new double[]{0, 1, 2, 3};
        double[] R2 = new double[]{1, 2, 3, 4, 5};
        double[] Rx = new double[]{1, 2, 3, 4};

        Operation sum = (x, y) -> x + y;
        Operation mul = (x, y) -> x * y;
        Operation div = (x, y) -> x / y;

        double[] A = findResult(R1, R2, sum);
        double[] B = findResult(R1, R2, mul);
        double[] ARx = findResult(A, Rx, mul);
        double[] sum1 = findResult(ARx, B, mul);
        double[] sum2 = findResult(Rx, R2, sum);
        double[] result = findResult(sum1, sum2, div);

        HashSet<Double> set = new HashSet<>();
        for (double elem: result){
            if (elem >= Rx[0] && elem <= Rx[Rx.length - 1]){
                set.add(elem);
            }
        }

        double[] answer = set.stream().mapToDouble(x -> x).toArray();
        Arrays.sort(answer);

        for (double elem: answer){
            System.out.println(elem);
        }
    }

    public static  double[] findResult(double[] mas1, double[] mas2, Operation op){
        int size = mas1.length * mas2.length;
        double[] result = new double[size];

        int counter = 0;

        for (double elem1: mas1) {
            for (double elem2: mas2) {
                result[counter] = op.op(elem1, elem2);
                counter++;
            }
        }

        return result;
    }
}

interface Operation{
    double op(double x, double y);
}