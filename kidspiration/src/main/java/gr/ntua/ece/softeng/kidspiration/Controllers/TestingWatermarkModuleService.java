package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.Services.WatermarkModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/watermark")
public class TestingWatermarkModuleService {

    @Autowired
    private WatermarkModuleService watermarkModuleService;

    @RequestMapping(value = "/service")
    public String testingWatermarkModule(@RequestParam String sourcePath, @RequestParam String destinationPath,
                                  @RequestParam int desiredWidth, @RequestParam int desiredHeight) {

        System.out.println("Calling watermarkModuleService...\n");
        return watermarkModuleService.watermarkModuleService(sourcePath, destinationPath, desiredWidth, desiredHeight);
    }
}
