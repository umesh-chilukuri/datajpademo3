package in.ashokit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entities.ContactsMasterEntity;
import in.ashokit.repo.ContactsMasterRepo;


@Service
public class EmployeeService {
	
	private ContactsMasterRepo cmr;

	public  EmployeeService(ContactsMasterRepo cmr) {
		this.cmr = cmr;
	}
	
	public void insertContact() {
		//first you need to create object for entity class
		 ContactsMasterEntity contact = new ContactsMasterEntity();
		 contact.setContactId(110);  // Use a unique ID
	        contact.setContactName("allu arjun");
	        contact.setContactNumber(9876543210L);

	        cmr.save(contact);  // 🔥 This inserts a new record
	        System.out.println("Contact inserted!");	 
	}
	
	public void updateContactName() {
        int count = cmr.updateContactNameById(107, "Naruto");
        System.out.println("Rows Updated: " + count);
    }

    public void deleteContact(int i) {
        int count = cmr.deleteContactById(i);
        System.out.println("Rows Deleted: " + count);
    }


	public void  getAllEmployee() {
		 List<ContactsMasterEntity>	members=	cmr.getallfromrepo();
		 members.forEach(System.out::println);
	}
	
	
	
	
	
}
