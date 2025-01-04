class Solution {
    public int[][] imageSmoother(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        int[] directions = {-1, 0, 1}; 

        int[][] smoothedImage = new int[rows][cols]; 

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int total = 0;
                int numPixels = 0;

                for (int rowOffset : directions) {
                    for (int colOffset : directions) {
                        int newRow = row + rowOffset;
                        int newCol = col + colOffset;

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            total += image[newRow][newCol];
                            numPixels++;
                        }
                    }
                }

                smoothedImage[row][col] = total / numPixels;
            }
        }

        return smoothedImage; 
    }
}
