import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Matrix{

  public int rows = 0, columns = 0;
  public double[][] data;

  /*Constructers*/
  public Matrix(int rows, int columns, double[] values){
    this.rows = rows;
    this.columns = columns;
    this.data = new double[rows][columns];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
        this.data[i][j] = values[i*columns+j]; //FIXED: we had [i*rows+j] instead of [i*columns+j] !
      }
    }
  }

  public Matrix(int rows, int columns, double[][] values){
    this.rows = rows;
    this.columns = columns;
    this.data = new double[rows][columns];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
        this.data[i][j] = values[i][j];
      }
    }
  }

  /*Getters & Setters*/
  public double getPos(int row, int column){
    return this.data[row][column];
  }

  public void setPos(int row, int column, double value){
    this.data[row][column] = value;
  }

  public double[] getRow(int row){
    return this.data[row];
  }
  public void setRow(int row, double[] vector){
    this.data[row] = vector;
  }

  public double[][] getData(){
    return this.data;
  }
  public void setData(double[][] matrix){
    this.data = matrix;
  }

  public Matrix getRowAsMatrix(int row){
    return new Matrix(1, this.columns, this.data[row]);
  }

  public double[] getColumn(int col){
    double[] column = new double[this.rows];
    for(int i = 0; i < this.rows; i++){
      column[i] = this.data[i][col];
    }
    return column;
  }
  public Matrix getColumnAsMatrix(int col){
    double[] column = new double[this.rows];
    for(int i = 0; i < this.rows; i++){
      column[i] = this.data[i][col];
    }
    return new Matrix(this.rows, 1, column);
  }

  /*Operations*/

  public Matrix transpose(){
    double[][] transposed = new double[this.columns][this.rows];
    for(int row = 0; row < this.rows; row++){
      for(int col = 0; col < this.columns; col++){
        transposed[col][row] = this.getPos(row, col);

      }
    }
    return new Matrix(this.columns, this.rows, transposed);
  }

  private double vectorMultiply(double[] a, double[] b){
    double res = 0;

    for(int i = 0; i < a.length; i++){
      res += a[i]*b[i];
    }
    return res;
  }

  public Matrix matrixMultiply(Matrix b){
    if(this.columns != b.rows){
      throw new java.lang.Error("Can't multiply matrices : this columns != b rows");
    }
    // multiply row vectors of first matrix by column vectors of second one, aka matrix multiplication.
    double[][] res = new double[this.rows][b.columns];
    for(int row = 0; row < this.rows; row++){
      for(int col = 0; col < b.columns; col++){
        // indexes of each row and column that are multiplied, correspond to the correct position in the result matrix.
        res[row][col] = vectorMultiply(this.getRow(row), b.getColumn(col));
      }
    }

    //construct and return result matrix
    Matrix result = new Matrix(this.rows, b.columns, res);
    return result;

  }

  /*Multiplies each row of this matrix by each element of the vector matrix b*/
  public Matrix elementRowMultiply(Matrix b){
    if((this.columns != b.rows) || (b.columns != 1)){
      throw new java.lang.Error("Can't multiply matrices : this columns != b rows");
    }

    double[][] res = new double[this.rows][this.columns];

    for(int row = 0; row < this.rows; row++){
      for(int col = 0; col < this.columns; col++){
        res[row][col] = this.data[row][col] * b.data[col][0];
      }
    }

    //construct and return result matrix
    Matrix result = new Matrix(this.rows, this.columns, res);
    return result;
  }

  /*Multiplies each column of this matrix by each element of the vector matrix b*/
  public Matrix elementColumnMultiply(Matrix b){
    if((this.rows != b.rows) || (b.columns != 1)){
      throw new java.lang.Error("Can't multiply matrices : this columns != b rows");
    }

    double[][] res = new double[this.rows][this.columns];

    for(int row = 0; row < this.rows; row++){
      for(int col = 0; col < this.columns; col++){
        res[row][col] = this.data[row][col] * b.data[row][0];
      }
    }

    //construct and return result matrix
    Matrix result = new Matrix(this.rows, this.columns, res);
    return result;
  }

  @Override
  public String toString() {
    String matrix = "";
    for(int i = 0; i < this.rows; i++){
      for(int j = 0; j < this.columns; j++){
        matrix += this.data[i][j] + " ";
      }
      matrix+="\n";
    }
    return matrix;
  }

}
