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
  public Matrix getRow(int row){
    return new Matrix(1, this.columns, this.data[row]);
  }

  /*Returns a column vector*/
  public Matrix getColumn(int col){
    double[] column = new double[this.rows];
    for(int i = 0; i < this.rows; i++){
      column[i] = this.data[i][col];
    }
    return new Matrix(this.rows, 1, column);
  }

  private double vectorMultiply(Matrix a, Matrix b){
    double res = 0;

    for(int i = 0; i < a.columns; i++){
      res += a.data[0][i]*b.data[i][0];
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


  public Matrix elementMultiply(Matrix b){
    if((this.columns != b.rows) || (this.rows != 1)){
      throw new java.lang.Error("Can't multiply matrices : this columns != b rows");
    }

    double[][] res = new double[1][this.columns];
    for(int col = 0; col < this.columns; col++){
      res[0][col] = this.data[0][col] * b.data[col][0];
    }

    //construct and return result matrix
    Matrix result = new Matrix(1, this.columns, res);
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
