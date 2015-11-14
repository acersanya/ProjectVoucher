package ua.epam.vouchers;
import ua.epam.interfaces.Hotelable;

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
	}

	/**
	 * Getter for disease
	 * @return disease
	 */
	public DISEASE getDisease() {
		return disease;
	}

	/**
	 * This is Treatment Voucher so people are placed here according
	 * to their diagnosis. You may put  any available diagnose from enum 
	 * @param disease
	 */
	public void setDisease(String disease) {
		for (DISEASE type : DISEASE.values()) {
			if (disease.equalsIgnoreCase(type.name())) {
				this.disease = type;
			}
		}
	}

	/**
	 * implemented method from Hotelable interface
	 */
	@Override
	public HotelTypes getHotelType() {
		return hotel;
	}

}
