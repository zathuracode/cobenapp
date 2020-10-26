package co.com.coomeva.coben.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PreferenciasServiceTest {
	@Autowired
	private PreferenciasService preferenciasService;

	@Test
	@DisplayName("findAll")
	public void findAll() {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("save")
	public void save() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("delete")
	public void delete() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("deleteById")
	public void deleteById() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("update")
	public void update() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("findById")
	public void findById() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}

	@Test
	@DisplayName("count")
	public void count() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(preferenciasService);
	}
}
