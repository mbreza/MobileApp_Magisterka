package pl.wnb.communicator;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import pl.wnb.communicator.model.User;
import pl.wnb.communicator.presenter.AuthenticationPresenter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest implements AuthenticationPresenter.View{


//    private Context context;
//    private AuthenticationPresenter authenticationPresenter;
//    private User user;
//
//
//    @BeforeAll
//    public void setup(){
//        authenticationPresenter = new AuthenticationPresenter(this);
//        user =  new User("test@test.com", "fdsa", "123");
//        context = InstrumentationRegistry.getTargetContext();
//    }

    @Test
    @Order(1)
    public void register() throws InterruptedException {
        AuthenticationPresenter authenticationPresenter = new AuthenticationPresenter(this);
        User user =  new User("testt1@test.comm", "ffdsakurwa1", "123");
        authenticationPresenter.signUp(user);
    }

//    @Test
//    @Order(2)
//    public void signUp(){
//        authenticationPresenter.signIn(user.getUsername(), user.getPassword());
//    }

    @Override
    public void showNotify(String info) {

    }

    @Override
    public void redirectHome(Class myClass) {

    }
}
