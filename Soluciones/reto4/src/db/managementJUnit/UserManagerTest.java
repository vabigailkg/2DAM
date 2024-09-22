package db.managementJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import db.management.PremiumUserManager;
import db.management.UserManager;

import db.pojos.PremiumUser;
import panelControllers.RegisterPanelController;

public class UserManagerTest {

	PremiumUserManager premiumUserManager = new PremiumUserManager();
	UserManager userManager = new UserManager();
	
	
	RegisterPanelController registerPanel = new RegisterPanelController();
	
	String login = "test";
	String password = "password";
	int id = 1;
	long cardNumber = 1818181818181818L;
	String expirationDate = "10/25";
	int cvv = 1234;
	
	PremiumUser premiumUser = new PremiumUser();{
		premiumUser.setCardNumber(cardNumber );
		premiumUser.setExpirationDate(expirationDate  );
		premiumUser.setCvv(cvv );
	}
	
	
	
	//RegisterPanelController registerPanel = new RegisterPanelController();
	
	//Read test - we test if a login exists
	@Test
	public void checkIfUserExistsSuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = userManager.checkIfUserExists(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("El usuario debe existir", checkUserExistance);
	}

	@Test
	public void checkIfUserExistsUnsuccessful() {

		// Llamar al método para obtener el dni y la contrasena
		boolean checkUserExistance = false;
		try {
			checkUserExistance = userManager.checkIfUserExists(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("El usuario no debe existir", checkUserExistance);
	}
	
	
	
	//Modify test - trying to change the password of an account by passing the login
	@Test
	public void modifyUserPasswordSuccessful() {

		boolean checkUserExistance = false;
		try {
			
			checkUserExistance = userManager.modifyUserPassword(login, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Se ha podido cambiar la contrasenia al usuario", checkUserExistance);
	}

	@Test
	public void modifyUserPasswordUnsuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = userManager.modifyUserPassword(login, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("Se ha podido cambiar la contrasenia al usuario", checkUserExistance);
	}
	
		//Create test - The basic account data of a premium user is already in the database, now we enter the rest of the data
	@Test
	public void createPremiumUserSuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = premiumUserManager.createPremiumAccountExtra(premiumUser, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Se ha podido crear al usuario", checkUserExistance);
	}

	@Test
	public void createPremiumUserUnsuccessful() {

		// Llamar al método para obtener el dni y la contrasena
		boolean checkUserExistance = false;
		try {
			
			checkUserExistance = premiumUserManager.createPremiumAccountExtra(premiumUser, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("No se ha podido crear al usuario", checkUserExistance);
	}
		
		//Delete test -  trying to delete an account by passing the login
	@Test
	public void deleteUserSuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = userManager.deleteAccount(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Se ha podido borrar al usuario", checkUserExistance);
	}

	@Test
	public void deletePremiumUserUnsuccessful() {

		// Llamar al método para obtener el dni y la contrasena
		boolean checkUserExistance = false;
		try {
			checkUserExistance = userManager.deleteAccount(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("No se ha podido borrar al usuario", checkUserExistance);
	}

}