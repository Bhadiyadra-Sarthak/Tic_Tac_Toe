package com.example.tictactoe;

public class game {
        private String player1;
        private String player2;
        private String turn;
        private int[][] board;
        private int isDone;
        private final int Max_length = 3;
        public game(String p1,String p2){
            this.player1=p1;
            this.player2=p2;
            setTurn(player1);
            isDone = 0;
            this.board = new int[Max_length][Max_length];
            for(int i = 0; i <Max_length; i++){
                for(int j = 0; i <Max_length; i++){
                    this.board[i][j] = 0;
                }
            }
    }

    public void board(int i, int j){
            if (getTurn().equals(player1)){
                this.board[i][j] = 1;
            }
            else if(getTurn().equals(player2)){
                this.board[i][j] = 2;
            }

    }
    public int check(){
            int i = 0;
        if(this.board[0][0] == 1 && this.board[1][0] == 1 && this.board[2][0]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][0] == 2 && this.board[1][0] == 2 && this.board[2][0]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][1] == 1 && this.board[1][1] == 1 && this.board[2][1]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][1] == 2 && this.board[1][1] == 2 && this.board[2][1]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][2] == 1 && this.board[1][2] == 1 && this.board[2][2]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][2] == 2 && this.board[1][2] == 2 && this.board[2][2]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][0] == 1 && this.board[0][1] == 1 && this.board[0][2]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][0] == 2 && this.board[0][1] == 2 && this.board[0][2]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[1][0] == 1 && this.board[1][1] == 1 && this.board[1][2]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[1][0] == 2 && this.board[1][1] == 2 && this.board[1][2]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[2][0] == 1 && this.board[2][1] == 1 && this.board[2][2]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[2][0] == 2 && this.board[2][1] == 2 && this.board[2][2]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][0] == 1 && this.board[1][1] == 1 && this.board[2][2]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][0] == 2 && this.board[1][1] == 2 && this.board[2][2]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][2] == 2 && this.board[1][1] == 2 && this.board[2][0]==2){
            i=2;
            setIsDone();
        }
        else if(this.board[0][2] == 1 && this.board[1][1] == 1 && this.board[2][0]==1){
            i=1;
            setIsDone();
        }
        else if(this.board[0][0] != 0 && this.board[0][1] != 0 && this.board[0][2] != 0 && this.board[1][0] != 0 && this.board[1][1] != 0 && this.board[1][2] != 0 && this.board[2][0] != 0 && this.board[2][1] != 0 && this.board[2][2] != 0){
            i = -1;
            setIsDone();
        }
        return i;
    }

    public String getTurn(){ return this.turn; }
    public void setTurn(String s){ this.turn = s; }
    public boolean getBoard(int i, int j){
            if(board[i][j] != 0){
                return false;
            }
            else{
                return true;
            }
    }
    public void setIsDone(){
            this.isDone = 1;
    }
    public int getIsDone(){
            return this.isDone;
    }

}
