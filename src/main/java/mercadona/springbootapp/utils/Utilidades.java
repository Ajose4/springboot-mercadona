package mercadona.springbootapp.utils;

public class Utilidades {
	
	public static Boolean isNumeric(String s) {
		
        if (s == null || s.equals("")) {
            return false;
        }
	 
	        return s.chars().allMatch(Character::isDigit);
    }

}
