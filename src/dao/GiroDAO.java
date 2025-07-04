package dao;

import modelo.Conexion;
import modelo.Giro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class GiroDAO {
	
	Connection connection = null;
	Conexion conexion = null;
	PreparedStatement preStatement = null;
	ResultSet resultSet = null;
	
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
		
		// buscamos coincidencias entre numerodestino, codigoseguridad y si el monto es mayor a 0 (osea existe)
		/* el motivo de buscar tambien el codigoseguridad es por si hayan mas giros a un mismo numero, entonces mantenemos unico el retiro
		de cada giro */
		
		/*
		String buscar = "SELECT * FROM giro WHERE numerodestino = '" 
		+ giro.getNumeroDestino() + "' AND codigoseguridad = '" + giro.getCodigoSeguridad() + "' AND monto > 0";
		
		String retirarmonto = "UPDATE giro SET monto = 0 WHERE numerodestino = '" + giro.getNumeroDestino() + "'"; // Es el update en sql
		*/
		
		//descartamos la forma anterior de guardar "buscar" y "retirarmonto" (la que se aprecia arriba) por una forma mas eficiente y segura
		
		String buscar = "SELECT * FROM giro WHERE numerodestino = ? AND codigoseguridad = ? AND monto > 0";
		String retirarmonto = "UPDATE giro SET monto = 0 WHERE codigoseguridad = ?"; //Es el update en SQL
		try {
		//busca una coincidencia de algun numero destino en la base de datos para retirar el monto
		preStatement = connection.prepareStatement(buscar);
		preStatement.setString(1, giro.getNumeroDestino()); // reemplaza el primer signo de pregunra "?" por la variable numerodestino
		preStatement.setString(2, giro.getCodigoSeguridad()); // reemplaza el segundo signo "?" por la variable codigoseguridad
		resultSet = preStatement.executeQuery();
		
		if(resultSet.next()) //devuelve true si existe una fila que coincidan con lo que buscamos
		{
			BigDecimal montoEncontrado = resultSet.getBigDecimal("monto");
			String mensaje = "GIRO ENCONTRADO:\nMONTO: " + montoEncontrado +"Gs\n Desea retirarlo?";
			//System.out.println("GIRO ENCONTRADO");

			int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar retiro", JOptionPane.YES_NO_OPTION);
			
			if(opcion == JOptionPane.YES_OPTION)
			{
                preStatement.close();
                preStatement = connection.prepareStatement(retirarmonto);
                preStatement.setString(1, giro.getCodigoSeguridad());
                preStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Giro retirado correctamente.\nSe retiraron " + montoEncontrado + "Gs");
            } 
			else if(opcion == JOptionPane.NO_OPTION)
			{
                JOptionPane.showMessageDialog(null, "El giro no fue retirado.");
            }

        } 
		else 
		{
            JOptionPane.showMessageDialog(null, "No se encontró el giro, verificar los datos introducidos", "Giro no encontrado", JOptionPane.WARNING_MESSAGE);
        }
		
		
		
		
		
		} catch (SQLException e) {
			System.out.println("Error SQL: " + e.getMessage());
			//e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			//e.printStackTrace();
			
		} finally {
			preStatement.close();
			resultSet.close();
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
