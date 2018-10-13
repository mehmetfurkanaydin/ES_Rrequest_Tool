package com.mfa.estool;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESRestHighLevelClient {
    RestHighLevelClient client;

    public RestHighLevelClient getClient() {
        return client;
    }

    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    public ESRestHighLevelClient() {
    }


    public void createNewClient(String hostname, int port, String scheme) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(hostname, port, scheme)));

        setClient(client);
    }

    public String sendIndexRequest(String index, String type, String id, String source) {
        IndexRequest request = new IndexRequest(
                index,
                type,
                id);
        request.source(source, XContentType.JSON);

        IndexResponse indexResponse = null;
        try {
            indexResponse = client.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return indexResponse.getResult().toString();
    }

    public void clientClose() {
        try {
            getClient().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
