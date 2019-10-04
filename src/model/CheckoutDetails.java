package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="checkout_details")
public class CheckoutDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRANS_ID")
	private int id;
	
	@Column(name="TRANS_CODE")
	private String transCode;
	
	@Column(name="TRANS_DATE")
	private LocalDate transDate;
	
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany (cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable ( name="checkout_items", joinColumns={ @JoinColumn(name="TRANS_ID", referencedColumnName="TRANS_ID") }, inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) } )
	 private List<ListItem> listOfItems;
	
	public CheckoutDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckoutDetails(String transCode, LocalDate transDate, User user) {
		this.transCode = transCode;
		this.transDate = transDate;
		this.user = user;
	}

	public CheckoutDetails(int id, String transCode, LocalDate transDate, User user, List<ListItem> listOfItems) {
		this.id = id;
		this.transCode = transCode;
		this.transDate = transDate;
		this.user = user;
		this.listOfItems = listOfItems;
	}
	
	public CheckoutDetails(String transCode, LocalDate transDate, User user, List<ListItem> listOfItems) {
		this.transCode = transCode;
		this.transDate = transDate;
		this.user = user;
		this.listOfItems = listOfItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransName(String transCode) {
		this.transCode = transCode;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ListItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "CheckoutDetails [id=" + id + ", listName=" + transCode + ", tripDate=" + transDate + ", user=" + user
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}