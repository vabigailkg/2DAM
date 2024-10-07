package ejemplos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class AccesoFireBase {

	public static void main(String[] args) {

		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream("serviceAccountKey.json");
			FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
					.setProjectId("ID DEL PROYECTO").setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();

			Firestore db = firestoreOptions.getService();

			ApiFuture<QuerySnapshot> query = db.collection("serviceAccountKey").get();

			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> departamentos = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot departamento : departamentos) {
				System.out.println("ID: " + departamento.getId());
				System.out.println("Nombre: " + departamento.getString("nombre"));
				System.out.println("Localización: " + departamento.getString("localización"));
			}
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
