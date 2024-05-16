package co.com.flamingo.gui;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.itextpdf.text.DocumentException;

import co.com.flamingo.utils.BarCode128Bonos;
import co.com.flamingo.utils.BarCode128List;
import co.com.flamingo.utils.BarEAN13;
import co.com.flamingo.utils.BarEAN8;
import co.com.flamingo.utils.BarUPC_A;
import co.com.flamingo.utils.BarUPC_E;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

//import com.flamingo.util.HexDump;

public class ChoosingWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtPathIn;
	private JTextField txtPathOut;
	private JTextField txtFolderBonos;
	private JTextField txtSubtitulo;
	private JTextArea txaLegales;
	private JTextArea txaCondiciones;
	private JTextArea txaMecanica;
	private JScrollPane spLegales;
	private JScrollPane spCondiciones;
	private JScrollPane spMecanica;
	JFileChooser fileChooserIn = new JFileChooser();
	JFileChooser fileChooserOut = new JFileChooser();
	JLabel lblMessage = new JLabel();
	static String sEAN13 = "EAN13";
	static String sEAN8 = "EAN8";
	static String sUPCA = "UPC-A";
	static String sUPCE = "UPC-E";
	static String sC128 = "Code 128";
	static String sBonos = "Bonos";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosingWindow window = new ChoosingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoosingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 2, 620, 755);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Lista a PDF con barras");
		frame.getContentPane().setLayout(null);

		JLabel lblIn = new JLabel("TXT File:");
		lblIn.setBounds(10, 10, 65, 20);
		txtPathIn = new JTextField();
		txtPathIn.setBounds(100, 10, 370, 23);
		frame.getContentPane().add(lblIn);
		frame.getContentPane().add(txtPathIn);
		txtPathIn.setColumns(10);

		JButton btnBrowseIn = new JButton("Explorar...");
		btnBrowseIn.setBounds(475, 10, 95, 23);
		frame.getContentPane().add(btnBrowseIn);

		JLabel lblOut = new JLabel("PDF File:");
		lblOut.setBounds(10, 55, 65, 20);
		txtPathOut = new JTextField();
		txtPathOut.setBounds(100, 55, 370, 23);
		frame.getContentPane().add(lblOut);
		frame.getContentPane().add(txtPathOut);
		txtPathOut.setColumns(10);

		JButton btnBrowseOut = new JButton("Explorar...");
		btnBrowseOut.setBounds(475, 55, 95, 23);
		frame.getContentPane().add(btnBrowseOut);
		
		JLabel lblFolderBonos = new JLabel("Folder Bonos:");
		lblFolderBonos.setBounds(10, 100, 90, 23);
		txtFolderBonos = new JTextField();
		txtFolderBonos.setBounds(100, 100, 370, 23);
		frame.getContentPane().add(lblFolderBonos);
		frame.getContentPane().add(txtFolderBonos);
		txtFolderBonos.setColumns(10);
		
		JButton btnBrowseFolderB = new JButton("Explorar...");
		btnBrowseFolderB.setBounds(475, 100, 95, 23);
		frame.getContentPane().add(btnBrowseFolderB);
		
		JRadioButton rbEAN13 = new JRadioButton(sEAN13);
		JRadioButton rbEAN8 = new JRadioButton(sEAN8);
		JRadioButton rbUPCA = new JRadioButton(sUPCA);
		JRadioButton rbUPCE = new JRadioButton(sUPCE);
		JRadioButton rbC128 = new JRadioButton(sC128);
		JRadioButton rbBono = new JRadioButton(sBonos);
		
		rbEAN13.setActionCommand(sEAN13);
		rbEAN8.setActionCommand(sEAN8);
		rbUPCA.setActionCommand(sUPCA);
		rbUPCE.setActionCommand(sUPCE);
		rbC128.setActionCommand(sC128);
		rbBono.setActionCommand(sBonos);
		
		rbEAN13.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbEAN13);
		group.add(rbEAN8);
		group.add(rbUPCA);
		group.add(rbUPCE);
		group.add(rbC128);
		group.add(rbBono);
		
		//rbEAN13.addActionListener(this);
		
		JPanel radioPanel = new JPanel(new GridLayout(1, 6));
		radioPanel.setBounds(30, 140, 570, 30);
		radioPanel.add(rbEAN13);
		radioPanel.add(rbEAN8);
		radioPanel.add(rbUPCA);
		radioPanel.add(rbUPCE);
		radioPanel.add(rbC128);
		radioPanel.add(rbBono);
		frame.getContentPane().add(radioPanel);
		
		JButton btnExport = new JButton("Exportar");
		btnExport.setBounds(140, 175, 120, 30);
		frame.getContentPane().add(btnExport);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(350, 175, 120, 30);
		frame.getContentPane().add(btnCancel);
		
		JLabel lbSubtitulo = new JLabel("Subtítulo para los bonos:");
		lbSubtitulo.setBounds(10 ,220, 250, 25);
		txtSubtitulo = new JTextField();
		txtSubtitulo.setBounds(180, 220, 390, 30);
		frame.getContentPane().add(lbSubtitulo);
		frame.getContentPane().add(txtSubtitulo);
		
		JLabel lbLegales = new JLabel("Legales para bonos:");
		lbLegales.setBounds(10, 255, 300, 25);
		frame.getContentPane().add(lbLegales);
		txaLegales = new JTextArea();
		txaLegales.setLineWrap(true);
		txaLegales.setWrapStyleWord(true);
		spLegales = new JScrollPane(txaLegales);
		spLegales.setBounds(10, 280, 560, 110);
		frame.getContentPane().add(spLegales);

		JLabel lbMecanica = new JLabel("Mecánica de redención para bonos:");
		lbMecanica.setBounds(10, 395, 300, 25);
		frame.getContentPane().add(lbMecanica);
		txaMecanica = new JTextArea();
		txaMecanica.setLineWrap(true);
		txaMecanica.setWrapStyleWord(true);
		spMecanica = new JScrollPane(txaMecanica);
		spMecanica.setBounds(10, 420, 560, 110);
		frame.getContentPane().add(spMecanica);

		JLabel lbCondiciones = new JLabel("Términos y condiciones para bonos:");
		lbCondiciones.setBounds(10, 540, 300, 25);
		frame.getContentPane().add(lbCondiciones);
		txaCondiciones = new JTextArea();
		txaCondiciones.setLineWrap(true);
		txaCondiciones.setWrapStyleWord(true);
		spCondiciones = new JScrollPane(txaCondiciones);
		spCondiciones.setBounds(10, 565, 560, 110);
		frame.getContentPane().add(spCondiciones);

		lblMessage.setText("Seleccione TXT a exportar");
		lblMessage.setHorizontalAlignment(0);
		lblMessage.setBounds(100, 685, 400, 20);
		frame.getContentPane().add(lblMessage);
		
		JLabel lblBy = new JLabel("by HHC");
		lblBy.setBounds(560, 685, 60, 20);
		frame.getContentPane().add(lblBy);

		btnBrowseIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fileChooserIn.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooserIn.setAcceptAllFileFilterUsed(false);

				int rVal = fileChooserIn.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					txtPathIn.setText(fileChooserIn.getSelectedFile().toString());
					String txtAux = fileChooserIn.getSelectedFile().toString();
					txtAux = txtAux.substring(0,txtAux.length()-3);
					txtAux = txtAux.concat("PDF");
					txtPathOut.setText(txtAux);
					txtFolderBonos.setText(fileChooserIn.getCurrentDirectory().getPath());

				}
			}
		});

		btnBrowseOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fileChooserOut.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooserOut.setAcceptAllFileFilterUsed(false);

				int rVal = fileChooserOut.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					txtPathOut.setText(fileChooserOut.getSelectedFile().toString());
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				System.exit(0);

			}
		});

		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stFileIn = txtPathIn.getText();
				String stFileOut = txtPathOut.getText();
				String stFolderBonos = txtFolderBonos.getText();
				File fFileText = new File(stFileOut);
				
				if (stFileIn.compareTo(stFileOut) == 0) {
					JOptionPane.showMessageDialog(frame, "Archivo destino debe ser diferente al origen.", "Error", JOptionPane.WARNING_MESSAGE);
					
				} else {
					
					try {
						lblMessage.setText("Generando PDF...");
						lblMessage.paintImmediately(lblMessage.getVisibleRect());
						if(rbEAN13.isSelected()){
							BarEAN13.PDFGenEAN13 (stFileOut, stFileIn);
						}
						if(rbEAN8.isSelected()){
							BarEAN8.PDFGenEAN8 (stFileOut, stFileIn);
						}
						if(rbUPCA.isSelected()){
							BarUPC_A.PDFGenUPCA (stFileOut, stFileIn);
						}
						if(rbUPCE.isSelected()){
							BarUPC_E.PDFGenUPCE (stFileOut, stFileIn);
						}
						if(rbC128.isSelected()){
							BarCode128List.BarCode128 (stFileOut, stFileIn);
						}
						if(rbBono.isSelected()){
							String legales = txaLegales.getText();
							String mecanica = txaMecanica.getText();
							String condiciones = txaCondiciones.getText();
							String subtitulo = txtSubtitulo.getText();
							stFolderBonos = BarCode128Bonos.BarCode128 (stFolderBonos, stFileIn, legales, mecanica, condiciones, subtitulo);
							fFileText = new File(stFolderBonos);
						}
						
						Desktop.getDesktop().open(fFileText);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(frame, "Error generando archivo(s)", "Error", JOptionPane.WARNING_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "Error. Revise los datos.", "Error", JOptionPane.WARNING_MESSAGE);
					} catch (DocumentException e1) {
						JOptionPane.showMessageDialog(frame, "Error. Revise los datos..", "Error", JOptionPane.WARNING_MESSAGE);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "Error. Revise los datos...", "Error", JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
					lblMessage.setText("Seleccione TLOG a exportar");
					lblMessage.paintImmediately(lblMessage.getVisibleRect());
				}


			}
		});

	}

}
