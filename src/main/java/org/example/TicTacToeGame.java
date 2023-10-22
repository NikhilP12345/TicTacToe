package org.example;

import org.example.enums.PlayingPieceType;
import org.example.models.Board.Board;
import org.example.models.Player.Player;
import org.example.models.PlayingPiece.PlayingPiece;
import org.example.models.PlayingPiece.PlayingPieceType.PlayingPieceX;
import org.example.models.PlayingPiece.PlayingPieceType.PlayingPieceY;

import com.sun.tools.javac.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Board board;
    Deque<Player> players;

    public TicTacToeGame() {
        initialiseGame();
    }

    private void initialiseGame() {
        players = new LinkedList<>();
        board = new Board(3);

        PlayingPiece pieceX = new PlayingPieceX();
        Player player1 = new Player("Player1", pieceX);

        PlayingPiece pieceY = new PlayingPieceY();
        Player player2 = new Player("Player2", pieceY);

        players.add(player1);
        players.add(player2);
    }

    public String startGame(){
        Boolean win = false;
        while(!win){

            Player activePlayer = players.removeFirst();


            Boolean isFreeExist = board.isFreeCellExists();
            if(!isFreeExist){
                win = true;
                continue;
            }

            board.printBoard();
            Pair<Integer, Integer> cords = this.takeInputFromConsole(activePlayer);
            if(board.isNotValidCords(cords.fst, cords.snd)){
                System.out.println("Invalid User Input for Player, Coordinates not exist" + activePlayer.getName());
                players.addFirst(activePlayer);
                continue;
            }
            Boolean addPiece = board.addPiece(activePlayer.getPlayingPiece(), cords.fst, cords.snd);
            if(!addPiece){
                System.out.println("Invalid User Input for Player " + activePlayer.getName());
                players.addFirst(activePlayer);
                continue;
            }

            players.addLast(activePlayer);

            Boolean isWin = isWinner(cords.fst, cords.snd, activePlayer.getPlayingPiece());

            if(isWin) {
                return "Player " + activePlayer.getName() + " wins!";
            }


        }

        return "tie";
    }

    public Pair<Integer, Integer> takeInputFromConsole(Player player){
        System.out.print("Player " + player.getName() + ": Enter your rows and cols: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String values[] = s.split(",");
        Integer x = Integer.valueOf(values[0]);
        Integer y = Integer.valueOf(values[1]);

        return new Pair<>(x, y);
    }

    public Boolean isWinner(int x, int y, PlayingPiece playingPiece){
        return board.isWinner(x, y, playingPiece);
    }
}
