package models;

public enum TypeOfBlood {
	O_POSITIVE("O+"), O_NEGATIVE("O-"), A_POSITIVE("A+"), A_NEGATIVE("A-"),
	B_POSITIVE("B+"), B_NEGATIVE("B-"), AB_POSITIVE("AB+"), AB_NEGATIVE("AB-");

	private String label;

	private TypeOfBlood (String labelIn){
		this.label = labelIn;
	}
	public String getLabel(){
		return label;
	}

}