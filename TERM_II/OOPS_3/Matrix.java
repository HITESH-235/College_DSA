package College_DSA.TERM_II.OOPS_3;

import java.util.Scanner;

public class Matrix {
    int rows;
    int cols;
    int[][] arr;
		
    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        arr = new int[rows][cols];
    }
	
	void input(Scanner sc){
		for(int i = 0; i < rows; i++){
		    for(int j = 0; j < cols; j++){
		        arr[i][j] = sc.nextInt();
		    }
		}
	}
	
	Matrix add(Matrix x){
		Matrix result = new Matrix(rows, cols);
		for(int i = 0; i < rows; i++){
		    for(int j = 0; j < cols; j++){
		        result.arr[i][j] = this.arr[i][j] + x.arr[i][j];
		    }
		}
		return result;
	}
	
	Matrix subtract(Matrix x){
		Matrix result = new Matrix(rows, cols);
		for(int i = 0; i < rows; i++){
		    for(int j = 0; j < cols; j++){
		        result.arr[i][j] = this.arr[i][j] - x.arr[i][j];
		    }
		}
		return result;
	}
		
	Matrix transpose(){
		Matrix result = new Matrix(cols, rows);
		for(int i = 0; i < rows; i++){
		    for(int j = 0; j < cols; j++){
		        result.arr[j][i] = this.arr[i][j];
		    }
		}
		return result;
	}
	
	void print(){
		for(int i = 0; i < rows; i++){
		    for(int j = 0; j < cols; j++){
		        System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}
