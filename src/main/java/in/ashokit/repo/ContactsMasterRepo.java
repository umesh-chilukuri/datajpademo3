package in.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entities.ContactsMasterEntity;

public interface ContactsMasterRepo  extends CrudRepository<ContactsMasterEntity,Serializable>{

	
	@Query("from ContactsMasterEntity")
	public List<ContactsMasterEntity> getallfromrepo();
	
	    @Modifying
	    @Transactional
	    @Query("UPDATE ContactsMasterEntity c SET c.contactName = :name WHERE c.contactId = :id")
	    public int updateContactNameById(@Param("id") Integer i, @Param("name") String n);
	    //in the above code id is mapped with "i" and then send it to the @Query
	
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM ContactsMasterEntity c WHERE c.contactId = :id")
	 public int deleteContactById(@Param("id") Integer id);

	 @Query("FROM ContactsMasterEntity c WHERE c.contactNumber = :number")
	 public List<ContactsMasterEntity> findByContactNumber(@Param("number") Long number);
	 /*
	  @Modifying
      @Transactional
      @Query("UPDATE ContactsMasterEntity c SET c.contactName = :name WHERE c.contactId = :id")
      public int updateContactNameById(Integer id, String name);  // ✅ variable names match :id and :name

      @Modifying
      @Transactional
      @Query("DELETE FROM ContactsMasterEntity c WHERE c.contactId = :id")
      public int deleteContactById(Integer id);  // ✅ variable name matches :id

      @Query("FROM ContactsMasterEntity c WHERE c.contactNumber = :number")
      public List<ContactsMasterEntity> findByContactNumber(Long number);  // ✅ variable name matches :number

	  */

}
