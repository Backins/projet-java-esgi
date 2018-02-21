package com.company;

public class Tour extends Piece {
    public Tour(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur > 0 && largeur == 0){
            return true;
        } else if(largeur >0 && hauteur == 0){
            return true;
        } else {
            return false;
        }
    }
}
