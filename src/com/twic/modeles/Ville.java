package com.twic.modeles;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ville {
	@JsonProperty("codeINSEE")
    private int codeINSEE;
	@JsonProperty("nomCommune")
    private String nomCommune;
	@JsonProperty("cp")
    private int cp;
	@JsonProperty("libelleAcheminement")
    private String libelleAcheminement;
	@JsonProperty("ligne_5")
    private String ligne_5;
	@JsonProperty("lattitude")
    private String lattitude;
	@JsonProperty("longitude")
    private String longitude;

	public Ville() {
		
	}
	
    public Ville(int codeINSEE,String commune,int cp,String libelleAcheminement,String ligne_5, String lattitude, String longitude) {
        this.codeINSEE = codeINSEE;
        this.nomCommune = commune;
        this.cp = cp;
        this.libelleAcheminement = libelleAcheminement;
        this.ligne_5 = ligne_5;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getCodeINSEE() {
        return codeINSEE;
    }
    public void setCodeINSEE(int codeINSEE) {
        this.codeINSEE = codeINSEE;
    }
    public String getNomCommune() {
        return nomCommune;
    }
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }
    public int getCP() {
        return cp;
    }
    public void setCP(int cp) {
        this.cp = cp;
    }
    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }
    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }
    public String getLigne_5() {
        return ligne_5;
    }
    public void setLigne_5(String ligne_5) {
        this.ligne_5 = ligne_5;
    }
    public String getLattitude() {
        return lattitude;
    }
    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }



}