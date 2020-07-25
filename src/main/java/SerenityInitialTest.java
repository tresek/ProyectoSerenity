import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

@RunWith(SerenityRunner.class)
public class SerenityInitialTest {

	private static final String restApiUrl = "https://reqres.in/api/users?page=2";

	@Test
	public void getUsers() {
		Actor freddy = Actor.named("freddy the trainer").whoCan(CallAnApi.at(restApiUrl));

		freddy.attemptsTo(Get.resource("/users?page=2"));
		assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

	}

	@Test
	public void getUsersFail() {
		Actor freddy = Actor.named("freddy the trainer").whoCan(CallAnApi.at(restApiUrl));

		freddy.attemptsTo(Get.resource("/users?page=2"));
		assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(400);

	}

}
