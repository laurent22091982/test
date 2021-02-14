package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the documents_types database table.
 * 
 */
@Entity
@Table(name="documents_types")
@NamedQuery(name="DocumentType.findAll", query="SELECT d FROM DocumentType d")
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to CustomerOrderDocumentType
	@OneToMany(mappedBy="documentType")
	private List<CustomerOrderDocumentType> customersOrdersDocumentsTypes;

	public DocumentType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<CustomerOrderDocumentType> getCustomersOrdersDocumentsTypes() {
		return this.customersOrdersDocumentsTypes;
	}

	public void setCustomersOrdersDocumentsTypes(List<CustomerOrderDocumentType> customersOrdersDocumentsTypes) {
		this.customersOrdersDocumentsTypes = customersOrdersDocumentsTypes;
	}

	public CustomerOrderDocumentType addCustomerOrderDocumentType(CustomerOrderDocumentType customerOrderDocumentType) {
		getCustomersOrdersDocumentsTypes().add(customerOrderDocumentType);
		customerOrderDocumentType.setDocumentType(this);

		return customerOrderDocumentType;
	}

	public CustomerOrderDocumentType removeCustomerOrderDocumentType(CustomerOrderDocumentType customerOrderDocumentType) {
		getCustomersOrdersDocumentsTypes().remove(customerOrderDocumentType);
		customerOrderDocumentType.setDocumentType(null);

		return customerOrderDocumentType;
	}

}