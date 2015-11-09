package ua.epam.vouchers;

import java.util.Date;

import ua.epam.additionally.DateUtil;


public abstract class TravelVoucher  {

	private static final String CHECKPRICE = "Tour price can't be bellow zero";
	private static final String CHECKDAYS = "At least should be one day in your travel voucher!";

	private enum TransportType {
		AIRPLANE, BUS, SHIP, TRAIN, CAR
	}

	private enum NutritionType {
		BREAKFAST, DINNER, SUPPER, NO_MEAL, ALL_PROVIDED
	}

	private int price;
	private Date departureDate;
	private Date returnDate;
	private String leavingFrom;
	private String goingTo;
	private int days;
	private NutritionType nutritionType;
	private TransportType transportType;

	public TravelVoucher(int price, String departureDate, String returnDate, String leavingFrom, String goingTo,
			int days, String transport, String nutrition) {

		setPrice(price);
		setDepartureDate(departureDate);
		setReturnDate(returnDate);
		setLeavingFrom(leavingFrom);
		setGoingTo(goingTo);
		setDays(days);
		setNutritionType(nutrition);
		setTransportType(transport);

	}

	public String getNutritionType() {
		return nutritionType.toString();
	}

	public void setNutritionType(String nutritionType) {
		for (NutritionType type : NutritionType.values()) {
			if (nutritionType.equalsIgnoreCase(type.name())) {
				this.nutritionType = type;
			}
		}
	}

	public String getTransportType() {
			return transportType.toString();
	}

	public void setTransportType(String transportType) {
		for (TransportType type : TransportType.values()) {
			if (transportType.equalsIgnoreCase(type.name())) {
				this.transportType = type;
			}
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			throw new IllegalArgumentException(CHECKPRICE);
		}
		this.price = price;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = DateUtil.convertToDate(departureDate);
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = DateUtil.convertToDate(returnDate);
	}

	public String getLeavingFrom() {
		return leavingFrom;
	}

	public void setLeavingFrom(String leavingFrom) {
		if (leavingFrom != null) {
			this.leavingFrom = leavingFrom;
		}
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		if (goingTo != null) {
			this.goingTo = goingTo;
		}
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		if (days <= 0) {
			throw new IllegalArgumentException(CHECKDAYS);
		}
		this.days = days;
	}



	@Override
	public String toString() {
		return "TravelVoucher [price=" + price + ", departureDate=" + departureDate + ", returnDate=" + returnDate
				+ ", leavingFrom=" + leavingFrom + ", goingTo=" + goingTo + ", days=" + days + ", nutritionType="
				+ nutritionType + ", transportType=" + transportType + "]";
	}

}