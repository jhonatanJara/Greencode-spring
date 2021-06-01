package pe.edu.upc.Greencode.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private int id;

	@Column(name="number_Account", nullable=false)
	private Integer numberAccount;

	@Column(name="password_Account", nullable=false)
	private Integer passwordAccount;

	@ManyToOne
	@JoinColumn(name="gatherer_id", nullable = false)
	private Gatherer gatherer;

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getnumberAccount() {
		return numberAccount;
	}

	public void setnumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Integer getpasswordAccount() {
		return passwordAccount;
	}

	public void setpasswordAccount(Integer passwordAccount) {
		this.passwordAccount = passwordAccount;
	}


	public Gatherer getgatherer() {
		return gatherer;
	}

	public void setRecycler(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberAccount == null) ? 0 : numberAccount.hashCode());
		result = prime * result + ((passwordAccount == null) ? 0 : passwordAccount.hashCode());
		result = prime * result + id;
		result = prime * result + ((gatherer == null) ? 0 : gatherer.hashCode());
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
		if (id != other.id)
			return false;
		if (gatherer == null) {
			if (other.gatherer != null)
				return false;
		} else if (!gatherer.equals(other.gatherer))
			return false;
		return true;
	}
}