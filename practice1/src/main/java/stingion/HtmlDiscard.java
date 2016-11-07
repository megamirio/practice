package stingion;

import org.jsoup.Jsoup;

public class HtmlDiscard {
    public static String text =
            "Web site developed by <a href=\"https://twitter.com/frodriguez\">@frodriguez</a><br/><br/>\n" +
                    "Powered by:\n" +
                    "<a href=\"/artifact/org.scala-lang\">Scala</a>,\n" +
                    "<a href=\"/artifact/com.typesafe.play\">Play</a>,\n" +
                    "<a href=\"/artifact/org.apache.spark\">Spark</a>,\n" +
                    "<a href=\"/artifact/com.typesafe.akka\">Akka</a> and\n" +
                    "<a href=\"/artifact/org.apache.cassandra\">Cassandra</a></div></div></div><div id=\"footer\">";

    public static void main(String[] args) {
        System.out.println("one");
        System.out.println(Jsoup.parse(text));
        System.out.println(new Integer(33).toString());
    }
}
