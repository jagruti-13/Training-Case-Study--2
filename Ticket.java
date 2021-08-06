package com.unext.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ticket {
	private static int counter=100;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	TreeMap<Passenger,Integer>passenger=new TreeMap<>();
	public Ticket(LocalDate travelDate, Train train) {
		if(travelDate.isBefore(LocalDate.now())) {
			System.out.println("Travel Date is before current Date");
			System.exit(1);
		}
		this.travelDate = travelDate;
		this.train = train;
	}
	
	public String generatePNR() {
		StringBuilder sb = new StringBuilder();
		char s=train.getSource().charAt(0);
		char d=train.getDestination().charAt(0);
		sb.append(s);
		sb.append(d);
		sb.append('_');
		/*sb.append(this.travelDate.getYear());
		sb.append(this.travelDate.getMonthValue());
		sb.append(this.travelDate.getDayOfMonth());*/
		sb.append(DateTimeFormatter.BASIC_ISO_DATE.format(this.travelDate));
		sb.append('_');
		sb.append(counter);
		this.pnr = sb.toString();
		return pnr;
	}
	
	public double calculatePassengerFare(Passenger p) {
		double amt=0;
		if(p.getAge()<=12) {
			amt=train.getTicketPrice()*0.5;
		}
		else if(p.getAge()>=60) {
			amt=train.getTicketPrice()*0.6;
		}
		else if(p.getGender().equals("F")) {
			amt=train.getTicketPrice()*0.75;
		}
		else {
			amt=train.getTicketPrice();
		}
		return amt;
	}
	
	public void addPassenger(String name,int age, String gender) {
		Passenger pr=new Passenger(name,gender,age);
		double fare=calculatePassengerFare(pr);
		passenger.put(pr, (int) fare);
		counter++;
	}
	
	public double calculateTotalTicketPrice(){
		double totalFare=0.0;
		for(Map.Entry<Passenger, Integer>entry:passenger.entrySet()) {
			totalFare+=entry.getValue();
		}
		return totalFare;
	}
	
	public StringBuilder generateTicket() {
		StringBuilder sb=new StringBuilder("");
		sb.append("PNR:  " +this.generatePNR()+"\n");
		sb.append("Train No:  "+this.train.getTrainNo()+"\n");
		sb.append("From:  "+this.train.getSource()+"\n");
		sb.append("To:  "+this.train.getDestination()+"\n");
		//sb.append("Travel Date:  "+this.travelDate.getDayOfMonth() +"/"+this.travelDate.getMonth()+"/"+this.travelDate.getYear());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		String text = this.travelDate.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		sb.append("Travel Date: "+ parsedDate+"\n");
		sb.append("Passengers: "+"\n");
		sb.append("Name \t Age \tGender \t Fare \n");
		Set<Passenger> ps=new HashSet<>();
		ps=this.passenger.keySet();
		for(Passenger p:ps) {
			sb.append(p.getName()+"\t"+p.getAge()+"\t"+p.getGender()+"\t"+this.calculatePassengerFare(p)+"\n");
		}
		sb.append("\n"+"Total Price:  "+this.calculateTotalTicketPrice());
		return sb;
	}
	
	public void writeTicket() throws IOException {
		String str=this.generateTicket().toString();
		String filename=this.generatePNR()+".txt";
		File file=new File(filename);
		FileOutputStream fos=new FileOutputStream(file,true);
		byte[] text=str.getBytes();
		fos.write(text);
		fos.close();
	}
	
	public int countTickets(LocalDate date) {
		int cnt=0;
		
		return cnt;
	}
}
