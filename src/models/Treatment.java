package models;

public enum Treatment{
	GENERAL_MEDICINE("Medicina General", 50000), OBSERVATION("Observacion", 70000), 
	NUTRITION("Nutricion", 60000), ODONTOLOGY("Odontologia", 65000), REMISSION ("Remision", 0);
	
	private String label;
	private double prices;
	
	private Treatment(String labelIn, double pricesIn){
		this.label = labelIn;
		this.prices = pricesIn;
	} 
	
	public String getLabel(){
		return label;
	}
	public double getPrices(){
		return prices;
	}
}