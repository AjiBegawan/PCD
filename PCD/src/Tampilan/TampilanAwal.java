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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.filechooser.*;
import java.awt.image.*;




public class TampilanAwal extends JFrame {

	private JPanel contentPane;
	JFileChooser fc;

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
		//BufferedImage img = ImageIO.read("java.png")
		
		JPanel source = new JPanel() {
		//	protected void paint
		};
		source.setBounds(59, 130, 320, 240);
		panel.add(source);
		
		JLabel lblRGBtoGray = new JLabel("True Color to Gray");
		lblRGBtoGray.setBounds(357, 5, 162, 26);
		lblRGBtoGray.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		panel.add(lblRGBtoGray);
		
		JPanel result = new JPanel();
		result.setBounds(495, 130, 320, 240);
		panel.add(result);
		
		JButton btnLoadImage = new JButton("Load Image");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == btnLoadImage) {
					 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
					  
			            // invoke the showsOpenDialog function to show the save dialog 
			            int r = j.showOpenDialog(null); 
			  
			            // if the user selects a file 
			            if (r == JFileChooser.APPROVE_OPTION) 
			  
			            { 
			                // set the label to the path of the selected file 
			                l.setText(j.getSelectedFile().getAbsolutePath()); 
			            } 
			            // if the user cancelled the operation 
			            else
			                l.setText("the user cancelled the operation"); 
			            }
			}
		});
		btnLoadImage.setBounds(159, 381, 106, 23);
		panel.add(btnLoadImage);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConvert.setBounds(393, 238, 89, 23);
		panel.add(btnConvert);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(194, 105, 46, 14);
		panel.add(lblSource);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(636, 105, 46, 14);
		panel.add(lblResult);
	}
	
}
