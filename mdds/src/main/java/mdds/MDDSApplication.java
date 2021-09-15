package mdds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/***
 * query{
 *   mastHeadList(pid: "1"){
 *     __typename
 *     ... on ContentItem{
 *       cid,
 *       description
 *     }
 *    ... on AdvtItem{
 *     aid,
 *     url
 *   }
 *
 *   }
 * }
 *
 *
 */
@SpringBootApplication
public class MDDSApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MDDSApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8082"));
		app.run(args);
	}

}
