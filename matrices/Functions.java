import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Functions{

    public static double evaluation(Matrix a, Matrix b, Matrix pi, int n, int[] seq){
        //first step
        Matrix alphas = pi.elementRowMultiply(b.getColumnAsMatrix(seq[0]));

        for(int i = 1; i< seq.length; i++){
            alphas = alphas.matrixMultiply(a).elementRowMultiply(b.getColumnAsMatrix(seq[i]));
        }

        double seq_prob = 0;
        for(int row = 0; row < alphas.rows; row++){
            for(int col = 0; col < alphas.columns; col++){
                seq_prob += alphas.getPos(row, col);
            }
        }
        return seq_prob;

    }

    public static Delta buildDelta(Matrix a){
        Delta d = new Delta();
        double[][] maxes = new double[a.rows][1];

        for(int row = 0; row < a.rows; row++){
            double[] values = a.getRow(row);
            double max = values[0];
            for (int i = 1; i < values.length; i++) {
                if (values[i] > max) {
                    max = values[i];
                }
            }
            maxes[row][0] = max;

            List<Integer> idx = new ArrayList<Integer>();
            for (int j = 0; j < values.length; j++) {
                if (values[j] == max && max != 0.0) {
                    idx.add(j);
                }
            }
            d.addArgmax(idx);
        }

        Matrix m = new Matrix(a.rows, 1, maxes);
        d.setMatrix(m);
        return d;
    }


    public static int[] decoding(Matrix a, Matrix b, Matrix pi, int n, int[] seq){
        List<Delta> deltaList = new ArrayList<>();

        //first step
        System.out.println("DELTA 0");
        Matrix m = pi.elementRowMultiply(b.getColumnAsMatrix(seq[0]));
        m = m.transpose();
        Delta delta = buildDelta(m);
        deltaList.add(delta);
        a = a.transpose();
        System.out.println(m);

        for(int i = 1; i< seq.length; i++){
            m = a.elementRowMultiply(m);
            m = m.elementColumnMultiply(b.getColumnAsMatrix(seq[i]));
            delta = buildDelta(m);
            deltaList.add(delta);
            m = delta.getMatrix();
        }

        for(int i = 0; i < deltaList.size(); i++){
            System.out.println("DELTA " + (int)(i+1));
            Delta r = deltaList.get(i);
            System.out.println(r.getMatrix());
        }


        int[] state_seq = new int[deltaList.size()];
        List<Integer> states = null;

        delta = deltaList.get(deltaList.size() - 1);
        Matrix matrix = delta.getMatrix();
        double max = matrix.getPos(0, 0);
        for(int row = 1; row < matrix.rows; row++){
            if (matrix.getPos(row, 0) > max) {
                max = matrix.getPos(row, 0);
            }
        }
        for(int row = 0; row < matrix.rows; row++){
            if (matrix.getPos(row, 0) == max) {
                states = delta.getArgmax(row);
                state_seq[deltaList.size() - 1] = row;
            }
        }

        for(int c = deltaList.size() - 2; c >= 0; c--){
            delta = deltaList.get(c);
            matrix = delta.getMatrix();

            for(int row : states){
                max = matrix.getPos(row, 0);
                if (matrix.getPos(row, 0) > max) {
                    max = matrix.getPos(row, 0);
                }
            }
            for(int row : states){
                if (matrix.getPos(row, 0) == max) {
                    states = delta.getArgmax(row);
                    state_seq[c] = row;
                }
            }

        }


        return state_seq;

    }

}