package spring.partie6.mbeans;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public class JmxBean implements  JmxBeanIntf {



    @ManagedOperation
    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @ManagedOperation
    @Override
    public Integer subtract(Integer a, Integer b) {
        return a-b;
    }
}
