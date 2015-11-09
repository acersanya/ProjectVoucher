package ua.epam.projectone.interfac;


public interface Hotelable {
	public static final String WRONGARRGUMENT = "CHECK ARRGUMENTS!";

	public enum HotelTypes {
		ONE, TWO, THREE, FOUR, FIVE
	}

	public HotelTypes getHotelType();

	/**
	 * This is default method implemented in interface
	 * All classes which implement this class may set hotels from enum
	 * @param hotelType one of types represented and HotelTypes
	 * @return HotelType 
	 * @throws IllegalArgumentException check the input validity
	 */
	default public HotelTypes setHotelType(String hotelType) throws IllegalArgumentException{
		for (HotelTypes type : HotelTypes.values()) {
			if (hotelType.equalsIgnoreCase(type.name())) {
				return type;
			}
		}
		throw new IllegalArgumentException(WRONGARRGUMENT);
	}
}


