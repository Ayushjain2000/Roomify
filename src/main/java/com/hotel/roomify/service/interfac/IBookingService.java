package com.hotel.roomify.service.interfac;

import com.hotel.roomify.dto.Response;
import com.hotel.roomify.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
