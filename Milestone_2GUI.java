package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Milestone_2GUI {

	private JFrame frame;
	private JButton btnRunVowelChecker;
	private JTextField inputTextField;
	private JTextField outputTextField;

	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Milestone_2GUI window = new Milestone_2GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application
	public Milestone_2GUI() {
		initialize();
	}

	//Initialize the frame
	private void initialize() {
		//New frame that sets the size
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Vowel checker title
		frame.setTitle("Vowel Checker");
		//New button and button text
		btnRunVowelChecker = new JButton("Run Vowel Checker");
		btnRunVowelChecker.addActionListener(new ActionListener() {
			//When you hit the button this is what will happen
			//Calls an object referencing our java code
			public void actionPerformed(ActionEvent e) {
				//call object
				String userInput = "";
				try {
				userInput = inputTextField.getText();
				userInput = userInput.toLowerCase();
				int numLetters = userInput.length();
				finalprojectm3 obj = new finalprojectm3();
				String finalString = obj.vowelCountMethod(userInput);
				
				outputTextField.setText(finalString);
				
			}catch(Exception e1){System.out.println("Please enter letters only.");}}
		});
		//Size of button
		btnRunVowelChecker.setBounds(22, 146, 206, 60);
		frame.getContentPane().add(btnRunVowelChecker);
		
		//Text prompting user
		JLabel inputText = new JLabel("Welcome to the Vowel Checker. Please Input a word or sentence.");
		inputText.setFont(new Font("Tahoma", Font.BOLD, 13));
		inputText.setBounds(22, 13, 487, 35);
		frame.getContentPane().add(inputText);
		
		//Input (word or sentence)
		inputTextField = new JTextField();
		inputTextField.setBounds(22, 61, 354, 72);
		frame.getContentPane().add(inputTextField);
		inputTextField.setColumns(10);
		
		//What is outputted
		outputTextField = new JTextField();
		outputTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		outputTextField.setBounds(22, 274, 354, 65);
		frame.getContentPane().add(outputTextField);
		outputTextField.setColumns(10);
		
		//Output text for output text field
		JLabel labelOutput = new JLabel("Output:");
		labelOutput.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelOutput.setBounds(22, 245, 56, 16);
		frame.getContentPane().add(labelOutput);
		
		//Label for authors
		JLabel lblMadyByDaanish = new JLabel("Mady by Daanish, Jordan, Mario, Hank, and Rudy");
		lblMadyByDaanish.setBounds(22, 352, 279, 16);
		frame.getContentPane().add(lblMadyByDaanish);
	}
}
