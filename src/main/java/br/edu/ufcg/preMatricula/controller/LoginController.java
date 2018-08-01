package br.edu.ufcg.preMatricula.controller;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.apache.catalina.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.ufcg.preMatricula.model.LoginNote;
import br.edu.ufcg.preMatricula.model.RequestNote;


public class LoginController {
	
	public String login(LoginNote idTokenString) throws UnsupportedOperationException, IOException {
		HttpGet get = new HttpGet("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token="+idTokenString.getIdTokenString());
		CloseableHttpClient client = HttpClients.custom().build();

		HttpResponse response = client.execute(get);
		String result = org.apache.commons.io.IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);

		Gson gson = new Gson();
		RequestNote request = gson.fromJson(result, RequestNote.class);
		int responseCode = response.getStatusLine().getStatusCode();
		String statusPhrase = response.getStatusLine().getReasonPhrase();

		response.getEntity().getContent().close();
		System.out.println(request.getEmail());
		return request.getExp();		
	}
		
}
