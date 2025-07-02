package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class VentanaRecarga extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMontoARecargar;
	private JTextField txtCompania;
	private JTextField txtNumero;
	private JLabel lblNewLabel;
	private JButton btnCargar;

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
		lblCompaniaTelefonica.setBounds(10, 184, 214, 47);
		contentPane.add(lblCompaniaTelefonica);
		
		JLabel lblNumero = new JLabel("Numero de Telefono");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNumero.setBounds(10, 139, 214, 47);
		contentPane.add(lblNumero);
		
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
		
		txtCompania = new JTextField();
		txtCompania.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtCompania.setColumns(10);
		txtCompania.setBounds(234, 193, 300, 30);
		contentPane.add(txtCompania);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(234, 148, 300, 30);
		contentPane.add(txtNumero);
		
		lblNewLabel = new JLabel("Datos del receptor");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblNewLabel.setBounds(261, 108, 188, 30);
		contentPane.add(lblNewLabel);
		
		btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(this);
		btnCargar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		btnCargar.setBounds(66, 366, 158, 49);
		contentPane.add(btnCargar);
		
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
		nuevarecarga.setNumeroDeTelefono(txtNumero.getText());
		nuevarecarga.setCompaniaTelefonica(Integer.parseInt(txtCompania.getText()));
		nuevarecarga.setMontoRecarga(new BigDecimal(txtMontoARecargar.getText()));
		RecargaDAO recargaDAO = new RecargaDAO();
		try {
			recargaDAO.registrarRecarga(nuevarecarga);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
