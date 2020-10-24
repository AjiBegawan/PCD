package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
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
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(102, 204, 255));
		menu.setBounds(0, 0, 120, 461);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel lblmenu = new JLabel("Menu");
		lblmenu.setBackground(UIManager.getColor("text"));
		lblmenu.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblmenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblmenu.setBounds(39, 11, 46, 14);
		menu.add(lblmenu);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Kelompok 4\nDicky Febrian Dwiputra 3411181097\nAde Ridwan Nugraha 3411181117\nIndiarto Aji Begawan 3411181114");
			}
		});
		btnAbout.setBounds(15, 427, 89, 23);
		menu.add(btnAbout);
		
		JButton btnRGBtoGray = new JButton("RGB to Gray");
		btnRGBtoGray.setBounds(5, 50, 109, 23);
		menu.add(btnRGBtoGray);
		btnRGBtoGray.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("text"));
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(122, 0, 862, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l = new JLabel("");
		
		JPanel source = new JPanel();
		source.setBounds(59, 104, 320, 240);
		panel.add(source);
		
		JLabel LblIS = new JLabel("");
		LblIS.setHorizontalAlignment(SwingConstants.CENTER);
		LblIS.setBounds(0, 0, 320, 240);
		source.add(LblIS);
		
		txtSourceAddress = new JTextField();
		txtSourceAddress.addMouseListener(new MouseAdapter() {
		});

		txtSourceAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtSourceAddress.setBounds(69, 389, 300, 45);
		txtSourceAddress.setColumns(10);
		panel.add(txtSourceAddress);
		
		txtFinalAddress = new JTextField();
		txtFinalAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinalAddress.setColumns(10);
		txtFinalAddress.setBounds(501, 389, 300, 45);
		panel.add(txtFinalAddress);
		
		JLabel lblRGBtoGray = new JLabel("True Color to Gray");
		lblRGBtoGray.setBounds(357, 5, 162, 26);
		lblRGBtoGray.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panel.add(lblRGBtoGray);
		
		JPanel result = new JPanel();
		result.setBounds(492, 104, 320, 240);
		panel.add(result);
		
		JLabel LblFS = new JLabel("");
		LblFS.setForeground(new Color(139, 69, 19));
		LblFS.setBackground(new Color(255, 255, 0));
		LblFS.setHorizontalAlignment(SwingConstants.CENTER);
		LblFS.setBounds(0, 0, 320, 240);
		result.add(LblFS);
		
		JButton btnBrowse = new JButton("Browse");
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
		btnBrowse.setBounds(59, 355, 106, 23);
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
		btnConvert.setBounds(393, 238, 89, 23);
		panel.add(btnConvert);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(194, 79, 46, 14);
		panel.add(lblSource);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(634, 79, 46, 14);
		panel.add(lblResult);
		
		JButton btnLoad = new JButton("Load Image");
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
		btnLoad.setBounds(273, 355, 106, 23);
		panel.add(btnLoad);
	}
}
