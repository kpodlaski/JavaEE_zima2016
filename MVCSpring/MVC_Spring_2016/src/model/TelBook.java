package model;

import java.util.HashMap;
import java.util.Map;

public class TelBook {
	
	public Map<String, User> book = new HashMap<>();
	
	public TelBook(){
		book.put("halinka",new User("Halinka","1234"));
		book.put("stefcio",new User("Stefan","4321"));
		book.put("edzio",new User("Edward","2341"));
		book.put("marysia",new User("Maria","3412"));
	}

}
