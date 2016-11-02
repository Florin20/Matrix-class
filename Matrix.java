package probleme;

public class Matrix { //a class for basic operations on matrices
	
	private int[][] matrix;
	private double[][] fmatrix;
	private int rows;
	private int columns;
	private int isFloat; //0 if it is a matrix of integers
	
	Matrix(int rows, int columns, char f){
		this.rows = rows;
		this.columns = columns;
		fmatrix = new double[rows][columns];
		isFloat = 1;
	}
	
	Matrix(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		matrix = new int[rows][columns];
		isFloat = 0;
	}
	
	Matrix(){
		
	}
	
	
	void setVal(int data, int x, int y){
		if(x > this.rows || x > this.columns || x < 0 || y < 0){
			System.out.println("You have entered an invalid position");
		}
		else{
			this.matrix[x][y] =  data;
			this.isFloat = 0;
		}
	}
	void setVal(double data, int x, int y){
		if(x > this.rows || x > this.columns || x < 0 || y < 0){
			System.out.println("You have entered an invalid position");
		}
		else{
			this.fmatrix[x][y] =  data;
			this.isFloat = 1;
		}
	}
	double fgetVal(int x, int y){
		return fmatrix[x][y];
	}
	
	int getVal(int x, int y){
		return matrix[x][y];
	}
	
	int isFloat(){
		return isFloat;
	}
	
	int getRowSize(){
		return rows;
	}
	
	int getColSize(){
		return columns;
	}
	
	void copy(int[][] x){ //copy integer matrix
		this.isFloat = 0;
		this.rows = x.length;
		this.columns = x[0].length;
		matrix = new int[this.rows][this.columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				this.setVal(x[i][j], i, j);
			}
		}
	}
	
	void copy(double[][] x){ //copy float matrix
		this.isFloat = 1;
		this.rows = x.length;
		this.columns = x[0].length;
		fmatrix = new double[this.rows][this.columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				this.setVal(x[i][j], i, j);
			}
		}
	}
	
	void print(){
		if(this.isFloat == 0){
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < columns; j++){
					System.out.println(matrix[i][j] + " ");
				}
				System.out.println("\n");
			}
		}
		
		else{
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < columns; j++){
					System.out.println(fmatrix[i][j] + " ");
				}
				System.out.println("\n");
			}
		}
	}
	Matrix add(Matrix x){
		
		Matrix temp;
		
		if(this.isFloat == 0 || x.isFloat() == 0){ // if both matrices are integer matrices, the result is an integer matrix
			temp = new Matrix(this.rows, this.columns);
		}
		else{
			temp = new Matrix(this.rows, this.columns, 'f');
		}
		
		
		for(int  i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				if(this.isFloat == 0){
					temp.setVal(this.matrix[i][j]  + x.getVal(i, j), i, j);
				}
				else{
					temp.setVal(this.fmatrix[i][j] + x.fgetVal(i, j), i, j);
				}
			}
		}
		return temp;
	}
	
	Matrix sub(Matrix x){
		
		Matrix temp;
		
		if(this.isFloat == 0 || x.isFloat() == 0){ // if both matrices are integer matrices, the result is an integer matrix
			temp = new Matrix(this.rows, this.columns);
		}
		else{
			temp = new Matrix(this.rows, this.columns, 'f');
		}
		
		
		for(int  i = 0; i < this.rows; i++){
			for(int j = 0; j < this.columns; j++){
				if(this.isFloat == 0){
					temp.setVal(this.matrix[i][j]  - x.getVal(i, j), i, j);
				}
				else{
					temp.setVal(this.fmatrix[i][j] - x.fgetVal(i, j), i, j);
				}
			}
		}
		return temp;
	}
	
	Matrix mul(Matrix x){
		
		Matrix temp;
		int sum = 0;
		double fsum = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		
		if(this.columns != x.getRowSize()){
			System.out.println("These 2 matrices can not be multiplied!");
			temp = null;
		}
		else{
			if(this.isFloat != 0 || x.isFloat() != 0){ 
				temp = new Matrix(this.rows, x.getColSize(), 'f');

				for(i = 0; i < this.rows; i++){
					for(j = 0; j < this.columns; j++){
						for(k = 0; k < this.columns; k++){
							fsum = fsum + (this.fmatrix[j][k] * fgetVal(k, j));
						}
						temp.setVal(fsum, i, j);
						fsum = 0;
					}
				}
			}
			
			else{
				temp = new Matrix(this.rows, x.getColSize());
			
				for(i = 0; i < this.rows; i++){
					for(j = 0; j < this.columns; j++){
						for(k = 0; k < this.columns; k++){
							sum = sum + (this.matrix[j][k] * getVal(k, j));
						}
						temp.setVal(sum, i, j);
						sum = 0;
					}
				}
			}
		}
		return temp;
	}
}
