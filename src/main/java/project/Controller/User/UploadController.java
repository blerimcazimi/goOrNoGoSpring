package project.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController
{

    //Save the uploaded file to this folder
    private String UPLOADED_FOLDER = "/Users/blerimcazimi/Applications/EksamensprojektSpring/src/main/resources/static/uploadedfiles/";

    @PostMapping("/upload")
    public @ResponseBody String fileUpload(@RequestParam("file") MultipartFile file)
    {

        boolean isUploaded = false;

        if (file.isEmpty())
        {
            isUploaded = false;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            //write to path..
            Files.write(path, bytes);

            isUploaded = true;

        } catch (IOException e)
        {
            isUploaded = false;
        }

        if(isUploaded)
        {

            return "OK";

        }

        return "ERROR";

    }

}