package bootcamp.it.exercise.forum;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

public class main {
    public static void main(String[] args) {

        Optional<Integer> op = Optional.empty();

        System.out.println("Optional: " + op);

        Date date = new Date();
       System.out.println(ZonedDateTime.now().toString().substring(0, 10)+ " godz: "+ZonedDateTime.now().toString().substring(11, 16));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(DigestUtils.md5Hex("admin"));
    }
}
