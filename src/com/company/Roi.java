package com.company;

public class Roi extends Piece {
    public Roi(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur == 1 && largeur == 1){
            return true;
        } else if(hauteur == 1 && largeur == 0){
            return true;
        } else if(hauteur == 0 && largeur == 1){
            return true;
        } else {
            return false;
        }
    }
}
