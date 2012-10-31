import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class emailInterface extends JFrame implements ActionListener{
	private JLabel toLabel;
	private JLabel ccLabel;
	private JLabel bccLabel;
	private JLabel subjectLabel;
	private JLabel messageLabel;
	private JTextField toField;
	private JTextField ccField;
	private JTextField bccField;
	private JTextField subjectLine;
	private JTextArea messageArea;
	private JButton sendButton;
	
	public emailInterface() {
		
		ContactListUI contactList= new ContactListUI(); 
		subjectLabel = new JLabel("Subject: ");
		subjectLine = new JTextField(30);
		messageLabel = new JLabel("Message:  \n ");
		messageArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(messageArea);
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		
		JPanel content = new JPanel();
		
		content.setLayout(new GridLayout(0,2));
		

		content.add(contactList);
		content.add(subjectLabel);
		content.add(subjectLine);
		content.add(messageLabel);
		

		
		setLayout(new BorderLayout());
		add(content, BorderLayout.NORTH);
		add(messageArea, BorderLayout.CENTER);
		add(sendButton, BorderLayout.SOUTH);

	}
	
	public void actionPerformed(ActionEvent event){
		if(sendButton == event.getSource()){
			//GmailSender sender = new GmailSender("stealthisemail123@gmail.com", "this-is-a-password");
			//contactArray = contactList.giveEmail();
			//sender.sendMail(contactArray, subjectLine.getText(), messageArea.getText());
		}
		
	}
	
	public static void main(String[] args) {
		emailInterface window = new emailInterface();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
}