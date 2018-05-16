package com.jianzhiOffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 *
 * Created by 林智 on 2018/5/16.
 */
public class No12 {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
       // if (matrix == null || rows <= 0 || cols <= 0 || str == null || str.length == 0) {
       //     return false;
       // }
        if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
            return false ;
        }
        int pathLength = 0;
        boolean[] visited = new boolean[rows*cols];
        for(int row = 0 ; row < rows ; row++) {
            for(int col = 0 ; col < cols ; col++) {

                if (hasPathCore(matrix, rows, cols, str, row, col, visited, pathLength)){
                    return true;
                }
            }
        }

        return false;


    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
                                int row, int col, boolean[] visited, int pathLength) {
        if(pathLength == str.length) {
            return true ;
        }
        boolean hasPath = false;
       // if (col < cols && col >= 0 && row < rows && row >= 0
       //         && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[row*cols+col] && matrix[row*cols+col] == str[pathLength]) {
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, str, row, col+1, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row, col-1, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row+1, col, visited, pathLength)  ||
                    hasPathCore(matrix, rows, cols, str, row-1, col, visited, pathLength) ;

            // 注意下面这个逻辑的位置, 不要放到外面去了..  这个bug找了很久..
            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    /**
     * 其他的参考代码
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
            return false ;
        }

        boolean[] visited = new boolean[rows*cols] ;
        int[] pathLength = {0} ;

        for(int i=0 ; i<=rows-1 ; i++) {
            for(int j=0 ; j<=cols-1 ; j++) {
                if(hasPathCore2(matrix, rows, cols, str, i, j, visited, pathLength)) { return true ; }
            }
        }

        return false ;
    }

    /**
     * 其他的参考代码
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param row
     * @param col
     * @param visited
     * @param pathLength
     * @return
     */
    public static boolean hasPathCore2(char[] matrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int[] pathLength) {
        boolean flag = false ;

        if(row>=0 && row<rows && col>=0 && col<cols && !visited[row*cols+col] && matrix[row*cols+col]==str[pathLength[0]]) {
            pathLength[0]++ ;
            visited[row*cols+col] = true ;
            if(pathLength[0]==str.length) { return true ; }
            flag = hasPathCore2(matrix, rows, cols, str, row, col+1, visited, pathLength)  ||
                    hasPathCore2(matrix, rows, cols, str, row+1, col, visited, pathLength)  ||
                    hasPathCore2(matrix, rows, cols, str, row, col-1, visited, pathLength)  ||
                    hasPathCore2(matrix, rows, cols, str, row-1, col, visited, pathLength) ;

            if(!flag) {
                pathLength[0]-- ;
                visited[row*cols+col] = false ;
            }
        }

        return flag ;
    }

    public static void main(String[] args) {
        char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'A','B','C','C','E','D'};
        System.out.println(hasPath(matrix,3,4,str));
        System.out.println(hasPath2(matrix,3,4,str));
    }
}
