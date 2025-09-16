package func;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class image {
    public static void downloads(String[] links,int page,String tags,String directory){
 
        double resultSize = 0;
        String resultString = "Kb";
        int downloadedImages = 0;
        int errorImage = 0;

        int li = links.length;
        for (int i = 0; i < links.length; i++) {
            String link = links[i];
            try {

                @SuppressWarnings("deprecation")
                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setRequestProperty("User-Agent", "Mozilla/5.0");

                InputStream inStream = conn.getInputStream(); 
                

                String pathFile = directory+"/"+"page-"+page+"-tags-"+tags+i+".png";
                FileOutputStream outStream = new FileOutputStream(pathFile);


                double size = conn.getContentLength() / 1024;
                String sizeS = "Kb";

                resultSize += size;

                if(size>1024){
                    size = size / 1024;
                    sizeS = "Mb";
                };


                System.out.println("[ ЗАПИСЬ 🖋️ "+(i+1)+"/"+li+"] "+"page-"+page+"-tags-"+tags+(i+1)+".png "+String.format("%.3f",size)+sizeS);


                byte[] buffer = new byte[4096];
                int bytesread;
                while ((bytesread = inStream.read(buffer)) != -1) {
                    outStream.write(buffer,0,bytesread);
                }
                inStream.close();
                outStream.close();


                System.out.println("[ УСПЕШНО ✅ ] "+(i+1)+".png");
                downloadedImages++;
                Thread.sleep(1521);

            } catch (Exception e) {
                System.err.println("[ ОШИБКА ❌ ] файл не смог загрузиться"+link+" ");
                errorImage++;
                Thread.currentThread().interrupt();
            }
        }        
        
        // final statistic
        if(resultSize>1024){
            resultSize = resultSize / 1024;
            resultString = "Mb";
        }
        if(resultSize>1024){
            resultSize = resultSize / 1024;
            resultString = "Gb";
        }

        System.out.println("[ СТАТИСТИКА ] суммарный размер фото:"+String.format("%.3f",resultSize)+resultString+" картинок загружено:"+downloadedImages+" картинок не загружено:"+errorImage);

    }
}
