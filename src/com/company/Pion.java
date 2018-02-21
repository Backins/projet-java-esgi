package com.company;

public class Pion extends Piece{
    public Pion(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        //Permet d'éviter de tester pour les mouvements négatifs aussi
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(largeur == 1 && hauteur == 1){
            isFirstMovement = false;
            return true;
        } else if(hauteur == 1 && largeur == 0){
            isFirstMovement = false;
            return true;
        } else if(hauteur == 2 && largeur==0 && isFirstMovement){
            isFirstMovement = false;
            return true;
        } else {
            return false;
        }
    }
}
