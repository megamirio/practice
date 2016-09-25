package stingion.spring;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ItIsBean implements InitializingBean {

    private String str;

    public void setStr(String str) {
        System.out.println("Set \"str\" property ->");
        this.str = str;
    }

    public ItIsBean() {
        System.out.println("Constructor ->");
    }

    public void init() {
        System.out.println("init ->");
    }

    public void destroy() {
        System.out.println("destroy ->");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ->");
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("postConstruct ->");
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("preDestroy ->");
    }
}
