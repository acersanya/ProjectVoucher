import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class VoucherBase {

	View view;
	public final static String CHECK = "No travel vouchers with such criteria";
	public final static String TRANSPORT = "Please enter transport";
	public final static String NUTRICIAL = "Plase enter when you wan't to take food: {dinner,supper,breakfast}";

	private List<TravelVoucher> vouchers = new ArrayList<TravelVoucher>();

	public List<TravelVoucher> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<TravelVoucher> vouchers) {
		this.vouchers = vouchers;
	}

	public void addVouchers(TravelVoucher voucher) {
		this.vouchers.add(voucher);
	}

	public boolean apply(TravelVoucher voucher, int a, int b) {
		return voucher.getPrice() > a && voucher.getPrice() < b;
	}

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

	public void sortByPrice() {
		Collections.sort(vouchers, new Comparator<TravelVoucher>() {
			@Override
			public int compare(TravelVoucher o1, TravelVoucher o2) {
				return new Integer(o1.getPrice()).compareTo(new Integer(o2.getPrice()));
			}
		});
	}

	public void chooseCriteriaTransport() {
		view.printer(TRANSPORT);
		//System.out.println("sd");
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
	
	public void chooseCriteriaNutricial(){
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
	

	public static void main(String[] args) {
		VoucherBase test = new VoucherBase();
		test.addVouchers(new TreatmentVoucher(200, "03/04/2014", "11/10/2014", "Kiev", "Boston", 10, "car", "dinner"));
		test.addVouchers(
				new TreatmentVoucher(70000, "03/04/2014", "11/10/2014", "Chicago", "Boston", 10, "bus", "dinner"));
		test.addVouchers(
				new TreatmentVoucher(100, "03/04/2014", "11/10/2014", "Monaco", "Boston", 10, "train", "dinner"));
		test.sortByPrice();
		for (TravelVoucher i : test.getVouchers()) {
			//System.out.println(i);
		}

		test.chooseCriteriaTransport();

	}
}
