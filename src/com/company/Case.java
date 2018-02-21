package com.company;

class Case {
    private boolean contentPiece;
    private Piece piece;
    private String nomAffiche;

    public Case() {
        contentPiece = false;
        nomAffiche = "  ";
    }

    public Case(Piece LeNomPiece, String LeNomAffiche) {
        contentPiece = true;
        piece = LeNomPiece;
        nomAffiche = LeNomAffiche;
    }

    public String getNomAffiche() {
        return nomAffiche;
    }
    public boolean getContentPiece(){
        return contentPiece;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece LaPiece, String LeNomAffiche){
        piece = LaPiece;
        nomAffiche = LeNomAffiche;
        contentPiece = true;
    }
    public void removePiece(){
        piece = null;
        nomAffiche = "  ";
        contentPiece = false;
    }
}