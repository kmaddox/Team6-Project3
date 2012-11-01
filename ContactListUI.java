import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContactListUI extends JPanel implements ActionListener{

	private JTextField[] newContactFields;
	private JTextField toText, fromText;
	private JButton to;
	private JButton addContacts, addSendContacts;
	private JButton removeContacts, deleteContact;
	private JButton editContacts;
	private JButton save;
	private JButton remove;
	private JButton edit;

	private JFrame addWindow, editWindow, toWindow, removeWindow;
	private ContactList cList;
	private ContactListCheckBox contactList;

	public ContactListUI(){
		cList = new ContactList("contacts.txt");

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
		addContacts = new JButton("Add");
		removeContacts = new JButton("Remove");
		editContacts = new JButton("Edit");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addContacts);
		buttonPanel.add(removeContacts);
		buttonPanel.add(editContacts);

		//Set up the panel with the contact selection and buttons
		JPanel dynPanel = new JPanel();
		toText = new JTextField();
		fromText = new JTextField();
		dynPanel.setPreferredSize(new Dimension(300, 100));
		dynPanel.setLayout(new GridLayout(3, 1));
		dynPanel.add(toText);
		dynPanel.add(buttonPanel);
		dynPanel.add(fromText);


		//Add everything to a ContactUI
		to.addActionListener(this);
		addContacts.addActionListener(this);
		removeContacts.addActionListener(this);
		editContacts.addActionListener(this);
		this.setPreferredSize(new Dimension(500, 125));
		this.setLayout(new FlowLayout());
		this.add(staticPanel);
		this.add(dynPanel);

		deleteContact = new JButton("Delete");
		deleteContact.addActionListener(this);
		addSendContacts = new JButton("Confirm");
		addSendContacts.addActionListener(this);
	}

	public void addContactWindow(){
		addWindow = new JFrame("Add a Contact");
		addWindow.setLayout(new GridLayout(2, 3));
		newContactFields = new JTextField[3];
		for(int i = 0; i < newContactFields.length; i++){
			newContactFields[i] = new JTextField("", 15);
		}
		save = new JButton("Save Contact");
		addWindow.add(new JLabel("Email Address: "));
		addWindow.add(newContactFields[0]);
		addWindow.add(new JLabel("First Name: "));
		addWindow.add(newContactFields[1]);
		addWindow.add(new JLabel("Last Name: "));
		addWindow.add(newContactFields[2]);
		save.addActionListener(this);
		addWindow.add(save);
		addWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindow.pack();
		addWindow.setVisible(true);
	}

	public void removeContactWindow(){
		removeWindow = new JFrame("Remove Contacts");
		removeWindow.setLayout(new BorderLayout());
		contactList = new ContactListCheckBox(cList);
		removeWindow.add(contactList, BorderLayout.CENTER);
		//Add List here
		removeWindow.add(deleteContact, BorderLayout.SOUTH);
		removeWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		removeWindow.pack();
		removeWindow.setVisible(true);

	}

	public void toSendWindow(){
		toWindow = new JFrame("Send Email To");
		toWindow.setLayout(new BorderLayout());
		contactList = new ContactListCheckBox(cList);
		toWindow.add(contactList, BorderLayout.CENTER);
		toWindow.add(addSendContacts, BorderLayout.SOUTH);
		toWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		toWindow.pack();
		toWindow.setVisible(true);
	}


	public void	editContactWindow(){
		editWindow = new JFrame("Edit Contacts");
		editWindow.setLayout(new FlowLayout());
		//Add List
		editWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		editWindow.pack();
		editWindow.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(to == e.getSource()){
			toSendWindow();
			//Display list for user selection
			//puts user selection into JTextField to
		}
		else if(addContacts == e.getSource()){
			addContactWindow();
			//Display prompt for information for new contact
			//Uses information to add to ContactList collection
			//
		}
		else if(removeContacts == e.getSource()){
			removeContactWindow();
			//Display prompt for removing contacts
			//Uses information to remove from ContactList collection
		}
		else if(editContacts == e.getSource()){
			editContactWindow();
			//UI for editing contacts
		}
		else if(save == e.getSource()){
			cList.addContact(new Contact(newContactFields[0].getText(), newContactFields[1].getText(), newContactFields[2].getText()));
			JOptionPane.showMessageDialog(null, "The contact has been added.", "Success!", JOptionPane.INFORMATION_MESSAGE);
			addWindow.dispose();
		}
		else if (deleteContact == e.getSource())
		{
			ContactList cDeleted = contactList.getContacts();
			for (int i = 0; i < cDeleted.getLength(); i++)
			{
				cList.removeContact(cDeleted.getContact(i));
				/*
				PLACEHOLDER FOR REPAINT
				*/
			}
			removeWindow.dispose();
		}
		else if (addSendContacts == e.getSource())
		{
			toText.setText(toText.getText() + contactList.getEmails());
			toWindow.dispose();
		}
	}

	//public String giveEmail(){
		//return toText.getText();
		//Create method to give email address as a string to
		//EmailSender class
	//}


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
