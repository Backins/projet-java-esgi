package com.company;

public class Piece {
    private int couleurPiece; // 0 = noir, 1 blanc

    public Piece(int pCouleurPiece){
        couleurPiece = pCouleurPiece;
    }

    public int getCouleurPiece() {
        return couleurPiece;
    }

    public boolean movePieceHauteur(int hauteur, int largeur){
        return true;
    }
}
