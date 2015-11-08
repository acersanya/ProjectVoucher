

public interface Hotelable {
	public static final String WRONGARRGUMENT = "CHECK ARRGUMENTS!";

	public enum HotelTypes {
		ONE, TWO, THREE, FOUR, FIVE
	}

	public HotelTypes getHotelType();

	default public HotelTypes setHotelType(String hotelType) throws IllegalArgumentException{
		for (HotelTypes type : HotelTypes.values()) {
			if (hotelType.equalsIgnoreCase(type.name())) {
				return type;
			}
		}
		throw new IllegalArgumentException(WRONGARRGUMENT);
	}
}


