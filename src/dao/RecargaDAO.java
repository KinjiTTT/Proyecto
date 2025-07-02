package dao;

import modelo.Conexion;
import modelo.Recarga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class RecargaDAO {
	
	Connection connection = null;
	Conexion conexion = null;
	PreparedStatement preStatement = null;
	
	private String conectar()
	{
		conexion = new Conexion();
		String resultado = conexion.conectar();
		
		if(resultado.equals("conectado"))
		{
			connection = conexion.getConnection();
		}
		else
		{
			JOptionPane.showMessageDialog(null, resultado,"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return resultado;
	}
	
	public String registrarRecarga(Recarga nuevarecarga) throws SQLException
	{
		String resultado = "";
		
		if(!conectar().equals("conectado"))
		{
			return "Error";
		}
		String cargar = "INSERT INTO recarga (codigo,numeroDeTelefono,companiaTelefonica,montoRecarga)" + "  VALUES (?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(cargar);
			preStatement.setInt(1, nuevarecarga.getCodigo());
			preStatement.setString(2, nuevarecarga.getNumeroDeTelefono());
			preStatement.setInt(3,nuevarecarga.getCompaniaTelefonica());
			preStatement.setBigDecimal(4,nuevarecarga.getMontoRecarga());
			preStatement.execute();

			resultado = "ok";
		
		}catch (SQLException e) {
			System.out.println("No se pudo realizar la recarga, verifique los datos ingresados: " + e.getMessage());
			//e.printStackTrace();
			resultado = "error";
		}
		catch (Exception e) {
			System.out.println("No se pudo cargar saldo: " + e.getMessage());
			//e.printStackTrace();
			resultado = "error";
		}
		finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		
		return resultado;
	}
	
	public Recarga consultarRecarga(String documento)
	{
		return new Recarga();
	}
	
	public ArrayList<Recarga> consultarLista(String lista)
	{
		return new ArrayList<Recarga>();
	}
	
	public String actualizarRecarga(Recarga recarga)
	{
		return "";
	}
	
	public String eliminarRecarga(String documento)
	{
		return "";
	}
}
