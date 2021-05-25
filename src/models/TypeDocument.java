package models;

public enum TypeDocument {
    CIVIL_REGISTRATION("R.C."), IDENTITY_CARD("T.I."), IDENTIFICATION_CARD("C.C.");
	
	private String label;
	
	private TypeDocument(String labelIn){
		this.label = labelIn;
	}
	
	public String getLabel(){
		return label;
	}
	
}