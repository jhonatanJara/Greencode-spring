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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gatherer == null) ? 0 : gatherer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberAccount == null) ? 0 : numberAccount.hashCode());
		result = prime * result + ((passwordAccount == null) ? 0 : passwordAccount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (gatherer == null) {
			if (other.gatherer != null)
				return false;
		} else if (!gatherer.equals(other.gatherer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberAccount == null) {
			if (other.numberAccount != null)
				return false;
		} else if (!numberAccount.equals(other.numberAccount))
			return false;
		if (passwordAccount == null) {
			if (other.passwordAccount != null)
				return false;
		} else if (!passwordAccount.equals(other.passwordAccount))
			return false;
		return true;
	}

}