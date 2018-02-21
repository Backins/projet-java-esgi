package com.company;

class Piece {
    //0 = noire
    //1 = blanche
    private int couleurPiece;

    public Piece(int LaCouleurPiece){
        couleurPiece = LaCouleurPiece;
    }

    public int getCouleurPiece() {
        return couleurPiece;
    }

    public boolean checkLegaliteMouvement(int hauteur, int largeur){
        return true;
    }
}