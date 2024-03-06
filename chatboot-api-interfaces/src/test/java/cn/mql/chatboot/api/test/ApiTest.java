package cn.mql.chatboot.api.test;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * ClassName: ApiTest
 * Package: cn.mql.chatboot.api.test
 * Description:
 *单元测试
 * @Author lmq
 * @Create 2024/3/6 20:47
 * @Version 1.0
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //封装接受到的信息

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/1522545814844852/comments?sort=asc&count=30&with_sticky=true");
        get.addHeader("cookie","zsxq_access_token=FECA6DDB-0FF6-9B0C-3241-DB114A43830E_1D3B856ECC190BB7; zsxqsessionid=6bc55872c9b47ce4942038f2396328b1; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212541811411521%22%2C%22first_id%22%3A%2218dcf37799910c5-0c282c632b55798-4c657b58-2073600-18dcf37799a1db4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkY2YzNzc5OTkxMGM1LTBjMjgyYzYzMmI1NTc5OC00YzY1N2I1OC0yMDczNjAwLTE4ZGNmMzc3OTlhMWRiNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU0MTgxMTQxMTUyMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212541811411521%22%7D%2C%22%24device_id%22%3A%2218dcf37799910c5-0c282c632b55798-4c657b58-2073600-18dcf37799a1db4%22%7D");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //封装接受到的信息
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1522545814844852/comments");
        post.addHeader("cookie","zsxq_access_token=FECA6DDB-0FF6-9B0C-3241-DB114A43830E_1D3B856ECC190BB7; zsxqsessionid=6bc55872c9b47ce4942038f2396328b1; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212541811411521%22%2C%22first_id%22%3A%2218dcf37799910c5-0c282c632b55798-4c657b58-2073600-18dcf37799a1db4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkY2YzNzc5OTkxMGM1LTBjMjgyYzYzMmI1NTc5OC00YzY1N2I1OC0yMDczNjAwLTE4ZGNmMzc3OTlhMWRiNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU0MTgxMTQxMTUyMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212541811411521%22%7D%2C%22%24device_id%22%3A%2218dcf37799910c5-0c282c632b55798-4c657b58-2073600-18dcf37799a1db4%22%7D");
        post.addHeader("Content-Type","application/json;charset=utf8");
        String paramJson = "{\"req_data\":{\"text\":\"测试333\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
