import java.io.File;

import func.tag;
import func.search;
import func.image;

public class app {
    public static void main(String[] args) {
        File tagFile = null;
        File outDir = null;
        int page = 0;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-tf":
                    try {
                        File file = new File(args[i+1]);    
                        if(!file.isDirectory()&&file.exists()){
                            System.out.println("[ TAG FILE ✅ ] "+args[i+1]);
                            tagFile = file;
                        }else if(file.isDirectory()){
                            System.out.println("[ TAG FILE ⚠️ ] This is the directory! "+args[i+1]);
    
                        }else if(!file.exists()){
                            System.out.println("[ TAG FILE ⚠️ ] There is no such file! "+args[i+1]);
    
                        }
                    } catch (Exception e) {
                        System.out.println("[ TAG FILE ⚠️ ] is this even a way? "+args[i+1]);
                        
                    }
                    i++;
                    break;
                case "-p":
                    try {
                        page = Integer.parseInt(args[i+1]);
                        System.out.println("[ PAGE ✅ ] "+page);   
                    } catch (Exception e) {
                        System.out.println("[ PAGE ⚠️ ] no page number, using default "+page);
                    }
                    i++; 
                    break;
                case "-o":
                    try {
                        File file = new File(args[i+1]);    
                        if(file.isDirectory()&&file.exists()){
                            System.out.println("[ OUT DIRECTORY ✅ ] "+args[i+1]);
                            outDir = file;
                        }else if(!file.exists()){
                            System.out.println("[ OUT DIRECTORY ⚠️ ] there is no directory, I'm trying to create it... "+args[i+1]);
                            boolean yes = file.mkdir();
                            if(yes){
                                System.out.println("[ OUT DIRECTORY ✅ ] directory created! "+args[i+1]);
                                outDir = file;
                            }else{
                               System.out.println("[ OUT DIRECTORY ⚠️ ] directory not created! "+args[i+1]);
                            }
                        }else if(!file.isDirectory()){
                            System.out.println("[ OUT DIRECTORY ⚠️ ] This is not a directory! "+args[i+1]);
    
                        }
                    } catch (Exception e) {
                        System.out.println("[ OUT DIRECTORY ⚠️ ] is this even a way? "+args[i]);
                    }
                    i++;
                    break;
                default:
                    System.out.println("[ WARMING ⚠️ ] is this an argument? "+arg);
                    break;
            }
        }
        if (tagFile!=null&&outDir!=null) {
            String[] tags = tag.read(tagFile);
            
            final String tagsUrl = tag.generate(tags,"+");
            final String tagsFile = tag.generate(tags, "-");

            final String urlString = "https://konachan.net/post?page="+page+"&tags="+tagsUrl;

            String[] links = search.links(urlString);
            image.downloads(links, page, tagsFile,outDir.getPath());
        }
    }
}