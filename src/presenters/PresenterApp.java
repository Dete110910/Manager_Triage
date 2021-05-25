package presenters;

import java.time.LocalDate;

import models.Patient;
import models.ManagerPatient;
import models.TypeEPS;
import models.TypeDocument;
import models.TypeOfBlood;
import models.Treatment;
import views.Console;

public class PresenterApp{
	private ManagerPatient managerPatientObj;
	private Console consoleObj;
	private Patient patientObj;
	
	public PresenterApp(){
		consoleObj = new Console();
		managerPatientObj = new ManagerPatient ();
		patientObj = new Patient();
		runApp();
	}
	
	private void runApp(){
		this.createPatient();
		byte menuOption = 0;
		
		do{
			menuOption = consoleObj.readMenuOption();

				switch (menuOption){
					case 1:
							this.manageAddPatient();
							break;
					case 2:
							this.managePrintPatient();
							break;
					case 3:
							this.showReportEPS();
							break;
					case 4:
							this.showReportTypeDocument();
							break;
					case 5:
							this.showReportTreatment();
							break;
					case 6:
							this.showReportTypeBlood();
							break;
					case 7:
							this.showPercentageGender();
							break;
					case 8:
							this.showQuantityIMC();
							break;
					case 9:
							this.showWQuantityPatientsForAge();
							break;
					case 10:
							this.showPaymentsReceived();
							break;
					case 11:
							this.showPriceByEPS();
							break;
					case 12:
							this.showPossiblesDonors();
							break;
					case 0: 
							consoleObj.showCloseApp();
							
					default:
							consoleObj.showError();
							break;
				}
			
		}while (menuOption != 0);
	}
	
	private void manageAddPatient(){
		String name = consoleObj.readName();
		LocalDate bornDate = consoleObj.readBornDate();
		TypeDocument typeDocument = consoleObj.readTypeDocument();
		String document = consoleObj.readDocument();
		TypeEPS typeEPS = consoleObj.readNameEPS();
		TypeOfBlood typeOfBlood = consoleObj.readTypeOfBlood();
		char gender = consoleObj.readGender();	
		float weight = consoleObj.readWeight();
		int height = consoleObj.readHeight();
		Treatment treatment = consoleObj.readTreatment();
		consoleObj.showAddedPatient();
		Patient patient = managerPatientObj.createPatient(name, bornDate, typeDocument, document, typeEPS, typeOfBlood, gender, treatment, weight, height);
		managerPatientObj.addAPatient(patient);
	}
	private void managePrintPatient(){
		Object [][] patientList = managerPatientObj.toMatrixVector();
		if (patientList != null){
			consoleObj.showListDataPatient(patientList);
		}else {
			consoleObj.printErrorNoElements();
		}
	}
	
	private void showReportEPS(){
		double [] getPercentageAllEPSAux = managerPatientObj.getPercentageAllEPS();
		if (getPercentageAllEPSAux [0] != 0){
		TypeEPS[] typeEPSAux = TypeEPS.values();
		consoleObj.printPercentageForEPS(getPercentageAllEPSAux, typeEPSAux);
		}else {
			consoleObj.printErrorNoPatients();
		}
	}
	
	private void showReportTypeDocument(){
		double [] getPercentageAllTypeDocumentAux = managerPatientObj.getPercentageAllTypeDocument();
		TypeDocument[] typeDocumentAux = TypeDocument.values();
		consoleObj.printPercentageForTypeDocument(getPercentageAllTypeDocumentAux, typeDocumentAux);
	}

	private void showReportTreatment(){
		double [] getPercentageAllTreatmentAux = managerPatientObj.getPercentageAllTreatment();
		Treatment[] treatmentAux = Treatment.values();
		consoleObj.printPercentageForTreatment(getPercentageAllTreatmentAux, treatmentAux);
	}
	
	private void showReportTypeBlood(){
		double [] getPercentageForTypeOfBloodAux = managerPatientObj.getPercentageForTypeOfBlood();
		TypeOfBlood[] typeOfBloodAux = TypeOfBlood.values();
		consoleObj.printPercentageForTypeBlood(getPercentageForTypeOfBloodAux, typeOfBloodAux);
	}
	
	private void showPercentageGender(){
		float getPercentageMaleAux = managerPatientObj.getPercentageMale();
		float getPercentageFemaleAux = managerPatientObj.getPercentageFemale();
		consoleObj.printPercentageGender(getPercentageMaleAux, getPercentageFemaleAux);
	}
	private void showQuantityIMC(){
		float [] getAllIMCAux = managerPatientObj.getAllIMC();
		consoleObj.printQuantityPatientsIMC(getAllIMCAux);
	}
	private void showWQuantityPatientsForAge(){
		int [] getAllAgeAux = managerPatientObj.getAllAge();
		consoleObj.printQuantityPatientsForEdad(getAllAgeAux);
	}
	
	private void showPaymentsReceived(){
		double priceForServicosAux = managerPatientObj.priceForServicos();
		consoleObj.printPaymentsReceived(priceForServicosAux);
	}
	private void showPriceByEPS(){
		double [] listPayEPS = managerPatientObj.payEPS();
		TypeEPS [] listEPS = TypeEPS.values();
		consoleObj.printPayByEPS(listPayEPS, listEPS );
	}
	private void showPossiblesDonors(){
		int getPossibleDonorsAux = managerPatientObj.getPossibleDonors();
		consoleObj.printPossibleDonor(getPossibleDonorsAux);
		
	}
	
	private void createPatient(){
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Daniel", LocalDate.of(2015, 5, 30), TypeDocument.IDENTIFICATION_CARD, "1051336620",   TypeEPS.NUEVA_EPS, TypeOfBlood.A_POSITIVE,'M', Treatment.GENERAL_MEDICINE, 42f, 180));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Santiago Zarate", LocalDate.of(2015, 5, 12), TypeDocument.CIVIL_REGISTRATION, "1051336620",   TypeEPS.NUEVA_EPS, TypeOfBlood.O_POSITIVE,'M', Treatment.ODONTOLOGY, 55f, 160));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Manuel Antonio", LocalDate.of(2000, 6, 28), TypeDocument.IDENTIFICATION_CARD, "10068294829",   TypeEPS.COOSALUD, TypeOfBlood.A_POSITIVE,'M', Treatment.GENERAL_MEDICINE, 65f, 166));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Carlos Angarita", LocalDate.of(1960, 7, 24), TypeDocument.IDENTITY_CARD, "1992849383",   TypeEPS.NUEVA_EPS, TypeOfBlood.O_POSITIVE,'M', Treatment.ODONTOLOGY, 76f, 168));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Maria Clavero", LocalDate.of(2001, 11, 22), TypeDocument.IDENTIFICATION_CARD, "403938953",   TypeEPS.SANITAS, TypeOfBlood.A_POSITIVE,'F', Treatment.GENERAL_MEDICINE, 80f, 150));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Juan Salamanca", LocalDate.of(2002, 9, 12), TypeDocument.IDENTIFICATION_CARD, "3049385935",   TypeEPS.COOSALUD, TypeOfBlood.AB_NEGATIVE,'M', Treatment.REMISSION, 78f, 171));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Camilo Robles", LocalDate.of(2001, 2, 11), TypeDocument.IDENTIFICATION_CARD, "385930293",   TypeEPS.NUEVA_EPS, TypeOfBlood.O_POSITIVE,'M', Treatment.OBSERVATION, 88f, 190));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("David Robayo", LocalDate.of(1996, 3, 1), TypeDocument.IDENTIFICATION_CARD, "39023950",   TypeEPS.SALUD_TOTAL, TypeOfBlood.B_NEGATIVE,'M', Treatment.REMISSION, 45f, 150));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Diego Maradona", LocalDate.of(1996, 6, 2), TypeDocument.IDENTIFICATION_CARD, "403838593",   TypeEPS.SANITAS, TypeOfBlood.B_POSITIVE,'M', Treatment.NUTRITION, 76f, 178));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Carlos Otalvaro", LocalDate.of(1976, 3, 9), TypeDocument.IDENTIFICATION_CARD, "49349394",   TypeEPS.COMFABOY, TypeOfBlood.A_POSITIVE,'M', Treatment.ODONTOLOGY, 100f, 198));
		managerPatientObj.addAPatient(managerPatientObj.createPatient("Vannessa Torres", LocalDate.of(2002, 4, 10), TypeDocument.IDENTIFICATION_CARD, "49334803",   TypeEPS.COMFABOY, TypeOfBlood.B_NEGATIVE,'F', Treatment.REMISSION, 52f, 154));
	}
}