public class Matrix{

  public int rows = 0, columns = 0;
  public double[][] data = null;

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

  /*Returns a row vector*/
  public double[] getRow(int row){
    return this.data[row];
  }

  /*Returns a column vector*/
  public double[] getColumn(int col){
    double[] column = new double[this.rows];
    for(int i = 0; i < column.length; i++){
      column[i] = this.data[i][col];
    }
    return column;
  }

  public double vectorMultiply(double[] a, double[] b){
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

}
