package com.prakhar.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio
{
    @GetMapping("/myself")
    public String Myself()
    {
        return """
                <h1>Myself</h1>
                <p>My name is Prakhar Maitreya Parashar</p>
                <ul>
                <li>Current CGPA: 7.56</l1>
                <li><a href="https://github.com/Prakhar-Maitreya">Github Link</a></li>
                <li><a href="https://www.linkedin.com/in/prakhar-maitreya/">Linkedin Link</a></li>
                </ul>
                """;
    }
}
