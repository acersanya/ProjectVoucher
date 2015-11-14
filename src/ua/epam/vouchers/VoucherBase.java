package ua.epam.vouchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ua.epam.additionally.View;
import ua.epam.interfaces.Filter;

public class VoucherBase implements Filter  {
	
	// low and high cost for Vouchers
	private int lowCost;
	private int highCost;
	
	//View
	private View view;
	private List<TravelVoucher> vouchers;
	public final static String CHECK = "No travel vouchers with such criteria";
	public final static String TRANSPORT = "Please enter transport";
	public final static String NO_TRANSPORT = "No transport for this criteria";
	public final static String DAYS = "Enter how much days you want at least";
	public final static String NO_DAYS = "There are no avaible vouchers for this amount of days";
	public final static String NUTRICIAL = "Plase enter when you wan't to take food: {dinner,supper,breakfast}";
	public final static String NO_NUTRICIAL = "No such nutricial, try again ";
	public final static String RANGE_VOUCHER =	"Choose voucher from range. Type lower bound and upper bound";

	/**
	 * VoucherBase is class for storing are vouchers available for customers
	 * Here you can place new travel vouchers Sort this vouchers by price Choose
	 * vouchers from available price interval Choose vouchers according to
	 * nutrition, transport and day remaining
	 */
	public VoucherBase() {
		view = new View();
		vouchers = new ArrayList<TravelVoucher>();
	}

	/**
	 * Getter for vouchers
	 * @return list of available vouchers
	 */
	public List<TravelVoucher> getVouchers() {
		return vouchers;
	}

	/**
	 * Setter for vouchers
	 * @param voucher add to the list
	 */
	public void addVouchers(TravelVoucher voucher) {
		this.vouchers.add(voucher);
	}

	/**
	 * Implemented method from Filter interface
	 */

	/**
	 * Get vouchers from price range
	 * @param a lower price bound
	 * @param b upper price bound
	 * @return list of vouchers from this price interval
	 */
	public void getFilterRange(Filter filter) {
		List<TravelVoucher> res = new ArrayList<>();
		getVouchers().stream().filter((voucher) -> (filter.apply(voucher) == true)).forEach((voucher) -> {
			res.add(voucher);
		});
		if (res.size() == 0) {
			//view.printer(CHECK);
		}
		System.out.println("STUB");
		view.printList(res);
	}
	
	
	public void getFilterTravelRange(){
		this.lowCost = getBoundPrice();
		this.highCost = getBoundPrice();
		Filter filter = new VoucherBase(){
				@Override
	public boolean apply(TravelVoucher voucher) {			
		return voucher.getPrice() > lowCost && voucher.getPrice() < highCost;
	}
		};
		getFilterRange(filter);
	}
	

	/**
	 * Sorts all vouchers by price Anonymous class used for implementing
	 * comparator compare method
	 */
	public void sortByPrice() {
		Collections.sort(vouchers, new Comparator<TravelVoucher>() {
			@Override
			public int compare(TravelVoucher o1, TravelVoucher o2) {
				return new Integer(o1.getPrice()).compareTo(new Integer(o2.getPrice()));
			}			
		});
		//Using Comparator with Java 8 
		//Collections.sort(vouchers,Comparator.comparing(TravelVoucher::getPrice));
	}

	/**
	 * Choose voucher based on customer transport preference
	 * Prints all vouchers according to users decision
	 */
	public void chooseCriteriaTransport() {
		view.printer(TRANSPORT);
		String transport;
		Scanner userInput = null;
		userInput = tryScan(userInput);
		transport = userInput.nextLine();
		for (TravelVoucher i : getVouchers()) {
			if (transport.equalsIgnoreCase(i.getTransportType())) {
				view.printer(i);
				return;
			}
		}
		view.printer(NO_TRANSPORT);
	}

	/**
	 * Choose voucher based on customer nutrition preference
	 * Checks nutrition from ENUM
	 */
	public void chooseCriteriaNutrition() {
		view.printer(NUTRICIAL);
		String nutricial = null;
		Scanner userInput = null;
		userInput = tryScan(userInput);
		try{
		nutricial = userInput.nextLine();
		} catch (InputMismatchException e){
			System.out.println(e);
		}
		for (TravelVoucher i : getVouchers()) {
			if (nutricial.equalsIgnoreCase(i.getNutritionType())) {
				view.printer(i);
				return;
			}
		}
		view.printer(NO_NUTRICIAL);
	}

	/**
	 * Choose voucher based on customer weekend days preference
	 */
	public void chooseCriteriaDays() {
		boolean check = false;
		view.printer(DAYS);
		int days = 0;
		Scanner userInput = null;
		userInput = tryScan(userInput);
		try{
		days = userInput.nextInt();
		} catch (InputMismatchException e){
			e.printStackTrace();
			}
		for (TravelVoucher i : getVouchers()) {
			if (days <= i.getDays()) {
				view.printer(i);
				check = true;
			}
		}
		if(check == false){
			view.printer(NO_DAYS);
		}
	}
	
	/**
	 * User can set voucher price range via console.
	 * If vouchers with set price exist in list
	 * they will be printed 
	 * @return 
	 */
	public int getBoundPrice(){
		int temp = 0;
		Scanner userInput = null;
		view.printer(RANGE_VOUCHER);
		userInput = tryScan(userInput);
		try{
			temp = userInput.nextInt();
		} catch( InputMismatchException e){
			e.printStackTrace();
			}
		return temp;
	}

	/**
	 * Creates new Scanner and handle error if occurs
	 * @param userInput Scanner object
	 * @return Scanner object
	 */
	private Scanner tryScan(Scanner userInput) {
		try{
			userInput = new Scanner(System.in);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userInput;
	}

	@Override
	public boolean apply(TravelVoucher object) {
		// TODO Auto-generated method stub
		return false;
	}
}
