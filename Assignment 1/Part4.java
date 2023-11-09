public class Part4 {
    public static int[][] TransposeMatrix(int[][] galaxy) {
        int cols = galaxy.length;
        int rows = galaxy[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                temp[j][i] = galaxy[i][j];
            }
        }

        return temp;
    }

    public static void printArray(int[][] Galaxy) {
        int row = Galaxy.length;
        int col = Galaxy[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(Galaxy[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int rows = 5;
        int cols = 4;
        int[][] _2DArray =
                {{23,21,35,65}, {56,65,44,47},{98,76,89,60},{10,20,34,56},{11,22,33,44}};

        System.out.print("Before Transpose 2D-Array: \n");
        printArray(_2DArray);

        System.out.print("After Transpose 2D-Array: \n");
        int [][] _2DTransArray = TransposeMatrix(_2DArray);
        printArray(_2DTransArray);
    }

}
