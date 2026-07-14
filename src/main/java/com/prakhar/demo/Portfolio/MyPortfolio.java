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

    @GetMapping("/education")
    public String Education()
    {
        return """
                <h1>Education</h1>
                <p></p>
                <ul>
                <li>Lovely Professional University: Current CGPA: 7.56</l1>
                <li>12th: 68.6%</li>
                <li>10th: 86.8%</li>
                </ul>
                """;
    }

    @GetMapping("/skills")
    public String Skills()
    {
        return """
                <h1>Skills</h1>
                <p>The following are my technical skills</p>
                <ul>
                <li>Programming Languages: C++, c, Java, Python, Javascript</l1>
                <li>Frameworks: Spring, SpringBoot, Django, React, Node</li>
                <li>Tools: MySQL, PostGresSQL, NoSQL, GIT</li>
                </ul>
                """;
    }

    @GetMapping("/project")
    public String Project()
    {
        return """
                <h1>Projects</h1>
                <p>The following are my projects</p>
                <ul>
                <li><a href="https://github.com/Prakhar-Maitreya/Library-Management-System">Library Management System Backend API</a></li>
                <li><a href="https://github.com/Prakhar-Maitreya/Employee-Portal-Cipherschools">Employee Management System</a></li>
                <li><a href="https://github.com/Prakhar-Maitreya/Rainwater-Harvesting-Mini-website">Rainwater Harvesting Awareness website</a></li>
                </ul>
                """;
    }
}
