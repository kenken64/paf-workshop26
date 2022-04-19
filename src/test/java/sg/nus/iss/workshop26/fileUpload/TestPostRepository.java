package sg.nus.iss.workshop26.fileUpload;

import java.io.InputStreamReader;
import java.nio.file.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.workshop26.fileUpload.models.Post;
import sg.nus.iss.workshop26.fileUpload.repository.PostRepository;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootTest
public class TestPostRepository {

    // @TestConfiguration
    // static class TestConfig {

    //     @Bean
    //     public Dotenv dotEnvBuilder() {
	// 		Dotenv dotenv = Dotenv.configure().load();

    //         return dotenv;
    //     }
        
    // }

	// @Autowired
    // private Dotenv dt;

    @Autowired
    private PostRepository postRepo;

    @Test
    public void insertPost() {
        final String testDataDir = System.getenv("TEST_DATA_DIR");
        File fi = new File(testDataDir + "pikachu_hi_pokemon.jpg");
		byte[] fileContent =  new byte[0];
        try {
            fileContent = Files.readAllBytes(fi.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Post p = new Post();
		p.setComment("test");
		p.setImage(fileContent);
		p.setImageType("image/png");
		p.setPostId(1);
		p.setPoster("Hello");

        postRepo.insertPost(p);
    }



    
}
