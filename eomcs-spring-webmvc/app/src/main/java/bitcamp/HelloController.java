package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  // 클라이언트의 요청 URL 예:
  //  ==> http://localhost:8080/웹앱경로 (spring)/프론트 컨트롤러경로(app)/hello라는 요청이 들어왔을 때 */
  //  ==> http://localhost:8080/srping/app/hello
  @RequestMapping("/hello") 
  @ResponseBody
  public String hello() {
    return "Hello!";
  }
}
