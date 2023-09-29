package com.HotelServices.hotelServices.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "hotels")
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private  String about;
}
