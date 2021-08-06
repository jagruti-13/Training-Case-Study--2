package com.unext.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="train")
public class Train {
	//@Column(name="train_no")
	@Id
	private int TrainNo;
	@Column(name="train_name")
	private String trainName;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="ticket_price")
	private double ticketPrice;
	public Train() {
		
	}
	public Train(int trainNo, String trainName, String source, String destination, double ticketPrice) {
		super();
		TrainNo = trainNo;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}
	public int getTrainNo() {
		return TrainNo;
	}
	public void setTrainNo(int trainNo) {
		TrainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
