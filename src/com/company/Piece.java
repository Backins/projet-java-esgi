package com.company;

class Piece {
    //0 = noire
    //1 = blanche
    private int couleurPiece;
    protected boolean isFirstMovement;

    public Piece(int LaCouleurPiece){
        couleurPiece = LaCouleurPiece;
        isFirstMovement = true;
    }

    public int getCouleurPiece() {
        return couleurPiece;
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        return true;
    }
}