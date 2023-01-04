package signupform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
public class signup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(870,0,500,600);
        frame.setTitle("JLabel Introduction");

        // Container
        Container c = frame.getContentPane();
        c.setLayout(null);

        // set font 
        Font Bold =new Font("Times New Roman", Font.BOLD, 20);
        Font Normal =new Font("Times New Roman", Font.PLAIN, 18);

        // set lable 
        JLabel Sign_Up = new JLabel("Sign Up",JLabel.CENTER);
        JLabel Id = new JLabel("Student ID");
        JLabel Name = new JLabel("Student Name");
        JLabel Add = new JLabel("Student Address");
        JLabel Mobile = new JLabel("Student Mobile");
        
        //set Text Field
        JTextField tId= new JTextField();
        JTextField tName= new JTextField();
        JTextField tAdd= new JTextField();
        JTextField tMobile= new JTextField();
//        tMobile.setEditable(false);

        // set locatio in the Container 
        Sign_Up.setBounds(-16,39,500,100);
        Id.setBounds(50,150,200,50);
        Name.setBounds(50,200,200,50);
        Add.setBounds(50,250,200,50);
        Mobile.setBounds(50,300,200,50);
        // set Text Field location
        tId.setBounds(250,150,200,40);
        tName.setBounds(250,200,200,40);
        tAdd.setBounds(250,250,200,40);
        tMobile.setBounds(250,300,200,40);
        tMobile.setBackground(new Color(255, 255, 255));
        
        // Add Font
        Sign_Up.setFont(Bold);
        Id.setFont(Normal);
        Name.setFont(Normal);
        Add.setFont(Normal);
        Mobile.setFont(Normal);
        tId.setFont(Normal);
        tName.setFont(Normal);
        tAdd.setFont(Normal);
        tMobile.setFont(Normal);
        
        // Image at bottom part
      

        // add lable to the Container 
        c.add(Sign_Up);
        c.add(Id);
        c.add(Name);
        c.add(Add);
        c.add(Mobile);
 
        c.add(tId);
        c.add(tName);
        c.add(tAdd);
        c.add(tMobile);
        
        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			int id = Integer.parseInt(tId.getText());
        			String name = tName.getText();
        			String add = tAdd.getText();
        			long mobile = Long.parseLong(tMobile.getText());
//        			connection
        			Connection conn = DB.dbConnection();
        			String q = "Insert into student values(?,?,?,?)";
        			PreparedStatement pst = conn.prepareStatement(q);
        			pst.setInt(1,id);
        			pst.setString(2,name);
        			pst.setString(3, add);
        			pst.setLong(4, mobile);
        			
        			pst.executeUpdate();
//        			dailog box
        			JOptionPane.showMessageDialog(null,"data added sucessfull!");
        			
        			//to set data empty after sucessfully added
        			tId.setText("");
        			tName.setText("");
        			tAdd.setText("");
        			tMobile.setText("");
        		
        		}catch(Exception e2) {
        			e2.printStackTrace();
        		}
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.setBounds(180, 408, 120, 40);
        frame.getContentPane().add(btnNewButton);
        

//        frame.setResizable(false);
		
		
		setContentPane(contentPane);
	}
}
