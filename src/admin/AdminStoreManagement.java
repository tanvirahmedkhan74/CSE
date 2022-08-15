package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.Book;
import main.BookCollection;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdminStoreManagement extends JFrame {

	private JPanel contentPane;
	private Book book;
	private ArrayList<Book> books;
	private BookCollection bookCollection;
	JTextArea textAreaBookInfoDisplay;
	private JTextField textFieldTotalBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStoreManagement frame = new AdminStoreManagement();
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
	public AdminStoreManagement() {
		setTitle("STORE MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new LineBorder(new Color(102, 0, 255), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 51, 51), 2, true));
		panel.setBounds(10, 11, 615, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 255, 0), 2, true));
		panel_1.setBounds(10, 11, 595, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStoreManagement = new JLabel("STORE MANAGEMENT");
		lblStoreManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreManagement.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblStoreManagement.setBounds(129, 11, 329, 35);
		panel_1.add(lblStoreManagement);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.setBackground(new Color(255, 204, 153));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
		panel_2.setBounds(10, 79, 595, 335);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 204, 153));
		panel_3.setBorder(new LineBorder(new Color(255, 51, 51), 2, true));
		panel_3.setBounds(10, 11, 188, 179);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SORT BY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(47, 11, 100, 22);
		panel_3.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(153, 0, 102));
		separator.setBounds(10, 36, 168, 2);
		panel_3.add(separator);
		
		JButton btnSortByIsbn = new JButton("ISBN Number");
		btnSortByIsbn.setBounds(10, 49, 168, 28);
		panel_3.add(btnSortByIsbn);
		btnSortByIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBookInfoDisplay.setText(null);
				bookCollection = new BookCollection();
				bookCollection.sortByIsbn();
				
				books = bookCollection.getBookCollection();
				textFieldTotalBooks.setText(Integer.toString(books.size()));
			
				Iterator<Book> itr = books.iterator();
				
				while(itr.hasNext()) {
					book = itr.next();
					textAreaBookInfoDisplay.append("Book Name: " + book.getName() + "\n" + "Author Name: " + book.getWriter().getName() + 
							"\n" + "Genre: " + book.getGenre().getGenre() + "\n" + "Price: " + book.getPrice() + "\n" + "Year Of Publish: " + book.getYearOfPublish() + 
							"\n" + "ISBN: " + book.getIsbn() + "\n--------------------------------------------------" + "\n\n");
				}
				
				
			}
		});
		btnSortByIsbn.setForeground(new Color(51, 0, 51));
		btnSortByIsbn.setBackground(new Color(240, 240, 240));
		btnSortByIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSortByYear = new JButton("Year Of Publish");
		btnSortByYear.setBounds(10, 88, 168, 28);
		panel_3.add(btnSortByYear);
		btnSortByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaBookInfoDisplay.setText(null);
				bookCollection = new BookCollection();
				bookCollection.sortByYearOfPublish();
				
				books = bookCollection.getBookCollection();
				textFieldTotalBooks.setText(Integer.toString(books.size()));
			
				Iterator<Book> itr = books.iterator();
				
				while(itr.hasNext()) {
					book = itr.next();
					textAreaBookInfoDisplay.append("Book Name: " + book.getName() + "\n" + "Author Name: " + book.getWriter().getName() + 
							"\n" + "Genre: " + book.getGenre().getGenre() + "\n" + "Price: " + book.getPrice() + "\n" + "Year Of Publish: " + book.getYearOfPublish() + 
							"\n" + "ISBN: " + book.getIsbn() + "\n--------------------------------------------------" + "\n\n");
				}
			}
		});
		btnSortByYear.setForeground(new Color(51, 0, 51));
		btnSortByYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSortByYear.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnPrice = new JButton("Price");
		btnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaBookInfoDisplay.setText(null);
				bookCollection = new BookCollection();
				bookCollection.sortByPrice();
				
				books = bookCollection.getBookCollection();
				textFieldTotalBooks.setText(Integer.toString(books.size()));
			
				Iterator<Book> itr = books.iterator();
				
				while(itr.hasNext()) {
					book = itr.next();
					textAreaBookInfoDisplay.append("Book Name: " + book.getName() + "\n" + "Author Name: " + book.getWriter().getName() + 
							"\n" + "Genre: " + book.getGenre().getGenre() + "\n" + "Price: " + book.getPrice() + "\n" + "Year Of Publish: " + book.getYearOfPublish() + 
							"\n" + "ISBN: " + book.getIsbn() + "\n--------------------------------------------------" + "\n\n");
				}
			}
		});
		btnPrice.setForeground(new Color(51, 0, 51));
		btnPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPrice.setBackground(UIManager.getColor("Button.background"));
		btnPrice.setBounds(10, 127, 168, 28);
		panel_3.add(btnPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 11, 370, 313);
		panel_2.add(scrollPane);
		
		textAreaBookInfoDisplay = new JTextArea();
		textAreaBookInfoDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textAreaBookInfoDisplay.setFont(new Font("Lato", Font.PLAIN, 16));
		textAreaBookInfoDisplay.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(textAreaBookInfoDisplay);
		
		JButton btnClearDisplay = new JButton("CLEAR DISPLAY");
		btnClearDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBookInfoDisplay.setText(null);
				textFieldTotalBooks.setText(null);
			}
		});
		btnClearDisplay.setForeground(Color.MAGENTA);
		btnClearDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClearDisplay.setBackground(SystemColor.menu);
		btnClearDisplay.setBounds(10, 257, 188, 28);
		panel_2.add(btnClearDisplay);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminPanelWindow adminPanel = new AdminPanelWindow();
				adminPanel.setVisible(true);
			}
		});
		btnGoBack.setForeground(Color.MAGENTA);
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBackground(SystemColor.menu);
		btnGoBack.setBounds(10, 296, 188, 28);
		panel_2.add(btnGoBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 102), 2, true));
		panel_4.setBackground(new Color(102, 205, 170));
		panel_4.setBounds(10, 201, 188, 44);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTotalBooks = new JLabel("Total Books:");
		lblTotalBooks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalBooks.setBounds(10, 11, 89, 22);
		panel_4.add(lblTotalBooks);
		
		textFieldTotalBooks = new JTextField();
		textFieldTotalBooks.setBounds(109, 11, 69, 22);
		panel_4.add(textFieldTotalBooks);
		textFieldTotalBooks.setColumns(10);
	}
}
