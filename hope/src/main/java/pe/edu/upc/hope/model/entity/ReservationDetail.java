package pe.edu.upc.hope.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReservationDetails")
public class ReservationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservationDetail;
	
	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "idReservation", nullable = false)
		private Reservation  reservation;

	  @ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "idReservation", nullable = false)
			private Product  product;

	  
		//========================= setters and getters and constructor 
	  
		public ReservationDetail(int idReservationDetail, Reservation reservation, Product product) {
			super();
			this.idReservationDetail = idReservationDetail;
			this.reservation = reservation;
			this.product = product;
		}
	  
	public ReservationDetail() {
			super();
			// TODO Auto-generated constructor stub
		}

	public int getIdReservationDetail() {
		return idReservationDetail;
	}



	public void setIdReservationDetail(int idReservationDetail) {
		this.idReservationDetail = idReservationDetail;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	  

	  
	  
}
