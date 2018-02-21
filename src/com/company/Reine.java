package com.company;

public class Reine extends Piece {
    public Reine(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur > 0 && largeur > 0){
            return true;
        } else if(hauteur > 0 && largeur == 0){
            return true;
        } else if(hauteur == 0 && largeur > 0){
            return true;
        } else {
            return false;
        }
    }
}
