
public class TreatmentVoucher extends TravelVoucher implements Hotelable {

	//The most common disease list is placed here 
	private enum DISEASE {
		ASTHMA, ALLERGY, OBESITY, LIVER, ULCER
	}

	private DISEASE disease;
	private HotelTypes hotel;

	public TreatmentVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo,
			int days, String transport, String nutrition) {
		super(price, departureDate, returnDate, leavingFrom, goingTo, days, transport, nutrition);
		// TODO Auto-generated constructor stub
	}

	public DISEASE getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		for (DISEASE type : DISEASE.values()) {
			if (disease.equalsIgnoreCase(type.name())) {
				this.disease = type;
			}
		}
	}

	@Override
	public HotelTypes getHotelType() {
		return hotel;
	}

}
