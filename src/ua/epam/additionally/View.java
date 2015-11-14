package ua.epam.additionally;
import java.util.List;

import ua.epam.vouchers.TravelVoucher;


public class View {
	public static final String DOTED_LINE ="--------------------------------------------------------";
	
	/**
	 * Message Printer
	 * @param t - message
	 */
	public void printer(String t){
		System.out.println(t);
	}
	
	/**
	 * Print voucher attributes
	 * @param t - TravelVoucher
	 */
	public void printer(TravelVoucher t){
		System.out.println(t);
	}
	
	
	/**
	 * Print list of TravelVouchers 
	 * @param list
	 */
	public void printList(List <TravelVoucher> list){
		for(TravelVoucher i : list){
			printer(i);
		}
	}
	
}
