package com.prospace.merchant.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prospace.merchant.client.configuration.MerchantGalaxyEndpoint;
import com.prospace.merchant.client.model.request.CurrencyConverterRequest;

import com.prospace.merchant.client.model.response.ResponseEntity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Application {

	private static String baseUrl = "http://localhost:8080";

	public static void main(String[] args) throws IOException {
		// Connecting to the API via Retrofit
		System.err.println("Building Retrofit client on " + baseUrl);
		final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		final Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(JacksonConverterFactory.create())
				.client(httpClient.build())
				.build();
		final MerchantGalaxyEndpoint merchantGalaxyEndpoint = retrofit.create(MerchantGalaxyEndpoint.class);
		System.err.println("Client has successfully been built");
		System.out.println("=============================================");
		System.out.println("Welcome to Merchant Galaxy Currency Converter");
		System.out.println("=============================================");

		// Create buffered reader to read input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Add temporary reader to check for conditions on each input line
		String tempReader = "";

		// Assign roman Variables
		System.out.println(">Please input Roman Characters");
		System.out.println(">Please do not use numeric value");
		System.out.println(">Leave blank to use default");
		final String[] romanCharacters = { "I", "V", "X", "L", "C", "D", "M" };
		List<String> romanSymbols = new ArrayList<>();
		int i = 0;
		do {
			System.out.print(romanCharacters[i] + " = ");
			tempReader = reader.readLine();
			if (tempReader.matches(".*\\d.*")) {
				System.out.println("Roman symbol contain number(s).");
			} else {
				romanSymbols.add(tempReader);
				i++;
			}
		} while (romanSymbols.size() != romanCharacters.length);

		// Assign the three currencies (iron, silver, and gold)
		System.out.println(">Please input currency values (iron, silver, and gold)");
		System.out.println(">Format: prok prok iron is 34 Credits");
		final String[] currencies = { "iron", "silver", "gold" };
		List<String> currencyValues = new ArrayList<>();
		do {
			tempReader = reader.readLine();
			if (tempReader.isEmpty()) {
				System.out.println("Input is empty, please input currency values.");
			} else {
				currencyValues.add(tempReader);
			}
		} while (currencyValues.size() != currencies.length);

		// Adding questions
		System.out.println(">Please input questions");
		System.out.println(">Format: how many Credits is I V ? , how many Credits is glob prok ? , how many Credits is glob prok Silver ?");
		System.out.println(">Input 'Done' to finish (case sensitive)");
		List<String> questions = new ArrayList<>();
		do {
			tempReader = reader.readLine();
			if (tempReader.isEmpty()) {
				System.out.println("Input is empty, please input a question.");
			} else {
				questions.add(tempReader);
			}
		} while (!tempReader.equals("Done"));

		// Finalising the input
		System.out.println(">Input finished");
		reader.close();

		// Declaring the request for HTTP call to the API
		CurrencyConverterRequest request = new CurrencyConverterRequest(
				romanSymbols.get(0),
				romanSymbols.get(1),
				romanSymbols.get(2),
				romanSymbols.get(3),
				romanSymbols.get(4),
				romanSymbols.get(5),
				romanSymbols.get(6)
		);
		request.setCurrencyValuesDeclaration(currencyValues);
		request.setQuestions(questions);

		// Initiating Retrofit call
		Call<ResponseEntity> retrofitCall = merchantGalaxyEndpoint.convertGalaxyCurrency(request);
		Response<ResponseEntity> responseCall = retrofitCall.clone().execute();
		final ResponseEntity convertGalaxyCurrencyResponse = Optional.ofNullable(responseCall.body()).orElse(new ResponseEntity());
		if (responseCall.code() == 200) {
			System.out.println(">Answers:");
			convertGalaxyCurrencyResponse.getBody().forEach(System.out::println);
		} else {
			System.err.println("Error:");
			System.err.println(responseCall.errorBody().string());
		}
	}
}