package pe.edu.upc.Greencode.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {
  //new account
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private Integer id;

	@Column(name="number_Account", nullable=false)
	private Integer numberAccount;

	@Column(name="password_Account", nullable=false)
	private Integer passwordAccount;

	@ManyToOne
	@JoinColumn(name="gatherer_id", nullable = false)
	private Gatherer gatherer;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Transaction> Transactions;

	public Account() {
		super();
		Transactions = new  ArrayList<Transaction>();
	}
	
	

	@Override
	public String toString() {
		return "Account [id=" + id + ", numberAccount=" + numberAccount + ", passwordAccount=" + passwordAccount
				+ ", gatherer=" + gatherer + ", Transactions=" + Transactions + "]";
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Integer getPasswordAccount() {
		return passwordAccount;
	}

	public void setPasswordAccount(Integer passwordAccount) {
		this.passwordAccount = passwordAccount;
	}

	public Gatherer getGatherer() {
		return gatherer;
	}

	public void setGatherer(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	public List<Transaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		Transactions = transactions;
	}

	

}