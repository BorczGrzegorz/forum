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
        System.out.println(DigestUtils.md5Hex("minimum"));
    }
    // <div>
    //        <form method="post">
    //            <textarea th:field="*{post.header}" rows="2" cols="70"></textarea><br>
    //            <textarea th:field="*{post.content}" rows="7" cols="100">  </textarea><br>
    //            autor:<input type="text" placeholder="Autor" class="text-input" id="author" th:field="*{post.author}">
    //              postId:<input type="text" placeholder="Id" class="text-input" id="id" th:field="*{post.id}"><br>
    //            <input type="submit" value="OK" class="button">
    //            <input type="reset">
    //        </form>
    //    </div>
}
