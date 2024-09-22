
package db.management;

import java.util.List;

public interface GestorInterfaz<T> {

	public List<T> select(int id) throws Exception;

	public void insert(String nombre, String imagen, String descripcion, java.util.Date fecha) throws Exception;

	public void update(String nombre, String imagen, String descripcion, java.util.Date fecha) throws Exception;

	public void delete(int id) throws Exception;
}