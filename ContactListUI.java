import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContactListUI extends JPanel implements ActionListener{
	
	private JButton to;
	private JButton addContacts;
	private JButton removeContacts;

	public ContactListUI(){
		//Set up the To: and From: panel
		JPanel staticPanel = new JPanel();
		staticPanel.setPreferredSize(new Dimension(100, 100));
		staticPanel.setLayout(new GridLayout(3, 1));
		to = new JButton("To: ");
		staticPanel.add(to);
		staticPanel.add(new JLabel(" "));
		staticPanel.add(new JLabel("From:", JLabel.CENTER));
		
		//Set up the panel for addContacts and removeContacts;
		JPanel buttonPanel = new JPanel();
		addContacts = new JButton("Add Contacts");
		removeContacts = new JButton("Remove Contacts");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addContacts);
		buttonPanel.add(removeContacts);
		
		//Set up the panel with the contact selection and buttons
		JPanel dynPanel = new JPanel();
		JTextField toText = new JTextField();
		JTextField fromText = new JTextField();
		dynPanel.setPreferredSize(new Dimension(300, 100));
		dynPanel.setLayout(new GridLayout(3, 1));
		dynPanel.add(toText);
		dynPanel.add(buttonPanel);
		dynPanel.add(fromText);
		
		
		//Add everything to a ContactUI
		to.addActionListener(this);
		addContacts.addActionListener(this);
		removeContacts.addActionListener(this);
		this.setPreferredSize(new Dimension(500, 125));
		this.setLayout(new FlowLayout());
		this.add(staticPanel);
		this.add(dynPanel);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(to == e.getSource()){
			//Display list for user selection
			//puts user selection into JTextField to
		}
		else if(addContacts == e.getSource()){
			//Display prompt for information for new contact
			//Uses information to add to ContactList collection
		}
		else if(removeContacts == e.getSource()){
			//Display prompt for removing contacts
			//Uses information to remove from ContactList collection
		}
	}
	
	//Debugging
	public static void main(String[] args){
		JFrame win = new JFrame();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ContactListUI clUI = new ContactListUI();
		win.add(clUI);
		win.pack();
		win.setVisible(true);
		
	}

}
