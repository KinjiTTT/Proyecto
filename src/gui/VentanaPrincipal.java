package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnGiro;
	private JButton btnSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1080, 720);
		setSize(1080,720);
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Giros y Recargas");
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Swis721 BlkEx BT", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 1064, 97);
		contentPane.add(lblTitulo);
		
		JLabel lblOperacionARealizar = new JLabel("Operacion a Realizar");
		lblOperacionARealizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacionARealizar.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 20));
		lblOperacionARealizar.setBounds(425, 123, 214, 47);
		contentPane.add(lblOperacionARealizar);
		
		btnGiro = new JButton("Giro");
		btnGiro.setFont(new Font("Arial", Font.PLAIN, 35));
		btnGiro.setBounds(95, 196, 405, 350);
		btnGiro.addActionListener(this);
		contentPane.add(btnGiro);
		
		btnSaldo = new JButton("Recarga de Saldo");
		btnSaldo.setFont(new Font("Arial", Font.PLAIN, 35));
		btnSaldo.setBounds(563, 196, 405, 350);
		btnSaldo.addActionListener(this);
		contentPane.add(btnSaldo);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnGiro)
		{
			VentanaGiro ventanaGiro = new VentanaGiro();
			ventanaGiro.setVisible(true);
		}
		else if(arg0.getSource() == btnSaldo)
		{
			VentanaRecarga ventanaSaldo = new VentanaRecarga();
			ventanaSaldo.setVisible(true);
		}
		
	}
}
