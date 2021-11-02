package hello.core.beanfind;
import hello.core.AppConfig;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Assertions;
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public  void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // bean에 있는 이름들 가져오기
        for (String beanDefinitionName : beanDefinitionNames) { //iter + tab
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName+"object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // bean에 있는 이름들 가져오기
        for (String beanDefinitionName : beanDefinitionNames) { //iter + tab
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
//                ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
//                ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+"object = "+bean);
            }
        }
    }


}
