package ua.epam.vouchers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ua.epam.projectone.interfac.Hotelable;

public class ShoppingVoucher  extends TravelVoucher implements Hotelable {

	private HotelTypes hotel;
	private List<String> shoppingPlaces;

	public ShoppingVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo,
			int days, String transport, String nutrition) {
		super(price, departureDate, returnDate, leavingFrom, goingTo, days, transport, nutrition);
		this.shoppingPlaces = new ArrayList<String>();
	}
	
	
	/**
	 * Setter
	 * You may set here placed to visit (Mall,Shops,boutique)
	 * @param shop
	 */
	public void settShoppingList(String shop){
		shoppingPlaces.add(shop);
	}

	
	@Override
	public HotelTypes getHotelType() {
		return hotel;
	}

	
	
}
