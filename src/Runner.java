import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public final static String CHECK = "No travel vouchers with such criteria";

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
			System.out.println(CHECK);
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

	public static void main(String[] args) {
		Runner test = new Runner();
		test.addVouchers( new TreatmentVoucher(200, "03/04/2014", "11/10/2014", "Kiev", "Boston", 10, "car", "dinner"));
		test.addVouchers( new TreatmentVoucher(70000, "03/04/2014", "11/10/2014", "Chicago", "Boston", 10, "car", "dinner"));
		test.addVouchers( new TreatmentVoucher(100, "03/04/2014", "11/10/2014", "Monaco", "Boston", 10, "car", "dinner"));
		test.sortByPrice();
		for(TravelVoucher i: test.getVouchers()){
			System.out.println(i);
		}
		
		
	
	}
}
