package lounge.fm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleJunitRadiosMainPageTest {

    @DisplayName("Check some function")
    @Disabled("Jira-111")
    @Test
    void simpleTest1(){

    }

    @DisplayName("Check another function")
    @Test
    void simpleTest3(){
        char a = 'A';
        char b = 'B';
        char c = (char) (a+b);
    }

    @DisplayName("Check audio")
    @Disabled("Пока не реализовано")
    @Test
    void simpleTest2(){
    }


}
