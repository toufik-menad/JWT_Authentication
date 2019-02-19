/**
 * 
 */
package com.canada.shawinigan.pos.sets;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.ContentType;

/**
 * @author mint
 *
 */
public class AppUserControllerTest {
	
	
	
	/**tests the response status for a get request passed to the service
	 * {@link AppUserController}
	 */
	@Test
	public void status_200_Test() {
		given().
		when().
		get("http://localhost:9000/users").
		then().
		assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON);
	}

}
