package com.graphql.tests;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojos.GraphQLQuery;
import com.qa.pojos.QueryVariable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GraphQLQueryTest {

    //    @Test
    public void getAllFilmsTest() {
        RestAssured.baseURI = "https://hasura.io";

        String query = "{\"query\":\"{ allFilms{ films{ title } } }\"," +
            "\"variables\":null" +
            "}";
        given().log().all()
            .contentType(ContentType.JSON)
            .body(query)
            .when().log().all()
            .post("/.netlify/functions/index")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .and()
            .body("data.allFilms.films[0].title", equalTo("A New Hope"));
    }

//        @Test
    public void getAllUsers() {
        RestAssured.baseURI = "https://hasura.io";

        String query = "{\"query\":\"{  users(limit: 10) { id  name } }\",\"variables\":null}";
        String token = System.getenv("BEARER_TOKEN");
        given().log().all()
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(query)
            .when()
            .post("/learn/graphql")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .body("data.users[0].name", equalTo("tui.glen"));
    }

//    @DataProvider
    public String[][] getQueryData() {
        return new String[][]{{"10", "lybakashif", "Shopping"}, {"5", "lybakashif", "dinner"}};
    }

//    @Test(dataProvider = "getQueryData")
    public void getUserWithData(String limit, String name, String title) {
        RestAssured.baseURI = "https://hasura.io";

        String query = "{\"query\":\"{\\n  users(where: {name: {_eq: \\\"" + name + "\\\"}}, limit: " + limit + ") {\\n    name\\n    todos(where: {title: {_eq: \\\"" + title + "\\\"}}) {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";
//        String token = System.getenv("BEARER_TOKEN");
        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY1OTExMjAzMTVhZTIyZGE0Yjg5NGE2ZCJ9LCJuaWNrbmFtZSI6ImNlbmF0YXRpb242NjYiLCJuYW1lIjoiY2VuYXRhdGlvbjY2NkBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvMGRmMzJiNDkzYzQ5ODBmZGRkNjRkOGZkNzQwMjA0NmI_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZjZS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMy0xMi0zMVQwNzowMjoyOS44NjBaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE3MDQwMjc3MTksImV4cCI6MTcwNDA2MzcxOSwic3ViIjoiYXV0aDB8NjU5MTEyMDMxNWFlMjJkYTRiODk0YTZkIiwiYXRfaGFzaCI6IkU2YWNpc1pUdExPalkyS0lHTWNuZUEiLCJzaWQiOiJfM3NVMjQzZUlvcVpZRWJ6OU5DdkRZZzNGZ0hUbGtJcSIsIm5vbmNlIjoiek9ONWdWMjVMcXFYbGNaalIwR2ZIUGYwZGItd2U4T3QifQ.ROT0aUk3NYGwoWjrLgJ-c1KCyG5BpGXrUW24I1P4QTh_FO833e7aN2LWjqSd-3_6UYR2TCyAXl-0y6yYSgESuCS_3Vf3Hpsj_PNfsPG5lOV_QT179yKq34mZ3_Vc3bpvyE7_O3iYkIK-fP9srkYliXesnH9V6tYrhC-3acjUpGk_oREk8JHOaFNr7H2Cp9qWuGaBcrSkMnk-ikZqrAU-WUz_t5cMRBAoXJH88S2WtzUI0Gd9OVoxjXeb1ODdUifL_za0__lKveZyvGVMDXKUbuFPVykONp-x9FHa66ZDsA3M-v5JwEL4IPxMaiYeb6j9qtxRW9XdO5JzTn1Qqxl5fg";
//        String token = properties.getProperty("BEARER_TOKEN");
//        System.out.println(token);

        given().log().all()
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(query)
            .when()
            .post("/learn/graphql")
            .then().log().all()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void getUsersWithPOJOTest()  {
        RestAssured.baseURI = "https://hasura.io";
        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY1OTExMjAzMTVhZTIyZGE0Yjg5NGE2ZCJ9LCJuaWNrbmFtZSI6ImNlbmF0YXRpb242NjYiLCJuYW1lIjoiY2VuYXRhdGlvbjY2NkBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvMGRmMzJiNDkzYzQ5ODBmZGRkNjRkOGZkNzQwMjA0NmI_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZjZS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMy0xMi0zMVQwNzowMjoyOS44NjBaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE3MDQwNzk3OTEsImV4cCI6MTcwNDExNTc5MSwic3ViIjoiYXV0aDB8NjU5MTEyMDMxNWFlMjJkYTRiODk0YTZkIiwiYXRfaGFzaCI6ImNYRzM0eFNfVldsNDU4MFNFTzQ2NnciLCJzaWQiOiJfM3NVMjQzZUlvcVpZRWJ6OU5DdkRZZzNGZ0hUbGtJcSIsIm5vbmNlIjoibDZ3cUFzWDk2NzZGQXNwRnRsZDdEaTlGZFFnQ0VHLlYifQ.RSEld_wn8Wjg_wZavqV3AiDWX3-ShxNzN_D7MsIACkDiybM6i7kW1K3e_evZAH8r-E2HQca8F7jVN4vEVAlwcM5jeLGDSLaKr3YE1XY5g-nFELa_bQKCXnfyIadwe4vrSaq-ZEcz6reH7znb94wlUzrYHuEYUInI-6pS5GbaVu97SpaMSru_JCjdAU_zNRnLgxSk6Gz-Djr48kCXiR1UhoVSYRmXPJE62oj8_K2xAg2AtDpLJUcdabAnC2tAIegO1lGvf_qf7VL8jJkzi-f6az7vZhd71sNFl2ew0ovJaeglAOlnvqkXN-UJcv6CcB3pBIxfMcKnqFrysB3EK9wKBw";

        GraphQLQuery query = new GraphQLQuery();

        query.setQuery("query($limit:Int!, $name:String!){\n" +
            "  users(where: {name: {_eq: $name}}, limit: $limit) {\n" +
            "    id\n" +
            "    name\n" +
            "  }\n" +
            "}\n");
        QueryVariable variable = new QueryVariable();

        variable.setLimit(10);
        variable.setName("tui.glen");
        query.setVariables(variable);

        given().log().all()
            .contentType(ContentType.JSON)
            .header("Authorization",token)
            .body(query)
            .when().log().all()
            .post("/learn/graphql")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .and()
            .body("data.users[0].name",equalTo("tui.glen"));
    }

}


















