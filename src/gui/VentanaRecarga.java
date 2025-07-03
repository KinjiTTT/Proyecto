package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Recarga;
import dao.RecargaDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaRecarga extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMontoARecargar;
	private JTextField txtNumeroDeTelefono;
	private JLabel lblNewLabel;
	private JButton btnCargar;
	private JComboBox cbxCompaniaTelefonica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecarga frame = new VentanaRecarga();
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
	public VentanaRecarga() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 200, 720, 480);
		setResizable(false);
		
		inciarComponentes();

	}

	private void inciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Recarga de Saldo");
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Swis721 BlkEx BT", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 704, 97);
		contentPane.add(lblTitulo);
		
		JLabel lblCompaniaTelefonica = new JLabel("Compania Telefonica");
		lblCompaniaTelefonica.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompaniaTelefonica.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblCompaniaTelefonica.setBounds(10, 139, 214, 47);
		contentPane.add(lblCompaniaTelefonica);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de Telefono");
		lblNumeroDeTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTelefono.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNumeroDeTelefono.setBounds(10, 184, 214, 47);
		contentPane.add(lblNumeroDeTelefono);
		
		JLabel lblMonto = new JLabel("Monto a Recargar");
		lblMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonto.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblMonto.setBounds(10, 229, 214, 47);
		contentPane.add(lblMonto);
		
		txtMontoARecargar = new JTextField();
		txtMontoARecargar.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtMontoARecargar.setColumns(10);
		txtMontoARecargar.setBounds(234, 238, 300, 30);
		contentPane.add(txtMontoARecargar);
		
		txtNumeroDeTelefono = new JTextField();
		txtNumeroDeTelefono.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtNumeroDeTelefono.setColumns(10);
		txtNumeroDeTelefono.setBounds(234, 193, 300, 30);
		contentPane.add(txtNumeroDeTelefono);
		
		lblNewLabel = new JLabel("Datos del receptor");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNewLabel.setBounds(261, 108, 188, 30);
		contentPane.add(lblNewLabel);
		
		btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(this);
		btnCargar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnCargar.setBounds(66, 366, 158, 49);
		contentPane.add(btnCargar);
		
		cbxCompaniaTelefonica = new JComboBox();
		cbxCompaniaTelefonica.setModel(new DefaultComboBoxModel(new String[] {"", "Personal", "Tigo", "Claro"}));
		cbxCompaniaTelefonica.setBounds(234, 148, 300, 30);
		contentPane.add(cbxCompaniaTelefonica);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCargar)
		{
			cargarSaldo();
		}
		
	}

	private void cargarSaldo() {
		Recarga nuevarecarga = new Recarga();
		//Almacenamos los datos ingresados en variables para que sea mas legible
		String compTelefonica = cbxCompaniaTelefonica.getSelectedItem().toString();
		String numTelefono = txtNumeroDeTelefono.getText();
		
		try {
			if (numTelefono.isEmpty() || compTelefonica.equals("")) {
	            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
	            return;
	        }
			BigDecimal montoRecarga = new BigDecimal(txtMontoARecargar.getText());
			nuevarecarga.setCompaniaTelefonica(compTelefonica);
			nuevarecarga.setNumeroDeTelefono(numTelefono);
			nuevarecarga.setMontoRecarga(montoRecarga);
			RecargaDAO recargaDAO = new RecargaDAO();
			recargaDAO.registrarRecarga(nuevarecarga);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Monto no valido");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
