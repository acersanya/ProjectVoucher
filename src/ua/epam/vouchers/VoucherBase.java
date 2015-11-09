package ua.epam.vouchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import ua.epam.additionally.View;
import ua.epam.projectone.interfac.*;

import ua.epam.projectone.interfac.Filter;

public class VoucherBase implements Filter {

	private View view;
	private List<TravelVoucher> vouchers;
	public final static String CHECK = "No travel vouchers with such criteria";
	public final static String TRANSPORT = "Please enter transport";
	public final static String DAYS = "Enter how much days you want at least";
	public final static String NUTRICIAL = "Plase enter when you wan't to take food: {dinner,supper,breakfast}";

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
	 * Getter
	 * @return list of available vouchers
	 */
	public List<TravelVoucher> getVouchers() {
		return vouchers;
	}

	/**
	 * Setter
	 * @param voucher add to the list
	 */
	public void addVouchers(TravelVoucher voucher) {
		this.vouchers.add(voucher);
	}

	/**
	 * Implemented method from Filter interface
	 */
	@Override
	public boolean apply(TravelVoucher voucher, int a, int b) {
		return voucher.getPrice() > a && voucher.getPrice() < b;
	}

	/**
	 * 
	 * @param a lower price bound
	 * @param b upper price bound
	 * @return list of vouchers from this price interval
	 */
	public List<TravelVoucher> getVoucherPriceRange(int a, int b) {
		List<TravelVoucher> res = new ArrayList<>();

		getVouchers().stream().filter((voucher) -> (apply(voucher, a, b) == true)).forEach((voucher) -> {
			res.add(voucher);

		});
		if (res.size() == 0) {
			view.printer(CHECK);
		}
		return res;
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
	}

	/**
	 * Choose voucher based on customer transport preference
	 */
	public void chooseCriteriaTransport() {
		view.printer(TRANSPORT);
		String transport;
		Scanner userInput = null;
		try {
			userInput = new Scanner(System.in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		transport = userInput.nextLine();
		for (TravelVoucher i : getVouchers()) {
			if (transport.equalsIgnoreCase(i.getTransportType())) {
				view.printer(i);
			}
		}
	}

	/**
	 * Choose voucher based on customer nutrition preference
	 */
	public void chooseCriteriaNutrition() {
		view.printer(NUTRICIAL);
		String nutricial;
		Scanner userInput = null;
		try {
			userInput = new Scanner(System.in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		nutricial = userInput.nextLine();
		for (TravelVoucher i : getVouchers()) {
			if (nutricial.equalsIgnoreCase(i.getNutritionType())) {
				view.printer(i);
			}
		}
	}

	/**
	 * Choose voucher based on customer weekend days preference
	 */
	public void chooseCriteriaDaysl() {
		view.printer(DAYS);
		int days;
		Scanner userInput = null;
		try {
			userInput = new Scanner(System.in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		days = userInput.nextInt();
		for (TravelVoucher i : getVouchers()) {
			if (days == i.getDays() || (days > i.getDays())) {
				view.printer(i);
			}
		}
	}

}
