package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * The persistent class for the customers_orders_documents_types database table.
 * 
 */
@Entity
@Table(name="customers_orders_documents_types")
@NamedQuery(name="CustomerOrderDocumentType.findAll", query="SELECT c FROM CustomerOrderDocumentType c")
public class CustomerOrderDocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name="document_date")
	private LocalDateTime documentDate;

	@NotNull
	@Column(name="document_number")
	private int documentNumber;

	//bi-directional many-to-one association to CustomerOrder
	@ManyToOne
	@JoinColumn(name="id_customer_order")
	private CustomerOrder customerOrder;

	//bi-directional many-to-one association to DocumentType
	@ManyToOne
	@JoinColumn(name="id_document_type")
	private DocumentType documentType;

	public CustomerOrderDocumentType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(LocalDateTime documentDate) {
		this.documentDate = documentDate;
	}

	public int getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public DocumentType getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

}