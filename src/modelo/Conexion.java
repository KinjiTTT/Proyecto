package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	String url = "jdbc:postgresql://localhost:5432/GirosYRecargas";
	String usuario = "postgres";
	String contraseña = "98765";
	
	Connection conn = null;
	public String conectar()
	{
		String respuesta = ""; 
		try {
	         conn = DriverManager.getConnection(url, usuario, contraseña);
	         respuesta = "conectado";
	         //conn.close();
	     } catch (SQLException e) {
	    	 respuesta = "error";
	         e.printStackTrace();
	     }
		return respuesta;
	}
	
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
	
}
