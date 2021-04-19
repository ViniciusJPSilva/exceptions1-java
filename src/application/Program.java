package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scanf = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = scanf.nextInt();
		
		System.out.print("Check-in (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(scanf.next());
		
		System.out.print("Check-out (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(scanf.next());
		
		if(!checkOut.after(checkIn))
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("\nEnter data to update the reservation: ");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(scanf.next());
			
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(scanf.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now))
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			else if(!checkOut.after(checkIn))
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		scanf.close();
	}

}
