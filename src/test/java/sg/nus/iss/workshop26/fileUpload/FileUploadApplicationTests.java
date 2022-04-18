package sg.nus.iss.workshop26.fileUpload;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.workshop26.fileUpload.models.Post;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootTest
class FileUploadApplicationTests {

	@TestConfiguration
    static class TestConfig {

        @Bean
        public Dotenv dotEnvBuilder() {
			Dotenv dotenv = Dotenv.configure().load();

            return dotenv;
        }
        
    }

	@Autowired
    private Dotenv dt;
	@Test
	void contextLoads() {
		
	}

	@Test
	void testNewPost(){
		Post p = new Post();
		p.setComment("test");
		p.setImage(null);
		p.setImageType("image/png");
		p.setPostId(1);
		p.setPoster("Hello");
		
	}

	@Test
	void testGetValuesPost(){
		Post p = new Post();
		p.setComment("test");
		p.setImage(null);
		p.setImageType("image/png");
		p.setPostId(1);
		p.setPoster("Hello");
		System.out.println(p.getComment());
		System.out.println(p.getImageType());
		System.out.println(p.getPoster());
		System.out.println(p.getPostId());
		System.out.println(p.getImage());
	}

 	

}
