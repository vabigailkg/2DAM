package cuentasBancarias.modelo.gestores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import cuentasBancarias.modelo.pojos.CuentaBancaria;

public interface GestorFicherosInterface {

	public List<CuentaBancaria> leerFicheroAhorro() throws FileNotFoundException, ClassNotFoundException, IOException;
	public List<CuentaBancaria> leerFicheroEmpresa() throws FileNotFoundException, ClassNotFoundException, IOException;
	public List<CuentaBancaria> leerFicheroInversion() throws FileNotFoundException, ClassNotFoundException, IOException;
	
	public void escribirFicheroAhorro(List<CuentaBancaria> cuentaAhorro, boolean append) throws FileNotFoundException, IOException;
	public void escribirFicheroEmpresa(List<CuentaBancaria> cuentaEmpresa, boolean append) throws FileNotFoundException, IOException;
	public void escribirFicheroInversion(List<CuentaBancaria> cuentaInversion, boolean append) throws FileNotFoundException, IOException;
	
	public void borrarFicheroAhorro();
	public void borrarFicheroEmpresa();
	public void borrarFicheroInversion();
}
