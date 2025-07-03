package dao;

import modelo.Conexion;
import modelo.Giro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class GiroDAO {
	
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
	
	public void registrarGiro(Giro nuevogiro) throws SQLException
	{
		//String resultado = "";
		
		if(!conectar().equals("conectado"))
		{
			//return "Error";
			System.out.println("Error de Conexion a la Base de Datos");
		}
		String cargar = "INSERT INTO giro (operacion, numerodestino, numeroremitente, cedularemitente, monto, metodopago, codigoseguridad)"
		+ "  VALUES (?,?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(cargar);
			preStatement.setString(1, nuevogiro.getOperacion());
			preStatement.setString(2,nuevogiro.getNumeroDestino());
			preStatement.setString(3,nuevogiro.getNumeroRemitente());
			preStatement.setString(4,nuevogiro.getCedulaRemitente());
			preStatement.setBigDecimal(5,nuevogiro.getMontoGiro());
			preStatement.setString(6,nuevogiro.getMetodoPago());
			preStatement.setString(7,nuevogiro.getCodigoSeguridad());
			preStatement.execute();

			//resultado = "registrado";
			System.out.println("Giro Registrado");
		
		}catch (SQLException e) {
			System.out.println("No se pudo realizar el giro, verifique los datos ingresados: " + e.getMessage());
			//e.printStackTrace();
			//resultado = "error";
		}
		catch (Exception e) {
			System.out.println("No se pudo realizar el giro: " + e.getMessage());
			//e.printStackTrace();
			//resultado = "error";
		}
		finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		
		//return resultado;
	}
	
	public void retirarGiro(Giro giro) throws SQLException{
		
		if(!conectar().equals("conectado"))
		{
			//return "Error";
			System.out.println("Error de Conexion a la Base de Datos");
		}
		
		
		String retirar = "SELECT operacion, numerodestino, numeroremitente, cedularemitente, monto, metodopago, codigoseguridad "
				+ "FROM giro WHERE numerodestino = "+ giro.getNumeroDestino();
		
		try {
		preStatement = connection.prepareStatement(retirar); //busca una coincidencia de algun numero destino en la base de datos
		//por completar
		
		
		
		
		} catch (SQLException e) {
			System.out.println("No se pudo retirar el giro, verifique los datos ingresados: " + e.getMessage());
			//e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("No se pudo retirar el giro: " + e.getMessage());
			//e.printStackTrace();
			
		} finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		
		}
	}
	
	public Giro consultarGiro(String documento)
	{
		return new Giro();
	}
	
	public ArrayList<Giro> consultarLista(String lista)
	{
		return new ArrayList<Giro>();
	}
	
	public String actualizarGiro(Giro giro)
	{
		return "";
	}
	
	public String eliminarGiro(String documento)
	{
		return "";
	}
}
