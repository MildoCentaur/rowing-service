package ar.com.eureka.rowing.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("health-check")
@RefreshScope
public class HealthCheckController {

  @Value("${challenge.attributes}")
  String challenges;

  @Value("${post.attributes}")
  String posts;

  @GetMapping("health-check/mildo")
  List<String> configurations() {
    final List<String> collect = Stream.of(posts.split(","), challenges.split(","))
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());
    return collect;
  }

}
