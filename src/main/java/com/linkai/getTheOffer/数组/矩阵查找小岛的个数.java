package com.linkai.getTheOffer.数组;

/**
 * @ClassName: 矩阵查找小岛的个数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-9 下午3:26
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 矩阵查找小岛的个数 {
    public int numOfLands(char[][] grid){
        int land = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='0')continue;
                land++;
                check(grid,i,j);
            }
        }
        return land;
    }
    public void check(char[][] grid,int row,int col){
        if (row<0||row>=grid.length||col<0||col>=grid[row].length||grid[row][col]=='0')return;
        //着色掉连着的land
        grid[row][col]='0';
        check(grid,row-1,col);
        check(grid,row+1,col);
        check(grid,row,col-1);
        check(grid,row,col+1);
    }
}
