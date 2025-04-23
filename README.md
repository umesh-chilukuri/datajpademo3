# 📦 Spring Boot Data JPA - Custom Queries Demo

This project demonstrates how to use **Spring Data JPA** with **custom JPQL (HQL)** and **native SQL** queries using the `@Query` annotation. It is built using Spring Boot and focuses on `ContactsMasterEntity`, performing CRUD operations.

---

## 📌 What are Custom Queries?

Custom Queries allow developers to write their own SQL or HQL queries rather than relying on Spring Data JPA's method naming conventions.

We can write custom queries using:

- `@Query` annotation (mandatory)
- `@Modifying` for update/delete operations
- `@Transactional` for consistency

---

## 🧠 SQL vs HQL

| Feature | SQL | HQL |
|--------|-----|-----|
| Definition | Structured Query Language | Hibernate Query Language |
| Dependency | DB dependent | DB independent |
| Uses | Table and column names | Entity class and variable names |
| Portability | Low | High |
| Example | `SELECT * FROM emp_tbl` | `FROM Employee` |

### SQL Query Example

```sql
SELECT * FROM emp_data WHERE emp_salary >= 10000;
```

> 🔴 Tightly coupled with DB. Might not work across Oracle/MySQL without changes.

### HQL Query Example

```java
FROM Employee WHERE empGender = 'Male'
```

> 🟢 Uses entity class and is converted to SQL at runtime using dialects like `MySQLDialect`.

---

## 📁 Project Overview

```
├── Springbootdatajpa3Application.java  # Main launcher class
├── entity/
│   └── ContactsMasterEntity.java       # JPA entity class
├── repository/
│   └── ContactsMasterRepo.java         # Repository with custom queries
├── service/
│   └── EmployeeService.java            # Service layer
```

---

## 🔍 Repository - Custom Query Implementations

```java
public interface ContactsMasterRepo extends CrudRepository<ContactsMasterEntity, Serializable> {
```

### 🔹 Get All Contacts (HQL)
```java
@Query("from ContactsMasterEntity")
List<ContactsMasterEntity> getallfromrepo();
```

### 🔹 Update Contact Name By ID (HQL)
```java
@Modifying
@Transactional
@Query("UPDATE ContactsMasterEntity c SET c.contactName = :name WHERE c.contactId = :id")
int updateContactNameById(@Param("id") Integer id, @Param("name") String name);
```

### 🔹 Delete Contact By ID (HQL)
```java
@Modifying
@Transactional
@Query("DELETE FROM ContactsMasterEntity c WHERE c.contactId = :id")
int deleteContactById(@Param("id") Integer id);
```

### 🔹 Find By Contact Number (HQL)
```java
@Query("FROM ContactsMasterEntity c WHERE c.contactNumber = :number")
List<ContactsMasterEntity> findByContactNumber(@Param("number") Long number);
```

---

## ▶️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/umesh-chilukuri/datajpademo3.git
   ```
2. Open in Spring Tool Suite / IntelliJ.
3. Run `Springbootdatajpa3Application.java`.

4. Inside the main method:
   ```java
   // Uncomment to test different features
   // e.insertContact();
   // e.updateContactName();
   // e.deleteContact(110);
   e.getAllEmployee();
   ```

---

## 📘 Example Service Logic

```java
public void updateContactName() {
    int count = cmr.updateContactNameById(107, "Naruto");
    System.out.println("Rows Updated: " + count);
}
```

---

## ✅ Summary

This project is perfect to learn:

- How to write **HQL-based queries** in Spring Data JPA.
- How to use **@Query, @Modifying, @Transactional**.
- Differences between **HQL and SQL** in real-world Spring Boot applications.

---

## 👨‍💻 Author

**Umesh Chilukuri**  
🔗 [GitHub Profile](https://github.com/umesh-chilukuri)

---

## 📄 License

Open-source under the [MIT License](LICENSE).
