package encode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encode {
	public static String toSHA1(String str) {
		String salt = "hdyfdknjdfjdhfdjfhdfd";
		str += salt;
		BigInteger bigInt = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(str.getBytes());
			bigInt = new BigInteger(1,messageDigest);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bigInt.toString(16);
	}
}
