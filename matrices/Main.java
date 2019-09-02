public class Main{
  public static void main(String [ ] args){
    //Tests first Matrix constructer
    System.out.println("Tests first Matrix constructer []");


    double[] matrix1 = {1, 2};
    Matrix m1 = new Matrix(2, 1, matrix1);
    System.out.println("Rows    = " + m1.rows);
    System.out.println("Columns = " + m1.columns);
    System.out.println("MATRIX 1");
    for(int i = 0; i < m1.rows; i++){
      for(int j = 0; j < m1.columns; j++){
        System.out.print(m1.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");

    //Tests second Matrix constructer
    System.out.println("Tests second Matrix constructer [][]");

    double[][] matrix2 = {{1}};
    Matrix m2 = new Matrix(1, 1, matrix2);
    System.out.println("Rows    = " + m2.rows);
    System.out.println("Columns = " + m2.columns);
    System.out.println("MATRIX 2");
    for(int i = 0; i < m2.rows; i++){
      for(int j = 0; j < m2.columns; j++){
        System.out.print(m2.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");

    //Tests vector multiplication
    System.out.println("Tests vector multiplication");
    System.out.println("If we multiply one row of MATRIX 1 and one column of MATRIX 2, which are vectors, the result is:");
    System.out.println(m1.vectorMultiply(m1.getRow(0), m2.getColumn(0)));

    System.out.println("\n");

    //Tests matrix multiplication
    System.out.println("Tests matrix multiplication");
    System.out.println("If we multiply MATRIX 1 and MATRIX 2 the result is:");
    Matrix res = m1.matrixMultiply(m2);
    for(int i = 0; i < res.rows; i++){
      for(int j = 0; j < res.columns; j++){
        System.out.print(res.data[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("Everything tested, end of test.");

  }
}
