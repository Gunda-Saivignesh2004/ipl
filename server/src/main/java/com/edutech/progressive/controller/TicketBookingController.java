package com.edutech.progressive.controller;
 
import com.edutech.progressive.entity.TicketBooking;
import com.edutech.progressive.service.impl.TicketBookingServiceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
@RestController
@RequestMapping("/ticket")
public class TicketBookingController {
 
    private TicketBookingServiceImpl ticketBookingServiceImpl;
    @Autowired
    public TicketBookingController(TicketBookingServiceImpl ticketBookingServiceImpl) {
        this.ticketBookingServiceImpl = ticketBookingServiceImpl;
    }
 
    @GetMapping
    public ResponseEntity<List<TicketBooking>> getAllBookings() {
      return ResponseEntity.ok(ticketBookingServiceImpl.getAllTicketBookings());
    }
    @PostMapping
    public ResponseEntity<Integer> createBooking(TicketBooking ticketBooking) {
       return ResponseEntity.status(HttpStatus.CREATED).body(ticketBookingServiceImpl.createBooking(ticketBooking));
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable int bookingId) {
        ticketBookingServiceImpl.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<List<TicketBooking>> getBookingsByUserEmail(@PathVariable String email) {
        return ResponseEntity.ok(ticketBookingServiceImpl.getBookingsByUserEmail(email));
    }
}