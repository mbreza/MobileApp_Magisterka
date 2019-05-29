package com.example.mbreza.wnb.presenter;

import android.util.Log;

import com.example.mbreza.wnb.model.Users;
import com.example.mbreza.wnb.service.APIClient;
import com.example.mbreza.wnb.service.CookieStore;
import com.example.mbreza.wnb.service.LoginService;
import com.example.mbreza.wnb.service.UsersService;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter {

    private View view;

    public LoginPresenter(View view) {
        this.view = view;
    }

    public void logIn(String username, String password) {
        APIClient api = new APIClient();
        final LoginService apiService = api.getClient().create(LoginService.class);


        Completable getLoginObservable = apiService.getLogin();
        getLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("Call", "onSubscribe - get");
                    }
                    @Override
                    public void onComplete() {
                        Log.e("Call", "onComplete - get");
                        Completable postLoginObservable = apiService.postLogin(CookieStore.token, username, password);

                        postLoginObservable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new CompletableObserver() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                        Log.e("Call", "onSubscribe - post");
                                    }
                                    @Override
                                    public void onComplete() {
                                        Log.e("Call", "onComplete - post");
                                            //getAllUsers();
                                    }
                                    @Override
                                    public void onError(Throwable e) {
                                        Log.e("Call", "onError - post: " + e.toString());
                                    }
                                });
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("Call", "onError - get: " + e.toString());
                    }
                });
    }


    public void getAllUsers(){
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
                        for(Users user : users){
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

    public interface View{
    }

}
