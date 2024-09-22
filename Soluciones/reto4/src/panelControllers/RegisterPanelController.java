package panelControllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import db.management.FreeUserManager;
import db.management.PremiumUserManager;
import db.management.UserManager;
import db.pojos.FreeUser;
import db.pojos.PremiumUser;

public class RegisterPanelController {

	public void registerPremiumAccount(PremiumUser premiumUser) throws Exception {
		UserManager userManager = new UserManager();
		int id = userManager.getId(premiumUser.getLogin());
		PremiumUserManager premiumUserManager = new PremiumUserManager();
		premiumUserManager.createPremiumAccount(premiumUser);
		premiumUserManager.createPremiumAccountExtra(premiumUser, id);
	}

	public void registerFreeAccount(FreeUser freeUser) throws Exception {

		FreeUserManager freeUserManager = new FreeUserManager();
		freeUserManager.createFreeAccount(freeUser);
	}

	public Date convertStringToDate(String StringDate) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaConvertida = null;

		try {
			Date parsed = dateFormat.parse(StringDate);
			fechaConvertida = new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
			System.out.println("Error occurred" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Escriba con el formato YY-MM-DD");
		}
		return fechaConvertida;
	}

	public String obtainTypeUserInSpanish(String accountType) throws ParseException {
		String ret = null;
		if (accountType.equals("premium")) {
			ret = "premium";
		} else {
			ret = "libre";
		}
		return ret;
	}
}
