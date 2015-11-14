package ua.epam.main;

import java.util.ArrayList;
import java.util.List;
import ua.epam.vouchers.CruiseVoucher;
import ua.epam.vouchers.TreatmentVoucher;
import ua.epam.vouchers.VoucherBase;
import ua.epam.additionally.View;

public class App {
	public static final String UNSORTED ="This is  unsorted by price voucher base";
	public static final String SORTED ="This is sorted by price voucher base";
	
	
	
	public static void main(String[] args) {
		View view =new View();
		VoucherBase vouchers = new VoucherBase();
		
		vouchers.addVouchers(new TreatmentVoucher(200, "03/04/2014", "11/10/2014", "Kiev", "Prague", 10, "car", "dinner"));
		vouchers.addVouchers(new TreatmentVoucher(7000, "03/04/2014", "11/10/2014", "Portland", "Miami", 10, "ship", "dinner"));
		vouchers.addVouchers(new TreatmentVoucher(100, "03/04/2014", "11/10/2014", "Monaco", "Potsdam", 10, "train", "supper"));
		vouchers.addVouchers(new CruiseVoucher(2500, "03/04/2015", "05/09/2015", "Beijing", "Portland", 100, "ship", "allday", "musica", "deluxe"));
		
		List<String> countries = new ArrayList<>();
		countries.add("Japan");
		countries.add("Indonesia");
		countries.add("USA");
		
		CruiseVoucher temp = (CruiseVoucher)vouchers.getVouchers().get(3);
		temp.setCountries(countries);
		
		vouchers.chooseCriteriaDays();
		view.printer(View.DOTED_LINE);
		
		vouchers.chooseCriteriaNutrition();
		view.printer(View.DOTED_LINE);
		
		vouchers.chooseCriteriaTransport();
		view.printer(View.DOTED_LINE);
		
		view.printer(UNSORTED);
		view.printList(vouchers.getVouchers());
		view.printer(View.DOTED_LINE);
		view.printer(SORTED);
		vouchers.sortByPrice();
		view.printList(vouchers.getVouchers());
		view.printer(view.DOTED_LINE);
		vouchers.getFilterTravelRange();
		


	}
}
