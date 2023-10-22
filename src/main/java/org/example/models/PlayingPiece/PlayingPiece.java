package org.example.models.PlayingPiece;

import org.example.enums.PlayingPieceType;


public class PlayingPiece {
    PlayingPieceType playingPieceType;

    public PlayingPiece(PlayingPieceType playingPieceType) {
        this.playingPieceType = playingPieceType;
    }
    public PlayingPieceType getPlayingPieceType() {
        return playingPieceType;
    }

    public void setPlayingPieceType(PlayingPieceType playingPieceType) {
        this.playingPieceType = playingPieceType;
    }
}
