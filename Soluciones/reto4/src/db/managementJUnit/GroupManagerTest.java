
package db.managementJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import db.management.GroupManager;
import db.management.PremiumUserManager;
import db.management.UserManager;
import db.pojos.Group;
import db.pojos.PremiumUser;
import panelControllers.RegisterPanelController;

public class GroupManagerTest {

	GroupManager groupManager = new GroupManager();
	
	String name = "Grupo A";
	String newName = "Grupo XZL";
	
	List<Group> previousList = null;
	List<Group> nextList = null;
	
	Group group = new Group();{
		group.setImagen(newName);
		group.setImagen("image");
		group.setDescription("Description" );
		group.setCreationDate(new Date());
	}

	@Test
	public void checkIfGroupExistsSuccessful() {
		boolean checkUserExistance = false;
		try {
			checkUserExistance = groupManager.checkIfGroupExists(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("El grupo debe existir", checkUserExistance);
	}

	@Test
	public void checkIfGroupExistsUnsuccessful() {
		boolean checkUserExistance = false;
		try {
			checkUserExistance = groupManager.checkIfGroupExists(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertFalse("El grupo no debe existir", checkUserExistance);
	}
	@Test
	public void modifyGroupNameSuccessful() {

		boolean checkUserExistance = false;
		try {
			
			checkUserExistance = groupManager.modifyGroupName(name, newName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Se ha podido cambiar el nombre del grupo", checkUserExistance);
	}

	@Test
	public void modifyGroupNameUnsuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = groupManager.modifyGroupName(name, newName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("No se ha podido cambiar el nombre del grupo", checkUserExistance);
	}

	@Test
	public void deleteGroupSuccessful() {

		boolean checkUserExistance = false;
		try {
			checkUserExistance = groupManager.deleteGroupByName(name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Se ha podido borrar el grupo", checkUserExistance);
	}

	@Test
	public void deleteGroupUnsuccessful() {

		// Llamar al método para obtener el dni y la contrasena
		boolean checkUserExistance = false;
		try {
			checkUserExistance = groupManager.deleteGroupByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verificar que el falle
		assertFalse("No se ha podido borrar el grupo", checkUserExistance);
	}

}