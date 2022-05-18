package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import telefonia.ProjectWork_TelefoniaApplication;
import telefonia.db.ChiamataRepository;

@SpringBootTest(classes = ProjectWork_TelefoniaApplication.class)
class ProjectWorkAcademyJavaCabApplicationTests {

	@Autowired
	ChiamataRepository chiamataRepo;
	
	@Test
	void contextLoads() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		try {
			Integer codLinea = 2;
			Date dateStart = sdf.parse("2022-05-18T12:10:00Z");
			Date dateEnd = sdf.parse("2022-05-18T12:50:00Z");
			
			System.out.println("DATESTART: " + dateStart);
			System.out.println("DATEEND: " + dateEnd);
			
			Long somma = chiamataRepo.sommaDurate(codLinea, dateStart, dateEnd);
			System.out.println("SOMMA: " + somma);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
