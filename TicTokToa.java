package LLD;

import java.util.Scanner;

public class TicTokToa {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int i = 0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean isGameOver=false;
        Scanner Input=new Scanner(System.in);
        while(!isGameOver){
            printBoard(board);
            System.out.print("Player "+ player +" Turn's:");
            int row=Input.nextInt();
            int col=Input.nextInt();
            if(board[row][col]== ' '){
                board[row][col]=player;
                isGameOver=haveWon(board,player);
                if(isGameOver){
                    System.out.println("Player "+player +" Won");
                    break;
                }
                else{
                    player=player=='X'?'O':'X';
                }

            }
            else{
                System.out.println("Invalid Move");
            }

            if(gameTied(board)){
                System.out.println("Game Tied");
                break;
            }
        }

    }

    public static boolean gameTied(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(board[i][j]==' ')
                     return false;
            }
        }
        return true;
    }

    public static boolean haveWon(char[][] board, char player) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
                return true;

        }
        for (int i = 0; i < board.length; i++) {
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player)
                return true;

        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            return true;
        else if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            return true;

        return false;

    }

    public static void printBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
