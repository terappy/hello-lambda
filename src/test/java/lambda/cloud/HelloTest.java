package lambda.cloud;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloTest {

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Hello");

        return ctx;
    }

    @Test
    public void handleRequest() {
        Hello hello = new Hello();
        Hello.Input in = new Hello.Input();
        in.firstName = "hoge";
        in.lastName = "foo";
        String expect = "hoge_foo";
        Context ctx = createContext();
        String actual = hello.handleRequest(in,ctx).fullName;
        assertEquals(expect, actual);
    }
}