import java.util.*;
import java.io.*;


public class ContactList
{
	private LinkedList<Contact> contacts;
	private String textFile;
	private boolean saveFlag;

	public ContactList()
	{
		contacts = new LinkedList<Contact>();
		saveFlag = false;
	}

	public ContactList(String fileName)
	{
		textFile = fileName;
		contacts = new LinkedList<Contact>();
		saveFlag = true;

		try
		{
			File f = new File(fileName);
			Scanner input = new Scanner(f);

			String line = "";
			while (input.hasNextLine())
			{
				line = input.nextLine();
				if (line.length() > 0)
				{
					contacts.add(parseContact(line));
				}
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			update();
		}
	}

	public int getContactIndex(Contact contact)
	{
		return contacts.indexOf(contact);
	}

	public Contact getContact(int index)
	{
		return contacts.get(index);
	}

	public void addContact(Contact contact)
	{
		if (!contacts.contains(contact))
		{
			contacts.add(contact);
			Contact[] cArray = contacts.toArray(new Contact[0]);
			Arrays.sort(cArray);
			LinkedList<Contact> temp = new LinkedList<Contact>();
			for (int i = 0; i < cArray.length; i++)
				temp.add(cArray[i]);
			contacts = temp;
			if (saveFlag)
				update();
		}
	}

	public void editContact(Contact oldContact, Contact editedContact)
	{
		contacts.remove(oldContact);
		addContact(editedContact);
	}

	public void removeContact(Contact contact)
	{
		if (contacts.size() > 0)
		{
			contacts.remove(contact);
			Contact[] cArray = contacts.toArray(new Contact[0]);
			Arrays.sort(cArray);
			LinkedList<Contact> temp = new LinkedList<Contact>();
			for (int i = 0; i < cArray.length; i++)
				temp.add(cArray[i]);
			contacts = temp;
			if (saveFlag)
				update();
		}
	}

	public int getLength()
	{
		return contacts.size();
	}

	public String toString()
	{
		String contactsString = "";
		for (int i = 0; i < contacts.size(); i++)
		{
			if (i > 0)
				contactsString += "\n";
			contactsString += contacts.get(i).getFirstName() + " ";
			contactsString += contacts.get(i).getLastName() + " ";
			contactsString += contacts.get(i).getEmail();
		}
		return contactsString;
	}

	private String tagContact(Contact contact)
	{
		String tag = "";
		if (contact.getFirstName() != "")
			tag += "FIRSTN" + contact.getFirstName() + " ";
		if (contact.getLastName() != "")
			tag += "LASTN" + contact.getLastName() + " ";
		tag += contact.getEmail();
		return tag;
	}

	private Contact parseContact(String fileLine)
	{
		Contact person = new Contact();
		String toSet = "";
		String[] infoArray = fileLine.split("/ /");

		if (infoArray.length == 1)
			person.setEmail(infoArray[0]);
		else if (infoArray.length == 2)
		{
			if (infoArray[0].contains("FIRSTN"))
				person.setFirstName(infoArray[0].substring(6));
			else
				person.setLastName(infoArray[0].substring(5));

			person.setEmail(infoArray[1]);
		}
		else if (infoArray.length == 3)
		{
			person.setFirstName(infoArray[0].substring(6));
			person.setLastName(infoArray[1].substring(5));
			person.setEmail(infoArray[2]);
		}

		return person;
	}

	private void update()
	{
		try
		{
			FileWriter f = new FileWriter(textFile);
			BufferedWriter outFile = new BufferedWriter(f);
			for (int i = 0; i < contacts.size(); i++)
			{
				if (i > 0)
					outFile.newLine();
				outFile.write(tagContact(contacts.get(i)));
			}
			outFile.close();
		}
		catch (IOException e) {}
	}
}