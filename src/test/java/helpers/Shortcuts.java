package test.java.helpers;

import org.openqa.selenium.Keys;

public class Shortcuts {
	public static final CharSequence GET_READY = Keys.chord(Keys.CONTROL,
			Keys.ALT, Keys.ENTER);

	public static final CharSequence HOME = Keys.chord(Keys.ALT, "q");
	public static final CharSequence HOME_PLUS = Keys.chord(Keys.ALT, "w");
	public static final CharSequence MESSAGE = Keys.chord(Keys.ALT, "e");

	public static final CharSequence HOLD = Keys.chord(Keys.ALT, "l");
	public static final CharSequence TRANSFER = Keys.chord(Keys.CONTROL,
			Keys.SUBTRACT);
	public static final CharSequence PICKUP = Keys.ADD;
	public static final CharSequence DIAL = Keys.MULTIPLY;
	public static final CharSequence HANGUP = Keys.DIVIDE;

	public static final CharSequence CANCEL = Keys.chord(Keys.ALT, "y");
	public static final CharSequence CONFIRM = Keys.chord(Keys.ALT, "g");

	public static final CharSequence DIRECT_NO = Keys.chord(Keys.ALT, "1");
	public static final CharSequence MOBILE_NO = Keys.chord(Keys.ALT, "2");
	public static final CharSequence COMPANY_BOX = Keys.chord(Keys.ALT, "v");
	public static final CharSequence SEARCH_CONTACT = Keys.chord(Keys.ALT, "s");
	public static final CharSequence CALENDAR_BOX = Keys.chord(Keys.ALT, "k");
	public static final CharSequence EVENTS_BOX = Keys.chord(Keys.ALT, "a");

	public static final CharSequence PARK = Keys.F7;

	public static String SELECT_1_NR = Keys.chord(Keys.ALT, "1");
}
