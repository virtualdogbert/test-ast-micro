package test.ast.micro.services

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine

import javax.annotation.PostConstruct
import java.nio.charset.StandardCharsets

class VelocityService {

    private VelocityEngine velocityEngine

    @PostConstruct // <2>
    void initialize() {
        final Properties p = new Properties()
        p.setProperty("resource.loader", "class")
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader")
        velocityEngine = new VelocityEngine(p)
    }

    String render(final String name, Map<String, Object> data) {
        final StringWriter writer = new StringWriter()
        final VelocityContext velocityContext = new VelocityContext(data)
        velocityEngine.mergeTemplate("templates/$name", StandardCharsets.UTF_8.name(), velocityContext, writer)
        writer.toString()
    }
}