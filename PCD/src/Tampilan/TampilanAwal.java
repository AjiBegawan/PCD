package Tampilan;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import javax.swing.filechooser.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;

import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;

//import pcd.Histogram.VisibleAction;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.Box;
import javax.swing.border.BevelBorder;

public class TampilanAwal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String GenerateImage = null;
	private JPanel contentPane;
	private JTextField txtSourceAddress;
	private JTextField txtFinalAddress;
	private String alamat = "null";
	private String simpan = "null";
	private String simpanHRed = "null";

	// Inisialisasi False untuk menu
	private boolean rgbtogray = false;
	private boolean brightness = false;
	private boolean negatif = false;
	private boolean bandw = false;
	private boolean kontras = false;
	private boolean translasi = false;
	private boolean flipping = false;
	private boolean cropping = false;
	private boolean rotation = false;
	private boolean scalling = false;
	private boolean smoothing = false;
	private boolean sharpening = false;
	private boolean edge = false;
	private boolean histogrameq = false;

	// inisialisasi false untuk flipping
	private boolean vertikal = true;
	private boolean horizontal = false;

	// inisisalisasi false untuk rotate
	private boolean rotatekanan = true;
	private boolean rotatekiri = false;

	// inisisalisasi false untuk rotate
	private boolean scallingbesar = true;
	private boolean scallingkecil = false;
	
	//smoothing
	int[][][] rgb_buffer;

	private boolean setFinalAddress = false;
	final JSlider sliderBrightness = new JSlider(0, 510, 255);
	int nilaiBrightness;

	JFileChooser fc;

	BufferedImage image;
	BufferedImage imagebaru;
	
	int width;
	int height;
	private JTextField FieldContras;
	private JTextField FieldTranslasiM;
	private JTextField FieldTranslasiN;
	private JTextField FieldCroppingX;
	private JTextField FieldCroppingY;
	private JTextField FieldCroppingpixelX;
	private JTextField FieldCroppingpixelY;
	
	private static final int BINS = 256;
	protected static final Component NullPointerException = null;
    private HistogramDataset dataset;
    private XYBarRenderer renderer;
    ChartPanel panel;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\UNJANI\\Gambar\\lunjani.png"));
		setTitle("KELOMPOK 4 (PCD)");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 742);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel menu = new JPanel();
		menu.setForeground(new Color(0, 0, 0));
		menu.setBackground(new Color(30, 144, 255));
		menu.setBounds(0, 0, 150, 703);
		contentPane.add(menu);
		menu.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("text"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(160, 0, 1199, 703);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		panel_1.setBounds(-22, 0, 1221, 55);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

		JLabel l = new JLabel("");

		JPanel source = new JPanel();
		source.setBackground(new Color(255, 255, 255));
		source.setBounds(40, 104, 400, 400);
		panel.add(source);

		JLabel LblIS = new JLabel("");
		LblIS.setHorizontalAlignment(SwingConstants.CENTER);
		LblIS.setBounds(0, 0, 320, 240);
		source.add(LblIS);

		txtSourceAddress = new JTextField();
		txtSourceAddress.addMouseListener(new MouseAdapter() {
		});

		txtSourceAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtSourceAddress.setBounds(40, 604, 400, 45);
		txtSourceAddress.setColumns(10);
		panel.add(txtSourceAddress);

		txtFinalAddress = new JTextField();
		txtFinalAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinalAddress.setColumns(10);
		txtFinalAddress.setBounds(475, 604, 400, 45);
		panel.add(txtFinalAddress);

		JPanel result = new JPanel();
		result.setBackground(new Color(255, 255, 255));
		result.setBounds(475, 104, 400, 400);
		panel.add(result);

		JLabel LblFS = new JLabel("");
		LblFS.setForeground(new Color(139, 69, 19));
		LblFS.setBackground(new Color(255, 255, 0));
		LblFS.setHorizontalAlignment(SwingConstants.CENTER);
		LblFS.setBounds(0, 0, 320, 240);
		result.add(LblFS);

		JButton btnBrowse = new JButton("Browse Image Address");
		btnBrowse.setBackground(new Color(60, 179, 113));
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
				alamat = txtSourceAddress.getText();

				ImageIcon gambarAwal = new ImageIcon(alamat);
				Image ga = gambarAwal.getImage(); // transform it
				Image newimg = ga.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				gambarAwal = new ImageIcon(newimg); // transform it back
				LblIS.setIcon(gambarAwal);
			}
		});
		btnBrowse.setBounds(154, 558, 175, 35);
		panel.add(btnBrowse);

		JButton btnConvert = new JButton("Convert & Save");
		btnConvert.setForeground(new Color(255, 255, 255));
		btnConvert.setBackground(new Color(30, 144, 255));
		btnConvert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alamat = txtSourceAddress.getText();
				// set path default
				if (!setFinalAddress) {
					StringBuffer str = new StringBuffer(txtSourceAddress.getText());
					if (rgbtogray) {
						str.insert(str.length() - 4, "Gray");
					}
					;
					if (brightness) {
						str.insert(str.length() - 4, "Brightness");
					}
					;
					if (negatif) {
						str.insert(str.length() - 4, "Negative");
					}
					;
					if (bandw) {
						str.insert(str.length() - 4, "B&W");
					}
					;
					if (kontras) {
						str.insert(str.length() - 4, "Kontras");
					}
					if (translasi) {
						str.insert(str.length() - 4, "Translasi");
					}
					;
					if (flipping) {
						str.insert(str.length() - 4, "Flipping");
					}
					;
					if (cropping) {
						str.insert(str.length() - 4, "Cropping");
					}
					;
					if (rotation) {
						str.insert(str.length() - 4, "Rotation");
					}
					;
					if (scalling) {
						str.insert(str.length() - 4, "Scalling");
					}
					;
					if (smoothing) {
						str.insert(str.length() - 4, "Smoothing");
					}
					;
					if (sharpening) {
						str.insert(str.length() - 4, "Sharpening");
					}
					;
					if (edge) {
						str.insert(str.length() - 4, "Edge");
					}
					;
					if (histogrameq) {
						str.insert(str.length() - 4, "Equalization");
					}
					;
					txtFinalAddress.setText(str.toString());
				}
				;
				simpan = txtFinalAddress.getText();

				ImageIcon gambarAwal = new ImageIcon(alamat);
				Image ga = gambarAwal.getImage(); // transform it
				Image newimg = ga.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				gambarAwal = new ImageIcon(newimg); // transform it back
				LblIS.setIcon(gambarAwal);

				try {
					if (rgbtogray) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();

						for (int i = 0; i < height; i++) {

							for (int j = 0; j < width; j++) {

								Color c = new Color(image.getRGB(j, i));
								int red = (int) (c.getRed() * 0.299);
								int green = (int) (c.getGreen() * 0.587);
								int blue = (int) (c.getBlue() * 0.114);
								Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);

								image.setRGB(j, i, newColor.getRGB());
							}
						}
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					if (brightness) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();

						for (int i = 0; i < height; i++) {

							for (int j = 0; j < width; j++) {

								Color c = new Color(image.getRGB(j, i));
								int red = c.getRed();
								red = red + nilaiBrightness;
								if (red > 255) {
									red = 255;
								}
								;
								if (red < 0) {
									red = 0;
								}
								;
								int green = c.getGreen();
								green = green + nilaiBrightness;
								if (green > 255) {
									green = 255;
								}
								;
								if (green < 0) {
									green = 0;
								}
								;
								int blue = c.getBlue();
								blue = blue + nilaiBrightness;
								if (blue > 255) {
									blue = 255;
								}
								;
								if (blue < 0) {
									blue = 0;
								}
								;

								Color newColor = new Color(red, green, blue);

								image.setRGB(j, i, newColor.getRGB());
							}
						}
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					if (negatif) {

						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();

						for (int i = 0; i < height; i++) {

							for (int j = 0; j < width; j++) {

								Color c = new Color(image.getRGB(j, i));
								int red = (int) (255 - c.getRed());
								int green = (int) (255 - c.getGreen());
								int blue = (int) (255 - c.getBlue());

								Color newColor = new Color(red, green, blue);

								image.setRGB(j, i, newColor.getRGB());
							}
						}
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					if (bandw) {

						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						int th = 127;

						for (int i = 0; i < height; i++) {
							for (int j = 0; j < width; j++) {
								Color c = new Color(image.getRGB(j, i));
								int red = (int) (c.getRed());
								int green = (int) (c.getGreen());
								int blue = (int) (c.getBlue());
								int sum = (red + green + blue) / 3;
								if (sum >= th) {
									sum = 255;
								} else {
									sum = 0;
								}

								Color newColor = new Color(sum, sum, sum);

								image.setRGB(j, i, newColor.getRGB());
							}
						}
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;
					if (kontras) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						float nilai;
						String wadah;
						wadah = FieldContras.getText();
						nilai = Float.parseFloat(wadah);
						nilai = nilai / 100;
						RescaleOp rescaleOp = new RescaleOp(nilai, 15, null);
						
						rescaleOp.filter(image, image); // Source and destination are the same.
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					// translasi
					if (translasi) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						imagebaru = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						String wadahM, wadahN;
						int nilaiM, nilaiN, red, green, blue;

						wadahM = FieldTranslasiM.getText();
						wadahN = FieldTranslasiN.getText();
						nilaiM = Integer.parseInt(wadahM);
						nilaiN = Integer.parseInt(wadahN);

						for (int i = 0; i < height; i++) {

							for (int j = 0; j < width; j++) {

								if ((j > nilaiN) && (i > nilaiM)) {
									Color c = new Color(image.getRGB(j - nilaiN, i - nilaiM));
									red = (int) (c.getRed());
									green = (int) (c.getGreen());
									blue = (int) (c.getBlue());
								} else {
									red = 0;
									green = 0;
									blue = 0;
								}

								Color newColor = new Color(red, green, blue);
								imagebaru.setRGB(j, i, newColor.getRGB());
							}
						}

						File ouptut = new File(simpan);
						ImageIO.write(imagebaru, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					// flip
					if (flipping) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						imagebaru = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						int i, j, k;

						if (vertikal) {
							k = height - 1;
							for (i = 0; i < height; i++) {

								for (j = 0; j < width; j++) {

									Color c = new Color(image.getRGB(j, i));
									int red = (int) (c.getRed());
									int green = (int) (c.getGreen());
									int blue = (int) (c.getBlue());
									Color newColor = new Color(red, green, blue);
									imagebaru.setRGB(j, k, newColor.getRGB());
								}
								k--;
							}
						}
						if (horizontal) {

							for (i = 0; i < height; i++) {
								k = width - 1;
								for (j = 0; j < width; j++) {

									Color c = new Color(image.getRGB(j, i));
									int red = (int) (c.getRed());
									int green = (int) (c.getGreen());
									int blue = (int) (c.getBlue());
									Color newColor = new Color(red, green, blue);
									imagebaru.setRGB(k, i, newColor.getRGB());
									k--;
								}

							}
						}

						File ouptut = new File(simpan);
						ImageIO.write(imagebaru, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					// rotasi
					if (rotation) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						imagebaru = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();

						int j, k, i, red, green, blue;
						if (rotatekanan) {
							k = height - 1;
							for (i = 0; i < height; i++) {

								for (j = 0; j < width; j++) {

									Color c = new Color(image.getRGB(j, i));
									red = (int) (c.getRed());
									green = (int) (c.getGreen());
									blue = (int) (c.getBlue());

									Color newColor = new Color(red, green, blue);
									imagebaru.setRGB(k, j, newColor.getRGB());

								}
								k--;
							}
						}
						if (rotatekiri) {

							for (i = 0; i < height; i++) {
								k = height - 1;
								for (j = 0; j < width; j++) {

									Color c = new Color(image.getRGB(j, i));
									red = (int) (c.getRed());
									green = (int) (c.getGreen());
									blue = (int) (c.getBlue());

									Color newColor = new Color(red, green, blue);
									imagebaru.setRGB(i, k, newColor.getRGB());
									k--;
								}

							}
						}

						File ouptut = new File(simpan);
						ImageIO.write(imagebaru, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					// cropping
					if (cropping) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						String wadahX, wadahY, wadahpixelX, wadahpixelY;
						int nilaiX, nilaiY, nilaipixelX, nilaipixelY;

						wadahX = FieldCroppingX.getText();
						wadahY = FieldCroppingY.getText();
						nilaiX = Integer.parseInt(wadahX);
						nilaiY = Integer.parseInt(wadahY);

						wadahpixelX = FieldCroppingpixelX.getText();
						wadahpixelY = FieldCroppingpixelY.getText();
						nilaipixelX = Integer.parseInt(wadahpixelX);
						nilaipixelY = Integer.parseInt(wadahpixelY);

						imagebaru = image.getSubimage(nilaiX, nilaiY, nilaipixelX, nilaipixelY);

						File ouptut = new File(simpan);
						ImageIO.write(imagebaru, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;

					// scalling
					if (scalling) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();

						if (scallingbesar) {
							ImageIcon scalegambar = new ImageIcon(alamat);
							Image amsclagegam = scalegambar.getImage();
							Image akhirgambar = amsclagegam.getScaledInstance(4000, 4000, java.awt.Image.SCALE_SMOOTH);
							Image akhirscalegambar = new ImageIcon(akhirgambar).getImage();

							imagebaru = new BufferedImage(akhirgambar.getWidth(null), akhirgambar.getHeight(null),
									BufferedImage.TYPE_INT_RGB);
							Graphics gambarakhir = imagebaru.createGraphics();
							gambarakhir.drawImage(akhirscalegambar, 0, 0, null);
							gambarakhir.dispose();
						}
						if (scallingkecil) {
							ImageIcon scalegambar = new ImageIcon(alamat);
							Image amsclagegam = scalegambar.getImage();
							Image akhirgambar = amsclagegam.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
							Image akhirscalegambar = new ImageIcon(akhirgambar).getImage();

							imagebaru = new BufferedImage(akhirgambar.getWidth(null), akhirgambar.getHeight(null),
									BufferedImage.TYPE_INT_RGB);
							Graphics gambarakhir = imagebaru.createGraphics();
							gambarakhir.drawImage(akhirscalegambar, 0, 0, null);
							gambarakhir.dispose();
						}

						File ouptut = new File(simpan);
						ImageIO.write(imagebaru, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					}
					;
					//Smoothing
					if (smoothing) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						Color c[];
						
						BufferedImage im = ImageIO.read(input);
						
					    BufferedImage bi = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
					    int i = 0;
					    int max = 49, radius = 3;
					    int a1 = 0, r1 = 0, g1 = 0, b1 = 0,t=0;
					    c = new Color[max];
					    float xx[] = {1,1,1,1,1,1,1,
					                  1,3,3,3,3,3,1,
					                  1,3,4,4,4,3,1,
					                  1,3,4,15,4,3,1,
					                  1,3,4,4,4,3,1,
					                  1,3,3,3,3,3,1,
					                  1,1,1,1,1,1,1,
					    };			    
					    float h=0;
					    for(t=0;t<xx.length;t++){
					        h+=xx[t];
					    }
					    int x = 1, y = 1, x1, y1, d = 0;
					    for (x = radius;x < im.getHeight()- radius; x++) {
					        for (y = radius; y < im.getWidth() - radius; y++) {

					            for (x1 = x - radius; x1 <= x + radius; x1++) {
					                for (y1 = y - radius; y1 <= y + radius; y1++) {
					                    c[i] = new Color(im.getRGB(y1, x1));
					                    i++;
					                }
					            }
					            i = 0;
					            for (d = 0; d < max; d++) {
					                float o = xx[d] * c[d].getAlpha();
					                a1 = (int) (a1 + o);
					            }
					            a1 = (int) (a1 / h);

					            for (d = 0; d < max; d++) {
					                float o = xx[d] * c[d].getRed();
					                r1 = (int) (r1 + o);
					            }
					            r1 = (int) (r1 / h);

					            for (d = 0; d < max; d++) {
					                float o = xx[d] * c[d].getGreen();
					                g1 = (int) (g1 + o);
					            }
					            g1 = (int) (g1 / h);
					            //System.out.println(g1);
					            for (d = 0; d < max; d++) {
					                float o = xx[d] * c[d].getBlue();
					                //System.out.println(o);
					                b1 = (int) (b1 + o);
					            }
					            b1 = (int) (b1 / h);
					            int sum1 = (r1 << 16) + (g1 << 8) + b1;
					            bi.setRGB(y, x, sum1);
					            r1 = g1 = b1 = 0;
					        }
					    }
								
						File ouptut = new File(simpan);
						ImageIO.write(bi, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					};
					
					//Sharpening
					if (sharpening) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						
						BufferedImage image = ImageIO.read(input);
						
						BufferedImage bufferedImage = new BufferedImage(200, 200,
						        BufferedImage.TYPE_BYTE_INDEXED);

						    // Kernel for Sharping
						    Kernel kernel = new Kernel(3, 3, 
						    				new float[] { 	-1, -1, -1, 
						    								-1, 9, -1, 
						    								-1, -1, -1 });
						
						    // Kernal for Edge Detection
//						    Kernel kernel = new Kernel(3, 3, 
//				    				new float[] { 	-1, -1, -1, 
//				    								-1, 8, -1, 
//				    								-1, -1, -1 });
						    
						    BufferedImageOp op = new ConvolveOp(kernel);
						    bufferedImage = op.filter(image, null);				        
						File ouptut = new File(simpan);
						ImageIO.write(bufferedImage, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);
					};
					
					//Edge Detection
					if(edge) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						imagebaru = ImageIO.read(input);
						width = image.getWidth();
						height = image.getHeight();
						
				        BufferedImage image = ImageIO.read(input);
		     			        
				        int x = image.getWidth();
				        int y = image.getHeight();

				        int[][] edgeColors = new int[x][y];
				        int maxGradient = -1;
						
				        for (int i = 1; i < x - 1; i++) {
				            for (int j = 1; j < y - 1; j++) {

				                int val00 = getGrayScale(image.getRGB(i - 1, j - 1));
				                int val01 = getGrayScale(image.getRGB(i - 1, j));
				                int val02 = getGrayScale(image.getRGB(i - 1, j + 1));

				                int val10 = getGrayScale(image.getRGB(i, j - 1));
				                int val11 = getGrayScale(image.getRGB(i, j));
				                int val12 = getGrayScale(image.getRGB(i, j + 1));

				                int val20 = getGrayScale(image.getRGB(i + 1, j - 1));
				                int val21 = getGrayScale(image.getRGB(i + 1, j));
				                int val22 = getGrayScale(image.getRGB(i + 1, j + 1));

				                int gx =  ((-1 * val00) + (0 * val01) + (1 * val02)) 
				                        + ((-2 * val10) + (0 * val11) + (2 * val12))
				                        + ((-1 * val20) + (0 * val21) + (1 * val22));

				                int gy =  ((-1 * val00) + (-2 * val01) + (-1 * val02))
				                        + ((0 * val10) + (0 * val11) + (0 * val12))
				                        + ((1 * val20) + (2 * val21) + (1 * val22));

				                double gval = Math.sqrt((gx * gx) + (gy * gy));
				                int g = (int) gval;

				                if(maxGradient < g) {
				                    maxGradient = g;
				                }

				                edgeColors[i][j] = g;
				            }
						
				        }
						
				        double scale = 255.0 / maxGradient;
						
				        for (int i = 1; i < x - 1; i++) {
				            for (int j = 1; j < y - 1; j++) {
				                int edgeColor = edgeColors[i][j];
				                edgeColor = (int)(edgeColor * scale);
				                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

				                image.setRGB(i, j, edgeColor);
				            }
				        }
				        					
						File ouptut = new File(simpan);
						ImageIO.write(image, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);								
					};		
					
					//histogrameque
					if (histogrameq) {
						File input = new File(alamat);
						image = ImageIO.read(input);
						double[] count = new double[256];//Number of gray values recorded
					    double[] Count = new double[256];//Statistical gray value of new graph
					    double[] NSK=new double[256];//Transformation function
					   
					        double H,S,I;
					        int width = image.getWidth();
					        int height = image.getHeight();
					        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
					        for (int j = 0; j < height; j++) {
					            for(int i=0; i<width; i++) {
					                Object data=image.getRaster().getDataElements(i,j,null);
					                int red = image.getColorModel().getRed(data);
					                int blue = image.getColorModel().getBlue(data);
					                int green = image.getColorModel().getGreen(data);
					                I= ((double)(red+green+blue)/(double)3);
					                if (count[(int)I]==0){
					                    count[(int)I]=1;
					                }else {
					                    count[(int)I]+=1;
					                }
					            }
					        }
					        double[] Pr=new double[256];//Calculate the occurrence probability of each gray value
					        for (int i=0;i<256;i++){
					            Pr[i]=(double)count[i]/(double)(width*height);
					        }
					        double[] sk = new double[256];//Cumulative probability
					        for (int i=0;i<256;i++){
					            for (int j=0;j<=i;j++){
					                sk[i]+=Pr[j];
					            }
					        }
					        for (int i=0;i<256;i++){
					            NSK[i]=(255*sk[i]+0.5);
					        }
					        int[] rgb=new int[3];
					        for (int j=0;j<height;j++){
					            for(int i=0;i<width;i++){
					                Object data=image.getRaster().getDataElements(i,j,null);//Get rgb value of image points
					                int red = image.getColorModel().getRed(data);
					                int blue = image.getColorModel().getBlue(data);
					                int green = image.getColorModel().getGreen(data);
					                int Alpha = image.getColorModel().getAlpha(data);
					                if (green>blue){//Set of formula calculation H
					                    H=Math.acos((red-green+red-blue)
					                            /(2.0*Math.sqrt((red-green)*(red-green)+(red-blue)*(green-blue))));
					                }else{
					                    H=2.0*Math.PI-Math.acos((red-green+red-blue)
					                            /(2.0*Math.sqrt((red-green)*(red-green)+(red-blue)*(green-blue))));
					                }
					                I= ((double)(red+green+blue)/(double)3);
					                I=NSK[(int)I];//I transformed i

					                if (Count[(int)I]==0){
					                    Count[(int)I]=1;
					                }else {
					                    Count[(int)I]+=1;
					                }
					                if (red==green&&green==blue){//Processing of black and white image
					                    rgb[0]=(int)I;
					                    rgb[1]=(int)I;
					                    rgb[2]=(int)I;
					                }else {     //Processing of color image
					                    S = 1 - ((double) 3 / (double) (red + green + blue)) * (double) red;//Calculate S
					                    if(H<=2.09){
					                        rgb[0]=(int)(I*(1.0+(S*Math.cos(H))/Math.cos((Math.PI/3.0)-H)));
					                        rgb[0]=rgb[0]>255?255:rgb[0];
					                        rgb[0]=rgb[0]<0?0:rgb[0];
					                        rgb[2]=(int)(I*(1.0-S));
					                        rgb[2]=rgb[2]<0?0:rgb[2];
					                        rgb[2]=rgb[2]>255?255:rgb[2];
					                        rgb[1]=(int)(3.0*I-rgb[0]-rgb[2]);
					                        rgb[1]=rgb[1]>255?255:rgb[1];
					                        rgb[1]=rgb[1]<0?0:rgb[1];
					                    }else if(H>2.09&&H<=4.18){
					                        rgb[1]=(int)(I*(1.0+(S*Math.cos(H-(Math.PI*2.0/3.0)))/Math.cos((Math.PI)-H)));
					                        rgb[1]=rgb[1]>255?255:rgb[1];
					                        rgb[1]=rgb[1]<0?0:rgb[1];
					                        rgb[0]=(int)(I*(1.0-S));
					                        rgb[0]=rgb[0]>255?255:rgb[0];
					                        rgb[0]=rgb[0]<0?0:rgb[0];
					                        rgb[2]=(int)(3.0*I-rgb[0]-rgb[1]);
					                        rgb[2]=rgb[2]>255?255:rgb[2];
					                        rgb[2]=rgb[2]<0?0:rgb[2];
					                    }else if(H>4.18){
					                        rgb[2]=(int)(I*(1.0+(S*Math.cos(H-(Math.PI*4.0/3.0)))/Math.cos((Math.PI*5.0/3.0)-H)));
					                        rgb[2]=rgb[2]>255?255:rgb[2];
					                        rgb[2]=rgb[2]<0?0:rgb[2];
					                        rgb[1]=(int)(I*(1.0-S));
					                        rgb[1]=rgb[1]>255?255:rgb[1];
					                        rgb[1]=rgb[1]<0?0:rgb[1];
					                        rgb[0]=(int)(3.0*I-rgb[1]-rgb[2]);
					                        rgb[0]=rgb[0]>255?255:rgb[0];
					                        rgb[0]=rgb[0]<0?0:rgb[0];
					                    }
					                }
					                int srgb=Alpha<<24|rgb[2]<<16|rgb[1]<<8|rgb[0];
					                result.setRGB(i,j, srgb);
					            }
					        }
						
						    
						    				        
						File ouptut = new File(simpan);
						ImageIO.write(result, "jpg", ouptut);

						ImageIcon gambarAkhir = new ImageIcon(simpan);
						Image gak = gambarAkhir.getImage(); // transform it
						Image newimg2 = gak.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
						gambarAkhir = new ImageIcon(newimg2); // transform it back
						LblFS.setIcon(gambarAkhir);		
					};
				} catch (Exception e) {
				}
			}
			private int getGrayScale(int rgb) {
				int r = (rgb >> 16) & 0xff;
		        int g = (rgb >> 8) & 0xff;
		        int b = (rgb) & 0xff;

		        int gray = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);

		        return gray;
			}

			
		});
		btnConvert.setBounds(700, 558, 175, 35);
		panel.add(btnConvert);

		JLabel lblSource = new JLabel("Source Image");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource.setBounds(164, 66, 150, 35);
		panel.add(lblSource);

		JLabel lblResult = new JLabel("Result Image");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(605, 66, 150, 35);
		panel.add(lblResult);
		

		JButton btnSave = new JButton("Browse Save Address");
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(60, 179, 113));
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
					setFinalAddress = true;
				}
				// if the user cancelled the operation
				else
					l.setText("the user cancelled the operation");
			}
		});
		btnSave.setBounds(475, 558, 175, 35);
		panel.add(btnSave);

		FieldContras = new JTextField();
		FieldContras.setBounds(700, 509, 75, 20);
		FieldContras.setColumns(10);

		JLabel lblContrasPer = new JLabel("%");
		lblContrasPer.setBounds(800, 509, 20, 20);

		JLabel lblContras = new JLabel("Kontras");
		lblContras.setHorizontalAlignment(SwingConstants.CENTER);
		lblContras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContras.setBounds(620, 509, 70, 20);

		FieldTranslasiM = new JTextField();
		FieldTranslasiM.setBounds(577, 509, 75, 20);
		FieldTranslasiM.setColumns(10);

		FieldTranslasiN = new JTextField();
		FieldTranslasiN.setBounds(700, 509, 75, 20);
		FieldTranslasiN.setColumns(10);

		JLabel lblTranslasiM = new JLabel("M");
		lblTranslasiM.setHorizontalAlignment(SwingConstants.CENTER);
		lblTranslasiM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTranslasiM.setBounds(560, 509, 20, 20);

		JLabel lblTranslasiN = new JLabel("N");
		lblTranslasiN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTranslasiN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTranslasiN.setBounds(683, 509, 20, 20);

		FieldCroppingX = new JTextField();
		FieldCroppingX.setBounds(475, 520, 75, 20);
		FieldCroppingX.setColumns(10);

		FieldCroppingY = new JTextField();
		FieldCroppingY.setBounds(575, 520, 75, 20);
		FieldCroppingY.setColumns(10);

		FieldCroppingpixelX = new JTextField();
		FieldCroppingpixelX.setBounds(700, 520, 75, 20);
		FieldCroppingpixelX.setColumns(10);

		FieldCroppingpixelY = new JTextField();
		FieldCroppingpixelY.setBounds(800, 520, 75, 20);
		FieldCroppingpixelY.setColumns(10);

		JLabel lblCroppingX = new JLabel("X");
		lblCroppingX.setHorizontalAlignment(SwingConstants.CENTER);
		lblCroppingX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCroppingX.setBounds(455, 520, 20, 20);

		JLabel lblCroppingY = new JLabel("Y");
		lblCroppingY.setHorizontalAlignment(SwingConstants.CENTER);
		lblCroppingY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCroppingY.setBounds(555, 520, 20, 20);

		JLabel lblCroppingKali = new JLabel("X");
		lblCroppingKali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCroppingKali.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCroppingKali.setBounds(777, 520, 20, 20);

		JLabel lblCroppingpixel = new JLabel("PIXEL");
		lblCroppingpixel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCroppingpixel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCroppingpixel.setBounds(750, 499, 70, 20);

		JLabel lblVersi = new JLabel("ver 0.6 Beta");
		lblVersi.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblVersi.setBounds(1145, 675, 54, 17);
		panel.add(lblVersi);
		
		JPanel histogram = new JPanel();
		histogram.setBorder(null);
		histogram.setBackground(Color.WHITE);
		histogram.setBounds(885, 104, 300, 443);
		panel.add(histogram);
		histogram.setLayout(null);
		
		JPanel histogramBiasa = new JPanel();
		histogramBiasa.setBackground(Color.WHITE);
		histogramBiasa.setBounds(0, 0, 300, 200);
		histogram.add(histogramBiasa);
		
		JPanel histogramEq = new JPanel();
		histogramEq.setBackground(Color.WHITE);
		histogramEq.setBounds(0, 221, 300, 200);
		histogram.add(histogramEq);
		
		JButton btnResult = new JButton("HISTOGRAM");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
			}
		});
		btnResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					File input = new File(alamat);
			    	image = ImageIO.read(input);
			        dataset = new HistogramDataset();
			        Raster raster = image.getRaster();
			        final int w = image.getWidth();
			        final int h = image.getHeight();
			        double[] r = new double[w * h];
			        r = raster.getSamples(0, 0, w, h, 0, r);
			        dataset.addSeries("Red", r, BINS);
			        r = raster.getSamples(0, 0, w, h, 1, r);
			        dataset.addSeries("Green", r, BINS);
			        r = raster.getSamples(0, 0, w, h, 2, r);
			        dataset.addSeries("Blue", r, BINS);
			        // chart
			        JFreeChart chart = ChartFactory.createHistogram("Histogram", "Value",
			            "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
			        XYPlot plot = (XYPlot) chart.getPlot();
			        renderer = (XYBarRenderer) plot.getRenderer();
			        renderer.setBarPainter(new StandardXYBarPainter());
			        // translucent red, green & blue
			        Paint[] paintArray = {
			            new Color(0x80ff0000, true),
			            new Color(0x8000ff00, true),
			            new Color(0x800000ff, true)
			        };
			        plot.setDrawingSupplier(new DefaultDrawingSupplier(
			            paintArray,
			            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
			        TampilanAwal.this.panel = new ChartPanel(chart);
			        
//			        renderer.setSeriesVisible(2, true);
//			        renderer.setSeriesVisible(1, !renderer.getSeriesVisible(1));
			        TampilanAwal.this.panel.setMouseWheelEnabled(true);
			        
			        histogramBiasa.setLayout(new java.awt.BorderLayout());
			        histogramBiasa.add(TampilanAwal.this.panel,BorderLayout.CENTER);
			        histogramBiasa.validate();
			        
			        
			        
			        //histogram luar biasa
			        input = new File(simpan);
			    	image = ImageIO.read(input);
			        dataset = new HistogramDataset();
			        raster = image.getRaster();
			        final int l = image.getWidth();
			        final int t = image.getHeight();
			        r = new double[w * h];
			        r = raster.getSamples(0, 0, l, t, 0, r);
			        dataset.addSeries("Red", r, BINS);
			        r = raster.getSamples(0, 0, l, t, 1, r);
			        dataset.addSeries("Green", r, BINS);
			        r = raster.getSamples(0, 0, l, t, 2, r);
			        dataset.addSeries("Blue", r, BINS);
			        // chart
			        chart = ChartFactory.createHistogram("Histogram Equelization", "Value",
			            "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
			        plot = (XYPlot) chart.getPlot();
			        renderer = (XYBarRenderer) plot.getRenderer();
			        renderer.setBarPainter(new StandardXYBarPainter());
			        // translucent red, green & blue
			        Paint[] aa = {
			            new Color(0x80ff0000, true),
			            new Color(0x8000ff00, true),
			            new Color(0x800000ff, true)
			        };
			        plot.setDrawingSupplier(new DefaultDrawingSupplier(
			            aa,
			            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
			            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
			        TampilanAwal.this.panel = new ChartPanel(chart);
			        
//			        renderer.setSeriesVisible(2, true);
//			        renderer.setSeriesVisible(1, !renderer.getSeriesVisible(1));
			        TampilanAwal.this.panel.setMouseWheelEnabled(true);
			        
			        histogramEq.setLayout(new java.awt.BorderLayout());
			        histogramEq.add(TampilanAwal.this.panel,BorderLayout.CENTER);
			        histogramEq.validate();
				}catch (Exception e1) {
					// TODO: handle exception
				}
				
//							
				
			}
		});
		
		
		
		btnResult.setForeground(Color.WHITE);
		btnResult.setBackground(Color.ORANGE);
		btnResult.setBounds(987, 558, 107, 35);
		panel.add(btnResult);
		
		JLabel lblHistogramImage = new JLabel("Histogram Image");
		lblHistogramImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistogramImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHistogramImage.setBounds(958, 66, 150, 35);
		panel.add(lblHistogramImage);
		

		JButton btnVertikal = new JButton("Vertikal");
		btnVertikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vertikal = true;
				horizontal = false;
			}
		});
		btnVertikal.setForeground(Color.WHITE);
		btnVertikal.setBackground(new Color(60, 179, 113));
		btnVertikal.setBounds(475, 512, 102, 35);

		JButton btnHorizontal = new JButton("Horizontal");
		btnHorizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vertikal = false;
				horizontal = true;
			}
		});
		btnHorizontal.setForeground(Color.WHITE);
		btnHorizontal.setBackground(new Color(60, 179, 113));
		btnHorizontal.setBounds(773, 512, 102, 35);

		JButton btnRotatekiri = new JButton("Kiri");
		btnRotatekiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotatekanan = false;
				rotatekiri = true;
			}
		});
		btnRotatekiri.setForeground(Color.WHITE);
		btnRotatekiri.setBackground(new Color(60, 179, 113));
		btnRotatekiri.setBounds(475, 512, 102, 35);

		JButton btnRotatekanan = new JButton("Kanan");
		btnRotatekanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotatekanan = true;
				rotatekiri = false;
			}
		});
		btnRotatekanan.setForeground(Color.WHITE);
		btnRotatekanan.setBackground(new Color(60, 179, 113));
		btnRotatekanan.setBounds(773, 512, 102, 35);

		JButton btnScallingBesar = new JButton("Besar");
		btnScallingBesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scallingbesar = true;
				scallingkecil = false;
			}
		});
		btnScallingBesar.setForeground(Color.WHITE);
		btnScallingBesar.setBackground(new Color(60, 179, 113));
		btnScallingBesar.setBounds(475, 512, 102, 35);

		JButton btnScallingKecil = new JButton("Kecil");
		btnScallingKecil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scallingbesar = false;
				scallingkecil = true;
			}
		});
		btnScallingKecil.setForeground(Color.WHITE);
		btnScallingKecil.setBackground(new Color(60, 179, 113));
		btnScallingKecil.setBounds(773, 512, 102, 35);

		JLabel lblSlider = new JLabel("");
		lblSlider.setBounds(780, 512, 46, 14);
		lblSlider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sliderBrightness.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSlider.setText(String.valueOf(sliderBrightness.getValue() - 255));
				nilaiBrightness = Integer.parseInt(lblSlider.getText());
				// debug
				// System.out.println(nilaiBrightness);
			}
		});
		sliderBrightness.setForeground(new Color(255, 255, 255));
		sliderBrightness.setBackground(new Color(60, 179, 113));
		sliderBrightness.setBounds(575, 510, 200, 20);

		// MENU BEGINS
		////////////////
		////////////////

		JLabel lblmenu = new JLabel("Menu");
		lblmenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblmenu.setBackground(UIManager.getColor("text"));
		lblmenu.setForeground(new Color(255, 255, 255));
		lblmenu.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblmenu.setBounds(0, 0, 150, 60);
		menu.add(lblmenu);

		// Button in menu
		JButton btnAbout = new JButton("About");
		btnAbout.setBackground(Color.PINK);
		btnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Kelompok 4\nDicky Febrian Dwiputra 3411181097\nAde Ridwan Nugraha 3411181117\nIndiarto Aji Begawan 3411181114");
			}
		});
		btnAbout.setBounds(10, 610, 130, 30);
		menu.add(btnAbout);

		JLabel lblRGBtoGray = new JLabel("RGB to Grayscale");
		lblRGBtoGray.setHorizontalAlignment(SwingConstants.CENTER);
		lblRGBtoGray.setBounds(24, 0, 205, 55);
		lblRGBtoGray.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblBrightness = new JLabel("Brightness");
		lblBrightness.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrightness.setBounds(24, 0, 205, 55);
		lblBrightness.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNegatif = new JLabel("Negative");
		lblNegatif.setHorizontalAlignment(SwingConstants.CENTER);
		lblNegatif.setBounds(24, 0, 205, 55);
		lblNegatif.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblBandW = new JLabel("Black & White");
		lblBandW.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandW.setBounds(24, 0, 205, 55);
		lblBandW.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblKontras = new JLabel("Contrast");
		lblKontras.setHorizontalAlignment(SwingConstants.CENTER);
		lblKontras.setBounds(24, 0, 205, 55);
		lblKontras.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblTranlasi = new JLabel("Translasi");
		lblTranlasi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTranlasi.setBounds(24, 0, 205, 55);
		lblTranlasi.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblFlipping = new JLabel("Flipping");
		lblFlipping.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlipping.setBounds(24, 0, 205, 55);
		lblFlipping.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblCropping = new JLabel("Cropping");
		lblCropping.setHorizontalAlignment(SwingConstants.CENTER);
		lblCropping.setBounds(24, 0, 205, 55);
		lblCropping.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblRotation = new JLabel("Rotation");
		lblRotation.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotation.setBounds(24, 0, 205, 55);
		lblRotation.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblScalling = new JLabel("Scalling");
		lblScalling.setHorizontalAlignment(SwingConstants.CENTER);
		lblScalling.setBounds(24, 0, 205, 55);
		lblScalling.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblSmoothing = new JLabel("Smoothing");
		lblSmoothing.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmoothing.setBounds(24, 0, 205, 55);
		lblSmoothing.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblSharpening = new JLabel("Sharpening");
		lblSharpening.setHorizontalAlignment(SwingConstants.CENTER);
		lblSharpening.setBounds(24, 0, 205, 55);
		lblSharpening.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblEdge = new JLabel("Edge Detection");
		lblEdge.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdge.setBounds(24, 0, 205, 55);
		lblEdge.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblHistogramEq = new JLabel("Histogram Equalization");
		lblHistogramEq.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistogramEq.setBounds(24, 0, 250, 55);
		lblHistogramEq.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnRGBtoGray = new JButton("RGB to Gray");
		btnRGBtoGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = true;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.add(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);

				
				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnRGBtoGray.setForeground(new Color(0, 0, 0));
		btnRGBtoGray.setBackground(new Color(255, 215, 0));
		btnRGBtoGray.setBounds(0, 70, 150, 30);
		menu.add(btnRGBtoGray);
		btnRGBtoGray.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnBrightness = new JButton("Brightness");
		btnBrightness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = true;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.add(lblBrightness);
				panel.add(sliderBrightness);
				panel.add(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnBrightness.setForeground(new Color(0, 0, 0));
		btnBrightness.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrightness.setBackground(new Color(255, 215, 0));
		btnBrightness.setBounds(0, 100, 150, 30);
		menu.add(btnBrightness);

		JButton btnBW = new JButton("B & W");
		btnBW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = true;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.add(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnBW.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBW.setForeground(new Color(0, 0, 0));
		btnBW.setBackground(new Color(255, 215, 0));
		btnBW.setBounds(0, 160, 150, 30);
		menu.add(btnBW);

		JButton btnNegatif = new JButton("Negatif Film");
		btnNegatif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = true;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.add(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				
				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnNegatif.setForeground(new Color(0, 0, 0));
		btnNegatif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNegatif.setBackground(new Color(255, 215, 0));
		btnNegatif.setBounds(0, 130, 150, 30);
		menu.add(btnNegatif);

		JButton btnKontras = new JButton("Kontras");
		btnKontras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = true;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.add(lblKontras);
				panel.add(FieldContras);
				panel.add(lblContras);
				panel.add(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnKontras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKontras.setForeground(new Color(0, 0, 0));
		btnKontras.setBackground(new Color(255, 215, 0));
		btnKontras.setBounds(0, 190, 150, 30);
		menu.add(btnKontras);

		JButton btnTranslasi = new JButton("Translasi");
		btnTranslasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = true;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.add(lblTranlasi);
				panel.add(FieldTranslasiM);
				panel.add(FieldTranslasiN);
				panel.add(lblTranslasiM);
				panel.add(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnTranslasi.setForeground(Color.BLACK);
		btnTranslasi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTranslasi.setBackground(new Color(255, 215, 0));
		btnTranslasi.setBounds(0, 235, 150, 30);
		menu.add(btnTranslasi);

		JButton btnFlipping = new JButton("Flipping");
		btnFlipping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = true;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.add(lblFlipping);
				panel.add(btnHorizontal);
				panel.add(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnFlipping.setForeground(Color.BLACK);
		btnFlipping.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFlipping.setBackground(new Color(255, 215, 0));
		btnFlipping.setBounds(0, 265, 150, 30);
		menu.add(btnFlipping);

		JButton btnCropping = new JButton("Cropping");
		btnCropping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = true;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.add(lblCropping);
				panel.add(FieldCroppingX);
				panel.add(FieldCroppingY);
				panel.add(FieldCroppingpixelX);
				panel.add(FieldCroppingpixelY);
				panel.add(lblCroppingpixel);
				panel.add(lblCroppingKali);
				panel.add(lblCroppingY);
				panel.add(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnCropping.setForeground(Color.BLACK);
		btnCropping.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCropping.setBackground(new Color(255, 215, 0));
		btnCropping.setBounds(0, 295, 150, 30);
		menu.add(btnCropping);

		JButton btnRotation = new JButton("Rotation");
		btnRotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = true;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.add(lblRotation);
				panel.add(btnRotatekanan);
				panel.add(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnRotation.setForeground(Color.BLACK);
		btnRotation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRotation.setBackground(new Color(255, 215, 0));
		btnRotation.setBounds(0, 325, 150, 30);
		menu.add(btnRotation);

		JButton btnScalling = new JButton("Scalling");
		btnScalling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = true;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.add(lblScalling);
				panel.add(btnScallingBesar);
				panel.add(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnScalling.setForeground(Color.BLACK);
		btnScalling.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnScalling.setBackground(new Color(255, 215, 0));
		btnScalling.setBounds(0, 355, 150, 30);
		menu.add(btnScalling);

		JButton btnSmoothing = new JButton("Smoothing");
		btnSmoothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = true;
				sharpening = false;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.add(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnSmoothing.setForeground(Color.BLACK);
		btnSmoothing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSmoothing.setBackground(new Color(255, 215, 0));
		btnSmoothing.setBounds(0, 399, 150, 30);
		menu.add(btnSmoothing);

		JButton btnSharpening = new JButton("Sharpening");
		btnSharpening.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = true;
				edge = false;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.add(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				
				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnSharpening.setForeground(Color.BLACK);
		btnSharpening.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSharpening.setBackground(new Color(255, 215, 0));
		btnSharpening.setBounds(0, 429, 150, 30);
		menu.add(btnSharpening);

		JButton btnEdgeDetection = new JButton("Edge Detection");
		btnEdgeDetection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = true;
				histogrameq = false;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.add(lblEdge);
				
				// histogram eq
				panel_1.remove(lblHistogramEq);
				

				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnEdgeDetection.setForeground(Color.BLACK);
		btnEdgeDetection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdgeDetection.setBackground(new Color(255, 215, 0));
		btnEdgeDetection.setBounds(0, 459, 150, 30);
		menu.add(btnEdgeDetection);
		
		JButton btnHistogramEq = new JButton("Histogram EQ");
		btnHistogramEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LblFS.setIcon(null);
				txtFinalAddress.setText("");
				rgbtogray = false;
				brightness = false;
				negatif = false;
				bandw = false;
				kontras = false;
				translasi = false;
				flipping = false;
				cropping = false;
				rotation = false;
				scalling = false;
				smoothing = false;
				sharpening = false;
				edge = false;
				histogrameq = true;

				// Gray
				panel_1.remove(lblRGBtoGray);

				// Brightness
				panel_1.remove(lblBrightness);
				panel.remove(sliderBrightness);
				panel.remove(lblSlider);

				// negatif
				panel_1.remove(lblNegatif);

				// Black and White
				panel_1.remove(lblBandW);

				// Kontras
				panel_1.remove(lblKontras);
				panel.remove(FieldContras);
				panel.remove(lblContras);
				panel.remove(lblContrasPer);

				// translasi
				panel_1.remove(lblTranlasi);
				panel.remove(FieldTranslasiM);
				panel.remove(FieldTranslasiN);
				panel.remove(lblTranslasiM);
				panel.remove(lblTranslasiN);

				// flipping
				panel_1.remove(lblFlipping);
				panel.remove(btnHorizontal);
				panel.remove(btnVertikal);

				// cropping
				panel_1.remove(lblCropping);
				panel.remove(FieldCroppingX);
				panel.remove(FieldCroppingY);
				panel.remove(FieldCroppingpixelX);
				panel.remove(FieldCroppingpixelY);
				panel.remove(lblCroppingpixel);
				panel.remove(lblCroppingKali);
				panel.remove(lblCroppingY);
				panel.remove(lblCroppingX);

				// rotation
				panel_1.remove(lblRotation);
				panel.remove(btnRotatekanan);
				panel.remove(btnRotatekiri);

				// scalling
				panel_1.remove(lblScalling);
				panel.remove(btnScallingBesar);
				panel.remove(btnScallingKecil);

				// smoothing
				panel_1.remove(lblSmoothing);

				// sharpening
				panel_1.remove(lblSharpening);

				// edge
				panel_1.remove(lblEdge);
				
				// histogram eq
				panel_1.add(lblHistogramEq);
				
				
				
				panel.setVisible(false);
				panel.setVisible(true);
				setFinalAddress = false;
			}
		});
		btnHistogramEq.setForeground(Color.BLACK);
		btnHistogramEq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHistogramEq.setBackground(new Color(255, 215, 0));
		btnHistogramEq.setBounds(0, 500, 150, 30);
		menu.add(btnHistogramEq);

		// Button in menu end
		// MENU ENDS
		
		
	}
}
