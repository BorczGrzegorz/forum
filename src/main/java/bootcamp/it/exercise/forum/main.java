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

// POSTY!!!!!!!!!!!!!!!11

//        postList.add(new Post(1, "Zbigniew Wodecki", "!!!!!!!!!!!**Podwyżki cen komunikacji mejskiej nie dla krakowian***!!!!",
//                "Będzie drożej i tyle,kanary dalej chodza i sprawdzją czy masz bilet i wgl i w szczególe.A tak" +
//                        " w ogóle to nie lubię tramwajów tzw: akwarium.Ciepło w nich i duszno i wgl człowiek na człowieku" +
//                        " i śmierdzi ... tak to już bywa...A wy których tramwajów nie lubicie?"));
//        postList.add(new Post(2, "Johny Bravo", "klata jak u pirata", "Ile razy ćwiczycie w tygodniu?"));
//        postList.add(new Post(3, "kot Jinks", "Podygfvyvnikacji mejskiej nie dla krakowian", "NIenawidzę ty myszy :P wy też?"));
//        postList.add(new Post(4, "Myszka miki", "USZY!?? SERIO??", "czy łądne mam uszy?"));
//        postList.add(new Post(5, "kaczor donald", "kwa kwa?", "Mam problem z kwakaniem"));
//        postList.add(new Post(6, "kaczor donald", "kwa kwa?", "Mam 0problem z kwakaniem,pomóżcie w końcu"));

