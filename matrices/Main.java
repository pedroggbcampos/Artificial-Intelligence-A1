import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main{

  public static void main(String [ ] args){
    //Tests first Matrix constructer
    System.out.println("Tests first Matrix constructer []");


    double[] matrixA = {0.0, 0.8, 0.1, 0.1, 0.1, 0.0, 0.8, 0.1, 0.1, 0.1, 0.0, 0.8, 0.8, 0.1, 0.1, 0.0};
    Matrix mA = new Matrix(4, 4, matrixA);
    System.out.println("Rows    = " + mA.rows);
    System.out.println("Columns = " + mA.columns);
    System.out.println("MATRIX A");
    System.out.println(mA);



    double[] matrixB = {0.9, 0.1, 0.0, 0.0, 0.0, 0.9, 0.1, 0.0, 0.0, 0.0, 0.9, 0.1, 0.1, 0.0, 0.0, 0.9};
    Matrix mB = new Matrix(4, 4, matrixB);
    System.out.println("Rows    = " + mB.rows);
    System.out.println("Columns = " + mB.columns);
    System.out.println("MATRIX B");
    System.out.println(mB);


    //Tests second Matrix constructer
    System.out.println("Tests second Matrix constructer [][]");

    double[][] matrixI = {{1.0, 0.0, 0.0, 0.0}};
    Matrix mI = new Matrix(1, 4, matrixI);
    System.out.println("Rows    = " + mI.rows);
    System.out.println("Columns = " + mI.columns);
    System.out.println("MATRIX I");
    System.out.println(mI);


//    //Tests matrix multiplication
//    System.out.println("Tests matrix multiplication");
//    System.out.println("If we multiply MATRIX I and MATRIX A the result is:");
//    Matrix step = mI.matrixMultiply(mA);
//    System.out.println(step);
//
//
//    System.out.println("If we multiply MATRIX resultant and MATRIX B the result is:");
//    Matrix res = step.matrixMultiply(mB);
//    System.out.println(res);
//
//    System.out.println("If we multiply MATRIX resultant and MATRIX B the result is:");
//    Matrix t = mI.elementMultiply(mA.getColumn(0));
//    System.out.println(t);
//
    Functions f = new Functions();
    System.out.println(f.evaluation(mA, mB, mI, 8, new int[] {0, 1, 2, 3, 0, 1, 2, 3}));
    System.out.println();


    int[] states = f.decoding(mA, mB, mI, 4, new int[] {1, 1, 2, 2});
    System.out.println("Answer state sequence : ");
    for(int state : states){
      System.out.print(state + " ");
    }

    System.out.println();
    System.out.println("Everything tested, end of test.");

  }
}
