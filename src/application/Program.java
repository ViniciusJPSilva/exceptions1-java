package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanf = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = scanf.nextInt();
			
			System.out.print("Check-in (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(scanf.next());
			
			System.out.print("Check-out (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(scanf.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("\nEnter data to update the reservation: ");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(scanf.next());
			
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(scanf.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e){ //Capturando excessões das datas
			System.out.println("Invalid date format");
		}
		catch(DomainException e) { //Capturanto excessões da excessão personalizada
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) { //Capturando qualquer outra excessão Runtime
			System.out.println("Unexpected error");
		}
		
		scanf.close();
	}

}
