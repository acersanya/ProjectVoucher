package ua.epam.vouchers;
import java.util.ArrayList;
import java.util.List;

import ua.epam.projectone.interfac.Hotelable;

public class ExcursionVoucher extends TravelVoucher implements Hotelable {

	private HotelTypes type;
	private List<String> ancientPlaces;

	public ExcursionVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo,
			int days, String transport, String nutrition) {
		super(price, departureDate, returnDate, leavingFrom, goingTo, days, transport, nutrition);
		ancientPlaces = new ArrayList<>();
	}

	/**
	 * 
	 * @return list of ancient places set by administrator
	 */
	public List<String> getAncientPlaces() {
		return ancientPlaces;
	}
	
	/**
	 * This is excursion voucher, so you may
	 * set ancient places for visiting
	 * @param ancient place
	 */
	public void setAncientPlace(String ancient) {
		ancientPlaces.add(ancient);
	}
	
	/**
	 * return hotel
	 */
	@Override
	public HotelTypes getHotelType() {
		return type;
	}

}
