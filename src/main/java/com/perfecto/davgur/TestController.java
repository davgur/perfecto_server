package com.perfecto.davgur;


import java.lang.String;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
    private JsonParser parser = JsonParserFactory.getJsonParser();
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/all")
    public String getAll() throws JsonProcessingException {
         Object[] list = TestList.all().entrySet().toArray();
        if (list.length == 0)
            list = new String[]{};
        return new Gson().toJson(list);
    }

    @RequestMapping(value = "/{id}")
    public String getTest(@PathVariable(value = "id") String id) {
        TestItem test = TestList.getTest(Long.parseLong(id));
        return new Gson().toJson(test);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public TestItem stop(@RequestBody String json) {
        Map<String, Object> map = parser.parseMap(json);
        Long id = Long.parseLong((String) map.get("id"));

        TestItem test = TestList.getTest(id);
        test.stop();
        return test;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public TestItem start(@RequestBody String json) {
        Map<String, Object> map = parser.parseMap(json);
        Long id = Long.parseLong((String) map.get("id"));

        return TestList.start(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public TestItem addTest(@RequestBody String json) {
        Map<String, Object> map = parser.parseMap(json);

        TestItem test = new TestItem((String) map.get("name"));
        return TestList.add(test);
    }

}