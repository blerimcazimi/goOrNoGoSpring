package project.Controller.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import project.Model.Post;
import project.Repository.PostRepositoryCrud;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController
{

    //Save the uploaded file to this folder
    private String UPLOADED_FOLDER = "/Applications/goOrNoGoSpring/src/main/resources/static/uploadedfiles/";

    //logger aspect...
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //post crud

    @Autowired
    PostRepositoryCrud postRepositoryCrud;

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file,
                                           @RequestParam("question") String question, HttpSession session)
    {

        boolean isUploaded = false;

        log.info("Trying to upload file...");

        if (file.isEmpty())
        {

            log.info("File not uploaded, error: no file selected..");
            isUploaded = false;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            //write to path..
            Files.write(path, bytes);

            isUploaded = true;

            log.info("File uploaded to the server...");

        } catch (IOException e)
        {

            isUploaded = false;
            log.info("File not uploaded, error: " + e.getMessage());

        }

        log.info(question + " question..s");


        if(isUploaded)
        {

            Post post = new Post();

            post.setQuestion(question);

            post.setUserid((int)session.getAttribute("user_id"));

            post.setImage_path(file.getOriginalFilename());

            postRepositoryCrud.save(post);

            return "redirect:/user/home";

        }


        return "ERROR";

    }

}