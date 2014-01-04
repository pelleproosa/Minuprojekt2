package pele.mysql.library.katse;


import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
// ...
public class random {

 
public static int start (int kogus) {
   try {
     SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
     // Generate 20 integers 0..20
     for (int i = 0; i < 1; i++) {
  //     System.out.println(number.nextInt(kogus));
       kogus=(number.nextInt(kogus));
     }
   } catch (NoSuchAlgorithmException nsae) { 
     // Forward to handler
   }
return kogus;
}
}