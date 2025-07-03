package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.math.BigDecimal;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.GiroDAO;
import modelo.Giro;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaGiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroDestino;
	private JTextField txtNumeroRemitente;
	private JTextField txtCedulaRemitente;
	private JTextField txtMonto;
	private JButton btnEnviar;
	private JComboBox cbxOperacion;
	
	GiroDAO giroDAO = new GiroDAO();
	private JComboBox cbxMetodoPago;
	private JLabel lblNumeroDestino;
	private JLabel lblCedulaRemitente;
	private JLabel lblNumeroRemitente;
	private JLabel lblMonto;
	private JLabel lblMetodoYCodigo;
	private JTextField txtCodigo;
	private JButton btnRetirar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGiro frame = new VentanaGiro();
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
	public VentanaGiro() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 720, 480);
		setResizable(false);
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Giros");
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Swis721 BlkEx BT", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 704, 97);
		contentPane.add(lblTitulo);
		
		JLabel lblOperacion = new JLabel("Operacion");
		lblOperacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOperacion.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblOperacion.setBounds(10, 95, 214, 47);
		contentPane.add(lblOperacion);
		
		lblNumeroDestino = new JLabel("Numero de Destino");
		lblNumeroDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDestino.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNumeroDestino.setBounds(10, 185, 214, 47);
		lblNumeroDestino.setVisible(false);
		contentPane.add(lblNumeroDestino);
		
		lblNumeroRemitente = new JLabel("Numero de Remitente");
		lblNumeroRemitente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroRemitente.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNumeroRemitente.setBounds(0, 230, 224, 47);
		lblNumeroRemitente.setVisible(false);
		
		contentPane.add(lblNumeroRemitente);
		
		lblCedulaRemitente = new JLabel("Cedula del Remitente");
		lblCedulaRemitente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedulaRemitente.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblCedulaRemitente.setBounds(10, 275, 214, 47);
		lblCedulaRemitente.setVisible(false);
		contentPane.add(lblCedulaRemitente);
		
		lblMonto = new JLabel("Monto a Enviar");
		lblMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonto.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblMonto.setBounds(10, 320, 214, 47);
		lblMonto.setVisible(false);
		contentPane.add(lblMonto);
		
		lblMetodoYCodigo = new JLabel("Codigo de Seguridad");
		lblMetodoYCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoYCodigo.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblMetodoYCodigo.setBounds(10, 368, 214, 47);
		lblMetodoYCodigo.setVisible(false);
		contentPane.add(lblMetodoYCodigo);
		
		txtNumeroDestino = new JTextField();
		txtNumeroDestino.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtNumeroDestino.setColumns(10);
		txtNumeroDestino.setBounds(234, 193, 300, 30);
		txtNumeroDestino.setVisible(false);
		contentPane.add(txtNumeroDestino);
		
		txtNumeroRemitente = new JTextField();
		txtNumeroRemitente.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtNumeroRemitente.setColumns(10);
		txtNumeroRemitente.setBounds(234, 238, 300, 30);
		txtNumeroRemitente.setVisible(false);
		contentPane.add(txtNumeroRemitente);
		
		txtCedulaRemitente = new JTextField();
		txtCedulaRemitente.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtCedulaRemitente.setColumns(10);
		txtCedulaRemitente.setBounds(234, 283, 300, 30);
		txtCedulaRemitente.setVisible(false);
		contentPane.add(txtCedulaRemitente);
		
		txtMonto = new JTextField();
		txtMonto.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtMonto.setColumns(10);
		txtMonto.setBounds(234, 328, 300, 30);
		txtMonto.setVisible(false);
		contentPane.add(txtMonto);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(234, 373, 300, 30);
		txtCodigo.setVisible(false);
		contentPane.add(txtCodigo);
		
		cbxOperacion = new JComboBox();
		cbxOperacion.setModel(new DefaultComboBoxModel(new String[] {"", "Realizar Giro", "Recibir Giro"}));
		cbxOperacion.setBounds(234, 103, 300, 30);
		cbxOperacion.addActionListener(this);
		contentPane.add(cbxOperacion);
		
		cbxMetodoPago = new JComboBox();
		cbxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"", "Efectivo", "Transferencia", "QR"}));
		cbxMetodoPago.setBounds(234, 373, 300, 30);
		cbxMetodoPago.setVisible(false);
		contentPane.add(cbxMetodoPago);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnEnviar.setBounds(544, 329, 132, 74);
		btnEnviar.addActionListener(this);
		btnEnviar.setVisible(false);
		contentPane.add(btnEnviar);
		
		btnRetirar = new JButton("Retirar");
		btnRetirar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnRetirar.addActionListener(this);
		btnRetirar.setBounds(544, 329, 132, 74);
		btnRetirar.setVisible(false);
		contentPane.add(btnRetirar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(cbxOperacion.getSelectedItem().toString().equals("Realizar Giro"))
		{
			
			lblMonto.setText("Monto a Enviar");
			lblMetodoYCodigo.setText("Metodo de Pago");
			
			lblNumeroDestino.setVisible(true);
			lblNumeroRemitente.setVisible(true);
			lblCedulaRemitente.setVisible(true);
			lblMonto.setVisible(true);
			lblMetodoYCodigo.setVisible(true);
			
			txtNumeroDestino.setVisible(true);
			txtNumeroRemitente.setVisible(true);
			txtCedulaRemitente.setVisible(true);
			txtMonto.setVisible(true);
			txtCodigo.setVisible(false);
			cbxMetodoPago.setVisible(true);
			
			btnEnviar.setVisible(true);
			btnRetirar.setVisible(false);
		}
		else if(cbxOperacion.getSelectedItem().toString().equals("Recibir Giro"))
		{
			
			lblMonto.setText("Monto a Retirar");
			lblMetodoYCodigo.setText("Codigo de Seguridad");
			
			lblNumeroDestino.setVisible(true);
			lblNumeroRemitente.setVisible(true);
			lblCedulaRemitente.setVisible(true);
			lblMonto.setVisible(true);
			lblMetodoYCodigo.setVisible(true);
			
			txtNumeroDestino.setVisible(true);
			txtNumeroRemitente.setVisible(true);
			txtCedulaRemitente.setVisible(true);
			txtMonto.setVisible(true);
			txtCodigo.setVisible(true);
			cbxMetodoPago.setVisible(false);
			
			btnEnviar.setVisible(false);
			btnRetirar.setVisible(true);
		}
		else
		{
			lblNumeroDestino.setVisible(false);
			lblNumeroRemitente.setVisible(false);
			lblCedulaRemitente.setVisible(false);
			lblMonto.setVisible(false);
			lblMetodoYCodigo.setVisible(false);
			
			txtNumeroDestino.setVisible(false);
			txtNumeroRemitente.setVisible(false);
			txtCedulaRemitente.setVisible(false);
			txtMonto.setVisible(false);
			txtCodigo.setVisible(false);
			cbxMetodoPago.setVisible(false);
			
			btnEnviar.setVisible(false);
			btnRetirar.setVisible(false);
		}
		
		if(arg0.getSource() == btnEnviar)
		{
			//Almacenamos los datos ingresados en variables para hacer mas legible el if de si esta o no vacio y su setteo en la Base de Datos
			String numDestino = txtNumeroDestino.getText();
			String numRemitente = txtNumeroRemitente.getText();
			String cedRemitente = txtCedulaRemitente.getText();
			String metPago = cbxMetodoPago.getSelectedItem().toString();
			//no hacemos aca una variable para monto porque se adquiere de manera diferente, y si esta vacio da un error distinto
			
			try {
				
				 if (numDestino.isEmpty() || numRemitente.isEmpty() || cedRemitente.isEmpty() || metPago.equals("")) {
			            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
			            return;
			        }
				
				BigDecimal monto = new BigDecimal(txtMonto.getText()); //Necesario para ingresar el valor de tipo Numeric
				
				String codSeguridad = String.valueOf((int)(Math.random() * 9000) + 1000); /* esta linea de codigo genera un numero 
				entre 1000 y 9999 usando Math.random(genera un numero entre 0 y 1), y es un String porque es un codigo que sera comparado,
				no operado, por lo tanto no es necesario su valor como una variable numerica*/
				
				Giro giro = new Giro();
				giro.setOperacion(cbxOperacion.getSelectedItem().toString());
				giro.setNumeroDestino(numDestino);
				giro.setNumeroRemitente(numRemitente);
				giro.setCedulaRemitente(cedRemitente);
				giro.setMontoGiro(monto);
				//giro.setMontoGiro(new BigDecimal(txtMontoAEnviar.getText())); //Tambien se puede hacer asi para setear el BigDecimal
				giro.setMetodoPago(metPago);
				giro.setCodigoSeguridad(codSeguridad);
				giroDAO.registrarGiro(giro);
				VentanaImprimirGiro ventanaImprimirGiro = new VentanaImprimirGiro();
				ventanaImprimirGiro.mostrarListaEnArea(giro);
				ventanaImprimirGiro.setVisible(true);
			} catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Monto no valido");
				
			} catch (SQLException e)
			{
				System.out.println("Error"); e.printStackTrace();
			}
			
		}
		
		if(arg0.getSource() == btnRetirar)
		{
			String numDestino = txtNumeroDestino.getText();
			String numRemitente = txtNumeroRemitente.getText();
			String cedRemitente = txtCedulaRemitente.getText();
			String codSeguridad = txtCodigo.getText();
			try {
				if (numDestino.isEmpty() || numRemitente.isEmpty() || cedRemitente.isEmpty() || codSeguridad.isEmpty() ) {
		            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
		            return;
		        }
				
				BigDecimal monto = new BigDecimal(txtMonto.getText());
				
				Giro giro = new Giro();
				giro.setOperacion(cbxOperacion.getSelectedItem().toString());
				giro.setNumeroDestino(numDestino);
				giro.setNumeroRemitente(numRemitente);
				giro.setCedulaRemitente(cedRemitente);
				giro.setMontoGiro(monto);
				giro.setCodigoSeguridad(codSeguridad);
				
				giroDAO.retirarGiro(giro);
			} catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Monto no valido");
				
			} catch (SQLException e)
			{
				System.out.println("Error"); e.printStackTrace();
			}
			
			
			
		}
		
	}
}
