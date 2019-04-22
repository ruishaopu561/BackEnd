package rsp.hw4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActuatorTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void auditeventsTest() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/actuator/auditevents"))
                .andExpect(status().isOk());
    }

    @Test
    public void beansTest() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/actuator/beans"))
                .andExpect(status().isOk());
    }

    @Test
    public void cacheTest() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/actuator/caches"))
                .andExpect(status().isOk());
    }

    @Test
    public void healthTest() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/actuator/health"))
                .andExpect(status().isOk());
    }

    @Test
    public void conditionsTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/conditions"))
                    .andExpect(status().isOk());
    }

    @Test
    public void shutdownTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.post("http://localhost:8080/actuator/shutdown"))
                    .andExpect(status().isOk());
    }

    @Test
    public void configpropsTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/configprops"))
                    .andExpect(status().isOk());
    }

    @Test
    public void envTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/env"))
                    .andExpect(status().isOk());
    }

    @Test
    public void infoTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/info"))
                    .andExpect(status().isOk());
    }

    @Test
    public void loggersTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/loggers"))
                    .andExpect(status().isOk());
    }

    @Test
    public void heapdumpTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/heapdump"))
                    .andExpect(status().isOk());
    }

    @Test
    public void threaddumpTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/threaddump"))
                    .andExpect(status().isOk());
    }

    @Test
    public void metricsTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/metrics"))
                    .andExpect(status().isOk());
    }

    @Test
    public void scheduledtasksTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/scheduledtasks"))
                    .andExpect(status().isOk());
    }

    @Test
    public void httptraceTest() throws Exception{
            mvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/actuator/httptrace"))
                    .andExpect(status().isOk());
    }

    @Test
    public void mappingsTest() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/actuator/mappings"))
                .andExpect(status().isOk());
    }
}
