package com.perfecto.davgur;


import com.google.gson.Gson;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/step")
public class StepController {
    private JsonParser parser = JsonParserFactory.getJsonParser();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Step addStep(@RequestBody String json) {
        Map<String, Object> map = parser.parseMap(json);
        Long id = Long.parseLong((String) map.get("testId"));

        TestItem test = TestList.getTest(id);
        Step step = new Step((String) map.get("name"), (String) map.get("description"));
        test.add(step);
        return step;
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String getAll(@RequestBody String json) {
        Map<String, Object> map = parser.parseMap(json);
        Long id = Long.parseLong((String) map.get("testId"));

        TestItem test = TestList.getTest(id);
        ArrayList<Step> list = new ArrayList<>();
        if (test != null)
            list = test.getSteps();
        return new Gson().toJson(list);
    }
}