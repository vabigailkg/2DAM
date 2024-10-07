package ejemplos;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class LeerFirebase {

	public static void main(String[] args) {
		DocumentReference db = null;
		ApiFuture<QuerySnapshot> query = db.collection("empresaBD").get();

		QuerySnapshot querySnapshot;
		try {
			querySnapshot = query.get();
			List<QueryDocumentSnapshot> departamentos = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot departamento : departamentos) {
				System.out.println("ID: " + departamento.getId());
				System.out.println("Nombre: " + departamento.getString("nombre"));
				System.out.println("Localización: " + departamento.getString("localización"));

				DocumentReference departamentoRef = departamento.getReference();
				CollectionReference empleadosCol = departamentoRef.collection("empleados");
				List<QueryDocumentSnapshot> empleados = empleadosCol.get().get().getDocuments();
				for (QueryDocumentSnapshot empleado : empleados) {
					System.out.println("ID: " + empleado.getId());
					System.out.println("Apellido: " + empleado.getString("apellido"));
					System.out.println("Fecha alta: " + empleado.getDate("fecha_alt"));
					System.out.println("Oficio: " + empleado.getString("oficio"));
					System.out.println("Salario: " + empleado.getDouble("salario"));

					DocumentReference dirRef = (DocumentReference) empleado.getData().get("dir");
					if (dirRef != null)
						System.out.println("Dir: " + dirRef.getId());
				}
			}

			// Leer campo relacionado
			if (empleado.getData().get("dir") != null) {
				DocumentReference dirObj = (DocumentReference) empleado.getData().get("dir");
				ApiFuture<DocumentSnapshot> queryDir = empleadosCol.document(dirObj.getId()).get();
				System.out.println(queryDir.get().getString("emple_ap1"));
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
