package mdds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/***
 *
 * query{
 *   mastHeadList(pid: "2"){
 *     __typename
 *     ... on ContentItem{
 *       cid,
 *       description
 *     }
 *    ... on AdvtItem{
 *     aid,
 *     url
 *   }
 *     ... on SportsItem{
 *       cid,
 *       score,
 *       title,
 *       description
 *     }
 *
 *   }
 * }
 *
 * query{
 *   mastHead(pid: "2"){
 *     contentItems{
 *       cid,
 *       description
 *     },
 *     advtItems{
 *     aid,
 *     url
 *     } ,
 *     sportsItems{
 *       cid,
 *       score,
 *       title,
 *       description
 *     }
 *
 *   }
 * }
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
