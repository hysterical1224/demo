package test;

import com.sinner.demo.config.SpringConfiguration;
import com.sinner.demo.proxy_jdk.Advice;
import com.sinner.demo.proxy_jdk.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ProxyTest {
    @Autowired
    private Target tg;
    @Autowired
    private Advice advice;

    @Test
    public void testProxy() throws SQLException {
        Target proxy = (Target)Proxy.newProxyInstance(tg.getClass().getClassLoader(), tg.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        method.invoke(tg, args);//执行目标方法
                        advice.after();
                        return null;
                    }
                    //MyInvocationHandler 是一个实现了 InvocationHandler 接口的类，用于处理代理类的方法调用。
                    //通过 Proxy.newProxyInstance 创建了一个代理实例，然后通过这个代理实例调用了 myMethod 方法。
                    // 在 MyInvocationHandler 的 invoke 方法中，你可以定义在调用方法前后的行为。
                    // 这样的动态代理机制可以在运行时为目标对象生成代理类，从而实现一些横切关注点的功能，比如日志记录、性能监控等。
                }
        );
        /**
         * Proxy.newProxyInstance 是 JDK 提供的用于创建动态代理实例的方法。它允许你在运行时动态地生成一个实现指定接口的代理类，并通过该代理类调用方法。
         *
         * Object proxy = Proxy.newProxyInstance(
         *     classLoader,      // 类加载器
         *     interfaces,       // 实现的接口数组
         *     invocationHandler // 代理类的调用处理器
         * );
         *
         *
         * classLoader（类加载器）：
         * 这个参数是一个类加载器，用于加载生成的代理类。通常可以使用被代理类的类加载器，例如 target.getClass().getClassLoader()。
         * interfaces（接口数组）：
         *
         * 这个参数是一个数组，包含了代理类要实现的接口。被代理的类必须实现这些接口，因为动态代理基于接口实现。
         * 可以通过 target.getClass().getInterfaces() 获取被代理类实现的接口数组。
         *
         * invocationHandler（调用处理器）：
         * 这是一个实现了 InvocationHandler 接口的对象，用于处理代理类的方法调用。在 invoke 方法中，你可以定义代理类方法调用时的行为。
         *
         * */
        proxy.save();


    }





    @Test
    public void testcglib() throws SQLException {
        //基于cglib的返回值就是动态生成的代理对象
        //1.创建增强器
        Enhancer enhancer = new Enhancer();

        //2.设置父类(目标)
        enhancer.setSuperclass(Target.class);

        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                method.invoke(tg,objects);//执行目标
                advice.after();
                return method;
            }
        });

        //4.创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();


    }






}
