package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import models.TypeEPS;
import models.TypeDocument;
import models.Patient;
import models.TypeOfBlood;
import models.Treatment;


public class Console {
	public static final String MESSAGE_FOR_ENTRY_NAME = "\nPor favor ingrese el nombre del paciente: ";
	public static final String MESSAGE_FOR_ENTRY_BORN_DATE = "\nPor favor ingrese la fecha de nacimiento del paciente en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_ENTRY_TYPE_DOCUMENT = "\nPor favor seleccione el tipo de documento que posee el paciente: \n"+ 
		"   1- Registro Civil\n" +
		"   2- Tarjeta de Identidad\n" + 
		"   3- Cedula de Ciudadania \n";
	public static final String MESSAGE_FOR_ENTRY_NUMBER_OF_DOCUMENT = "\nPor favor ingrese el numero de documento de identidad del paciente: ";
	public static final String MESSAGE_FOR_ENTRY_EPS_OF_PATIENT = "\nPor favor seleccione la EPS que posee el paciente: \n" + 
		"   1- Nueva EPS\n"+
		"   2- Coosalud\n" + 
		"   3- Sanitas\n" + 
		"   4- Comfaboy\n" + 
		"   5- Famisanar \n" +
		"   6- Salud Total \n" +
		"   7- Compensar \n" ;
		
	public static final String FORMAT = "\t%1$-28s %2$-23s %3$-10s %4$-15s %5$-20s %6$-8s %7$-4s %8$-10s %9$-15s %10$-18s %11$-15s";
	public static final String FORMAT_OF_DATE = "d/M/yyyy";
	public static final String TEXT_MAIN_MENU = "\n***BIENVENIDO AL SISTEMA DE GESTION DE URGENCIAS*** \n\n"+
		"Seleccione la opcion la opcion que desea ejecutar: \n \n"+
		"1- Ingresar nuevo paciente \n"+
		"2- Ver historial de pacientes \n"+
		"3- Consultar promedio de pacientes segun EPS \n"+
		"4- Consultar promedio de pacientes segun el tipo de documento \n"+
		"5- Consultar promedio de pacientes segun tratamiento aplicado \n"+
		"6- Consultar promedio de pacientes segun su RH\n"+
		"7- Consultar promedio de pacientes segun su genero\n"+
		"8- Consultar reporte  de pacientes segun su indice de masa coorporal\n"+
		"9- Consultar reporte  de pacientes segun su edad\n"+
		"10- Consultar reporte de ingresos obtenidos por prestacion de servicios\n"+
		"11- Consultar reporte de pagos segun EPS\n"+
		"12- Consultar reporte de posibles donadores de sangre \n"+
		"0- salir \n";
	public static final String MESSAGE_ERROR_OF_OPTION = "\nERROR!, por favor ingrese una opcion valida ";
	public static final String MESSAGE_FOR_ENTRY_TYPE_BLOOD ="\nPor favor ingrese el RH del paciente: \n" +
		"   1- O Positivo \n"+
		"   2- O Negativo \n" + 
		"   3- A Positivo \n" + 
		"   4- A Negativo \n" + 
		"   5- B Positivo \n" +
		"   6- B Negativo \n" +
		"   7- AB Positivo \n" +
		"   8- AB Negativo \n"; 
	public static final String MESSAGE_FOR_ENTRY_GENDER = "\nPor favor, elija F (femenino) o M (masculino)segun el genero del paciente: \n"+
		"   F- Femenino \n"+
		"   M- Masculino \n";
	public static final char MALE = 'M';
	public static final char FEMALE = 'F';
	public static final String MESSAGE_TYPE_OF_TREATMENTS = "\nPor favor ingrese el tipo de tratamiento que el paciente requiere: \n"+
		"   1- Medicina general \n"+
		"   2- Observacion \n"+
		"   3- Nutricion \n"+
		"   4- Odontologia \n"+
		"   5- Remision \n";
	public static final String MESSAGE_FOR_ENTRY_WEIGHT = "\nPor favor ingrese el peso del paciente en kg: ";		
	public static final String MESSAGE_FOR_ENTRY_HEIGHT = "\nPor favor ingrese la altura del paciente en cm: ";	
	public static final String SPACE = "\n";
	public static final String NAME = "Nombre";
	public static final String NAME_DATE_BORN = "F. Nacimiento";
	public static final String NAME_TYPE_DOCUMENT = "Tipo doc.";
	public static final String NAME_DOCUMENT = "No. Documento";
	public static final String NAME_TYPE_EPS = "EPS";
	public static final String NAME_TYPE_OF_BLOOD = "RH";
	public static final String NAME_GENDER = "Genero";
	public static final String NAME_TREATMENT = "Tratamiento";
	public static final String NAME_WEIGHT = "Peso(Kg)";
	public static final String NAME_HEIGHT = "Estatura(CM)";
	public static final String NAME_AGE = "Edad";
	public static final Object[] HEADERS = {NAME, NAME_DATE_BORN, NAME_AGE, NAME_TYPE_DOCUMENT, NAME_DOCUMENT, NAME_GENDER, NAME_TYPE_OF_BLOOD, NAME_WEIGHT, NAME_HEIGHT, NAME_TREATMENT, NAME_TYPE_EPS};
	public static final String SEPARATOR_LINE = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String MESSAGE_ERROR_NOT_ELEMENTS = "ERROR: No hay elementos creados";
	public static final String MESSAGE_ERROR_NOT_PATIENTS = "ERROR: No hay pacientes";
	public static final String MESSAGE_THANKS = "\n*****GRACIAS POR UTILIZAR NUESTROS SERVICIOS*****";
	public static final String MESSAGE_ADD_PATIENT = "\nPACIENTE AGREGADO SATISFACTORIAMENTE";
	public static final String MESSAGE_PERCENTAGE_EPS_VECTOR = "[La EPS %s: tiene el: %1.1f %%]\n";
	public static final String MESSAGE_PERCENTAGE_TYPE_DOCUMENT_VECTOR = "\n[El Documento %s: tiene el: %1.1f %%]\n";
	public static final String MESSAGE_PERCENTAGE_TREATMENT_VECTOR = "\n[El tratamiento %s: tiene el: %1.1f %%]\n";
	public static final String MESSAGE_PERCENTAGE_TYPE_BLOOD_VECTOR = "\n[Del RH %s: hay: %1.1f %%]\n";
	public static final String MESSAGE_PERCENTAGE_GENDER_FEMALE = "\n[El porcentaje de pacientes mujeres es: %1.1f]\n";
	public static final String MESSAGE_PERCENTAGE_GENDER_MALE = "\n[El porcentaje de pacientes hombres es: %1.1f]\n";
	public static final String MESSAGE_PRICE_PAY_BY_EPS = "\n[LA EPS  %s: debe pagar: %1.1f]\n";
	public static final String MESSAGE_QUANTITY_IMC_LOW = "\n[Cantidad de personas con peso inferior al normal: %1.0f]";
	public static final String MESSAGE_QUANTITY_IMC_NORMAL = "\n[Cantidad de personas con peso normal: %1.0f]";
	public static final String MESSAGE_QUANTITY_IMC_HIGH = "\n[Cantidad de personas con peso superior al normal: %1.0f]";
	public static final String MESSAGE_QUANTITY_IMC_OBESITY = "\n[Cantidad de personas con obesidad: %1.0f]\n";
	public static final String MESSAGE_QUANTITY_MINORS_AGE = "\n[Cantidad de pacientes menores de edad: %d]\n";
	public static final String MESSAGE_QUANTITY_ADULTS_AGE = "\n[Cantidad de pacientes adultos: %d]\n";
	public static final String MESSAGE_QUANTITY_SENIORS_AGE = "\n[Cantidad de pacientes de la tercera edad: %d]\n";
	public static final String MESSAGE_PEYMENTS_RECEIVED = "\n[El centro Hospitalario recibio: %1.1f pesos, por los servicios prestados]\n";
	public static final String MESSAGE_QUANTITY_POSSIBLE_DONOR = "\n[Hay %d posible(es) donador(es) de sangre]\n";
	
	private Scanner scannerObj;
	
	public Console(){
		scannerObj = new Scanner(System.in);
	}
	public void showError() {
    	System.out.println(MESSAGE_ERROR_OF_OPTION);
    }
	public void showInvalidOption() {
    	System.out.println(MESSAGE_ERROR_OF_OPTION);
    }
	public void showCloseApp() {
    	System.out.println(MESSAGE_THANKS);
    }
	public void showAddedPatient() {
    	System.out.println(MESSAGE_ADD_PATIENT);
    }
	public void showSpace() {
    	System.out.print(SPACE);
    }
	
	public byte readMenuOption(){
		System.out.println (TEXT_MAIN_MENU);
		return Byte.parseByte(scannerObj.nextLine());
	}
	
	public String readName(){
		System.out.println(MESSAGE_FOR_ENTRY_NAME);
		return scannerObj.nextLine();
	}	
	public LocalDate readBornDate(){
		System.out.println(MESSAGE_FOR_ENTRY_BORN_DATE);
		return this.bornDate(scannerObj.nextLine());
	}
	
	public LocalDate bornDate(String dateBornString){
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( FORMAT_OF_DATE );
			return LocalDate.parse( dateBornString, dateTimeFormatter );
	}
	
	public TypeEPS readNameEPS(){
		System.out.println(MESSAGE_FOR_ENTRY_EPS_OF_PATIENT);
		byte option = Byte.parseByte(scannerObj.nextLine());
		TypeEPS typeEPS=null;
		switch (option){
			case 1: 
					typeEPS = TypeEPS.NUEVA_EPS;
					break;
			case 2:
					typeEPS = TypeEPS.COOSALUD;
					break;
			case 3: 
					typeEPS = TypeEPS.SANITAS;
					break;
			case 4: 
					typeEPS = TypeEPS.COMFABOY;
					break;
			case 5: 
					typeEPS = TypeEPS.FAMISANAR;
					break;
			case 6: 
					typeEPS = TypeEPS.SALUD_TOTAL;
					break;
			case 7: 
					typeEPS = TypeEPS.COMPENSAR;
					break;
			default: 
					System.out.println(MESSAGE_ERROR_OF_OPTION);
					this.readNameEPS();
					break;
		}
		return typeEPS;
	}
	public  TypeDocument readTypeDocument(){
		System.out.println(MESSAGE_FOR_ENTRY_TYPE_DOCUMENT);
		byte option = Byte.parseByte(scannerObj.nextLine());
		TypeDocument typeDocument = null;
		switch (option){
			case 1: 
					typeDocument = TypeDocument.CIVIL_REGISTRATION;
					break;
			case 2:
					typeDocument = TypeDocument.IDENTITY_CARD;
					break;
			case 3: 
					typeDocument = TypeDocument.IDENTIFICATION_CARD;
					break;
			default: 
					System.out.println(MESSAGE_ERROR_OF_OPTION);
					this.readTypeDocument();
					break;
		}return typeDocument;
		
	}
	public String readDocument(){
		System.out.println(MESSAGE_FOR_ENTRY_NUMBER_OF_DOCUMENT);
		return scannerObj.nextLine();
		}
		
	public TypeOfBlood readTypeOfBlood(){
		System.out.println(MESSAGE_FOR_ENTRY_TYPE_BLOOD);
		byte option = Byte.parseByte(scannerObj.nextLine());
		TypeOfBlood typeOfBlood = null;
		switch (option){
			case 1: 
					typeOfBlood = TypeOfBlood.O_POSITIVE;
					break;
			case 2:
					typeOfBlood = TypeOfBlood.O_NEGATIVE;
					break;
			case 3: 
					typeOfBlood = TypeOfBlood.A_POSITIVE;
					break;
			case 4: 
					typeOfBlood = TypeOfBlood.A_NEGATIVE;
					break;
			case 5: 
					typeOfBlood = TypeOfBlood.B_POSITIVE;
					break;
			case 6: 
					typeOfBlood = TypeOfBlood.B_NEGATIVE;
					break;
			case 7: 
					typeOfBlood = TypeOfBlood.AB_POSITIVE;
					break;
			case 8: 
					typeOfBlood = TypeOfBlood.AB_NEGATIVE;
					break;
			default: 
					System.out.println(MESSAGE_ERROR_OF_OPTION);
					this.readTypeOfBlood();
					break;
		}return typeOfBlood;
	}
	
	public char readGender (){
		System.out.println (MESSAGE_FOR_ENTRY_GENDER);
		String genderAux = scannerObj.nextLine();
		char auxGender = genderAux.charAt(0);
		if (auxGender == FEMALE){
			return FEMALE;
			
		}else if (auxGender == MALE){
			return MALE ;
			
		}else {
			System.out.println(MESSAGE_ERROR_OF_OPTION);
			return this.readGender();
		}
	}
	
	public Treatment readTreatment(){
		System.out.println(MESSAGE_TYPE_OF_TREATMENTS);
		byte option = Byte.parseByte(scannerObj.nextLine());
		Treatment treatment = null;
		switch (option){
			case 1: 
					treatment = Treatment.GENERAL_MEDICINE;
					break;
			case 2:
					treatment = Treatment.OBSERVATION;
					break;
			case 3: 
					treatment = Treatment.NUTRITION;
					break;
			case 4: 
					treatment = Treatment.ODONTOLOGY;
					break;
			case 5: 
					treatment = Treatment.REMISSION;
					break;
			default: 
					System.out.println(MESSAGE_ERROR_OF_OPTION);
					this.readTreatment();
					break;
		}
		return treatment;
	}
	
	public float readWeight(){
		System.out.println(MESSAGE_FOR_ENTRY_WEIGHT);
		return  Float.parseFloat(scannerObj.nextLine());
	}
	
	public int readHeight(){
		System.out.println(MESSAGE_FOR_ENTRY_HEIGHT);
		return Integer.parseInt(scannerObj.nextLine());
		
	}
	
	public void printInvalidOption(){
		System.out.println(MESSAGE_ERROR_OF_OPTION);
	}
	
	public void generateHeader() {
		System.out.println(String.format(FORMAT, HEADERS));
		System.out.println(SEPARATOR_LINE);
	}
	
	public void showListDataPatient (Object[][] listPatient){
		System.out.println(SPACE);
		this.generateHeader();
		for (int index = 0; index < listPatient.length; index++){
			Object [] datasObject = listPatient[index];
			System.out.println (String.format(FORMAT, datasObject));
		}
	}
	public void printErrorNoElements(){
		System.out.println( MESSAGE_ERROR_NOT_ELEMENTS );
	}
	
	public void printPercentageForEPS(double [] percentagesEPS, TypeEPS [] typeEPSAux){
		
		for (int index = 0; index < percentagesEPS.length; index++){
			
				System.out.printf(MESSAGE_PERCENTAGE_EPS_VECTOR, typeEPSAux[index].getLabel(), percentagesEPS[index] );
			
		}
	}

	public void printErrorNoPatients(){
		System.out.println(MESSAGE_ERROR_NOT_PATIENTS);
	}
	
	public void printPercentageForTypeDocument(double[] percentagesTypeDocument, TypeDocument [] typeDocumentAux){
		for (int index = 0; index < percentagesTypeDocument.length; index++){
			System.out.printf(MESSAGE_PERCENTAGE_TYPE_DOCUMENT_VECTOR, typeDocumentAux[index].getLabel(), percentagesTypeDocument[index] );
		}
	}
	
	
	public void printPercentageForTreatment(double[] percentagesTreatment, Treatment [] treatmentAux){
		for (int index = 0; index < percentagesTreatment.length; index++){
			System.out.printf(MESSAGE_PERCENTAGE_TREATMENT_VECTOR, treatmentAux[index].getLabel(), percentagesTreatment[index] );
		}
	}
	
	public void printPercentageForTypeBlood(double[] percentagesTypeBlood, TypeOfBlood [] typeOfBloodAux){
		for (int index = 0; index < percentagesTypeBlood.length; index++){
			System.out.printf(MESSAGE_PERCENTAGE_TYPE_BLOOD_VECTOR, typeOfBloodAux[index].getLabel(), percentagesTypeBlood[index] );
		}
	}
	

	public void printPercentageGender (float percetageMale, float percentageFemale){
		System.out.printf (MESSAGE_PERCENTAGE_GENDER_MALE, percetageMale);
		System.out.printf (MESSAGE_PERCENTAGE_GENDER_FEMALE, percentageFemale);
	}
	
	public void printQuantityPatientsIMC(float [] quantityIMC){
		System.out.printf (MESSAGE_QUANTITY_IMC_LOW, quantityIMC[0]);
		System.out.printf (MESSAGE_QUANTITY_IMC_NORMAL, quantityIMC[1]);
		System.out.printf (MESSAGE_QUANTITY_IMC_HIGH, quantityIMC[2]);
		System.out.printf (MESSAGE_QUANTITY_IMC_OBESITY, quantityIMC[3]);
		
	}
	
	public void printQuantityPatientsForEdad(int [] quantityPorAge){
		System.out.printf (MESSAGE_QUANTITY_MINORS_AGE, quantityPorAge[0]);
		System.out.printf (MESSAGE_QUANTITY_ADULTS_AGE, quantityPorAge[1]);
		System.out.printf (MESSAGE_QUANTITY_SENIORS_AGE, quantityPorAge[2]);
		
	}
	public void printPaymentsReceived(double peyments){
		System.out.printf(MESSAGE_PEYMENTS_RECEIVED, peyments);
	}
	
	public void printPayByEPS(double [] priceByEPS, TypeEPS[] listEPS){
		for (int index = 0; index < listEPS.length; index++){
			System.out.printf(MESSAGE_PRICE_PAY_BY_EPS, listEPS[index].getLabel(), priceByEPS[index] );
		}
	}
	
	public void printPossibleDonor (int quantityPossibleDonor){
		System.out.printf(MESSAGE_QUANTITY_POSSIBLE_DONOR,  quantityPossibleDonor);
	}
}