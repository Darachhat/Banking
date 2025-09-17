package kh.rupp.fe.ite.mobileappdevelopmet.week.myapplication.repository;

public interface NetworkCallback<T> {
    void onSuccess(T data);
    void onError(Throwable t);
}