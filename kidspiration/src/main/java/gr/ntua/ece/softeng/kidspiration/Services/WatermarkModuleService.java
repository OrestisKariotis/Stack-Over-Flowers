package gr.ntua.ece.softeng.kidspiration.Services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WatermarkModuleService {

    /* returns path of watermarked image or error message */
    /* dimensions given in pixel */
    public String watermarkModuleService (String sourcePath, String destinationPath, int desiredWidth, int desiredHeight){
        String response;
        try {
            //System.out.println("Trying to run the watermark module...\n");
            /*  hard-coded version for testing
                Runtime.getRuntime().exec("java -jar C:/Users/Orestis/Desktop/kidspiration/kidspiration/src/WatermarkModule.jar C:/Users/Orestis/Desktop/Screenshot_11.jpg C:/Users/Orestis/Desktop/Result.png 200 180");
             */
            Runtime.getRuntime().exec("java -jar C:/Users/Orestis/Desktop/kidspiration/kidspiration/src/WatermarkModule.jar"
                    + " " + sourcePath + " " + destinationPath + " " + desiredWidth + " " + desiredHeight);
            //System.out.println("WatermarkModule's runtime ended.\n");
            response = destinationPath;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nError occurred while trying to run the WatermarkModule.\nError in image: " + sourcePath + "\n");
            response = "watermarking failed";
        }
        System.out.println("WatermarkModuleService's response:\n" + response);
        return response;
    }
}
