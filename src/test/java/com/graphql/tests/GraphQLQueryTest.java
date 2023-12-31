package com.graphql.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GraphQLQueryTest {
    @Test
    public void getAllFilmsTest(){
        RestAssured.baseURI = "https://swapi-graphql.netlify.app";
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
            .body("data.allFilms.films[0].title",equalTo("A New Hope"));
    }
    @Test
    public void getAllUsers(){
        RestAssured.baseURI="https://hasura.io";
        String query="{\"query\":\"{  users(limit: 10) { id  name } }\",\"variables\":null}";
        String token = System.getenv("BEARER_TOKEN");
        given().log().all()
            .contentType(ContentType.JSON)
            .header("Authorization",token)
            .body(query)
            .when()
            .post("/learn/graphql")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .body("data.users[0].name",equalTo("tui.glen"));

    }
}
