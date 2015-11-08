import java.util.ArrayList;
import java.util.List;

public class ExcursionVoucher extends TravelVoucher implements Hotelable {

	private HotelTypes type;
	private List<String> ancientPlaces;

	public ExcursionVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo,
			int days, String transport, String nutrition) {
		super(price, departureDate, returnDate, leavingFrom, goingTo, days, transport, nutrition);
		ancientPlaces = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public List<String> getAncientPlaces() {
		return ancientPlaces;
	}

	public void setAncientPlace(String castle) {
		ancientPlaces.add(castle);
	}

	@Override
	public HotelTypes getHotelType() {
		return type;
	}

}
