package ua.epam.interfaces;
import ua.epam.vouchers.*;

public interface Filter {
	boolean apply(TravelVoucher object);
}
