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

import com.itextpdf.text.DocumentException;

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

//import com.flamingo.util.HexDump;

public class ChoosingWindow {
	private JFrame frame;
	private JTextField txtPathIn;
	private JTextField txtPathOut;
	JFileChooser fileChooserIn = new JFileChooser();
	JFileChooser fileChooserOut = new JFileChooser();
	JLabel lblMessage = new JLabel();
	static String sEAN13 = "EAN13";
	static String sEAN8 = "EAN8";
	static String sUPCA = "UPC-A";
	static String sUPCE = "UPC-E";
	static String sC128 = "Code 128";

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
		frame.setBounds(100, 100, 600, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Lista a PDF con barras");
		frame.getContentPane().setLayout(null);

		JLabel lblIn = new JLabel("TXT File:");
		lblIn.setBounds(10, 20, 65, 20);
		txtPathIn = new JTextField();
		txtPathIn.setBounds(80, 20, 390, 23);
		frame.getContentPane().add(lblIn);
		frame.getContentPane().add(txtPathIn);
		txtPathIn.setColumns(10);

		JButton btnBrowseIn = new JButton("Explorar...");
		btnBrowseIn.setBounds(475, 20, 95, 23);
		frame.getContentPane().add(btnBrowseIn);

		JLabel lblOut = new JLabel("PDF File:");
		lblOut.setBounds(10, 70, 65, 20);
		txtPathOut = new JTextField();
		txtPathOut.setBounds(80, 70, 390, 23);
		frame.getContentPane().add(lblOut);
		frame.getContentPane().add(txtPathOut);
		txtPathOut.setColumns(10);

		JButton btnBrowseOut = new JButton("Explorar...");
		btnBrowseOut.setBounds(475, 70, 95, 23);
		frame.getContentPane().add(btnBrowseOut);
		
		JRadioButton rbEAN13 = new JRadioButton(sEAN13);
		JRadioButton rbEAN8 = new JRadioButton(sEAN8);
		JRadioButton rbUPCA = new JRadioButton(sUPCA);
		JRadioButton rbUPCE = new JRadioButton(sUPCE);
		JRadioButton rbC128 = new JRadioButton(sC128);
		
		rbEAN13.setActionCommand(sEAN13);
		rbEAN8.setActionCommand(sEAN8);
		rbUPCA.setActionCommand(sUPCA);
		rbUPCE.setActionCommand(sUPCE);
		rbC128.setActionCommand(sC128);
		
		rbEAN13.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbEAN13);
		group.add(rbEAN8);
		group.add(rbUPCA);
		group.add(rbUPCE);
		group.add(rbC128);
		
		//rbEAN13.addActionListener(this);
		
		JPanel radioPanel = new JPanel(new GridLayout(1, 5));
		radioPanel.setBounds(75, 110, 400, 30);
		radioPanel.add(rbEAN13);
		radioPanel.add(rbEAN8);
		radioPanel.add(rbUPCA);
		radioPanel.add(rbUPCE);
		radioPanel.add(rbC128);
		frame.getContentPane().add(radioPanel);
		
		JButton btnExport = new JButton("Exportar");
		btnExport.setBounds(140, 160, 120, 30);
		frame.getContentPane().add(btnExport);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(350, 160, 120, 30);
		frame.getContentPane().add(btnCancel);

		lblMessage.setText("Seleccione TXT a exportar");
		lblMessage.setHorizontalAlignment(0);
		lblMessage.setBounds(100, 215, 400, 20);
		frame.getContentPane().add(lblMessage);
		
		JLabel lblBy = new JLabel("by HHC");
		lblBy.setBounds(540, 222, 60, 20);
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
						
						Desktop.getDesktop().open(fFileText);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(frame, "Archivo seleccionado no existe.", "Error", JOptionPane.WARNING_MESSAGE);
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
