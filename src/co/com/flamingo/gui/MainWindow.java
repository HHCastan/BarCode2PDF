package co.com.flamingo.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainWindow {

	private JFrame frmFrame;
	private JTextField txtPathIn;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtFileOut;
	private JTextField txtFolderOut;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrame = new JFrame();
		frmFrame.setTitle("PDF con códigos de barra a partir de lista");
		frmFrame.setBounds(100, 100, 811, 607);
		frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrame.getContentPane().setLayout(null);
		
		JLabel lblIn = new JLabel("TXT File:");
		lblIn.setBounds(10, 11, 46, 14);
		frmFrame.getContentPane().add(lblIn);
		
		txtPathIn = new JTextField();
		txtPathIn.setBounds(66, 8, 418, 20);
		frmFrame.getContentPane().add(txtPathIn);
		txtPathIn.setColumns(10);
		
		JButton btnBrowseIn = new JButton("Explorar...");
		btnBrowseIn.setBounds(494, 7, 89, 23);
		frmFrame.getContentPane().add(btnBrowseIn);
		
		JRadioButton rbUnicoArchivo = new JRadioButton("Único archivo con todo:");
		rbUnicoArchivo.setSelected(true);
		buttonGroup_1.add(rbUnicoArchivo);
		rbUnicoArchivo.setBounds(10, 46, 152, 23);
		frmFrame.getContentPane().add(rbUnicoArchivo);
		
		JRadioButton rbMultiplesArchivos = new JRadioButton("Múltiples archivos tipo Voucher:");
		buttonGroup_1.add(rbMultiplesArchivos);
		rbMultiplesArchivos.setBounds(10, 78, 185, 23);
		frmFrame.getContentPane().add(rbMultiplesArchivos);
		
		txtFileOut = new JTextField();
		txtFileOut.setBounds(195, 47, 289, 20);
		frmFrame.getContentPane().add(txtFileOut);
		txtFileOut.setColumns(10);
		
		JButton btnBrowseFileOut = new JButton("Explorar...");
		btnBrowseFileOut.setBounds(494, 46, 89, 23);
		frmFrame.getContentPane().add(btnBrowseFileOut);
		
		txtFolderOut = new JTextField();
		txtFolderOut.setBounds(195, 79, 289, 20);
		frmFrame.getContentPane().add(txtFolderOut);
		txtFolderOut.setColumns(10);
		
		JButton btnBrowseFolderOut = new JButton("Carpeta...");
		btnBrowseFolderOut.setBounds(494, 78, 89, 23);
		frmFrame.getContentPane().add(btnBrowseFolderOut);
		
		JRadioButton rbEAN13 = new JRadioButton("EAN13");
		buttonGroup.add(rbEAN13);
		rbEAN13.setBounds(19, 126, 109, 23);
		frmFrame.getContentPane().add(rbEAN13);
		
		JRadioButton rbEAN8 = new JRadioButton("EAN8");
		buttonGroup.add(rbEAN8);
		rbEAN8.setBounds(19, 152, 109, 23);
		frmFrame.getContentPane().add(rbEAN8);
		
		JRadioButton rbUPCA = new JRadioButton("UPC-A");
		buttonGroup.add(rbUPCA);
		rbUPCA.setBounds(19, 178, 109, 23);
		frmFrame.getContentPane().add(rbUPCA);
		
		JRadioButton rbUPCE = new JRadioButton("UPC-E");
		buttonGroup.add(rbUPCE);
		rbUPCE.setBounds(19, 204, 109, 23);
		frmFrame.getContentPane().add(rbUPCE);
		
		JRadioButton rbC128 = new JRadioButton("Code 128");
		rbC128.setSelected(true);
		buttonGroup.add(rbC128);
		rbC128.setBounds(19, 230, 109, 23);
		frmFrame.getContentPane().add(rbC128);
	}
}
