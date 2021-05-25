package models;

import java.time.LocalDate;

public class ManagerPatient{
	private Patient[] patientVector;
	private int position;
	
	private static final float PERCENT = 100;
	private static final char GENDER_MALE = 'M';
	private static final char GENDER_FEMALE = 'F';
	private static final int TEN_THOUSAND = 10000;
	private static final float INDEX_IMC_LOW = 18.5f;
	private static final float INDEX_IMC_NORMAL_PARAMETER_TWO = 24.9f;
	private static final float INDEX_IMC_HIGH_PARAMETER_TWO = 29.9f;
	public static final int ADULT = 18;
	public static final int SENIORS = 60;
	
	
	public ManagerPatient(){
		patientVector = new Patient[20];
		position = 0;
	}
	
	public static Patient createPatient (String name, LocalDate dateBorn, TypeDocument typeDocument, String document,  TypeEPS typeEPS, TypeOfBlood typeOfBlood, char gender, Treatment treatment, float weight, int height){
		return new Patient (name, dateBorn, typeDocument, document,  typeEPS, typeOfBlood, gender, treatment, weight, height);
	}
	
	public boolean addAPatient(Patient patient){
		if (position < patientVector.length){
			patientVector[position]=patient;
			position ++;
			return true;
		}
		return false;
	}
	
	public Patient[] getPatientVector(){
		return this.patientVector;
	}
	public Object[][] toMatrixVector(){
		Object[][] datasMatrixPatient = null;
		if (position > 0){
				int datasColumns = patientVector[0].toObjectVector().length;
				datasMatrixPatient = new Object[position][datasColumns];
				for (int index = 0; index < datasMatrixPatient.length; index++){
					datasMatrixPatient[index] = patientVector[index].toObjectVector();
				}
		}
		return datasMatrixPatient;
	}
	
	public double  getPercentageForEPS(TypeEPS auxEPS){
		int counterEPS = 0;
		for (int index = 0; index < position; index++){
			if (auxEPS.equals(patientVector[index].getTypeEPS()))
				counterEPS++;
		}return (counterEPS * PERCENT) /position;
	}
	
	public double [] getPercentageAllEPS(){
		TypeEPS [] listEPS = TypeEPS.values();
		double [] percentageList = new double [listEPS.length];
		for (int index = 0; index < listEPS.length; index++){
			percentageList [index] = getPercentageForEPS(listEPS[index]);
	
		}
		return percentageList;
	}
	
	public double getPercentageForTypeDocument(TypeDocument auxTypeDocument){
		int counterTypeDocument = 0;
		for (int index = 0; index < position; index++){
			if(auxTypeDocument.equals(patientVector[index].getTypeDocument()))
				counterTypeDocument++;
		}return counterTypeDocument * PERCENT / position;
	}
	
	public double[] getPercentageAllTypeDocument(){
		TypeDocument[] listTypeDocument = TypeDocument.values();
		double [] percentageListDocument = new double[listTypeDocument.length];
		for (int index = 0; index < listTypeDocument.length; index++){
		percentageListDocument [index] = getPercentageForTypeDocument(listTypeDocument[index]);
		}
		return percentageListDocument;
	}
	
	public double getPercentageForTreatment(Treatment auxTreatment){
		int counterTreatment = 0;
		for (int index = 0; index < position; index++){
			if(auxTreatment.equals(patientVector[index].getTreatment()))
				counterTreatment++;
		}return counterTreatment * PERCENT / position;
	}
	
	public double[] getPercentageAllTreatment(){
		Treatment[] listTreatment = Treatment.values();
		double [] percentageListTreatment = new double[listTreatment.length];
		for (int index = 0; index < listTreatment.length; index++){
		percentageListTreatment [index] = getPercentageForTreatment(listTreatment[index]);
		}
		return percentageListTreatment;
	}
	
	public double getPercentageForTypeOfBlood(TypeOfBlood auxTypeOfBlood){
		int counterTypeOfBlood = 0;
		for (int index = 0; index < position; index++){
			if(auxTypeOfBlood.equals(patientVector[index].getTypeOfBlood()))
				counterTypeOfBlood++;
		}return counterTypeOfBlood * PERCENT / position;
	}
	
	public double[] getPercentageForTypeOfBlood(){
		TypeOfBlood[] listTypeOfBlood = TypeOfBlood.values();
		double [] percentageListTypeOfBlood = new double[listTypeOfBlood.length];
		for (int index = 0; index < listTypeOfBlood.length; index++){
		percentageListTypeOfBlood [index] = getPercentageForTypeOfBlood(listTypeOfBlood[index]);
		}
		return percentageListTypeOfBlood;
	}
	
	public float getPercentageMale(){
		char [] genderAux = new char [position];
		int counterMale =0;
		for (int index = 0; index < position; index ++){
			genderAux [index] = patientVector[index].getGender();
			if (genderAux[index] == GENDER_MALE)
				counterMale++;
		} return counterMale * PERCENT / position;
	}
	
	public float getPercentageFemale(){
		char [] genderAux = new char [position];
		int counterFemale =0;
		for (int index = 0; index < position; index ++){
			genderAux [index] = patientVector[index].getGender();
			if (genderAux[index] == GENDER_FEMALE)
				counterFemale++;
		} return counterFemale * PERCENT / position;
	}
	
	public float [] getVectorIMC(){
		float [] weightAux = new float [position];
		int [] heightAux = new int [position];
		float [] auxIMC = new float [position];
		for (int index = 0; index < position; index ++){
			weightAux [index] = patientVector[index].getWeight();
			heightAux [index] = patientVector[index].getHeight();
			auxIMC[index] = (weightAux[index]/(heightAux[index]*heightAux[index]))*TEN_THOUSAND;
		} return auxIMC;
	}

	public float[] getAllIMC(){
		float [] getVectorIMCAux = new float [position];
		getVectorIMCAux = this.getVectorIMC();
		float [] indexIMC = new float[4];
		int counterLowWeigth = 0;
		int counterNormalWeigth = 0;
		int counterHigherWeight = 0;
		int counterObesity = 0;
		for (int index = 0; index < position; index ++){
			if (getVectorIMCAux[index] < INDEX_IMC_LOW)
				counterLowWeigth++;
		}
			indexIMC[0]=counterLowWeigth;
			
		for (int index = 0; index < position; index ++){
			if (getVectorIMCAux[index] >= INDEX_IMC_LOW && getVectorIMCAux[index] < INDEX_IMC_NORMAL_PARAMETER_TWO)
			counterNormalWeigth++;
		}
			indexIMC[1]= counterNormalWeigth;
		for (int index = 0; index < position; index ++){
			if (getVectorIMCAux[index] >= INDEX_IMC_NORMAL_PARAMETER_TWO && getVectorIMCAux[index] <= INDEX_IMC_HIGH_PARAMETER_TWO)
				counterHigherWeight++;
		} 
			indexIMC[2]= counterHigherWeight;
		for (int index = 0; index < position; index ++){
			if (getVectorIMCAux[index] > INDEX_IMC_HIGH_PARAMETER_TWO)
					counterObesity++;
		}
			indexIMC[3]=counterObesity;
			return indexIMC;
	}
	
	public int [] getVectorAge(){
		int [] auxAge = new int [position];
		for (int index = 0; index < position; index ++){
			auxAge[index] = patientVector[index].calculateDateBorn();
		} return auxAge;
	}

	public int [] getAllAge(){
		int [] getVectorAgeAux = new int [position];
		getVectorAgeAux = this.getVectorAge();
		int [] indexAge = new int[3];
		int counterMinors = 0;
		int counterAdults = 0;
		int counterSeniors = 0;
		for (int index = 0; index < position; index ++){
			if (getVectorAgeAux[index] < ADULT)
				counterMinors++;
		}
			indexAge[0]=counterMinors;
			
		for (int index = 0; index < position; index ++){
			if (getVectorAgeAux[index] >=ADULT && getVectorAgeAux[index] < SENIORS)
				counterAdults++;
		}
			indexAge[1]= counterAdults;

		for (int index = 0; index < position; index ++){
			if (getVectorAgeAux[index] >= SENIORS)
					counterSeniors++;
		}
			indexAge[2]=counterSeniors;
			return indexAge;
		}
	
	public double priceForServicos (){
		Treatment [] treatmentsRendered = new Treatment[position];
		double [] priceTreatmentsRendered = new double [position];
		double totalPayReceived = 0;
		for (int index = 0; index < position; index++){
			treatmentsRendered[index] = patientVector[index].getTreatment();
			priceTreatmentsRendered [index ]= treatmentsRendered[index].getPrices();
			totalPayReceived += priceTreatmentsRendered[index];
		}  
		return totalPayReceived;
	}
	
	public String [] getVectorNameEps (){
		TypeEPS [] listEPS = TypeEPS.values();
		String [] vectorNameEps = new String [listEPS.length];
		for (int index = 0; index < listEPS.length; index++){
			vectorNameEps[index] = listEPS[index].getLabel();
		}  
		return vectorNameEps;
	}

	public String [] getVectorNameEPSOfPatients (){
		TypeEPS [] listEPS = new TypeEPS [position];
		String [] vectorNameEpsExistent = new String [position];
		for (int index = 0; index < position; index++){
			listEPS[index] = patientVector[index].getTypeEPS();
			vectorNameEpsExistent[index] = listEPS[index].getLabel();
		}
			return vectorNameEpsExistent;
	}
		
	public double [] payEPS (){
		TypeEPS [] listEPS = new TypeEPS [position];
		String [] vectorNameEpsExistent = new String [listEPS.length];
		double [] listSumaPricess = new double [position];
		String [] vectorNameEps = this.getVectorNameEps();
			for (int index = 0; index < vectorNameEps.length ; index++){
				listEPS[index] = patientVector[index].getTypeEPS();
				vectorNameEpsExistent[index] = listEPS[index].getLabel();			
				listSumaPricess [index] = this.getPayEPS( vectorNameEps [index]);
			}  
			
		return listSumaPricess;
	}
		
	public double  getPayEPS(String eps){
		String[] listEPSPatientExistent = new String [position];
		listEPSPatientExistent = this.getVectorNameEPSOfPatients();
		Treatment [] listTreatment = new Treatment [position];
		double [] listTreatmentUsed = new double [position];
		double price =0;
		for (int index = 0; index < position; index++){
			if (listEPSPatientExistent[index] == eps ){
				listTreatment[index] = patientVector[index].getTreatment();
				listTreatmentUsed[index] = listTreatment[index].getPrices();
				price += listTreatmentUsed[index];
			}
		}
		return price;
	}
		 	 
	public int getPossibleDonors (){
		float [] dataIMC = this.getVectorIMC();
		int [] dataAge = this.getVectorAge();
		int counterPatient=0;
		for (int index = 0; index < position; index++){
			if ((dataIMC[index] >= INDEX_IMC_LOW) && (dataIMC[index] <= INDEX_IMC_HIGH_PARAMETER_TWO) && (dataAge [index] >= ADULT) && (dataAge[index] <= SENIORS)){
				counterPatient++;
			}
		}
		return counterPatient;
	}
	
	
	
		 
}
