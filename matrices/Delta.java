import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Delta{

    public Matrix matrix;
    public List<List<Integer>> argmaxList = new ArrayList<List<Integer>>();

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public List<List<Integer>> getArgmaxList() {
        return argmaxList;
    }

    public List<Integer> getArgmax(int i) {
        return argmaxList.get(i);
    }

    public void addArgmax(List<Integer> argmax) {
        this.argmaxList.add(argmax);
    }


}
