package org.tank.core.db.generator;

import java.util.Arrays;

/**
  * @description TODO
  * @author lbx
  * @date 2019/12/1 16:19
  * @version 1.0.0
 **/
public class GeneratorTest {

    public static void main(String[] args) {
        CodeGenerator ge = new CodeGenerator();
        ge.setAuthor("lbx");
        ge.setCodeName("user-center-service");
        ge.setHasWrapper(true);
        ge.run();
    }
}
