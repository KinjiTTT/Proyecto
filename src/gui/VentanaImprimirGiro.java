package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Giro;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaImprimirGiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaImprimirGiro frame = new VentanaImprimirGiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaImprimirGiro() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(905, 200, 450, 550);
		setResizable(false);
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 489);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		
		
	}
	
	public void mostrarListaEnArea(Giro giro) {
		String cadena = "";
		cadena += "===============================\n";
		cadena += "        GIRO REALIZADO\n";
		cadena += "===============================\n";
		cadena += "Operación: " + giro.getOperacion() + "\n";
		cadena += "Destino: " + giro.getNumeroDestino() + "\n";
		cadena += "Remitente: " + giro.getNumeroRemitente() + "\n";
		cadena += "Cédula Remitente: " + giro.getCedulaRemitente() + "\n";
		cadena += "Monto: Gs. " + giro.getMontoGiro() + "\n";
		cadena += "Método de Pago: " + giro.getMetodoPago() + "\n";
		cadena += "-------------------------------\n";
		cadena += "CÓDIGO DE SEGURIDAD: " + giro.getCodigoSeguridad() + "\n";
		cadena += "===============================\n";
		cadena += "     GUARDE ESTE COMPROBANTE\n";
		cadena += "===============================\n";
		    
		txtArea.setText(cadena);
	}
	
}
