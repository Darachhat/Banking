package kh.rupp.fe.ite.mobileappdevelopmet.week.myapplication.repository;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kh.rupp.fe.ite.mobileappdevelopmet.week.myapplication.model.Transaction;

/**
 * Fake repository that simulates network calls by delaying responses and returning placeholder data.
 * No Internet permission or libraries required.
 */
public class FakeNetworkRepository {

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    /**
     * Simulate fetching recent transactions with a small delay.
     */
    public void fetchRecentTransactions(@NonNull final NetworkCallback<List<Transaction>> callback) {
        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Transaction> items = placeholderTransactions();
                    callback.onSuccess(items);
                } catch (Throwable t) {
                    callback.onError(t);
                }
            }
        }, 1000L); // ~1s delay to simulate network
    }

    /**
     * Simulate fetching a single transaction by ID.
     */
    public void fetchTransactionById(@NonNull final String id,
                                     @NonNull final NetworkCallback<Transaction> callback) {
        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    for (Transaction t : placeholderTransactions()) {
                        if (t.getId().equals(id)) {
                            callback.onSuccess(t);
                            return;
                        }
                    }
                    callback.onSuccess(new Transaction(
                            id,
                            "Sample Merchant",
                            "Today • 10:00 AM",
                            "- $9.99",
                            "2025-09-17T10:00:00Z"
                    ));
                } catch (Throwable t) {
                    callback.onError(t);
                }
            }
        }, 800L);
    }

    private List<Transaction> placeholderTransactions() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(uuid(), "Amazon", "Today • 12:45 PM", "- $24.99", "2025-09-17T12:45:00Z"));
        list.add(new Transaction(uuid(), "Starbucks", "Yesterday • 09:12 AM", "- $4.50", "2025-09-16T09:12:00Z"));
        list.add(new Transaction(uuid(), "Salary", "Sep 1 • 08:00 AM", "+ $3,200.00", "2025-09-01T08:00:00Z"));
        list.add(new Transaction(uuid(), "Netflix", "Aug 30 • 07:30 PM", "- $15.99", "2025-08-30T19:30:00Z"));
        list.add(new Transaction(uuid(), "Uber", "Aug 29 • 10:05 PM", "- $12.75", "2025-08-29T22:05:00Z"));
        return list;
    }

    private String uuid() {
        return UUID.randomUUID().toString();
    }
}