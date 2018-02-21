package com.company;

public class Cavalier extends Piece {
    public Cavalier(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegaliteMouvement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur == 2 && largeur == 1){
            return true;
        } else if(hauteur == 1 && largeur == 2){
            return true;
        } else {
            return false;
        }
    }
}
