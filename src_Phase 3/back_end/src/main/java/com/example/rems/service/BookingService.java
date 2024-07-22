package com.example.rems.service;

import com.example.rems.domain.BookingDetails;
import com.example.rems.entity.Booking;
import com.example.rems.entity.Reward;
import com.example.rems.repository.BookingRepo;
import com.example.rems.repository.RewardsRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Resource
    private BookingRepo bookingRepo;

    @Resource
    private RewardsRepo rewardsRepo;

    public String bookAProperty(List<BookingDetails> bookingDetails) {

        List<Booking> bookingList = new ArrayList<>();
        bookingDetails.forEach(booking -> {
            Booking b = bookingRepo.saveAndFlush( Booking.builder().pid(booking.getPid())
                    .booking_amount(booking.getBooking_amount())
                    .creditcard_number(booking.getCreditcard_number())
                    .email(booking.getEmail())
                    .name(booking.getName())
                    .start_date(booking.getStart_date())
                    .end_date(booking.getEnd_date()).build());

            rewardsRepo.save(Reward.builder().bid(b.getId()).pid(booking.getPid()).name(booking.getName())
                    .email(booking.getEmail()).reward_point(booking.getBooking_amount()).build());

        });
        return "Success";
    }

    public List<Booking> getAllBookings(String email) {
       return bookingRepo.findByEmail(email);
    }

    public String updatebooking(BookingDetails bookingDetails) {
        Optional<Booking> bookingEntity = bookingRepo.findById(bookingDetails.getId());
        if (bookingEntity.isPresent()){
            Booking booking = bookingEntity.get();
            booking.setBooking_amount(bookingDetails.getBooking_amount());
            booking.setCreditcard_number(bookingDetails.getCreditcard_number());
            booking.setStart_date(bookingDetails.getStart_date());
            booking.setEnd_date(bookingDetails.getEnd_date());
            bookingRepo.save(booking);
        }
        else {
            return "No Booking Found";
        }

        return "Updated SuccessFully";
    }

    public String cancelBooking(BigInteger id) {
        bookingRepo.deleteById(id);
        return "Deleted SuccessFully and Amount is refunded";
    }
}
