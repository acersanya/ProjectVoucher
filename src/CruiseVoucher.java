import java.util.List;

public class CruiseVoucher extends TravelVoucher {

	private List<String> countries;

	// type of cabins
	private enum CabinType {
		COMMODORE, DELUXE, SUITE, PROMENADE
	};

	// liner classes
	private enum LinerType {
		FANTASIA, MUSICA, LIRICA
	};

	CabinType cabinType;
	LinerType linerType;

	public CruiseVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo, int days,
			String transport, String nutrition, String linerType, String cabinType) {
		super(price, departureDate, returnDate, leavingFrom, goingTo, days, transport, nutrition);
		setLinerType(linerType);
		setCabinType(cabinType);
	}

	/**
	 * This method returns list of counties through which 
	 * cruise is taking place 
	 * @return countries 
	 */
	public List<String> getCountries() {
		return countries;
	}

	/**
	 * Add country for cruise
	 * @param countries to add to the list
	 */
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	
	public CabinType getCabinType() {
		return cabinType;
	}

	/**
	 * There are different liner cabin types
	 * This method set liner cabin and checks 
	 * the cabin validity
	 * @param cabinType
	 */
	public void setCabinType(String cabinType) {
		for (CabinType type : CabinType.values()) {
			if (cabinType.equalsIgnoreCase(type.name())) {
				this.cabinType = type;
			}
		} throw new IllegalArgumentException("CHECK ARGUMENT");
	}

	/**
	 * @return liner cabin type
	 */
	public LinerType getLinerType() {
		return linerType;
	}

	/**
	 * This method is used for setting liner 
	 * type.
	 * @param linerType to set
	 */
	public void setLinerType(String linerType) {
		for (LinerType type : LinerType.values()) {
			if (linerType.equalsIgnoreCase(type.name())) {
				this.linerType = type;
			}
		}

	}

}
