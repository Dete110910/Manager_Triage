package models;

public enum TypeEPS {
    NUEVA_EPS("Nueva EPS"), COOSALUD("Coosalud"), SANITAS("Sanitas"), 
	COMFABOY("Comfaboy"), FAMISANAR("Famisanar"), SALUD_TOTAL ("Salud Total"), 
	COMPENSAR("Compensar");
	
	private String label;
	
	private TypeEPS(String labelIn){
		this.label = labelIn;
		
	}
	public String getLabel(){
		return label;
	}
	
}
