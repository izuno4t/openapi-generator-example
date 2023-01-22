/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.example.api.handler;

import com.example.api.handler.ApiClient;
import com.example.api.handler.ApiException;
import com.example.api.handler.ApiResponse;
import com.example.api.handler.Pair;

import com.example.api.model.Order;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-22T09:30:20.145942+09:00[Asia/Tokyo]")
public class StoreApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public StoreApi() {
    this(new ApiClient());
  }

  public StoreApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Delete purchase order by ID
   * For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors
   * @param orderId ID of the order that needs to be deleted (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteOrder(Long orderId) throws ApiException {
    deleteOrderWithHttpInfo(orderId);
  }

  /**
   * Delete purchase order by ID
   * For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors
   * @param orderId ID of the order that needs to be deleted (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteOrderWithHttpInfo(Long orderId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteOrderRequestBuilder(orderId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteOrder", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteOrderRequestBuilder(Long orderId) throws ApiException {
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
      throw new ApiException(400, "Missing the required parameter 'orderId' when calling deleteOrder");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/store/order/{orderId}"
        .replace("{orderId}", ApiClient.urlEncode(orderId.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns pet inventories by status
   * Returns a map of status codes to quantities
   * @return Map&lt;String, Integer&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, Integer> getInventory() throws ApiException {
    ApiResponse<Map<String, Integer>> localVarResponse = getInventoryWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Returns pet inventories by status
   * Returns a map of status codes to quantities
   * @return ApiResponse&lt;Map&lt;String, Integer&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Map<String, Integer>> getInventoryWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getInventoryRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getInventory", localVarResponse);
        }
        return new ApiResponse<Map<String, Integer>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Map<String, Integer>>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getInventoryRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/store/inventory";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Find purchase order by ID
   * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10.         Other values will generated exceptions
   * @param orderId ID of pet that needs to be fetched (required)
   * @return Order
   * @throws ApiException if fails to make API call
   */
  public Order getOrderById(Long orderId) throws ApiException {
    ApiResponse<Order> localVarResponse = getOrderByIdWithHttpInfo(orderId);
    return localVarResponse.getData();
  }

  /**
   * Find purchase order by ID
   * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10.         Other values will generated exceptions
   * @param orderId ID of pet that needs to be fetched (required)
   * @return ApiResponse&lt;Order&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Order> getOrderByIdWithHttpInfo(Long orderId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getOrderByIdRequestBuilder(orderId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getOrderById", localVarResponse);
        }
        return new ApiResponse<Order>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Order>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getOrderByIdRequestBuilder(Long orderId) throws ApiException {
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
      throw new ApiException(400, "Missing the required parameter 'orderId' when calling getOrderById");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/store/order/{orderId}"
        .replace("{orderId}", ApiClient.urlEncode(orderId.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/xml, application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Place an order for a pet
   * 
   * @param body order placed for purchasing the pet (required)
   * @return Order
   * @throws ApiException if fails to make API call
   */
  public Order placeOrder(Order body) throws ApiException {
    ApiResponse<Order> localVarResponse = placeOrderWithHttpInfo(body);
    return localVarResponse.getData();
  }

  /**
   * Place an order for a pet
   * 
   * @param body order placed for purchasing the pet (required)
   * @return ApiResponse&lt;Order&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Order> placeOrderWithHttpInfo(Order body) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = placeOrderRequestBuilder(body);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("placeOrder", localVarResponse);
        }
        return new ApiResponse<Order>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Order>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder placeOrderRequestBuilder(Order body) throws ApiException {
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling placeOrder");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/store/order";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/xml, application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(body);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
