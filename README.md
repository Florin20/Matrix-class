# Matrix-class

A class that has methods for basic matrix operations.

Example:

int[][] temp = {{1,2,3}, {1,2,3}, {1,2,3}};
//double[][] temp = {{1,2,3}, {1,2,3}, {1,2,3}
Matrix a = new Matrix();
a.copy(temp);
Matrix b = new Matrix();
b.copy(temp);

Matrix c;
c = a.sum(b);
c.print();
c = a.dif(b);
c.print();
c = a.mul(b);
c.print();




