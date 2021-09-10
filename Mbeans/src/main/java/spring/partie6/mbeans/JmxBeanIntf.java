package spring.partie6.mbeans;

import org.springframework.jmx.export.annotation.ManagedOperation;

public interface JmxBeanIntf {

    Integer add(Integer a, Integer b);


    Integer subtract(Integer a, Integer b);
}
