package ua.epam.additionally;
import ua.epam.vouchers.TravelVoucher;

public class View {

	/**
	 * Message Printer
	 * @param t - message
	 */
	public void printer(String t){
		System.out.println(t);
	}
	
	/**
	 * Print object attributes
	 * @param t - object
	 */
	public void printer(TravelVoucher t){
		System.out.println(t);
	}

}
