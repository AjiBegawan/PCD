package Tampilan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.filechooser.*;
import java.awt.image.*;




public class TampilanAwal extends JFrame {

	protected static final String GenerateImage = null;
	private JPanel contentPane;
	private JTextField txtSourceAddress;
	private JTextField txtFinalAddress;
	private String alamat = "null";
	private String simpan = "null";
	JFileChooser fc;
	
	 BufferedImage  image;
	   int width;
	   int height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TampilanAwal frame = new TampilanAwal();
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
	public TampilanAwal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(30, 144, 255));
		menu.setBounds(0, 0, 130, 681);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel lblmenu = new JLabel("Menu");
		lblmenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblmenu.setBackground(UIManager.getColor("text"));
		lblmenu.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblmenu.setFont(new Font("Arial", Font.PLAIN, 15));
		lblmenu.setBounds(40, 11, 50, 20);
		menu.add(lblmenu);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Kelompok 4\nDicky Febrian Dwiputra 3411181097\nAde Ridwan Nugraha 3411181117\nIndiarto Aji Begawan 3411181114");
			}
		});
		btnAbout.setBounds(10, 647, 110, 23);
		menu.add(btnAbout);
		
		JButton btnRGBtoGray = new JButton("RGB to Gray");
		btnRGBtoGray.setBackground(new Color(255, 255, 255));
		btnRGBtoGray.setBounds(10, 50, 110, 23);
		menu.add(btnRGBtoGray);
		btnRGBtoGray.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnNewButton = new JButton("Brightness");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 84, 110, 23);
		menu.add(btnNewButton);
		
		JButton btnBW = new JButton("B & W");
		btnBW.setBackground(new Color(255, 255, 255));
		btnBW.setBounds(10, 152, 110, 23);
		menu.add(btnBW);
		
		JButton btnNewButton_1_1 = new JButton("Negatif Film");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(10, 118, 110, 23);
		menu.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Kontras");
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.setBounds(10, 186, 110, 23);
		menu.add(btnNewButton_1_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("text"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(128, 0, 936, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l = new JLabel("");
		
		JPanel source = new JPanel();
		source.setBackground(new Color(255, 255, 255));
		source.setBounds(60, 100, 320, 240);
		panel.add(source);
		
		JLabel LblIS = new JLabel("");
		LblIS.setHorizontalAlignment(SwingConstants.CENTER);
		LblIS.setBounds(0, 0, 320, 240);
		source.add(LblIS);
		
		txtSourceAddress = new JTextField();
		txtSourceAddress.addMouseListener(new MouseAdapter() {
		});

		txtSourceAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtSourceAddress.setBounds(59, 389, 320, 45);
		txtSourceAddress.setColumns(10);
		panel.add(txtSourceAddress);
		
		txtFinalAddress = new JTextField();
		txtFinalAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinalAddress.setColumns(10);
		txtFinalAddress.setBounds(492, 389, 320, 45);
		panel.add(txtFinalAddress);
		
		JLabel lblRGBtoGray = new JLabel("RGB to Grayscale");
		lblRGBtoGray.setBounds(324, 11, 200, 26);
		lblRGBtoGray.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(lblRGBtoGray);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 936, 55);
		panel.add(panel_1);
		panel_1.setBackground(new Color(0, 191, 255));
		
		JPanel result = new JPanel();
		result.setBackground(new Color(255, 255, 255));
		result.setBounds(492, 104, 320, 240);
		panel.add(result);
		
		JLabel LblFS = new JLabel("");
		LblFS.setForeground(new Color(139, 69, 19));
		LblFS.setBackground(new Color(255, 255, 0));
		LblFS.setHorizontalAlignment(SwingConstants.CENTER);
		LblFS.setBounds(0, 0, 320, 240);
		result.add(LblFS);
		
		JButton btnBrowse = new JButton("Browse Source Image");
		btnBrowse.setBackground(new Color(30, 144, 255));
		btnBrowse.setForeground(Color.WHITE);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == btnBrowse) {
					 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
					  
			            // invoke the showsOpenDialog function to show the save dialog 
			            int r = j.showOpenDialog(null); 
			  
			            // if the user selects a file 
			            if (r == JFileChooser.APPROVE_OPTION) 
			  
			            { 
			                // set the label to the path of the selected file 
			            	txtSourceAddress.setText(j.getSelectedFile().getAbsolutePath()); 
			            } 
			            // if the user cancelled the operation 
			            else
			                l.setText("the user cancelled the operation"); 
			            }
			}
		});
		btnBrowse.setBounds(59, 355, 150, 25);
		panel.add(btnBrowse);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alamat = txtSourceAddress.getText();			
				simpan = txtFinalAddress.getText();
				
	
				ImageIcon gambarAwal = new ImageIcon (alamat);				
				Image ga = gambarAwal.getImage(); // transform it 
				Image newimg = ga.getScaledInstance(320, 240,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				gambarAwal = new ImageIcon(newimg);  // transform it back
				LblIS.setIcon(gambarAwal);
				
				try {
			         //File input = new File("F:\\College\\5th Semester\\Pengolahan Citra Digital\\Coklat.jpg");
					
					 File input = new File(alamat);
			         image = ImageIO.read(input);
			         width = image.getWidth();
			         height = image.getHeight();
			         
			         for(int i=0; i<height; i++) {
			         
			            for(int j=0; j<width; j++) {
			            
			               Color c = new Color(image.getRGB(j, i));
			               int red = (int)(c.getRed() * 0.299);
			               int green = (int)(c.getGreen() * 0.587);
			               int blue = (int)(c.getBlue() *0.114);
			               Color newColor = new Color(red+green+blue, red+green+blue,red+green+blue);
			               
			               image.setRGB(j,i,newColor.getRGB());
			            }
			         }
			         
			         //File ouptut = new File("F:\\College\\5th Semester\\Pengolahan Citra Digital\\TampilanHitamPutih.jpg");
			         File ouptut = new File(simpan);
			         ImageIO.write(image, "jpg", ouptut);
			         
					 ImageIcon gambarAkhir = new ImageIcon (simpan);
					 Image gak = gambarAkhir.getImage(); // transform it 
					 Image newimg2 = gak.getScaledInstance(320, 240,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					 gambarAkhir = new ImageIcon(newimg2);  // transform it back
					 LblFS.setIcon(gambarAkhir);
			      } catch (Exception e) {}

			}
		});
		btnConvert.setBounds(492, 355, 150, 25);
		panel.add(btnConvert);
		
		JLabel lblSource = new JLabel("Source Image");
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource.setBounds(168, 74, 100, 20);
		panel.add(lblSource);
		
		JLabel lblResult = new JLabel("Result Image");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(604, 78, 100, 20);
		panel.add(lblResult);
		
		JButton btnLoad = new JButton("Load Image");
		btnLoad.setForeground(new Color(255, 255, 255));
		btnLoad.setBackground(new Color(30, 144, 255));
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alamat = txtSourceAddress.getText();			
				
				ImageIcon gambarAwal = new ImageIcon (alamat);				
				Image ga = gambarAwal.getImage(); // transform it 
				Image newimg = ga.getScaledInstance(320, 240,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				gambarAwal = new ImageIcon(newimg);  // transform it back
				LblIS.setIcon(gambarAwal);
							
			}
		});
		btnLoad.setBounds(229, 355, 150, 25);
		panel.add(btnLoad);
		
		JButton btnSave = new JButton("Save As");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create an object of JFileChooser class 
				JFileChooser js = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

				// invoke the showsSaveDialog function to show the save dialog 
				int r = js.showSaveDialog(null); 

				// if the user selects a file 
				if (r == JFileChooser.APPROVE_OPTION) 

				{ 
					// set the label to the path of the selected file 
					txtFinalAddress.setText(js.getSelectedFile().getAbsolutePath()); 
				} 
				// if the user cancelled the operation 
				else
					l.setText("the user cancelled the operation"); 
			}
		});
		btnSave.setBounds(662, 353, 150, 25);
		panel.add(btnSave);
	}
}
