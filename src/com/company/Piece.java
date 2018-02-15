package com.company;

public class Piece {
    private int couleurPiece; // 0 = noir, 1 blanc
    protected boolean premierCoup;

    public Piece(int pCouleurPiece){
        couleurPiece = pCouleurPiece;
        premierCoup = true;
    }

    public int getCouleurPiece() {
        return couleurPiece;
    }

    public boolean checkLegaliteMove(int hauteur, int largeur){
        return true;
    }
}
