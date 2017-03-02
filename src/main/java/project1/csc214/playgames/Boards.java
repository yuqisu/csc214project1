package project1.csc214.playgames;

/**
 * Created by yuqisu on 2/26/17.
 */

public class Boards {
    public int rows=8;
    public int columns=8;
    public Board[][] board;
    public final int player1=1;
    public final int player2 =2;
    public int player=player1;
    public boolean isEnd = false;
    public Boards(int rows, int columns){
      this.rows = rows;
        this.columns = columns;
        board  = new Board[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                board[i][j] = new Board();
            }
        }

    }
    public void makeMove(int row, int column){
        if (player==player1){
            board[row][column].setMove(player);
            player=player2;
        }else if (player==player2){
            board[row][column].setMove(player);
            player=player1;
        }
    }
    public int findSpot(int column){
        int row =-1;
        for (int i=7;i>=0;i--){
            if (board[i][column].isEmpty){
                return i;
            }
        }
        return row;
    }
    public boolean checkWin(){
        for (int i=0;i<rows;i++){
            if (checkEnds(player,0,1,i,0,0)|| checkEnds(player,1,1,i,0,0)||checkEnds(player,-1,1,i,0,0)){
                isEnd = true;
                return true;
            }
        }
        for (int j=0;j<columns;j++){
            if (checkEnds(player,1,0,0,j,0)|| checkEnds(player,1,1,0,j,0)||checkEnds(player,-1,1,rows-1,j,0)){
                isEnd=true;
                return true;
            }
        }
        return false;
    }
    public boolean checkEnds(int player,int x, int y, int row, int column,int count){
      if (count>=4){
          return true;
      }else if (row<0||row>rows||column<0||column>columns){
          return false;
      }
        Board check = board[row][column];
        if (check.player==player){
            return checkEnds(player,x,y,row+x,column+y,count+1);
        }else{
            return checkEnds(player,x,y,row+x,column+y,0);
        }
    }
    public class Board {
        public boolean isEmpty;
        public int player;

        public Board() {
               this.player=0;
              this.isEmpty=true;


        }
        public void setMove(int player){
            this.player = player;
            isEmpty = false;
        }
    }
}
