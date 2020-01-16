package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

import static io.restassured.http.ContentType.JSON;

public class MobileApi {
    private MobileApi() {
    }

    public static final String baseUrl = "https://mobilecloud.epam.com/automation/api/";
    private String path = "";
    private Method method = Method.POST;
    private ContentType contentType = JSON;
    private Charset charset = Charset.defaultCharset();
    private HashMap<String, String> params = new HashMap<String, String>();
    private File multipart;

    public static class ApiBuilder {
        MobileApi ApiApp;


        private ApiBuilder(MobileApi gcApi) {
            ApiApp = gcApi;
        }

        public ApiBuilder path(String path) {
            ApiApp.path = path;
            return this;
        }

        public ApiBuilder contentType(ContentType contentType) {
            ApiApp.contentType = contentType;
            return this;
        }

        public ApiBuilder multipart(File file) {
            ApiApp.multipart = file;
            return this;
        }

        public Response callApi(String token) {
            RequestSpecification spec = baseRequestConfiguration(token);
            if (ApiApp.multipart != null) {
                spec.multiPart("file", ApiApp.multipart);
            } else {
                spec.contentType(ApiApp.contentType.withCharset(ApiApp.charset.name()));
            }
            return RestAssured.with()
                    .spec(spec)
                    .params(ApiApp.params)
                    .log().all()
                    .request(ApiApp.method,
                            String.format("%s%s", baseUrl, ApiApp.path))
                    .prettyPeek();
        }
    }

    public static ApiBuilder with() {
        MobileApi api = new MobileApi();
        return new ApiBuilder(api);
    }

    public static RequestSpecification baseRequestConfiguration(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setRelaxedHTTPSValidation()
                .addHeader("Authorization", String.format("Bearer %s", token))
                .build();
    }
}
