package com.example.mbreza.wnb.presenter;

import android.util.Log;

import com.example.mbreza.wnb.model.ResponseHandler;
import com.example.mbreza.wnb.model.Temp;
import com.example.mbreza.wnb.model.Users;
import com.example.mbreza.wnb.service.APIClient;
import com.example.mbreza.wnb.service.LoginService;
import com.example.mbreza.wnb.service.UsersService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LoginPresenter {

    private View view;

    public LoginPresenter(View view) {
        this.view = view;
    }


    public void register(){
        APIClient api = new APIClient();
        final LoginService apiService = api.getClient().create(LoginService.class);
        Observable<ResponseHandler> postLoginObservable = apiService.postUser( new Temp("asdf", "fdsa"));

        postLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseHandler>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("Call", "onSubscribe - logIn");
                    }
                    @Override
                    public void onNext(ResponseHandler responseHandler) {
                        Log.e("Call", responseHandler.toString());
                    }
                    @Override
                    public void onError(Throwable e) {
                        ResponseBody body = ((HttpException) e).response().errorBody();
                        ResponseHandler responseHandler = null;
                        try {
                            responseHandler = new Gson().fromJson(body.string(), ResponseHandler.class);
                            if(responseHandler.getStatus() == 401){
                                view.showNotify("Wrong username or password");
                            }else{
                                view.showNotify("Somethong went wrong, try again later.");
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        Log.e("Call","I am in error" + responseHandler.toString());
                    }
                    @Override
                    public void onComplete() {
                        Log.e("Call", "onComplete - logIn");
                    }
                });
    }


    public void logInNoGet(String username, String password){
        APIClient api = new APIClient();
        final LoginService apiService = api.getClient().create(LoginService.class);

        Observable<ResponseHandler> postLoginObservable = apiService.postLogin(username, password);

        postLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseHandler>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Call", "onSubscribe - logIn");
            }
            @Override
            public void onNext(ResponseHandler responseHandler) {
                getAllUsers();
                if(responseHandler.getStatus() == 200){
                    view.redirectHome();
                }
                Log.e("Call", responseHandler.toString());
            }
            @Override
            public void onError(Throwable e) {
                ResponseBody body = ((HttpException) e).response().errorBody();
                ResponseHandler responseHandler = null;
                try {
                    responseHandler = new Gson().fromJson(body.string(), ResponseHandler.class);
                    if(responseHandler.getStatus() == 401){
                        view.showNotify("Wrong username or password");
                    }else{
                        view.showNotify("Somethong went wrong, try again later.");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Log.e("Call","I am in error" + responseHandler.toString());
            }
            @Override
            public void onComplete() {
                Log.e("Call", "onComplete - logIn");
            }
        });
    }


    public void getAllUsers() {
        APIClient api = new APIClient();
        final UsersService apiService = api.getClient().create(UsersService.class);

        Observable<List<Users>> getUsersObservable = apiService.getUsers();

        getUsersObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("Call", "onSubscribe - getUsers");
                    }

                    @Override
                    public void onNext(List<Users> users) {
                        Log.e("Call", "onNext - getUsers");
                        for (Users user : users) {
                            System.out.println(user.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Call", "onError - getUsers" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Call", "onComplete - getUsers");
                    }
                });
    }

    public interface View {
        void showNotify(String info);
        void redirectHome();

    }

}
