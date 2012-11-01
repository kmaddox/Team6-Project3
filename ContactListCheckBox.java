import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactListCheckBox extends JPanel implements ItemListener
{
	private JCheckBox[] contactSelect;
	private boolean[] selectedContacts;
	private ContactList contacts;

	public ContactListCheckBox(ContactList c)
	{
		contacts = c;
		contactSelect = new JCheckBox[contacts.getLength()];
		selectedContacts = new boolean[contacts.getLength()];

		setLayout(new GridLayout(contacts.getLength(), 1));
		for (int i = 0; i < contacts.getLength(); i++)
		{
			contactSelect[i] = new JCheckBox(contacts.getContact(i).toString(), false);
			contactSelect[i].addItemListener(this);
			contactSelect[i].setVisible(true);
			add(contactSelect[i]);
			selectedContacts[i] = false;
		}

	}

	public ContactList getContacts()
	{
		ContactList selected = new ContactList();
		for (int i = 0; i < contactSelect.length; i++)
		{
			if (selectedContacts[i])
				selected.addContact(contacts.getContact(i));
		}
		return selected;
	}

	public void itemStateChanged(ItemEvent event)
	{
		for (int i = 0; i < contactSelect.length; i++)
		{
			if (contactSelect[i] == (JCheckBox)event.getSource())
			{
				selectedContacts[i] = !selectedContacts[i];
				break;
			}
		}
	}

	public String getEmails()
	{
		String inField = "";
		ContactList selected = getContacts();
		for (int i = 0; i < selected.getLength(); i++)
		{
			inField += selected.getContact(i).getEmailAddress();
			if (i < selected.getLength() - 1)
				inField += ", ";
		}
		return inField;
	}
}