package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTacToe {

    public void ticTacToe(){
        char[][] board = new char[3][3];
        for(int i = 0 ; i < board.length ; i++){
            for(int j  = 0 ;  j < board[i].length ; j++){
                board[i][j] = ' ';
            }
        }

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        System.out.println("===================================WELCOME TO THE GAME OF TIC TAC TOE===================================");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("CHOOSE PLAYER : X || O");
        System.out.println("--------------------------------");
        char player = sc.next().charAt(0);

        while(!gameOver){
            System.out.println("--------------------------------");
            System.out.print("ENTER THE VALUES PLAYER " + player + " : ");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x < 0 || x > 2){
                System.out.println("Please Keep it in the range of 0-2 \nTry again");
                continue;

            }
            if(board[x][y] == ' '){
                board[x][y] = player;
                if(haveWon(board , player)) {
                    System.out.println("You have won " + player + " !!!!!");
                    gameOver = true;
                }
                else{
                    player = player == 'X' ? 'O' : 'X';
                }
                display(board);

            }
            else{
                System.out.println("ENTER VALID INPUT : ");
                continue;
            }

        }
    }

    public static boolean haveWon(char[][] arr ,char player){
        //check for row
        for(int row = 0 ; row < arr.length ; row++){
            if(arr[row][0] == player && arr[row][1] == player && arr[row][2] == player){
                return true;
            }
        }
        //check for col
        for(int col = 0 ; col < arr.length ; col++){
            if(arr[0][col] == player && arr[1][col] == player && arr[2][col] == player){
                return true;
            }
        }

        //check for diagonal
        if((arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) || (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) ){
            return true;
        }

        return false;
    }
    public static void display(char[][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + "|");
            }
            System.out.println("");
        }
    }
}
