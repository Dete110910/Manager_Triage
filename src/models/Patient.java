package models;
import  java.time.LocalDate;

public class Patient {
	private String name;
	private LocalDate dateBorn;
	private String document;
	private TypeDocument typeDocument;
	private TypeEPS typeEPS;
	private TypeOfBlood typeOfBlood;
	private char gender;
	private Treatment treatment;
	private float weight;
	private int height;
	
	public Patient (){
		this.gender = Character.MIN_VALUE;;
		this.weight = 0f;
		this.height = 0;
	}
	public Patient (String nameIn, LocalDate dateBornIn, TypeDocument typeDocumentIn, String documentIn,  TypeEPS typeEPSIn, TypeOfBlood typeOfBloodIn, char genderIn, Treatment treatmentIn, float weightIn, int heightIn){
		this.name = nameIn;
        this.dateBorn = dateBornIn;
        this.document = documentIn;
		this.typeDocument = typeDocumentIn;
        this.typeEPS = typeEPSIn;	
		this.typeOfBlood = typeOfBloodIn;
		this.gender = genderIn;
		this.treatment = treatmentIn;
		this.weight = weightIn;
		this.height = heightIn;
	}
	
	public void setName(String nameIn){
        this.name = nameIn;
    }
    public String getName(){
    return this.name;
    }
	
	public void setdateBorn(LocalDate dateBornIn){
        this.dateBorn = dateBornIn;
    }
    public LocalDate getdateBorn(){
    return this.dateBorn;
    }
	
	public void setDocument(String documentIn){
        this.document = documentIn;
    }
    
    public String getDocument(){
    return this.document;
    }
	
	public void setTypeDocument(TypeDocument typeDocumentIn){
		this.typeDocument = typeDocumentIn;
	}
	public TypeDocument getTypeDocument(){
		return this.typeDocument;
	}
	
	public void setTypeEPS(TypeEPS typeEPSIn){
        this.typeEPS = typeEPSIn;
    }
    public TypeEPS getTypeEPS(){
    return this.typeEPS;
    }
	
	public void setTypeOfBlood(TypeOfBlood typeOfBloodIn){
        this.typeOfBlood = typeOfBloodIn;
    }
    public TypeOfBlood getTypeOfBlood(){
    return this.typeOfBlood;
    }
	
	public void setGender(char genderIn){
        this.gender = genderIn;
    }
    public char getGender(){
    return this.gender;
    }
	
	public void setTreatment(Treatment treatmentIn){
        this.treatment = treatmentIn;
    }
    public Treatment getTreatment(){
    return this.treatment;
    }
	
	public void setWeight(float weightIn){
        this.weight = weightIn;
    }
    public float getWeight(){
    return this.weight;
    }
	
	public void setHeight(int heightIn){
        this.height = heightIn;
    }
    public int getHeight(){
    return this.height;
    }

	public int calculateDateBorn(){
		int dayBorn = dateBorn.getDayOfMonth();
		int monthborn = dateBorn.getMonthValue();
		int yearBorn = dateBorn.getYear();
		LocalDate currentDate = LocalDate.now();
		int dayCurrent = currentDate.getDayOfMonth();
		int monthCurrent = currentDate.getMonthValue();
		int yearCurrent = currentDate.getYear();
		int years= yearCurrent - yearBorn;
		if (monthCurrent < monthborn){
			--years;
			return years;
		}
		else if (monthCurrent == monthborn && dayCurrent < dayBorn){
			--years;
			return years;
		}return years;
			
	}
	
	public Object[] toObjectVector(){
		return new Object[] {name, dateBorn, calculateDateBorn(), typeDocument.getLabel(), document, gender, typeOfBlood.getLabel(),  weight, height, treatment.getLabel(), typeEPS.getLabel()};
	}
}