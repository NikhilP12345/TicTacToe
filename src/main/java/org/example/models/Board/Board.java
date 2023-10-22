package org.example.models.Board;

import org.example.models.PlayingPiece.PlayingPiece;

public class Board {
    PlayingPiece[][] board;
    int size;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void printBoard(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                String c = ".";
                if(board[i][j] != null){
                    c = String.valueOf(board[i][j].getPlayingPieceType());

                }
                System.out.print(c + " ");
            }
            System.out.println("\n");
        }
    }

    public boolean addPiece(PlayingPiece playingPiece, int x, int y) {
        if (board[x][y] != null) return false;
        board[x][y] = playingPiece;
        return true;
    }

    public Boolean isFreeCellExists(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean isWinner(int x, int y, PlayingPiece piece){
        Boolean isRow = true, isCol = true, isRightDiagonal = true, isLeftDiaginal = true;
        for(int i = 0 ; i < size ; i++){
            if(board[x][i] == null || board[x][i].getPlayingPieceType() != piece.getPlayingPieceType()){
                isRow = false;
                break;
            }
        }

        for(int i = 0 ; i < size ; i++){
            if(board[i][y] == null || board[i][y].getPlayingPieceType() != piece.getPlayingPieceType()){
                isCol = false;
                break;
            }
        }

        for(int i = 0, j = 0 ; i < size ; i++, j++){
            if(board[i][j] == null || board[i][j].getPlayingPieceType() != piece.getPlayingPieceType()){
                isRightDiagonal = false;
                break;
            }
        }

        for(int i = 0, j = size - 1 ; i < size && j >= 0 ; i++, j--){
            if(board[i][j] == null || board[i][j].getPlayingPieceType() != piece.getPlayingPieceType()){
                isLeftDiaginal = false;
                break;
            }
        }

        return isRow || isCol || isRightDiagonal || isLeftDiaginal;
    }

    public Boolean isNotValidCords(int x, int y) {
        return x >= size || y >= size || x < 0 || y < 0;
    }
}
