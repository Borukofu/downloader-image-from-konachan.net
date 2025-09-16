package func;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class search {
    public static String[] links(String urlString){
        try {

            System.out.println("[ ЗАРГУЗКА 💾 ] загрузка сайта по этому url -> "+urlString);
            
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();

            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            System.out.println("[ ЗАГРУЖЕНО ✅ ] сайт успешно загружен url -> "+urlString);


            String html = content.toString();
            // System.out.println(html);

            String regex = "(https?://[^\\s]+?\\.(jpg|jpeg|png|gif|bmp|webp))";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(html);
            
            String linksString = "";

            while (matcher.find()) {
                String item = matcher.group(0);
                if(item.length()>78){
                    linksString += item+"%20!20%";
                }
            }
            
            String[] links = linksString.split("%20!20%");

            return links;
        } catch (Exception e) {
            System.out.println("[ ERROR ❌ ] "+e);
            e.printStackTrace();
        }
        return null;
    }
}
