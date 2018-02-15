package com.company;

public class Pion extends Piece{
    public Pion(int pCouleurPiece) {
        super(pCouleurPiece);
    }

    public boolean checkLegaliteMove(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(largeur == 1 && hauteur == 1){
            premierCoup = false;
            return true;
        } else if(hauteur == 1){
            premierCoup = false;
            return true;
        } else if(hauteur == 2 && premierCoup){
            premierCoup = false;
            return true;
        } else {
            return false;
        }
    }
}
