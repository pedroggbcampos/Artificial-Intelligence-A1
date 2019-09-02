public class Main{
  public static void main(String [ ] args){
    //Tests first Matrix constructer
    System.out.println("Tests first Matrix constructer []");


    double[] matrixA = {0.2, 0.5, 0.3, 0.0, 0.1, 0.4, 0.4, 0.1, 0.2, 0.0, 0.4, 0.4, 0.2, 0.3, 0.0, 0.5};
    Matrix mA = new Matrix(4, 4, matrixA);
    System.out.println("Rows    = " + mA.rows);
    System.out.println("Columns = " + mA.columns);
    System.out.println("MATRIX A");
    for(int i = 0; i < mA.rows; i++){
      for(int j = 0; j < mA.columns; j++){
        System.out.print(mA.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");


    double[] matrixB = {1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.2, 0.6, 0.2};
    Matrix mB = new Matrix(4, 3, matrixB);
    System.out.println("Rows    = " + mB.rows);
    System.out.println("Columns = " + mB.columns);
    System.out.println("MATRIX B");
    for(int i = 0; i < mB.rows; i++){
      for(int j = 0; j < mB.columns; j++){
        System.out.print(mB.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");

    //Tests second Matrix constructer
    System.out.println("Tests second Matrix constructer [][]");

    double[][] matrixI = {{0.0, 0.0, 0.0, 1.0}};
    Matrix mI = new Matrix(1, 4, matrixI);
    System.out.println("Rows    = " + mI.rows);
    System.out.println("Columns = " + mI.columns);
    System.out.println("MATRIX I");
    for(int i = 0; i < mI.rows; i++){
      for(int j = 0; j < mI.columns; j++){
        System.out.print(mI.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");


//    //Tests vector multiplication
//    System.out.println("Tests vector multiplication");
//    System.out.println("If we multiply one row of MATRIX 1 and one column of MATRIX 2, which are vectors, the result is:");
//    System.out.println(mA.vectorMultiply(mB.getRow(0), mI.getColumn(0)));
//
//    System.out.println("\n");

    //Tests matrix multiplication
    System.out.println("Tests matrix multiplication");
    System.out.println("If we multiply MATRIX I and MATRIX A the result is:");
    Matrix step = mI.matrixMultiply(mA);
    for(int i = 0; i < step.rows; i++){
      for(int j = 0; j < step.columns; j++){
        System.out.print(step.data[i][j] + " ");
      }
      System.out.println();
    }


    System.out.println("If we multiply MATRIX resultant and MATRIX B the result is:");
    Matrix res = step.matrixMultiply(mB);
    for(int i = 0; i < res.rows; i++){
      for(int j = 0; j < res.columns; j++){
        System.out.print(res.data[i][j] + " ");
      }
      System.out.println();
    }



    System.out.println("Everything tested, end of test.");

  }
}
