package de.tum.in.ase.eist;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Lucas";
        } else if (query.contains("largest")) {
            String[] parts = query.split(":");
            String numbers = parts[1];
            String[] newStr = numbers.split(",");
            int largestnumber = 0;
            for (String s : newStr) {
                if (Integer.parseInt(s) > largestnumber) {
                    largestnumber = Integer.parseInt(s);
                }
            }
            return String.valueOf(largestnumber);
        } else if(query.contains("plus")){
            String first = query.substring(query.indexOf("is%20") + 1, query.indexOf("%20plus"));
            String second = query.substring(query.indexOf("plus%20") + 1, query.indexOf('"'));

            int finalint = Integer.parseInt(first) + Integer.parseInt(second);

            return String.valueOf(finalint);

        }
        else {
            return "";
        }
    }
}


