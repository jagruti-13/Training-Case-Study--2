package com.unext.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unext.model.Ticket;
import com.unext.model.Train;
import com.unext.repository.TrainRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TrainRepository trainRepository;
	@RequestMapping("/bookticket")
	public String bookTicket(@RequestParam int code,int y,int m,int d,String name,int age,String gender) throws IOException {
		Optional<Train>trainData=trainRepository.findById(code);
		LocalDate date2=LocalDate.of(y, m, d);
		Train train=null;
		if(trainData.isPresent()) {
			train=trainData.get();
			Ticket ticket=new Ticket(date2, train);
			ticket.addPassenger(name, age, gender);	
			ticket.writeTicket();
			return "Booked Successfully!!";
		}	
		else {
			return "Failed to book ticket";
		}
	}
	@RequestMapping("/enquiry")
	public String enquiry(@RequestParam int code) {
		Optional<Train>trainData=trainRepository.findById(code);
		if(trainData.isPresent()) {
			return "Train is available";
		}
		return "Not Available";
	}
}


